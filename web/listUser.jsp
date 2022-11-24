
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Example Login JSP</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" 
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <link rel="stylesheet" href="css/listUser.css">
        <!-- jQuery library -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="card card-list-user">
                <div class="card-header d-flex align-items-center">
                    <div>List User</div>
                    <div class="ml-auto">
                        <a href="AddUser?action=forward" class="btn btn-add-user">Add User</a>
                    </div>
                </div>
                <div class="list-user">
                    <div class="row list-header">
                        <div class="col-md-1">id</div>
                        <div class="col-md-3">Username</div>
                        <div class="col-md-3">Email</div>
                        <div class="col-md-2">Phone</div>
                    </div>
                </div>
                <div class="list-user-body">
                    <c:forEach var="user" items="${users}" varStatus="loop">
                        <div class="row">
                            <div class="col-md-1">${loop.index + 1}</div>
                            <div class="col-md-3">${user.getUsername()}</div>
                            <div class="col-md-3">${user.getEmail()}</div>
                            <div class="col-md-2">${user.getPhone()}</div>
                            <div class="col-md-3">
                                <form action="DeleteUserServlet?id=${user.getId()}" method="POST">
                                    
                                    <a style="color:white;" href="Updetele?id=${user.getId()}" class="btn btn-primary float-right btn-delete-user" >EDIT</a>
                                    
                                    <input class="btn btn btn-danger float-right btn-updelete-user" type="submit" value="delete" onclick="return confirm('Are you sure you want to delete?')" />
                                </form>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="card-footer ">
                    LY XUAN HUE &copy;<script>document.write(new Date().getFullYear());</script>
                    Lap trinh java!
                </div>
            </div>
        </div>
    </body>
</html>
