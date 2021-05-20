package cn.tedu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/my01")
public class MyController01 {

    /**
     * 文件上传
     */
    @RequestMapping("/test01.action")
    public void test01(MultipartFile fx) throws IOException {
        fx.transferTo(new File("D://"+fx.getOriginalFilename()));
    }
}
