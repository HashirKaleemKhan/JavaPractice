

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hello
 */

public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res.setContentType("text/html");
//		PrintWriter out = res.getWriter();
//		out.print("<html><body>");
//		out.print("<h3>Hello Servlet</h3>");
//		out.print("</html></body>");
		
		res.setContentType("text/html");  
		PrintWriter pw=res.getWriter();  
		  
		String name=req.getParameter("name");//will return value  
		pw.println("Welcome "+name);  
		  
		pw.close();  
	}

}
