<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test02.jsp</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.2.6.js"></script>
    <script type="text/javascript">
        function sendData(){
            //准备数据
            var data1={"id":3,"name":"zs","addrs":["bj","sh","gz"]}
            //发送数据
            $.ajax({
                type:"POST", 		//必须以POST方式提交，必须大写
                url:"${pageContext.request.contextPath}/my01/test02.action",
                dataType:"json",
                contentType:"application/json",    	//已json格式处理
                data:JSON.stringify(data1),	//将js对象转换为json串
                success:function(data){
                    alert("success");
                }
            });
        }
    </script>
</head>
<body>
    <input type="button" onclick="sendData()" value="点我"/>
</body>
</html>
