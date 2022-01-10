package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class AddGroupsToStudies {

    public static void Add() {
        final boolean[] flag1 = new boolean[1];
        final boolean[] flag = new boolean[1];
        JFrame frame = new JFrame();
        JTextField listas = new JTextField();
        JButton save_to_file = new JButton("Save to file");
        JButton add = new JButton("Add group to studies");
        JLabel messageLabel = new JLabel();
        JLabel topic = new JLabel("Studies management");
        JButton read = new JButton("Read studies from database");
        JButton read1 = new JButton("Read groups from database");
        JButton back = new JButton("BACK");
        JLabel topic1 = new JLabel("List of studies");
        JLabel topic2 = new JLabel("List of groups");
        JLabel topic3 = new JLabel("List of added groups");

        flag[0] = true;
        flag1[0] = true;

        topic3.setFont(new Font(null, Font.BOLD, 25));
        topic3.setBounds(750, 0, 300, 150);

        topic2.setFont(new Font(null, Font.BOLD, 25));
        topic2.setBounds(240, 0, 300, 150);

        topic.setFont(new Font(null, Font.ITALIC, 25));
        topic.setBounds(500, 0, 300, 30);

        topic1.setFont(new Font(null, Font.BOLD, 25));
        topic1.setBounds(20, 0, 300, 150);

        messageLabel.setBounds(500, 400, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        DefaultListModel<String> l1 = new DefaultListModel<>();
        JList<String> list = new JList<>(l1);
        list.setBounds(20, 100, 200, 450);

        DefaultListModel<String> l2 = new DefaultListModel<>();
        JList<String> list2 = new JList<>(l2);
        list2.setBounds(240, 100, 200, 450);

        DefaultListModel<String> l3 = new DefaultListModel<>();
        JList<String> list3 = new JList<>(l3);
        list3.setBounds(750, 100, 250, 450);
        BufferedReader br3 = null;
        try {
            br3 = new BufferedReader(new FileReader("AddedGroupsToStudies.txt"));
            int val = Integer.parseInt(br3.readLine());
            for (int i = 0; i < val; i++) {
                String ss = br3.readLine();
                l3.addElement(ss);
            }
            list3.setModel(l3);
        } catch (Exception e1) {
            System.out.println("" + e1);
        } finally {
            try {
                br3.close();
            } catch (Exception e1) {
                System.out.println("" + e1);
            }

            save_to_file.setBounds(500, 300, 200, 30);
            save_to_file.setFocusable(false);
            save_to_file.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == save_to_file) {
                        int val = list3.getModel().getSize();
                        PrintWriter writer = null;
                        try {
                            writer = new PrintWriter("AddedGroupsToStudies.txt");
                            writer.println(val);
                            for (int i = 0; i < val; i++) {
                                writer.println(list3.getModel().getElementAt(i));
                            }
                        } catch (Exception e1) {
                            System.out.println("" + e1);
                        } finally {
                            writer.close();
                        }
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Save successful!");
                    }
                    if (e.getSource() == save_to_file) {
                        int val = list2.getModel().getSize();
                        PrintWriter writer = null;
                        try {
                            writer = new PrintWriter("GroupsSelected.txt");
                            writer.println(val);
                            for (int i = 0; i < val; i++) {
                                writer.println(list2.getModel().getElementAt(i));
                            }
                        } catch (Exception e1) {
                            System.out.println("" + e1);
                        } finally {
                            writer.close();
                        }
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Save successful!");
                    }

                }
            });

            add.setBounds(500, 250, 200, 30);
            add.setFocusable(false);
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (list2.getSelectedValue() != null) {
                        if (list.getSelectedValue() != null) {
                            l3.addElement(list2.getSelectedValue() + " " + list.getSelectedValue());
                            list3.setModel(l3);
                            l2.removeElementAt(list2.getSelectedIndex());
                            messageLabel.setForeground(Color.green);
                            messageLabel.setText("Add successful!");
                        } else {
                            messageLabel.setForeground(Color.red);
                            messageLabel.setText("Select studies!");
                        }
                    } else {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("Select group!");
                    }
                }
            });
            read1.setBounds(500, 200, 200, 30);
            read1.setFocusable(false);
            read1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flag1[0]) {
                        messageLabel.setText("");
                        BufferedReader br1 = null;
                        try {
                            br1 = new BufferedReader(new FileReader("Groups.txt"));
                            int val = Integer.parseInt(br1.readLine());
                            for (int i = 0; i < val; i++) {
                                String ss = br1.readLine();
                                l2.addElement(ss);
                            }
                            list2.setModel(l2);
                            flag1[0] = false;
                        } catch (Exception e1) {
                            System.out.println("" + e1);
                        } finally {
                            try {
                                br1.close();
                            } catch (Exception e1) {
                                System.out.println("" + e1);
                            }

                        }
                    }
                }
            });

            read.setBounds(500, 150, 200, 30);
            read.setFocusable(false);
            read.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (flag[0]) {
                        messageLabel.setText("");
                        BufferedReader br = null;
                        try {
                            br = new BufferedReader(new FileReader("Studies.txt"));
                            int val = Integer.parseInt(br.readLine());
                            for (int i = 0; i < val; i++) {
                                String ss = br.readLine();
                                l1.addElement(ss);
                            }
                            list.setModel(l1);
                            flag[0] = false;
                        } catch (Exception e1) {
                            System.out.println("" + e1);
                        } finally {
                            try {
                                br.close();
                            } catch (Exception e1) {
                                System.out.println("" + e1);
                            }

                        }
                    }
                }
            });

            back.setBounds(550, 500, 100, 25);
            back.setFocusable(false);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == back) {
                        frame.dispose();
                        WelcomePage.Welcome();
                    }
                }
            });

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1200, 600);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.add(listas);
            frame.add(save_to_file);
            frame.add(list);
            frame.add(add);
            frame.add(messageLabel);
            frame.add(topic);
            frame.add(read);
            frame.add(back);
            frame.add(topic1);
            frame.add(topic2);
            frame.add(list2);
            frame.add(read1);
            frame.add(list3);
            frame.add(topic3);

        }
    }
}