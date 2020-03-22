<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Stores | Admin </title>
    <jsp:directive.include file="/templates/fragments/css-links.jsp" />
</head>
<body>
<jsp:directive.include file="/templates/fragments/menu.jsp" />
<div class="container">

    <h1>Welcome to admin home page</h1>
    <a href="${pageContext.request.contextPath}/admin/list_users">Users</a>
</div>
</body>
</html>