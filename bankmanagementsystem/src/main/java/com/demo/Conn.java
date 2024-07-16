package com.demo;

import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){

        try{
            //no need to write this below line because the mysql dependency directly takes from the class path no need to register
            //create the database with the name bankmanagementsystem and use it
            //use bankamanagementsystem
           // Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql///bankmanagementsystem","root","1234");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
