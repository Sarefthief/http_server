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
    private String htmlPath;

    /**
     * @param client client socket
     * @param htmlPath string path to html response file
     * @throws IOException
     */
    public SocketProcessor(Socket client, String htmlPath) throws IOException
    {
        this.htmlPath = htmlPath;
        this.outputStream = client.getOutputStream();
        System.out.println("Сonnection established");
    }

    /**
     * http response
     */
    public void run()
    {
        try{
            DataOutputStream out = new DataOutputStream(outputStream);
            byte[] content = Files.readAllBytes(Paths.get(htmlPath));
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
