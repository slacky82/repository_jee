package com.acme.splitfile;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        Util util = new Util();
        try {
			util.split(args[0], Long.valueOf(args[1]) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
