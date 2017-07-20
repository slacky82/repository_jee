package com.acme.main;

import java.util.Scanner;

import com.acme.file.walker.Walker;

public class MainClass {
	// 0 DOM 1 TEXT
	//"C:\Aptar1MES\git-repository\3.5.x/aptar-gmes-web\src\main\webapp\pages";
	// = "C:\Users\fabrizio\Desktop\skyWalker4.txt";

	public static void main(String[] args) {
		int type = Integer.valueOf(args[0]);
		String pathToScan = args[1];
		String outputPath = args[2];
		Walker wlk = new Walker(type,pathToScan,outputPath);
		wlk.parseMe();
	}

}
