package com.chatapp.views;

import com.chatapp.dao.UserDao;
import com.chatapp.dto.UserDto;
import com.chatapp.utils.UserInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UserScreen {

    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton registerButton;

    static JFrame frame = new JFrame("UserScreen");
        UserDao userDao = new UserDao();
    private void doLogin() throws NoSuchAlgorithmException {
        String userid = textField1.getText();
        char [] password = passwordField1.getPassword();
        UserDto userDto =new UserDto(userid,password);
        try {
            String message;
            if (userDao.isLogin(userDto)){
                message ="welcome "+userid;
                UserInfo.USER_NAME = userid;
                JOptionPane.showMessageDialog(panel1,message);
                frame.setVisible(false);
                frame.dispose();
                DashBoard dashBoard = new DashBoard(message);

            }
            else{
                message = "Invalid user id or password";
                JOptionPane.showMessageDialog(panel1,message);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void register() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        String userid = textField1.getText();
        char [] password = passwordField1.getPassword();
        //UserDao userDao = new UserDao();
        UserDto userDto =new UserDto(userid,password);
        int result = userDao.add(userDto);
        if (result>0){
            JOptionPane.showMessageDialog(panel1,"record created");
            System.out.println("record created");
        }
        else {
            System.out.println("record not created");
        }
       // System.out.println(userid + password);
    }
    public UserScreen() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    register();
                } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    doLogin();
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {

        frame.setContentPane(new UserScreen().panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}
