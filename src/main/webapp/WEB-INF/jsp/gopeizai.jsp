<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>装车</title>
</head>
<body>

<form action="zhuangche">
    请选择：
    <select name="carid" id="carid" class=" span1" style=" height: 26px ; width: 99px">
        <option value="">-请选择-</option>
        <option value="1">苏E77888</option>
        <option value="2">苏E77999</option>
        <option value="3">苏E77666</option>
    </select>
    <br>
    <input type="hidden" name="id" value="${id}">
    <input type="submit" value="确认"/>
</form>
</body>
</html>
