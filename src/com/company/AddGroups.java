package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class AddGroups {

    public static void Add(){


        final boolean[] flag = new boolean[1];
        JFrame frame = new JFrame();
        JTextField listas = new JTextField();
        JButton save_to_file = new JButton("Save to file");
        JButton add = new JButton("Add");
        JLabel messageLabel = new JLabel();
        JLabel topic = new JLabel("Groups management");
        JButton read = new JButton("Read from Database");
        JButton back = new JButton("BACK");
        JLabel topic1 = new JLabel("List of groups");
        JLabel topic2 = new JLabel("Insert group name:");

        flag[0] = true;

        topic2.setFont(new Font(null, Font.BOLD, 13));
        topic2.setBounds(300,15,300,150);

        topic.setFont(new Font(null, Font.ITALIC, 25));
        topic.setBounds(270,0,300,30);

        topic1.setFont(new Font(null, Font.BOLD, 25));
        topic1.setBounds(20,0,300,150);

        messageLabel.setBounds(310, 300, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        DefaultListModel<String> l1 = new DefaultListModel<>();
        JList<String> list = new JList<>(l1);
        list.setBounds(20,100,200,450);


        listas.setBounds(300, 100, 200, 25);

        save_to_file.setBounds(300, 250, 200, 30);
        save_to_file.setFocusable(false);
        save_to_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == save_to_file) {
                    int val = list.getModel().getSize();
                    PrintWriter writer = null;
                    try{writer = new PrintWriter("Groups.txt");
                        writer.println(val);
                        for (int i=0;i<val;i++){
                            writer.println(list.getModel().getElementAt(i));
                        }
                    } catch (Exception e1){
                        System.out.println(""+e1);
                    }finally {
                        writer.close();
                    } messageLabel.setForeground(Color.green);
                    messageLabel.setText("Save successful");
                }
            }
        });

        add.setBounds(300, 200, 200, 30);;
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = listas.getText();
                if(str.equals("")||str.equalsIgnoreCase("Type here")) {
                    listas.setText("Type Here");
                    messageLabel.setText("");
                }else{
                    l1.addElement(str);
                    list.setModel(l1);
                    listas.setText("");
                    messageLabel.setText("");
                    flag[0] = true;
                }
            }
        });

        read.setBounds(300, 150, 200, 30);
        read.setFocusable(false);
        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag[0]) {
                    messageLabel.setText("");
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader("Groups.txt"));
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

        back.setBounds(450, 500, 100, 25);
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
        frame.setSize(600, 600);
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
    }
}
