package com.company;

import java.io.IOException;

public class ServerApp
{
    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
        server.start();
    }
}
