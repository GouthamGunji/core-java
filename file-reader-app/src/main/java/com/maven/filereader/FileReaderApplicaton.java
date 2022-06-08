package com.maven.filereader;

import java.util.List;

import com.maven.filereader.beans.UserModel;
import com.maven.filereader.parser.UserController;

public class FileReaderApplicaton {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UserController controller = new UserController();
		List<UserModel> userList = controller.xmlParser();

		for (UserModel userModel : userList) {
			System.out.println(userModel);

		}

	}

}
