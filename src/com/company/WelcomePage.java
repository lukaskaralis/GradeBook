package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends AddStudent {

    public static void Welcome() {
        JFrame frame = new JFrame();
        JLabel welcomeLabel = new JLabel("MENU");
        JButton addStudent = new JButton("ADD STUDENT");
        JButton deleteStudent = new JButton("DELETE STUDENT");
        JButton addLector = new JButton("ADD LECTOR");
        JButton deleteLector = new JButton("DELETE LECTOR");
        JButton signOut = new JButton("SIGNOUT");
        JButton addGroups = new JButton("ADD GROUPS");
        JButton deleteGroups = new JButton("DELETE GROUPS");
        JButton addStudies = new JButton("ADD STUDIES");
        JButton deleteStudies = new JButton("DELETE STUDIES");
        JButton addStudentToGroups = new JButton("ADD STUDENTS TO GROUPS");
        JButton addLectorToStudies = new JButton("ADD LECTORS TO STUDIES");
        JButton addGroupsToStudies = new JButton("ADD GROUPS TO STUDIES");

        addGroupsToStudies.setBounds(20, 540, 590, 60);
        addGroupsToStudies.setFont(new Font(null, Font.PLAIN, 25));
        addGroupsToStudies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addGroupsToStudies) {
                    frame.dispose();
                    AddGroupsToStudies.Add();
                }
            }
        });

        addLectorToStudies.setBounds(20, 460, 590, 60);
        addLectorToStudies.setFont(new Font(null, Font.PLAIN, 25));
        addLectorToStudies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addLectorToStudies) {
                    frame.dispose();
                    AddLectorsToStudies.Add();
                }
            }
        });

        addStudentToGroups.setBounds(20, 380, 590, 60);
        addStudentToGroups.setFont(new Font(null, Font.PLAIN, 25));
        addStudentToGroups.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addStudentToGroups) {
                    frame.dispose();
                    AddStudentToGroup.Add();
                }
            }
        });

        addStudies.setBounds(20, 300, 250, 60);
        addStudies.setFont(new Font(null, Font.PLAIN, 25));
        addStudies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addStudies) {
                    frame.dispose();
                    AddStudies.Add();
                }
            }
        });

        deleteStudies.setBounds(350, 300, 260, 60);
        deleteStudies.setFont(new Font(null, Font.PLAIN, 25));
        deleteStudies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == deleteStudies) {
                    frame.dispose();
                    DeleteStudies.Delete();
                }
            }
        });

        addGroups.setBounds(20, 220, 250, 60);
        addGroups.setFont(new Font(null, Font.PLAIN, 25));
        addGroups.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addGroups) {
                    frame.dispose();
                    AddGroups.Add();
                }
            }
        });

        deleteGroups.setBounds(350, 220, 260, 60);
        deleteGroups.setFont(new Font(null, Font.PLAIN, 25));
        deleteGroups.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == deleteGroups) {
                    frame.dispose();
                    DeleteGroups.Delete();
                }
            }
        });

            addStudent.setBounds(20, 60, 250, 60);
            addStudent.setFont(new Font(null, Font.PLAIN, 25));
            addStudent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == addStudent) {
                        frame.dispose();
                        AddStudent.Add();
                    }
                }
            });

            deleteStudent.setBounds(350, 60, 260, 60);
            deleteStudent.setFont(new Font(null, Font.PLAIN, 25));
            deleteStudent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == deleteStudent) {
                        frame.dispose();
                        DeleteStudents.Delete();
                    }
                }
            });

            addLector.setBounds(20, 140, 250, 60);
            addLector.setFont(new Font(null, Font.PLAIN, 25));
            addLector.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == addLector) {
                        frame.dispose();
                        AddLectors.AddLector();
                    }
                }
            });

            deleteLector.setBounds(350, 140, 260, 60);
            deleteLector.setFont(new Font(null, Font.PLAIN, 25));
            deleteLector.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == deleteLector) {
                        frame.dispose();
                        DeleteLector.Delete();
                    }
                }
            });

            signOut.setBounds(500, 650, 250, 60);
            signOut.setFont(new Font(null, Font.PLAIN, 25));
            signOut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == signOut) {
                        frame.dispose();
                        LoginPage.LogIn();
                    }
                }
            });

            welcomeLabel.setBounds(280, 0, 200, 35);
            welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
            welcomeLabel.setText("MENU");

            frame.add(welcomeLabel);
            frame.add(addStudent);
            frame.add(deleteStudent);
            frame.add(addLector);
            frame.add(deleteLector);
            frame.add(signOut);
            frame.add(addGroups);
            frame.add(deleteGroups);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.add(addStudies);
            frame.add(deleteStudies);
            frame.add(addStudentToGroups);
            frame.add(addLectorToStudies);
            frame.add(addGroupsToStudies);
    }
}
