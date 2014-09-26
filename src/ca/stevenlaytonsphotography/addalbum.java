package ca.stevenlaytonsphotography;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addalbum extends HttpServlet {
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		out.println(request.getParameter("data"));
		out.close();
	}

}
