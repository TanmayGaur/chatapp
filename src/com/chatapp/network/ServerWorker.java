package com.chatapp.network;

import java.io.*;
import java.net.Socket;
//worker = thread
public class ServerWorker extends Thread {
    private Socket clientSocket;
    private InputStream in;
    private OutputStream out;
    private Server server;

    public ServerWorker(Socket clientSocket, Server server) throws IOException {
        this.server = server;
        this.clientSocket = clientSocket;
        in = clientSocket.getInputStream();
        out = clientSocket.getOutputStream();
        System.out.println("new Client comes");
    }

    @Override
    public void run() {
        // read data from client and broadcast the data to all
        BufferedReader  br = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while(true){
                line = br.readLine(); // needs \n
                if(line.equalsIgnoreCase("quit")){
                    break;
                }
                //out.write(line.getBytes());
                // to broadcast to all clients
                for(ServerWorker serverWorker: server.workers){
                    line = line + "\n";
                    serverWorker.out.write(line.getBytes());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(br!=null){
                    br.close();
                }
                if(in!=null){
                    in.close();
                }
                if(out!=null){
                    out.close();
                }
                if(clientSocket!=null){
                    clientSocket.close();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

    }
}

