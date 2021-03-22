package com.main;

import com.main.checkbar.CheckBar;


public class App 
{
    public static void main( String[] args )
    {
        CheckBar check = new CheckBar();
        for (int i = 0; i < args.length; i++)
            check.check(args[i]);
    }
}

