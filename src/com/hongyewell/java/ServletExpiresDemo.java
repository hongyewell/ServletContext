package com.hongyewell.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//控制浏览器缓存
@WebServlet("/ServletExpiresDemo")
public class ServletExpiresDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		response.setDateHeader("expires", 1000*3600);  //没有加上当前时间，默认为1970年
		
		response.setDateHeader("expires", System.currentTimeMillis()+1000*3600);
		String data = "heheheheda";
		response.getWriter().write(data);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
