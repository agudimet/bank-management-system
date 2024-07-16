package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdraw,fastcash, mini,bala, pincha, exit;
    String pinumber;
    Transaction(String pinumber){
        this.pinumber = pinumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);


        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(235,300, 700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        label.add(text);

         deposit = new JButton("Deposit");
        deposit.setBounds(170,415, 150,30);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw = new JButton("Withdrew");
        withdraw.setBounds(355,415, 150,30);
        withdraw.addActionListener(this);
        label.add(withdraw);

         fastcash = new JButton("Fastcash");
        fastcash.setBounds(170,450, 150,30);
        fastcash.addActionListener(this);
        label.add(fastcash);

         mini = new JButton("Mini Statement");
        mini.setBounds(355,450, 150,30);
        mini.addActionListener(this);
        label.add(mini);

         pincha = new JButton("Pin Change");
        pincha.setBounds(170,485, 150,30);
        pincha.addActionListener(this);
        label.add(pincha);

         bala = new JButton("Balance Enquiry");
        bala.setBounds(355,485, 150,30);
        bala.addActionListener(this);
        label.add(bala);

         exit = new JButton("Exit");
        exit.setBounds(355,520, 150,30);
        exit.addActionListener(this);
        label.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args){
        new Transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource() == exit){
    System.exit(0);
} else if (e.getSource() ==deposit) {
    setVisible(false);
    new Deposit(pinumber).setVisible(true);

} else if (e.getSource() == withdraw) {
    setVisible(false);
    new WithDraw(pinumber).setVisible(true);
}else if (e.getSource() == fastcash){
    setVisible(false);
    new FastCash(pinumber).setVisible(true);
} else if (e.getSource() == pincha) {
    setVisible(false);
    new PinChange(pinumber).setVisible(true);
} else if (e.getSource() == bala) {
    setVisible(false);
    new BalanceEnquiry(pinumber).setVisible(true);
} else if (e.getSource() ==mini) {
new MiniStatement(pinumber).setVisible(true);
}
    }
}
