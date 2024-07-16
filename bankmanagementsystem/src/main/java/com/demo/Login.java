package com.demo;


import com.mysql.cj.jdbc.ConnectionImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.ExportException;
import java.sql.Connection;
import java.sql.ResultSet;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class Login extends JFrame implements ActionListener {
JButton button, clear, sighup;
    JTextField cardtextField;
       JPasswordField pintextField;
    Login(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(70,10,100,100);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JLabel text = new JLabel("Welcome to ATM");
       text.setFont(new Font("Osward",Font.BOLD,38));
       text.setBounds(200,50,400,40);
        add(text);

        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(200,150,400,40);
        add(cardno);
         cardtextField = new JTextField();
         cardtextField.setFont(new Font("Arial",Font.BOLD,14));
         cardtextField.setBounds(420, 160, 250,30);
         add(cardtextField);

        JLabel pinNo = new JLabel("PIN:");
        pinNo.setFont(new Font("Osward",Font.BOLD,28));
        pinNo.setBounds(200,220,250,30);
        add(pinNo);
         pintextField = new JPasswordField();
         pintextField.setFont(new Font("Arial",Font.BOLD,14));
        pintextField.setBounds(425, 220, 250,30);
        add(pintextField );

         button = new JButton("SIGN IN");
        button.setBounds(430,300,150,30);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.addActionListener(this);
        add(button);

         clear = new JButton("CLEAR");
        clear.setBounds(590,300,150,30);
        clear.setBackground(Color.WHITE);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

         sighup = new JButton("SIGN UP");
        sighup.setBounds(450,350,250,30);
        sighup.setBackground(Color.WHITE);
        sighup.setForeground(Color.BLACK);
        sighup.addActionListener(this);
        add(sighup);


        add(lable);
        setTitle("SBI Bank ATM  ");
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == clear){
        cardtextField.setText("");
        pintextField.setText("");
    } else if (e.getSource() == sighup) {
        setVisible(false);
        new SignupOne().setVisible(true);
    } else if (e.getSource() == button) {
       Conn con = new Conn();
       String  cardnumber = cardtextField.getText();
       String pinumber = pintextField.getText();
       //need to fetch the data from database
       String query = "Select * from login where cardnumber= '"+cardnumber+"' and pin = '"+pinumber+"', ";

       try{
           //it will return the data
         ResultSet rs =  con.s.executeQuery(query);
         if(rs.next()){
             setVisible(false);
             new Transaction(pinumber).setVisible(true);
         }else {
             JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
         }
       }catch (Exception e1){
           System.out.println(e1);
       }
    }
    }
    public static void main(String[] args) {

new Login();

    }


}