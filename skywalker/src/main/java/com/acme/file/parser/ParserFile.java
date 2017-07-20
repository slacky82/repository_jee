package com.acme.file.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserFile implements Parser {
	
	public List<String> parseFile(String filePath) {
		List<String> wolkeRow = new ArrayList<String>();
		try {
			int row = 0;
			File file = new File(filePath);
			final Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				final String lineFromFile = scanner.nextLine();
				++row;
				// if (lineFromFile.contains("#{wdf:hasPermission(")) {
				if (lineFromFile.matches(".*(wdf:hasPermission|accessPrivilege=).*")) {
					wolkeRow.add(filePath + "° " + "row:" + row + "° " + lineFromFile.toString());
				} else {
					// TODO
				}
			}
			scanner.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return wolkeRow;
	}

	

}
