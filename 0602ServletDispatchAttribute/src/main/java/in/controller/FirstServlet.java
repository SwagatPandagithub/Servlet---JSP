package in.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in servlet 1");
		
		ServletContext context =getServletContext();
		context.setAttribute("swagat", "java");
		context.setAttribute("kitu", "spring boot");
		
		RequestDispatcher reqDisp = request.getRequestDispatcher("/SecondServlet");
		reqDisp.forward(request, response);
	}

}
