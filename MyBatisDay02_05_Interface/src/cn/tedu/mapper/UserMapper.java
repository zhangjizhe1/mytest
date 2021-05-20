package cn.tedu.mapper;

import cn.tedu.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 接口的全路径应该等同于映射文件的名称空间
 * 接口中应该声明和映射文件中对应的方法，方法名对应映射文件中sql的id
 * 方法的参数必须对应sql中的参数
 * 方法的返回值必须对应sql的返回值
 */
public interface UserMapper {
    public int insertUser(User user);
    public List<User> selectBetweenAge(@Param("min") int min,@Param("max") int max);
    public User selectById(int id);
}
