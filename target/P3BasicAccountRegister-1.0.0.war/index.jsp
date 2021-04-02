<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>gastos</title>
</head>
<body>
<h1>Gastos</h1>
<form method="get" action="ServletGastos">
    <select name="accion">
        <option value="agregar">Agregar gasto</option>
        <option value="reporte">Reporte de gastos</option>
    </select><br>
    <input type="submit" value= "Enviar">
</form>
</body>
</html>