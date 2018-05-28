package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Server
{
    private int port;
    private String htmlPath;

    public int getPort()
    {
      return port;
    }

    public String getHtmlPath()
    {
        return htmlPath;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public void setHtmlPath(String htmlPath)
    {
        this.htmlPath = htmlPath;
    }

    public void runServer() throws IOException
    {
        ServerSocket server = new ServerSocket(8090);
        while(true){
            try(Socket client = server.accept()){
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                byte[] encoded = Files.readAllBytes(Paths.get("C:/Projects/123.html"));
                String html = new String(encoded);
                out.writeBytes("HTTP/1.1 200 OK\r\n");
                out.writeBytes("Content-Type: text/html\r\n\r\n");
                out.writeBytes(html);
            }
        }
    }
}
