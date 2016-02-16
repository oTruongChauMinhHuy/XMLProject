<%-- 
    Document   : Login
    Created on : Feb 15, 2016, 10:39:53 AM
    Author     : HuyTCM - Trương Châu Minh Huy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/lib/bootstrap.min.css" />
        <title>Login page</title>
    </head>
    <body>
        <div class="form-container">
            <form action="ControllerServlet" method="POST" class="login-form">
                <c:set var="message" value="${requestScope.msg}"/>
                <c:if test="${not empty message}">
                    <font color="red">${message}</font>
                </c:if>
                <table>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="txtUsername"/></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="txtPassword"/></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="btnAction" value="Login"/>
                        </td>
                        <td>
                            <input type="reset" value="Reset"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
