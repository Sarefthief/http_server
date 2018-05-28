package com.company;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
        ServerSocket server = new ServerSocket(8080);
        while(true){
            try(Socket client = server.accept()){
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                client.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
}
