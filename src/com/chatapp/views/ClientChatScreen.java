package com.chatapp.views;

import com.chatapp.network.Client;
import com.chatapp.utils.UserInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientChatScreen {
    private JPanel panel1;
    private JTextField textField1;
    private JButton sendMessageButton;
    private JTextArea textArea1;
    private Client client;

private void sendIt() throws IOException {
    String message = textField1.getText();
    client.sendMessage(UserInfo.USER_NAME+" : "+message);
}
public ClientChatScreen() throws IOException {
    JFrame frame = new JFrame();
    frame.add(panel1);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    client = new Client(textArea1);
    sendMessageButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                sendIt();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
}

    public static void main(String[] args) {
        try {
            ClientChatScreen clientChatScreen = new ClientChatScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

