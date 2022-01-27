
<html>
<head>

</head>
<body>

	<%   
  
		String name=request.getParameter("uname");  
		out.print("Welcome "+name);  
  
		session.setAttribute("user",name);  
  
		  
  
	%>  
<a href="third.jsp">second jsp page</a>
</body>
</html>