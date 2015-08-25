package com.hongyewell.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletContextDemo")
public class ServletContextDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void test(){
		
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		System.out.println("当前读取到的资源名称是："+filename);
		
		try {
			FileInputStream in = new FileInputStream(path);
			Properties props = new Properties();            //map
			try {
				props.load(in);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		    test();
		    
		    
			InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
			Properties props = new Properties();            //map
			props.load(in);
			
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
	}

}
