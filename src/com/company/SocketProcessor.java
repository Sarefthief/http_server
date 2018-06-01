package com.company;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class SocketProcessor implements Runnable
{
    private OutputStream outputStream;
    private InputStream inputStream;
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
        this.inputStream = client.getInputStream();
    }

    /**
     * http response
     */
    public void run()
    {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while(true) {
                String s = br.readLine();
                if (s.contains("text")){
                    System.out.println("Connection established");
                }
                if(s == null || s.trim().length() == 0) {
                    break;
                }
            }

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
