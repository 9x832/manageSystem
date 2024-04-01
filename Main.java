import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/libmanage";
        String userName="root";
        String passWord="Xuanqixian1234";


        //加载驱动
        try {
            Class.forName(driver);
            //创建连接
            Connection connection = DriverManager.getConnection(url, userName, passWord);
            //创建statement
            Statement statement=connection.createStatement();
            //执行sql
            String sql="create table books(bookId int primary key,bookName varchar(30),bookPress varchar(30),bookDate date,bookPrice float,bookNum int)";
            int rows = statement.executeUpdate(sql);
            System.out.println("Table created successfully.");
            System.out.println("受影响的行数："+rows);
            //关闭资源
            statement.close();
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}