package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinumber;
    BalanceEnquiry(String pinumber){
    this.pinumber = pinumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD,20));
        back.setBounds(355,520, 150,30);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        label.add(back);

        Conn con = new Conn();
        int balance = 0;
        try{
            ResultSet rs = con.s.executeQuery("Select * from bank where pin = '" + pinumber + " ' ");

            while (rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance  -= Integer.parseInt(rs.getString("amount"));

                }
                }
            }catch (Exception e6){
            System.out.println(e6);
            }

        JLabel l1 = new JLabel("Your Current Account Balance is:" + balance);
        l1.setBounds(170,300, 400,30 );
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD,16));
        label.add(l1);

        setSize(900, 900);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setVisible(true);

    }


    public static void main(String[] args){
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transaction(pinumber).setVisible(true);
    }
}
