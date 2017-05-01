package it.nerd.freetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadHTML {

	public static void main(String[] args) throws Exception {
		URL connectionURL = new URL("http://www.google.com/");
        BufferedReader in = new BufferedReader(new InputStreamReader(connectionURL.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();

	}

}
