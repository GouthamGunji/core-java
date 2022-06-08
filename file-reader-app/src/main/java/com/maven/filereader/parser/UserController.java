package com.maven.filereader.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.maven.filereader.beans.UserModel;

public class UserController {

	public List<UserModel> xmlParser() throws Exception {
		List<UserModel> userList = new ArrayList<>();
		File file = new File("C://Spring/user_details.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(file);

		NodeList nodeList = document.getElementsByTagName("name");

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) node;

				String firstName = element.getElementsByTagName("first_name").item(0).getTextContent();
				String lastName = element.getElementsByTagName("last_name").item(0).getTextContent();
				UserModel model = new UserModel(firstName, lastName);
				userList.add(model);
			}
		}

		return userList;
	}

}
