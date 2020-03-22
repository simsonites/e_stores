<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>eStores | Login</title>
    <jsp:directive.include file="/templates/fragments/css-links.jsp"/>
</head>
<body>
<jsp:directive.include file="/templates/fragments/menu.jsp"/>

<div class="container">
    ${log}
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Users Login Form</div>
                <div class="card-body">
                    <h2 align="center">Login</h2>

                    <form name="my-form" method="">

                        <div class="form-group row">
                            <label for="email" class="col-md-4 col-form-label text-md-right">
                                Email Address</label>
                            <div class="col-md-6">
                                <input type="email" id="email" class="form-control" name="email">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="password"
                                   class="col-md-4 col-form-label text-md-right">Password</label>
                            <div class="col-md-6">
                                <input type="password" id="password" class="form-control" name="password">
                            </div>
                        </div>
                        <div class="col-md-6 offset-md-4">
                            <button type="submit" class="btn btn-primary">
                                Login
                            </button>
                        </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
