package com.easymall.controller;

import com.easymall.domain.User;
import com.easymall.exception.MsgException;
import com.easymall.service.UserService;
import com.easymall.utils.MD5Utils;
import com.easymall.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = null;

    /**
     * 注销用户
     */
    @RequestMapping("/logout.action")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.jsp";
    }

    /**
     * 登录用户
     */
    @RequestMapping("/login.action")
    public String login(HttpServletRequest request,HttpServletResponse response,String remname, String username, String password, Model model, HttpSession session) throws UnsupportedEncodingException {
        //获取用户名密码
        //记住用户名
        if("true".equals(remname)){
            Cookie remnamec = new Cookie("remname", URLEncoder.encode(username,"utf-8"));
            remnamec.setMaxAge(60*60*24*30);
            remnamec.setPath(request.getContextPath());
            response.addCookie(remnamec);
        }else{
            Cookie remnamec = new Cookie("remname","");
            remnamec.setMaxAge(0);
            remnamec.setPath(request.getContextPath());
            response.addCookie(remnamec);
        }
        //调用service完成登录
        try{
            User user = userService.loginUser(username,MD5Utils.md5(password));
            session.setAttribute("user",user);
            //30天内自动登录
            //登录成功回到主页
            //TODO
            return "redirect:/index.jsp";
        }catch (MsgException e){
            //登录失败提示用户
            model.addAttribute("msg",e.getMessage());
            return "forward:/WEB-INF/jsp/login.jsp";
        }
    }

    /**
     * 注册用户
     * @return
     */
    @RequestMapping("/regist.action")
    public String regist(@Valid User user, Errors errors, HttpSession session, String valistr, Model model){
        //获取请求参数
        user.setPassword(MD5Utils.md5(user.getPassword()));
        //验证验证码
        String valistr2 = (String) session.getAttribute("valistr");
        if(!valistr.equals(valistr2)){
            model.addAttribute("msg","验证码不正确！");
            return "forward:/WEB-INF/jsp/regist.jsp";
        }
        //校验数据
        if(errors.hasErrors()){
            List<FieldError> errs = errors.getFieldErrors();
            StringBuilder sb = new StringBuilder();
            for(FieldError err : errs){
                String field = err.getField();
                String message = err.getDefaultMessage();
                sb.append(message+" ");
            }
            model.addAttribute("msg",sb.toString());
            return "forward:/WEB-INF/jsp/regist.jsp";
        }
        //调用service完成注册
        try{
            userService.registUser(user);
        }catch (MsgException e){
            //失败回到注册页面提示原因
            model.addAttribute("msg",e.getMessage());
            return "forward:/WEB-INF/jsp/regist.jsp";
        }
        //成功回到主页
        return "redirect:/index.jsp";
    }

    /**
     * 校验用户名是否已经存在
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/ajaxCheckUserName.action",produces="text/html;charset=utf-8")
    public String ajaxCheckUserName(String username){
        if(userService.hasUserName(username)){
            return "用户名已存在！";
        }else{
            return "用户名可用！";
        }
    }

    /**
     * 生产验证码
     */
    @RequestMapping("/valistr.action")
    public void valistr(HttpServletResponse response, HttpSession session) throws IOException {
        //禁止缓存
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-control", "no-cache");
        //生成验证码
        VerifyCode vc = new VerifyCode();
        //输出验证码图片
        vc.drawImage(response.getOutputStream());
        //验证码文字版
        String valistr = vc.getCode();
        System.out.println("验证码："+valistr);
        //验证码信息存储到session
        session.setAttribute("valistr",valistr);
    }
}
