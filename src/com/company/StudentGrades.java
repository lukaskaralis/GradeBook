package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class StudentGrades {
     static void SGrades(){
        JFrame frame = new JFrame();
        JButton loginButton = new JButton("Watch grades");
        JLabel intro = new JLabel("GRADES");
        JButton signOut = new JButton("BACK");

        intro.setBounds(160, 20, 250, 35);
        intro.setFont(new Font(null, Font.BOLD, 25));
        String column[]={"STUDIES","CONTROL WORK","CLASS WORK","EXAM","HOMEWORK"};
        String data[][] = {{"STUDIES","CONTROL WORK","CLASS WORK","EXAM","HOMEWORK"},
                {"MATH.","8","9","4","7"},
                {"HISTORY","5","","","7"},
                {"BIOLOGY","9","7","","8"},
                {"ECONOMICS","7","8","","8"},
                {"SOCIOLOGY","9","","6","8"},
                {"CHEMISTRY","","7","","10"},
                {"MANAGMENT","10","","7","8"},
        };
        JTable jt = new JTable(data,column);
        jt.setBounds(10,100,380,200);
        JScrollPane sp=new JScrollPane(jt);
        frame.add(jt);
        frame.add(sp);
        jt.setEnabled(false);

        signOut.setBounds(250, 320, 150, 25);
        signOut.setFont(new Font(null, Font.BOLD, 15));
        signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == signOut) {
                    frame.dispose();
                    StudentPage.StudentPG();
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
