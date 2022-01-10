package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class StudentPage implements ActionListener {
    public static void StudentPG(){
        JFrame frame = new JFrame();
        JButton loginButton = new JButton("Watch grades");
        JLabel intro = new JLabel("MENU");
        JButton signOut = new JButton("SIGNOUT");

        intro.setBounds(180, 20, 250, 35);
        intro.setFont(new Font(null, Font.BOLD, 25));

        loginButton.setBounds(110, 60, 200, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == loginButton) {
                    frame.dispose();
                    StudentGrades.SGrades();
                }
            }
        });

        signOut.setBounds(250, 320, 150, 25);
        signOut.setFont(new Font(null, Font.BOLD, 15));
        signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == signOut) {
                    frame.dispose();
                    LoginPage.LogIn();
                }
            }
        });


                frame.add(loginButton);
        frame.add(intro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(signOut);
    }
}
