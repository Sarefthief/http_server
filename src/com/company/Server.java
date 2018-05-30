package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private int port;
    private String htmlPath;

    public int getPort() {
        return port;
    }

    public String getHtmlPath() {
        return htmlPath;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setHtmlPath(String htmlPath)
    {
        this.htmlPath = htmlPath;
    }

    public void start() throws IOException
    {
        ServerSocket server = new ServerSocket(port);
        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        while(true) {
            Socket client = server.accept();
            SocketProcessor thread = new SocketProcessor(client, htmlPath);
            pool.execute(thread);
        }
    }
}