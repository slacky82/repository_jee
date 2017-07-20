package com.acme.file.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserDOM implements Parser {

	public List<String> parseFile(String filePath) {
		List<String> wolkeRow = new ArrayList<String>();
		int row = 0;
		try {
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			// System.out.println("Root element :" +
			// doc.getDocumentElement().getNodeName());

			// GET ALL NODES
			NodeList nList = doc.getElementsByTagName("*");

			// System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					if (!eElement.getAttribute("rendered").isEmpty()) {
						System.out.println(filePath + " " + "rendered : " + eElement.getAttribute("rendered"));
						wolkeRow.add("row: " + row++ + "Current Element :" + nNode.getNodeName() + " " + filePath + " "
								+ "rendered: " + eElement.getAttribute("rendered"));
					}
					if (!eElement.getAttribute("accessPrivilege").isEmpty()) {
						System.out.println(
								filePath + " " + "accessPrivilege : " + eElement.getAttribute("accessPrivilege"));
						wolkeRow.add("Current Element :" + nNode.getNodeName() + " " + filePath + " "
								+ "accessPrivilege: " + eElement.getAttribute("accessPrivilege"));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wolkeRow;
	}
}
