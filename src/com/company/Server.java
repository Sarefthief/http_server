package com.company;
import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private String htmlPath;

    /**
     * @return int port number
     */
    public int getPort() {
        return port;
    }

    /**
     * @return string html path
     */
    public String getHtmlPath() {
        return htmlPath;
    }

    /**
     * @param port int port number
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @param htmlPath string html path
     */
    public void setHtmlPath(String htmlPath)
    {
        this.htmlPath = htmlPath;
    }

    /**
     * @throws IOException
     */
    public void start() throws IOException
    {
        try{
            ServerSocket server = new ServerSocket(port);
            ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
            System.out.println("Port number: " + port);
            while(true) {
                Socket client = server.accept();
                SocketProcessor thread = new SocketProcessor(client, htmlPath);
                pool.execute(thread);
            }
        } catch(BindException e){
            System.out.println("Port: " + port + " is unavailable. Please change port number in config.yml file.");
        }
    }
}