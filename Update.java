package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		System.out.println("Connection is created");
		Statement st = con.createStatement();
		String q = "update posts set title='khushi'where id=1";
		int i = st.executeUpdate(q);
		System.out.println("Rows affected : " + i);

	}

}
