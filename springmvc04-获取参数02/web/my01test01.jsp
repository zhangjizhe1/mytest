<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>my01test01.jsp</title>
</head>
<body>
    <h1>GET提交</h1><hr/>
    <form action="${pageContext.request.contextPath}/my01/test01.action" method="GET">
        用户名:<input type="text" name="uname"/>
        地址:<input type="text" name="uaddr"/>
        <input type="submit"/>
    </form>
    <h1>POST提交</h1><hr/>
    <form action="${pageContext.request.contextPath}/my01/test01.action" method="POST">
        用户名:<input type="text" name="uname"/>
        地址:<input type="text" name="uaddr"/>
        <input type="submit"/>
    </form>
</body>
</html>
