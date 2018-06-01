package com.company;

import java.util.Scanner;

public class ExitThread implements Runnable
{
    public void run()
    {
        while(true) {
            Scanner input = new Scanner(System.in);
            String exit = input.nextLine();
            if (exit.equals("exit")) {
                System.exit(0);
            }
        }
    }
}
