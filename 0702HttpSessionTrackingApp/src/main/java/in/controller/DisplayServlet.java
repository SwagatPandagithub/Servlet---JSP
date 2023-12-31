package in.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/disp")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String studMobile = request.getParameter("smobile");
		String studEmail = request.getParameter("semail");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("Mobile", studMobile);
		session.setAttribute("Email", studEmail);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head>");		
		out.println("<body bgcolor='lightgreen'>");
		out.println("<center>");
		out.println("<h1 style = 'color:green; text-align:center'>Registration details...</h1>");
		out.println("<table border = '1'>");
		out.println("<tr><th>   Attribute Name   </th><th>     Attribute Values     </th></tr>");
		
		Enumeration<String> attributeNames = session.getAttributeNames();
		while(attributeNames.hasMoreElements()) {
			String attributeName = attributeNames.nextElement();
			Object attributeValue = session.getAttribute(attributeName);
			out.println("<tr><th>"+attributeName+"</th><th>"+attributeValue+"</th></tr>");
		}
		
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("The request session id used is ::"+request.getRequestedSessionId());
		
		out.close();

	}

}
