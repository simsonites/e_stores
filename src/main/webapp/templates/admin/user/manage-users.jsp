<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Stores | Manage Users</title>
    <jsp:directive.include file="/templates/fragments/css-links.jsp" />
</head>
<body>
<jsp:directive.include file="/templates/fragments/menu.jsp" />
<div class="container">

    <div class="card">
        <div class="card-body">

            <!-- course section -->
            <div class="admin-tab-content mb-50">
                <section>
                    <h2>List Of Users</h2>
                    <div class="col-md-12 mb-30">
                        <div class="row">
                            <a href="${pageContext.request.contextPath}/admin/user_form"
                               class="col-md-2 btn btn-primary">
                                <span class="fa fa-plus"></span>
                                Add User
                            </a>

                            <div class="input-group col-md-10">
                                <input type="text" class="form-control" placeholder="enter a user name or email to search"
                                       aria-label="Recipient's username" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <span class="input-group-text btn btn-primary" id="basic-addon2">Search User</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-bordered table-striped table-hover">
                        <thead class="text-center">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email Address</th>
                            <th align="center" colspan="2">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>The First Name </td>
                            <td>The Last Name</td>
                            <td>The Email Address</td>
                           <td>
                                <a href="#" class="text-info">Edit</a>
                            </td>
                            <td>
                                <a href="#" class="text-danger">Delete</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </section>
            </div>
        </div>
    </div>
</div>
</body>
</html>