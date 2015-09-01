package com.hongyewell.java;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//控制浏览器定时刷新
@WebServlet("/ServletRefresh")
public class ServletRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	//模拟一个meta请求头，实现自动跳转
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//假设这是一个用于处理登录的servlet
		
		//假设程序运行到此，用户登录成功了
		
		String message = "<meta http-equiv='refresh' content='3;url=index.jsp'>"
				+ "恭喜你，登录成功，作为一个高级智能浏览器，我将在3秒后跳到首页，"
				+ "如果没有跳，请自行点击<a href=''>超链接</a>跳转";
		
		this.getServletContext().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}
	private void test2(HttpServletResponse response)throws ServletException, IOException{
		//假设这是一个用于处理登录的servlet
		
		//假设程序运行到此，用户登录成功了
		response.setCharacterEncoding("UTF-8");  //设置编码
		response.setContentType("text/html;chartset=UTF-8");
		response.setHeader("refresh", "3;url='index.jsp");
		response.getWriter().write("恭喜你，登录成功，作为一个高级智能浏览器，我将在3秒后跳到首页，"
				           + "如果没有跳，请自行点击<a href=''>超链接</a>跳转");
				
				
		
	}
	
	private void test1(HttpServletResponse response)throws ServletException, IOException{
		//设置每隔三秒响应一次
				response.setHeader("refresh", "3");
				
			    //生成一个随机数  ，通过+"  "转换成字符串类型
				String data = new Random().nextInt(1000000)+" ";
				
				//将字符串data写出
				response.getWriter().write(data);
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
