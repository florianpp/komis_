<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testowa strona JSP</title>
</head>
<body>
<%! int counter = 0; %>

<%= counter++ %>

<br><br>

<%= LocalDate.now() %>

<br><br>

<ul>
<% for (int i = 0; i < 10; i++) { %>
<%--<% out.println(i); %>--%>
<li>
<%= i %><br>
</li>
<% } %>
</ul>
</body>
</html>
