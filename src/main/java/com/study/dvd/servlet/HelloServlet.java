package com.study.dvd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")	
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name = "황인수";
//		
//		resp.setContentType("text/html");
////		resp.setContentType("text/plain"); 문자열 그대로 받아옴
//		resp.setCharacterEncoding("utf-8");
//		
//		resp.getWriter().println(""
//				+ "<html>"
//				+ "<head>"
//				+ "<title>hello</title>"
//				+ "</head>"
//				+ "<body>"
//				+ "<h1>Hello Servlet!! :D</h1>"
//				+ "<h2>" + name + "</h2>"
//				+ "</body>"
//				+ "</html>");
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");	// 파라미터는 무조건 문자열로 받아준다. 
		
		System.out.println(name);
		System.out.println(age);
		
		// 서블릿은 서버 내부에 들어있기 때문에 WEB-INF 폴더에 접근할 수 있음. 캡슐화 게터 세터의 느낌.
		req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
																  //(요청, 응답)
	}
}
