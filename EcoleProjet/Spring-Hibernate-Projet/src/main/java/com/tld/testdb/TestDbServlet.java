//package com.tld.testdb;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/TestDbServlet")
//public class TestDbServlet extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		 //set up connection varialbles
//		String user = "my-app-account";
//		String pwd = "my-app-pwd";
//
//		//jdbcurl compliant with MySQL 8
//		String jdbcUrl = "jdbc:mysql://localhost:3306/web_user_manager?useSSL=false&serverTimezone=UTC";
//		String driver = "com.mysql.jdbc.Driver";
//
//		try {
//			PrintWriter out= response.getWriter();
//			out.println("Connection à la base de données : " +jdbcUrl);
//
//			Class.forName(driver);
//
//			Connection connection = DriverManager.getConnection(jdbcUrl, user, pwd);
//			out.println("Connection effectuée !!");
//			connection.close();
//
//		}catch(SQLException e) {
//
//		e.printStackTrace();
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
