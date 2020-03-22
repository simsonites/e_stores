<html>
<head>
    <title>eStores | Add User</title>
    <jsp:directive.include file="/templates/fragments/css-links.jsp"/>
</head>
<body>
<jsp:directive.include file="/templates/fragments/menu.jsp"/>

<div class="container">
    ${message}
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">User Form</div>
                <div class="card-body">
                    <div align="center">
                        <h2 class="pageheading">
                            <c:if test="${user != null}">
                                <h2 align="center">Edit User</h2>
                            </c:if>
                            <c:if test="${user == null}">
                                <h2 align="center">Add New User</h2>
                            </c:if>
                        </h2>
                    </div>

                    <div align="center">
                        <c:if test="${user != null}">
                        <form action="${pageContext.request.contextPath}/admin/update_user"
                              method="post" id="userForm">
                            <input type="hidden" name="userId" value="${user.userId}">
                            </c:if>
                            <c:if test="${user == null}">
                            <form action="${pageContext.request.contextPath}/admin/create_user"
                                  method="post" id="userForm">
                                </c:if>

                                <div class="form-group row">
                                    <label for="first_name" class="col-md-4 col-form-label text-md-right">
                                        First Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="first_name" class="form-control" name="firstName">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="last_name" class="col-md-4 col-form-label text-md-right">
                                        Last Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="last_name" class="form-control" name="lastName">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="email" class="col-md-4 col-form-label text-md-right">Email
                                        Address</label>
                                    <div class="col-md-6">
                                        <input type="email" id="email" class="form-control" name="email">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                                    <div class="col-md-6">
                                        <input type="password" id="password" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="col-md-6 offset-md-4">
                                    <button type="submit" class="btn btn-primary">
                                        Save User
                                    </button>
                                </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:directive.include file="/templates/fragments/js.jsp"/>
</body>
</html>
