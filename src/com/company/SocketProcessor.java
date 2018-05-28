package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SocketProcessor implements Runnable
{
    private OutputStream outputStream;

    public SocketProcessor(Socket client) throws IOException
    {
        this.outputStream = client.getOutputStream();
        System.out.println("Поток создан");
    }

    public void run()
    {
        try{
            DataOutputStream out = new DataOutputStream(outputStream);
            byte[] content = Files.readAllBytes(Paths.get("response.html"));
            String html = new String(content);
            out.writeBytes("HTTP/1.1 200 OK\r\n");
            out.writeBytes("Content-Type: text/html\r\n\r\n");
            out.writeBytes(html);
            out.close();
        } catch (IOException e){
            System.out.println("Exception");
        }

    }
}
