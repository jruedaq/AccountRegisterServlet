<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Egress</title>
</head>
<body>
<h1>Egress</h1>
<form method="get" action="EgressServlet">
    <label> Select an option
        <select name="action">
            <option value="add">Add Egress</option>
            <option value="report">Egress Report</option>
        </select>
    </label><br>
    <input type="submit" value= "Send">
</form>
</body>
</html>