<%@page import="cn.standard.tools.PieChart "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>发货排行榜</title>
 <%--   <%
        String fileName = PieChart.genBarChart(session);
        System.out.println(fileName);
    %>--%>
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
</head>
<body>
<script>

    $(document).ready(function () {
        $.getJSON("paixue",callBack);
        function callBack(data) {
            var name = "DisplayChart?filename="+data.fileName
            $("#pic").attr("src",name);
        }
    })
</script>
统计结果:<br>
    <%--<img src="DisplayChart?filename=<%=fileName%>" width="700" height="500">--%>
    <img src="" width="700" height="500"id="pic">
</body>
</html>