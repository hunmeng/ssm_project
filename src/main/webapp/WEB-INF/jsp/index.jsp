<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>主页</head>
<%@include file="../../common/head.jsp" %>
<%@taglib prefix="t" uri="http://www.springframework.org/tags" %>
<body>
<h2>Hello World!</h2>
<h3><t:message code="hello.label" /> </h3>
<h3><t:message code="login.error.label" /> </h3>

    <a href="${ctx}/book/listBook" >查看书本</a>
    <a href="${ctx}/book/doAdd" >增加页面</a>
    <a href="${ctx}/index/i18n?locale=en" >修改英文</a>
    <a href="${ctx}/index/i18n?locale=zh" >修改中文</a>
    <input type="button"  value="nisms" /><br>
    <a href="${ctx}/file/dofile" >修改中文</a>

</body>
</html>
