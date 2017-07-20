package com.acme.file.walker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


import com.acme.file.parser.Parser;
import com.acme.file.parser.ParserDOM;
import com.acme.file.parser.ParserFile;
import com.acme.utils.TypeParser;

public class Walker {
	
	protected List<String> allRowWolker = new ArrayList<String>();
	private String path; // = "C:/Aptar1MES/git-repository/3.5.x/aptar-gmes-web/src/main/webapp/pages";
	private String pathFileOutput; // = "C:/Users/fabrizio/Desktop/skyWalker4.txt";

	private Parser pFile;
	
	public Walker(int type, String pathToScan,String outputPath){
		init(type, pathToScan, outputPath);
	}
	
	private void init(int type, String pathToScan, String outputPath ){
		this.path = pathToScan; 
		this.pathFileOutput = outputPath;
		
		if (type == 0) {
			pFile = new ParserDOM();
		}
		if (type == 1) {
			pFile = new ParserFile();
		}
	}
	
	public void parseMe(){
		walk(pFile);
		System.out.println("END PARSING check file output on: "+ pathFileOutput);
	}
	
	private void walk(final Parser pFile) {
		try {
			Path startPath = Paths.get(path);

			Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {

				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
					// TODO
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
					if (file.toString().endsWith(".xhtml")) {
						//PARSING
						allRowWolker.addAll(pFile.parseFile(file.toString()));
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException e) {
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		createOutputFile(allRowWolker,pathFileOutput);
	}
	
	private void createOutputFile(List<String> allRowWolker, String pathFileOutput) {
		try {
			FileWriter fileWriter = new FileWriter(pathFileOutput);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (String row : allRowWolker) {
				System.out.println(row);
				bufferedWriter.write(row);
				bufferedWriter.write("\n");
			}
			bufferedWriter.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
