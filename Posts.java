package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Posts {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		System.out.println("Connection is created");
		// CallableStatement cst=con.prepareCall("call titleupdate(?,?)");
		// cst.setInt(1,1);
		// cst.setString(2, "new post title");
		// cst.registerOutParameter(2, Types.VARCHAR);
		// int res=cst.executeUpdate();
		// String title=cst.getString(2);
		// System.out.println(title);

		//CallableStatement cst = con.prepareCall("call insertTitle(?,?)");
		//cst.setString(1, "third post title");
		//cst.setString(2, "Weather");
		//cst.registerOutParameter(1, Types.VARCHAR);
		//cst.registerOutParameter(2, Types.VARCHAR);
		//int res1 = cst.executeUpdate();
		//String title = cst.getString(1);
		//String body = cst.getString(2);
		//System.out.println(title);
		//System.out.println(body);

		CallableStatement cst = con.prepareCall("call deletePosts(?)");
		cst.setInt(1,2);
		int res = cst.executeUpdate();
		System.out.println("post is deleted");

	}

}
