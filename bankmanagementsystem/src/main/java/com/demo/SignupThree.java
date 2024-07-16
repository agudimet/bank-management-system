package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancle;
    String formno;

    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page-3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        l1.setBounds(230,40,400,40);
        add(l1 );

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,28));
        type.setBounds(100,140,200,30);
        add(type);


        r1 = new JRadioButton("Savinga Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,200,30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit  Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,250,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,260,20);
        add(r4);

        ButtonGroup  accountgroup = new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,25 ));
        card.setBounds(100,300,200,30);
        add(card );

        JLabel num = new JLabel("XXXX-XXXX-XXXX-8790");
        num.setFont(new Font("Raleway",Font.BOLD,16));
        num.setBounds(330,300,330,30);
        add(num);

        JLabel cnumdetail = new JLabel("16 Digit Card Number");
        cnumdetail.setFont(new Font("Raleway",Font.BOLD,16));
        cnumdetail.setBounds(100,330,300,20);
        add(cnumdetail);

        JLabel pinno = new JLabel("PIN Number");
        pinno.setFont(new Font("Raleway",Font.BOLD,25 ));
        pinno.setBounds(100,370,200,30);
        add(pinno);

        JLabel nump = new JLabel("XXXX");
        nump.setFont(new Font("Raleway",Font.BOLD,16));
        nump.setBounds(330,370,330,30);
        add(nump);

        JLabel pindetail = new JLabel("4 Digit PIN number");
        pindetail.setFont(new Font("Raleway",Font.BOLD,16));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);

        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,25));
        service.setBounds(100,450,250,30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);


        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declate that the above mentioned details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBounds(100,740,200,30);
        add(submit);
        submit.addActionListener(this);

        cancle = new JButton("Cancle");
        cancle.setFont(new Font("Raleway",Font.BOLD,20));
        cancle.setBounds(350,740,200,30);
        add(cancle);
        cancle.addActionListener(this);


        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,0);
    }

    public  static void main(String[] args){

        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String accounType = null;
            if(r1.isSelected()){
                accounType = "Savings Account";
            } else if (r2.isSelected()) {
                accounType = "Fixed Deposit  Account";
            }else if (r3.isSelected()) {
                accounType = "Current Account";
            }else if (r4.isSelected()) {
                accounType = "Recurring Deposit Account";
            }

            Random ran = new Random();
            String cardnumber = "" + Math.abs((ran.nextLong() % 90000000L) + 5432930800000000L);
            String pinnumbeer = ""+ Math.abs((ran.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(c1.isSelected()){
                facility = facility +"ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            }else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            }else if (c4.isSelected()) {
                facility = facility + "Email & SMS Alerts";
            }else if (c5.isSelected()) {
                facility = facility + "Cheque Book";
            }else if (c6.isSelected()) {
                facility = facility + "E-Statement";
            }

            try{
                if(accounType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else {
                    Conn conn  = new Conn();
                    //after witing the below liine we need to create table in database with table name signupthree
                    //create table signupthree(formno varchar(20), accounttype varchar(40), cardnumber varchar(25) , pinnumber varchar(10), facility varchar(100));
                    //select * from signupthree;
                    String query = "insert into signupthree value('"+formno+"','"+accounType+"','"+cardnumber+"','"+pinnumbeer+"','"+facility+"',)";
                    conn.s.executeUpdate(query);

                //here we rae creating another table for login
                    //create table login(form varchar(20), cardnumber varchar(25),pinnumber varchar(10));
                    //select * from login;
                    String query1 = "insert into login value('"+formno+"',"+cardnumber+"','"+pinnumbeer+"')";
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Card number:" + cardnumber +"\n Pin Number:" + pinnumbeer);
                    setVisible(false);
                    new Deposit(pinnumbeer).setVisible(true);

                }
            }catch (Exception e1){
                System.out.println(e1);
            }


        } else if (e.getSource()==cancle) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
