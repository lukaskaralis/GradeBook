package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage extends Person implements ActionListener {


    public static void LogIn() {

        JFrame frame = new JFrame();
        JButton loginButton = new JButton("Login");
        JButton resetButton = new JButton("Reset");
        JTextField userIDField = new JTextField();
        JPasswordField userPasswordField = new JPasswordField();
        JLabel userIDLabel = new JLabel("Name");
        JLabel userPasswordLabel = new JLabel("Password");
        JLabel messageLabel = new JLabel();
        JLabel intro = new JLabel("ACADEMIC SYSTEM");

        HashMap<String, String> logininfo = new HashMap<String, String>();
        HashMap<String, String> Student = new HashMap<String, String>();
        HashMap<String, String> Lector = new HashMap<String, String>();

        Lector l1 = new Lector();
        l1.setName("Lector");
        l1.setPassword("123");
        l1.setStudies("Biology");
        Lector.put(l1.getName(),l1.getPassword());

        Student s1 = new Student();
        s1.setName("Student");
        s1.setPassword("123");
        s1.setGroup("PI20S");
        Student.put(s1.getName(),s1.getPassword());

        Person admin = new Person();
        admin.setName("Admin");
        admin.setPassword("123");
        logininfo.put(admin.getName(), admin.getPassword());


            userIDLabel.setBounds(50, 100, 75, 25);
            userPasswordLabel.setBounds(50, 150, 75, 25);

            intro.setBounds(100, 20, 250, 35);
            intro.setFont(new Font(null, Font.BOLD, 25));

            messageLabel.setBounds(125, 250, 250, 35);
            messageLabel.setFont(new Font(null, Font.ITALIC, 25));

            userIDField.setBounds(125, 100, 200, 25);
            userPasswordField.setBounds(125, 150, 200, 25);

            loginButton.setBounds(125, 200, 100, 25);
            loginButton.setFocusable(false);
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == loginButton) {
                        String userID = userIDField.getText();
                        String password = String.valueOf(userPasswordField.getPassword());

                        if(Lector.containsKey(userID)){
                            if(Lector.get(userID).equals(password)){
                                frame.dispose();
                                LectorPage.LectorPG();
                            }else {
                                messageLabel.setForeground(Color.red);
                                messageLabel.setText("Wrong password");
                            }
                        }

                        if(Student.containsKey(userID)){
                            if(Student.get(userID).equals(password)){
                                frame.dispose();
                                StudentPage.StudentPG();
                            }else {
                                messageLabel.setForeground(Color.red);
                                messageLabel.setText("Wrong password");
                            }
                        }
                        if (logininfo.containsKey(userID)) {
                            if (logininfo.get(userID).equals(password)) {
                                messageLabel.setForeground(Color.green);
                                messageLabel.setText("Login successful");
                                frame.dispose();
                                WelcomePage.Welcome();
                            } else {
                                messageLabel.setForeground(Color.red);
                                messageLabel.setText("Wrong password");
                            }
                        } else {
                            messageLabel.setForeground(Color.red);
                            messageLabel.setText("Username not found");
                        }
                    }
                }
            });

            resetButton.setBounds(225, 200, 100, 25);
            resetButton.setFocusable(false);
            resetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == resetButton) {
                        userIDField.setText("");
                        userPasswordField.setText("");
                    }
                }
            });

            frame.add(loginButton);
            frame.add(resetButton);
            frame.add(messageLabel);
            frame.add(userIDLabel);
            frame.add(userPasswordLabel);
            frame.add(userIDField);
            frame.add(intro);
            frame.add(userPasswordField);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(420, 420);
            frame.setLayout(null);
            frame.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}