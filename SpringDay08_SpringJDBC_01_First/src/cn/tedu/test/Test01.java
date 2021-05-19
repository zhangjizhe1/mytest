package cn.tedu.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;

public class Test01 {

    private static DataSource dataSource = new ComboPooledDataSource();

    @Test
    public void test01(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.注册数据库驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            //conn = DriverManager.getConnection("jdbc:mysql:///sdb","root","root");
            conn = dataSource.getConnection();
            //3.获取传输器对象
            ps = conn.prepareStatement("select * from user where id < ?");
            ps.setInt(1,3);
            //4.传输sql执行获取结果集
            rs = ps.executeQuery();
            //5.处理结果
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    ps = null;
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    conn = null;
                }
            }
        }
    }
}
