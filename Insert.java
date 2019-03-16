package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
		System.out.println("Connection is created");
		Statement st = con.createStatement();
		String q = "insert into posts(title,body) values('Lio',11656.9)";
		ResultSet i = st.executeQuery(q);
		System.out.println("Rows affected : " + i);

	}
}
