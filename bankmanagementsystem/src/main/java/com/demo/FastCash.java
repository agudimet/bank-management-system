package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdraw, fastcash, mini, bala, pincha, exit;
    String pinumber;

    FastCash(String pinumber) {
        this.pinumber = pinumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);


        JLabel text = new JLabel("Select the withdraw amount");
        text.setBounds(235, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw = new JButton("Rs 500");
        withdraw.setBounds(355, 415, 150, 30);
        withdraw.addActionListener(this);
        label.add(withdraw);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        label.add(fastcash);

        mini = new JButton("Rs 2000");
        mini.setBounds(355, 450, 150, 30);
        mini.addActionListener(this);
        label.add(mini);

        pincha = new JButton("Rs 5000");
        pincha.setBounds(170, 485, 150, 30);
        pincha.addActionListener(this);
        label.add(pincha);

        bala = new JButton("Rs 10000");
        bala.setBounds(355, 485, 150, 30);
        bala.addActionListener(this);
        label.add(bala);

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        label.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
           setVisible(false);
           new Transaction(pinumber).setVisible(true);
        } else  {
           String amount = ((JButton)e.getSource()).getText().substring(3);
           Conn con = new Conn();
           try{
               ResultSet rs = con.s.executeQuery("Select * from bank where pin = '" + pinumber + " ' ");
               int balance = 0;
               while (rs.next()){
                   if(rs.getString("type").equals("deposit")){
                   balance += Integer.parseInt(rs.getString("amount"));
               } else {
                    balance  -= Integer.parseInt(rs.getString("amount"));

                   }
               }
               if(e.getSource() != exit && balance < Integer.parseInt("amount")){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
               }
               Date date = new Date();
               String query = "Insert  into bank values ('" + pinumber + "','" + date + "','Deposit','" + amount + "')";
               con.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs " +amount + "Debited Successfully");

               setVisible(false);
               new Transaction(pinumber).setVisible(true);
           }catch (Exception e4){
               System.out.println(e4);
           }
        }
    }
}

