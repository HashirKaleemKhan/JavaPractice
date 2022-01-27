<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Jsp Page</title>
</head>
<body>

<!-- Scriplet Tag -->
<% 
	out.print("Hello user number "+5+" The sum of "+i+" and "+j+" is: ");
%>

<!-- Expression Tag -->

<%= sum(i,j) %>

<!-- Declaration Tag -->
<%!	
	int i = 5, j = 2, sum ;
	public int sum(int i, int j)
	{
		sum = i+j;
		return sum;
	}
%>

<%    
	out.print("Welcome "+request.getParameter("fname"));  
  
	String driver=config.getInitParameter("dname");  
	out.print("driver name is="+driver);  
 
%>
<% response.sendRedirect("http://google.com/search?q="+request.getParameter("uname")); %>
</body>
</html>