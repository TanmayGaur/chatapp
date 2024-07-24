package com.chatapp.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DashBoard {
    private JPanel panel1;
    private JButton startChatButton;
    private JLabel lable;


    public DashBoard(String message){
        JFrame jFrame = new JFrame();

        jFrame.add(panel1);
        jFrame.pack();
        jFrame.setTitle(message);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startChatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                  new ClientChatScreen();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
