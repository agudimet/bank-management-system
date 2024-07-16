package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField tx, tx1;
    JButton change, back;
    String pinumber;
    PinChange(String pinumber){
        this.pinumber = pinumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(235,280, 500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        label.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165,320, 180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,16));
        label.add(pintext);

         tx = new JPasswordField();
        tx.setFont(new Font("Raleway", Font.BOLD,25));
        tx.setBounds(330,320, 180,25);
        tx.setForeground(Color.BLACK);
        label.add(tx);


        JLabel repintext = new JLabel("ReEnter New PIN:");
        repintext.setBounds(165,360, 180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,16));
        label.add(repintext);

         tx1 = new JPasswordField ();
        tx1.setFont(new Font("Raleway", Font.BOLD,25));
        tx1.setBounds(330,360, 180,25);
        tx1.setForeground(Color.BLACK);
        label.add(tx1);

         change = new JButton("CHANGE");
        change.setFont(new Font("Raleway", Font.BOLD,20));
        change.setBounds(355,480, 150,30);
        change.setForeground(Color.BLACK);
        change.addActionListener(this);
        label.add(change);

         back = new JButton("BACK");
        back.setFont(new Font("Raleway", Font.BOLD,20));
        back.setBounds(355,520, 150,30);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        label.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setVisible(true);

    }


    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change) {
            try {
                String npin = tx.getText();
                String rpin = tx1.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (!npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                if (!rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Re-PIN");
                    return;
                }
                Conn c = new Conn();
                String query1 = " Update bank set pin = '"+rpin+"' where '"+pinumber+"'";
                String query2 = " Update login set pin = '"+rpin+"' where '"+pinumber+"'";
                String query3 = " Update signupthree set pin = '"+rpin+"' where '"+pinumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN UPDATED/CHANGED Successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception e5) {
                System.out.println(e5);
            }
        } else  {
            setVisible(false);
            new Transaction(pinumber).setVisible(true);
            
        }
    }
}
