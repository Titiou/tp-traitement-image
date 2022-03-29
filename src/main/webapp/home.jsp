<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<title>Truite</title>
</head>
<body>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>id</th>
				<th>title</th>
			</tr>
		</thead>
		<tbody class="thead-light">
			<%
			List<Integer> ids = (ArrayList<Integer>)request.getAttribute("id");
			List<String> titles = (ArrayList<String>)request.getAttribute("titre");
			List<String> images = (ArrayList<String>)request.getAttribute("image");
			for (int i = 0; i < ids.size(); ++i) {
			%>
			<tr>
				<td><%= ids.get(i) %></td>
				<td><%= titles.get(i) %></td>
				<td><img src=<%= images.get(i) %>/></td>
			</tr>
			<% } %>
		</tbody>
	</table>

</body>
</html>