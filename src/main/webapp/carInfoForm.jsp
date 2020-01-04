<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj auto</title>
</head>
<body>

<%!
    List<String> makes = Arrays.asList("Fiat", "Volkswagen",
            "Ford", "Volvo", "Honda", "Citroen");
%>

<form action="checkInfoForm.jsp" method="post">
    Marka
    <select name="make">
        <% for (String m : makes) { %>
        <option><%=m%></option>
        <% } %>
    </select>
    <br>
    Typ
    <input type="text" name="type"> <br>
    Rok produkcji
    <select name="year">
        <%for (int i = 2019; i >= 1980; i--) { %>
            <option><%=i%></option>
        <% } %>
    </select><br>
    Przebieg
    <select name="distance">
        <%for (int i = 0; i <= 1000000; i+= 100000) { %>
        <option><%=i%></option>
        <% } %>
    </select><br>
    Pojemność
    <select name="capacity">
        <%for (int i = 1; i <= 9; i++) { %>
        <option><%=i%></option>
        <% } %>
    </select>
    <input type="submit" value="Wyślij">
</form>

<%@include file="footer.html"%>
</body>
</html>
