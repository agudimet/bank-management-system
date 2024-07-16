package com.demo;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {
    long random;
    JTextField pan, aadhar;
    JButton next;
    JRadioButton eyes,eno, syes,sno;
    JComboBox religion, category,income, qualify,occupation;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);


        setTitle("NEW ACCOUNT APPLICATION FORM : PAGE-2");
        JLabel additionalDet = new JLabel("Additional Details");
        additionalDet.setFont(new Font("Raleway", Font.BOLD, 28));
        additionalDet.setBounds(230, 80, 400, 30);
        add(additionalDet);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        String valreli[] = {"Hindu", "Muslim","Christian","Sikh","Pnjabi","Other"};
         religion = new JComboBox(valreli);
        religion.setBounds(300, 140, 300, 30);
        add(religion);


        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valcate[] = {"General", "OBC","BC","SC","ST","Other"};
         category = new JComboBox(valcate);
        category.setBounds(300, 190, 300, 30);
        add(category);

        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String valinc[] = {"Null", "<1,50,000",">1,50,000","<2,50,000","<5,00,000","UP TO 1,00,000"};
         income = new JComboBox(valinc);
        income.setBounds(300, 240, 400, 30);
        add(income);

        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);
        String valqual[] = {"Non Graduate", "Graduate","Post Graduate","Doctrate","Otherd"};
         qualify = new JComboBox(valqual);
        qualify.setBounds(300, 340, 300, 30);
        add(qualify);

        JLabel mstatus = new JLabel("Occupation:");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        mstatus.setBounds(100, 390, 200, 30);
        add(mstatus);

        String valoccu[] = {"Salaried", "Self-Employed","Business","Student","Retired", "Other"};
        occupation = new JComboBox(valoccu);
        occupation.setBounds(300, 390, 100, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 300, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 300, 30);
        add(aadhar);


        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(450, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("NO");
        sno.setBounds(630, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sstatusgroup = new ButtonGroup();
        sstatusgroup.add(syes);
        sstatusgroup.add(sno);

        JLabel country = new JLabel("Existing Account:");
        country.setFont(new Font("Raleway", Font.BOLD, 20));
        country.setBounds(100, 590, 200, 30);
        add(country);

        eyes = new JRadioButton("YES");
        eyes.setBounds(450, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("NO");
        eno.setBounds(630, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup estatusgroup = new ButtonGroup();
        estatusgroup.add(eyes);
        estatusgroup.add(eno);



        next = new JButton("Next");
//        next.setBackground(Color.BLACK);
//        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(500, 700, 100, 30);
        add(next);
        next.addActionListener(this);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = " " + random;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) qualify.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingacc = null;
        if (eyes.isSelected()) {
            existingacc = "Yes";
        } else if (eno.isSelected()) {
            existingacc = "No";
        }
        String saadhar = aadhar.getText();
        String span = pan.getText();

        try {
                Conn c = new Conn();
            //after witing the below liine we need to create table in database with table name signuptwo
            //create table signuptwo(formno varchar(20), religion varchar(20), category varchar(25) , income varchar(30), education varchar(20), occupation varchar(20),seniorcitizen varchar(20),existingac varchar(20),aadhar varchar(20), pan varchar(20));
            //select * from signuptwo;
                String query = "insert into signuptwo values ('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "', '" + soccupation + "', '" + seniorcitizen + "','" + existingacc + "','" + saadhar + "','" + span + "')";
                c.s.executeUpdate(query);

            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception ae) {
            System.out.println(ae);
        }

    }
}