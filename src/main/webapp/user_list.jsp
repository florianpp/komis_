<%@ page import="java.util.List" %>
<%@ page import="pl.altkom.web.Client" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 15.12.2019
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>Id</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Wiek</th>
        <th>Region</th>
        <th>Plec</th>
        <th>Akcja</th>
    </tr>

    <% Object oClients = request.getAttribute("clients"); %>
    <% List clients = (List) oClients; %>
    <% for (Object o : clients) { %>
        <% Client c = (Client)o; %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getFirstName() %></td>
            <td><%= c.getLastName() %></td>
            <td><%= c.getAge() %></td>
            <td><%= c.getRegion()%></td>
            <td><%= c.getSex()%></td>
            <td>
                <form action="delete_user_by_id">
                    <input type="text" disabled="true" name="id" value="<%= c.getId() %>">
                    <input type="submit" value="Usuń">
                </form>
            </td>
        </tr>
    <% } %>
</table>
</body>
</html>