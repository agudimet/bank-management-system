package com.demo;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinumber;
    MiniStatement(String pinumber){
        this.pinumber = pinumber;


        setLayout(null);
        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("SBI Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("Raleway",Font.BOLD,16));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
        Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("Select * from login where pin = '"+pinumber+"'");
            while (rs.next()){
                card.setText("Card number:"+ rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

        try{
            Conn con = new Conn();
            int bal = 0;
            ResultSet rs = con.s.executeQuery("Select * from bank where pin: '"+pinumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>"  + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>") ;
                if(rs.getString("type").equals("deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                }
            balance.setText("Your Current Balance is Rs:" + bal);
        }catch (Exception e){
            System.out.println(e);
        }

       mini.setBounds(20,140,400,200);

        setSize(400, 600);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args){
        new MiniStatement("");
    }
}
