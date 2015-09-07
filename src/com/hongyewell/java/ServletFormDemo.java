package com.hongyewell.java;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletFormDemo")
public class ServletFormDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	/*	aboutPost(request);
		aboutGet(request);*/
		test3(request,response);
	
	}
  

	//解决post提交的乱码
	private void aboutPost(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String info = request.getParameter("username");
		System.out.println(info);
	}


	//解决get提交的乱码 （手工处理）
	private void aboutGet(HttpServletRequest request) throws UnsupportedEncodingException {
		String info = request.getParameter("username");
		info = new String(info.getBytes("iso8859-1"),"UTF-8");	
		System.out.println(info);
	}
	
	//post提交的乱码的另一种方式
		private void test3(HttpServletRequest request, HttpServletResponse response) 
				throws IOException {
			request.setCharacterEncoding("UTF-8");
			String info = request.getParameter("username");
			
			response.setCharacterEncoding("gb2312");
			response.setContentType("text/html;charset=gb2312");
			response.getWriter().write(info);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		doGet(request, response);
	}

}
