<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <td>Marka</td>
        <td><%= request.getParameter("make")%></td>
    </tr>
    <tr>
        <td>Typ</td>
        <td><%= request.getParameter("type")%></td>
    </tr>
    <tr>
        <td>Rok produkcji</td>
        <td><%= request.getParameter("production_year")%></td>
    </tr>
    <tr>
        <td>Przebieg</td>
        <td><%= request.getParameter("milage")%></td>
    </tr>
    <tr>
        <td>Pojemność</td>
        <td><%= request.getParameter("capacity")%></td>
    </tr>
</table>

<%@include file="footer.html"%>
</body>
</html>
