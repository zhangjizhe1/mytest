<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload.jsp</title>
</head>
<body>
    <h1>文件上传表单</h1><hr/>
    <form action="${pageContext.request.contextPath}/my01/test01.action" method="POST" enctype="multipart/form-data">
        <input type="file" name="fx"/>
        <input type="submit"/>
    </form>
</body>
</html>
