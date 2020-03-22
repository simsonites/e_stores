<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>eStores | Home</title>
    <jsp:directive.include file="/templates/fragments/css-links.jsp" />
</head>
<body>
<jsp:directive.include file="/templates/fragments/menu.jsp" />

<div class="container">
    <div class="row">
        <h2>Welcome to E-Stores</h2>
    </div>

    <a href="${pageContext.request.contextPath}/admin">Admin Page</a> &nbsp;|
    <a href="${pageContext.request.contextPath}/login">Login</a>
</div>
</body>
</html>
