package com.chatapp.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends JFrame implements ActionListener {

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(500,500);
//        setResizable(false);
//        setVisible(true);
//        setTitle("Login");
//        setLocationRelativeTo(null);
//        setLocation(100,100);
//        JLabel welcome = new JLabel("Login");
//        welcome.setFont(new Font("Arial",Font.BOLD,40));
//        Container container = this.getContentPane();
//        container.setLayout(null);
//        welcome.setBounds(100,70,200,60);
//        container.add(welcome);
        // Declare components as instance variables
        private JLabel userLabel, passLabel, message;
        private JTextField userField;
        private JPasswordField passField;
        private JButton loginButton, registerButton;

        // Create a constructor for the class
    public UserView(){
            super("Login Form");
            setSize(400, 300);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            // Create a panel for the title
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            titlePanel.add(new JLabel("Welcome to My Application"));

            // Create a panel for the form
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(3, 2, 10, 10));

            // Create and add the user label and field to the form panel
            userLabel = new JLabel("Username: ");
            userField = new JTextField(20);
            formPanel.add(userLabel);
            formPanel.add(userField);

            // Create and add the password label and field to the form panel
            passLabel = new JLabel("Password: ");
            passField = new JPasswordField(20);
            formPanel.add(passLabel);
            formPanel.add(passField);

            // Create and add the login and register buttons to the form panel
            loginButton = new JButton("Login");
            loginButton.addActionListener(this); // Add action listener to the button
            registerButton = new JButton("Register");
            registerButton.addActionListener(this); // Add action listener to the button
            formPanel.add(loginButton);
            formPanel.add(registerButton);

            // Create a panel for the message
            JPanel messagePanel = new JPanel();
            messagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            message = new JLabel(); // Create an empty label for the message
            messagePanel.add(message); // Add the label to the message panel

            // Add the panels to the frame
            add(titlePanel, BorderLayout.NORTH);
            add(formPanel, BorderLayout.CENTER);
            add(messagePanel, BorderLayout.SOUTH);

            // Set the frame to be visible
            setVisible(true);
    }

        // Override the actionPerformed method to handle the button clicks
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the command from the action event
            String command = e.getActionCommand();

            // Check which button was clicked
            if (command.equals("Login")) {
                // Get the username and password from the text fields
                String username = userField.getText();
                String password = new String(passField.getPassword());

                // Validate the username and password
                // For simplicity, we assume the username is "admin" and the password is "1234"
                // In a real application, we would use a database or a file to store the user credentials
                if (username.equals("admin") && password.equals("1234")) {
                    // If the credentials are valid, show a success message and open a new frame
                    message.setText("Login successful!");
                    message.setForeground(Color.GREEN);
                    // Create a new frame for the main application
                    JFrame mainFrame = new JFrame("Main Application");
                    mainFrame.setSize(600, 400);
                    mainFrame.setLocationRelativeTo(null);
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame.add(new JLabel("This is the main application"));
                    mainFrame.setVisible(true);
                    // Dispose the current frame
                    this.dispose();
                } else {
                    // If the credentials are invalid, show an error message and clear the text fields
                    message.setText("Invalid username or password!");
                    message.setForeground(Color.RED);
                    userField.setText("");
                    passField.setText("");
                }
            } else if (command.equals("Register")) {
                // If the register button was clicked, open a new frame for the registration form
                // Create a new frame for the registration form
                JFrame registerFrame = new JFrame("Registration Form");
                registerFrame.setSize(400, 300);
                registerFrame.setLocationRelativeTo(null);
                registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                registerFrame.add(new JLabel("This is the registration form"));
                registerFrame.setVisible(true);
            }
        }


    public static void main(String[] args) {
        UserView userView = new UserView();
            userView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
