<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Dodaj użytkownika</title>
</head>
<body>
    <form action="add_user" method="post">
        Imię: <input type="text" name="firstName"> <br>
        Nazwisko: <input type="text" name="lastName"> <br>
        Wiek: <select name="age">
            <% for (int i = 1; i<= 100; i++) {%>
                <option><%= i %></option>
            <% } %>
        </select> <br>
        Region: <select name="region">
            <option>Polska</option>
            <option>Niemcy</option>
        </select><br>
        <input type="radio" name="sex" value="MALE"> Mężczyzna <br>
        <input type="radio" name="sex" value="FEMALE"> Kobieta <br>
        <input type="submit" value="Utwórz użytkownika">
    </form>
</body>
</html>