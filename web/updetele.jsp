<%-- 
    Document   : updetele
    Created on : Nov 21, 2022, 8:39:32 AM
    Author     : DELL
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>List User</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/addUser.css">
        
        <!-- jQuery library -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container add-user-form">                
            <div class="card">
                <div class="card-header">Update USER</div>
                <form class="card-body" action="Updetele" method="POST">
                    <div class="form-group">
                        <input type="hidden" name="id" value="${st.getId()}">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" value="${st.getUsername()}" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" value="${st.getPassword()}"  required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" value="${st.getEmail()}" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" name="phone" value="${st.getPhone()}" >
                    </div>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>                
                <div class="card-footer">
                    <div class="text-center"> Tottenham &copy;<script>document.write(new Date().getFullYear());</script></div>

                    <h3>JAVA NANG CAO </h3>
                </div>
            </div>
        </div>
    </body>
</html>
