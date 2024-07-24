package com.chatapp.network;
import com.chatapp.utils.ConfigReader;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    Socket socket;
    OutputStream out;
    InputStream in;
    ClientWorker worker;
    JTextArea textArea;
    public Client(JTextArea textArea) throws IOException {
        int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
        socket= new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
        out = socket.getOutputStream();
        in = socket.getInputStream();
        this.textArea=textArea;
        readMessage();
//        System.out.println("Client comes");
//        OutputStream out = socket.getOutputStream();
//        System.out.println("Enter a message to send server");
//        Scanner scanner = new Scanner(System.in);
//        String message = scanner.nextLine();
//        out.write(message.getBytes());
//        socket.close();
    }
public void sendMessage(String message) throws IOException {
        message = message + "\n";
        out.write(message.getBytes());
}

public void readMessage(){
        worker = new ClientWorker(in,textArea);
        worker.start();
}
//    public static void main(String[] args) throws IOException {
//        Client client = new Client();
//    }
}
