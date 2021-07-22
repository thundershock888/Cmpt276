package com.example;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
class Db{
    Connection connection;
    Db() {//constructor for an object that simply containts a db (postgres) connection. Only works locally, not on Heroku, as password and username and hardcoded right now.
        String url = "jdbc:postgresql://localhost:1234/postgres";
        String username = "postgres";
        String password = "root";
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected yay");
        } catch (SQLException e) {
            System.out.println("error connecting to postgres");
            e.printStackTrace();
        }
    }

    public void initTables() {//makes a table in the database storing league user id data
        try {
            PreparedStatement stmt = connection.prepareStatement("Create table if not exists users(id varchar(50), accountId varchar(50), puuid varchar(80), name varchar(50))");
            System.out.println("sucsessfully made user table");
            stmt.executeUpdate();
            stmt = connection.prepareStatement("Create table if not exists matches(puuid varchar(50), matchId varchar(30))");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("caught sql excpetion");
            e.printStackTrace();
        }


    }

    public void insertUser (String userData) {// inserts a user, given the string userData which is obtained from an API call to getMatchesBySummonerId(). note that
        //this call returns match data also, but the first four elements are userdata which is why it can be used to obtain user data.
        //will also innitiate a database for matches WIP.
        System.out.println(userData);
        String data[] = userData.split(",");
        String id = "";
        String sql = "";
        for (int i = 0; i < 4; i++) {

            String temp = (data[i].split(":")[1]);
            System.out.println(temp);
            temp = temp.replace("\"", "\'");
            sql+=temp;
            sql += ",";

        }
        sql = sql.substring(0,sql.length()-1);
        String query = "INSERT INTO users (id, accountId, puuid,name)\n" +
                "VALUES ("+sql+");";
        //String query = "If Not Exists(select * from tablename where id = " + id+ " Begin insert into tablename (code) values (" + sql+ ") End)";
        System.out.println(query);
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            System.out.println("sucsessfully made user table");
            stmt.executeUpdate();
            stmt = connection.prepareStatement("Create table if not exists matches(puuid varchar(50), matchId varchar(30))");
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("caught sql excpetion");
            e.printStackTrace();
        }

    }
//test

}




































