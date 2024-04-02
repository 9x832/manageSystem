package experiment1.temp;

import experiment1.util.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 功能：用来完成表的创建
 一共需要创建四个表

 */
public class create {
    public static void main(String[] args) throws SQLException {
        //sql操作语句


        //创建图书表
        String sql1="create table books" +
                "(bNo char(30) primary key," +
                "bName varchar(20)," +
                "bPublish varchar(20)," +
                "bDate date," +
                "bPrice float check(bPrice>0)," +
                "bNum int check(bNum>=0));";

        //创建借阅用户表
        String sql2="create table borrowPerson" +
                "(pNo char(15) primary key," +
                "pName varchar(20)," +
                "pSex char(2) check(pSex='男' or pSex='女')," +
                "pDate date);";

        //登录用户存储表
        String sql3="create table loginUser" +
                "(account char(25) primary key," +
                "password char(20)," +
                "identity char(20));";

        //借阅人员与图书的借阅关系表
        String sql4="create table book_borrowPerson" +
                "(bNo char(30)," +
                "pNo char(15)," +
                "pState int(1) check(pState=0 or pState=1)," +
                "primary key(bNo,pNo)," +
                "foreign key(bNo)references books(bNo)," +
                "foreign key(pNo)references borrowPerson(pNo));";
        //获取连接
        Connection connection=connectionUtils.getConnection();
        Statement statement=null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            //关闭连接
            connectionUtils.closeConnection(connection, statement, null);
        }
    }
}
