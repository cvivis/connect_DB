package com.dbexercise;

import java.sql.*;
import java.util.Map;
import java.util.Objects;

public class userDao {
    public void add() throws SQLException{
        Map<String,String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id,name,password) VALUES (?,?,?)");
        ps.setString(1,"4");
        ps.setString(2,"qweqwe");
        ps.setString(3,"asdfasdf");

        PreparedStatement ps2 = conn.prepareStatement("select * from users where id = 2");
        ResultSet result = ps2.executeQuery();


        while(result.next()){
            System.out.println("id: "+result.getString("id"));
            System.out.println("name: "+result.getString("name"));
            System.out.println("password: "+result.getString("password"));
        }


//        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        userDao userdao = new userDao();
        userdao.add();

    }

}


