<%--
  Created by IntelliJ IDEA.
  User: zy_futuremove
  Date: 2019/8/25
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="index.jsp" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
a的时间是多久
<%--<jsp:include page="other.jsp"></jsp:include>--%>
<%--<jsp:param name="" value=""></jsp:param>--%>
<%--<jsp:forward page="other.jsp"></jsp:forward>--%>
<%--把运行结果拿过来--%>
<jsp:include page="other.jsp"></jsp:include>
<%--照搬另个jsp的代码--%>
<%@include file="other.jsp" %>

    <%--跳转到哪个页面--%>
    <jsp:forward page="other.jsp"></jsp:forward>
<%--<%--%>
    <%--request.getRequestDispatcher("other.jsp").forward(request,response);--%>
<%--%>--%>
</body>
</html>
