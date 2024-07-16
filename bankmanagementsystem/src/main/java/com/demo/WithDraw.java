package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class WithDraw extends JFrame  implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinumber;
    WithDraw(String pinumber){

        this.pinumber = pinumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(170,300, 700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        label.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(170,350, 320,25);
        amount.setForeground(Color.BLACK);
        label.add(amount);

        withdraw = new JButton("Withdraw ");
        withdraw.setBounds(355,485,150,30);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        label.add(withdraw);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        label.add(back );


        setSize(900, 900);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args){
        new WithDraw("");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdraw ){
            //need to create table bank
            //create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else {
                try {
                    Conn con = new Conn();
                    String query = " insert into bank values('" + pinumber + "','" + date + "','Deposit','" + number + "')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs" + number + "Withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinumber).setVisible(true);
                }catch(Exception e4) {
                    System.out.println(e4);
                }
            }

        } else if(e.getSource() == back){
            setVisible(false);
            new Transaction(pinumber).setVisible(true);
        }
    }
}
