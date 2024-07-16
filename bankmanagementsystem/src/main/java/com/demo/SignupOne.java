package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField,
            countryTextField, pinTextField;
    JButton next;
    JRadioButton others, male, female,married, unmarried;
    JDateChooser dateChooser;

    SignupOne(){
        setLayout(null);
        Random ran = new Random();
       long random = Math.abs(ran.nextLong() % 9000L)+ 1000L;

        getContentPane().setBackground(Color.white);
        JLabel from = new JLabel("Application Form No:"+ random);
        from.setFont(new Font("Raleway",Font.BOLD,38));
        from.setBounds(140,20,600,40);
        add(from);

        JLabel personalDet = new JLabel("Page-1: Personal Details");
        personalDet.setFont(new Font("Raleway",Font.BOLD,28));
        personalDet.setBounds(230,80,400,30);
        add(personalDet);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(300, 140,300,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father Name:");
        fname .setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fnameTextField.setBounds(300, 190,300,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob .setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
         dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender .setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

         male = new JRadioButton("Male");
        male.setBounds(300, 290, 80, 30);
        male.setBackground(Color.WHITE);
        add(male);
         female = new JRadioButton("Female");
        female.setBounds(400, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup  gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email:");
        email .setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(300, 340,300,30);
        add(emailTextField);

        JLabel mstatus = new JLabel("Marital Status:");
        mstatus .setFont(new Font("Raleway",Font.BOLD,20));
        mstatus.setBounds(100,390,200,30);
        add(mstatus);

        married = new JRadioButton("Married");
       married.setBounds(300, 390, 100, 30);
       married.setBackground(Color.WHITE);
       add(married);
        unmarried = new JRadioButton("UnMarried");
       unmarried.setBounds(450, 390, 100, 30);
       unmarried.setBackground(Color.WHITE);
       add(unmarried);
       others = new JRadioButton("Others");
      others.setBounds(630, 390, 100, 30);
      others.setBackground(Color.WHITE);
      add(others);

      ButtonGroup  mstatusgroup = new ButtonGroup();
       mstatusgroup.add(married);
       mstatusgroup.add(unmarried);
       mstatusgroup.add(others);

     JLabel address = new JLabel("Address:");
        address .setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField.setBounds(300, 440,300,30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city .setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
        cityTextField.setBounds(300, 490,300,30);
        add(cityTextField);



        JLabel state = new JLabel("State:");
        state .setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
        stateTextField.setBounds(300, 540,300,30);
        add(stateTextField);

        JLabel country = new JLabel("Country:");
        country.setFont(new Font("Raleway",Font.BOLD,20));
        country.setBounds(100,590,200,30);
        add(country);
        countryTextField = new JTextField();
        countryTextField.setFont(new Font("Raleway", Font.BOLD,14));
        countryTextField.setBounds(300, 590,300,30);
        add(countryTextField);


        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,640,200,30);
        add(pincode);
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
        pinTextField.setBounds(300, 640,300,30);
        add(pinTextField);

         next = new JButton("Next");
//        next.setBackground(Color.BLACK);
//        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(500,700,100,30);
        add(next);
        next.addActionListener(this );

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno =  " " + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String martial = null;
        if(married.isSelected()){
            martial = "Married";
        } else if (unmarried.isSelected()) {
            martial = "Unmarried";

        }else if(others.isSelected()){
            martial = "Others";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String country = countryTextField.getText();
        String pin = pinTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else {
                Conn c = new Conn();
                //after witing the below liine we need to create table in database with table name signupthree
                //create table signup(formno varchar(20), name varchar(40), father_name varchar(25) , dob varchar(20), gender varchar(20),email varchar(20),address varchar(40),city varchar(20),state varchar(20),country varchar(20),pin varchar(20));
                //select * from signup;
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"', '"+email+"', '"+martial+"','"+address+"','"+city+"','"+state+"','"+country+"','"+pin+"')";
            c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch (Exception ae) {
            System.out.println(ae);
        }
    }
}
