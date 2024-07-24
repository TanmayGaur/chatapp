package com.chatapp.network;
import com.chatapp.utils.ConfigReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    ServerSocket serverSocket;
    ArrayList<ServerWorker> workers = new ArrayList<>();

    //multiple Client
    public Server() throws IOException {
        int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server Started and waiting for the Client Connection");
        handleClientRequest();

    }

    //multiple client handshake
    public void handleClientRequest() throws IOException {
        while(true){
            Socket clientSocket = serverSocket.accept();
            //per client per thread
            ServerWorker serverWorker = new ServerWorker(clientSocket,this);
            workers.add(serverWorker);
            serverWorker.start();
        }
    }

    /*Single Client*/
    /*
    public Server() throws IOException {
        int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server Started and waiting for the Client Connection");
        Socket socket = serverSocket.accept();
        System.out.println("Client joins the server");
        InputStream in = socket.getInputStream();
        byte[] arr = in.readAllBytes();
        String str = new String(arr);
        System.out.println("message received : "+ str);
        in.close();
        socket.close();
    }*/
    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}
