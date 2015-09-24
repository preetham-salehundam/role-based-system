<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body>
<%
session.invalidate();
while(session==null){
%>
<h3>logged out successfully</h3>
	<div class="login" align="center">
		<table>
				<tr>
					<td><form method="post" action="index.html"><input type="submit" value="Login"/></form>		
		
		</table></div>
		
<%}
%>
</body>
</html>
