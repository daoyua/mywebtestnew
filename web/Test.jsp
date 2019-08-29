<%@ page import="java.util.ArrayList" %><%--
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
<%--<jsp:include page="other.jsp"></jsp:include>--%>

<%--照搬另个jsp的代码--%>
<%--<%@include file="other.jsp" %>--%>

<%--跳转到哪个页面等同于请求转发--%>
<%--<jsp:forward page="other.jsp" >--%>
    <%--跳转到某个页面带参数，或者包含某个页面--%>
    <%--<jsp:param name="aa" value="aa"></jsp:param>--%>

    <%--获取跳转参数--%>
    <%--<%= request.getParameter("aa")%>--%>

<%--</jsp:forward>--%>
<%--<%--%>
<%--request.getRequestDispatcher("other.jsp").forward(request,response);--%>
<%--%>--%>
<%
    pageContext.setAttribute("name","hahhaha");
    String  []a={"aa","bb","cc"};
    pageContext.setAttribute("aaa",a);
    ArrayList list=new ArrayList();
    list.add("a1");
    list.add("vs");
    list.add("a3");
    list.add("a4");
    list.add("a5");
    pageContext.setAttribute("lis",list);
%>
<%--只能输出一个值--%>
<%--${--%>
        <%--u.a--%>
<%--}--%>
<%--el表达式内置对象pageScope,sessionScope,applicationScope,requestScope,pageContext,header,headerValues,param,paramValues,--%>
<%--cookie,initParam--%>
${
        pageScope.name;
        sessionScope.clear();
        requestScope.clear();
        applicationScope.name;
       lis[1]
        }
${
        lis[0]
        },
${
aaa[0]
},
${
        aaa[2]
        }

</body>
</html>
