<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<form action="modify" method="">
    发货日期：
    <input type="text" value="${send.senddate}" name="senddate"><br>
    <input type="hidden" value="${send.id}" name="id">
    起站：
    <input type="text" value="${send.start}" name="start"><br>
    到站：
    <input type="text" value="${send.end}" name="end"><br>
    发货单号：
    <input type="text" value="${send.sendnum}" name="sendnum"><br>
    发货人：
    <input type="text" value="${send.sender}" name="sender"><br>
    收货人：
    <input type="text" value="${send.taker}" name="taker"><br>
    发货人电话：
    <input type="text" value="${send.serderphone}" name="serderphone"><br>
    收货人电话：
    <input type="text" value="${send.takerphone}" name="takerphone"><br>
    货物名字：
    <input type="text" value="${send.goods}" name="goods"><br>
    付款方式：
    <input type="text" value="${send.paytype}" name="paytype"><br>
    送货方式：
    <input type="text" value="${send.sendtype}" name="sendtype"><br>
    货物状态：
    <input type="text" value="${send.goodsname}" name="goodsname"><br>
    <input type="submit" value="提交"><br>
</form>

</body>
</html>
