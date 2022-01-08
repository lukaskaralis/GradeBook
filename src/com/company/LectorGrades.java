package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Logger;

public class LectorGrades {
    static void SGrades() {
        JFrame frame = new JFrame();
        JButton loginButton = new JButton("Watch grades");
        JLabel intro = new JLabel("GRADES");
        JButton signOut = new JButton("BACK");
        JButton add = new JButton("ADD TO LIST");
        JTextField name = new JTextField();
        JLabel topic = new JLabel("Insert student name and surname:");
        JTextField name2 = new JTextField();
        JLabel topic2 = new JLabel("Insert studies:");
        JTextField name3 = new JTextField();
        JLabel topic3 = new JLabel("Insert grade:");
        JLabel topic4 = new JLabel("Name                                          Studies                                        Grade");
        JButton save = new JButton("SAVE TO DATABASE");


        JTable jt = new JTable();
        jt.setBounds(10, 330, 620, 350);
        jt.setAutoCreateRowSorter(true);
        jt.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Name", "Subject", "Grade"
                }
        ));


        name.setBounds(500, 110, 200, 25);
        name2.setBounds(500, 160, 200, 25);
        name3.setBounds(500, 210, 200, 25);

        topic4.setFont(new Font(null, Font.BOLD, 15));
        topic4.setBounds(10, 240, 600, 150);

        topic.setFont(new Font(null, Font.BOLD, 25));
        topic.setBounds(20, 50, 450, 150);

        topic2.setFont(new Font(null, Font.BOLD, 25));
        topic2.setBounds(20, 100, 300, 150);

        topic3.setFont(new Font(null, Font.BOLD, 25));
        topic3.setBounds(20, 150, 300, 150);

        intro.setBounds(360, 20, 250, 35);
        intro.setFont(new Font(null, Font.BOLD, 25));


        save.setBounds(500, 280, 200, 30);
        save.setFocusable(false);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                BufferedWriter bfw = null;
                try {
                    bfw = new BufferedWriter(new FileWriter("Data.txt"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                for (int i = 0; i < jt.getColumnCount(); i++) {
                    try {
                        bfw.write(jt.getColumnName(i));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        bfw.write("\t");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                for (int i = 0; i < jt.getRowCount(); i++) {
                    try {
                        bfw.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    for (int j = 0; j < jt.getColumnCount(); j++) {
                        try {
                            bfw.write((String) (jt.getValueAt(i, j)));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            bfw.write("\t");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        ;
                    }
                }
                try {
                    bfw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });

        add.setBounds(500, 240, 200, 30);
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().equals("") || name2.getText().equals("") || name3.getText().equals("")) {
                } else {
                    String data[] = {name.getText(), name2.getText(), name3.getText()};
                    DefaultTableModel dm = (DefaultTableModel) jt.getModel();
                    dm.addRow(data);
                    name.setText("");
                    name2.setText("");
                    name3.setText("");
                    ObjectOutputStream outstream = null;
                    try {
                        outstream = new ObjectOutputStream(new FileOutputStream("Table.txt"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        outstream.writeObject(data);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        outstream.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });


        signOut.setBounds(620, 700, 150, 25);
        signOut.setFont(new Font(null, Font.BOLD, 15));
        signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == signOut) {
                    frame.dispose();
                    LectorPage.LectorPG();
                }
            }
        });

        frame.add(save);
        frame.add(loginButton);
        frame.add(intro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(signOut);
        frame.add(add);
        frame.add(topic);
        frame.add(topic2);
        frame.add(topic3);
        frame.add(name);frame.add(name2);frame.add(name3);
        frame.add(jt);
        frame.add(topic4);
    }
}
