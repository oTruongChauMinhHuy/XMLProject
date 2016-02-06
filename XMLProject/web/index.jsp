<%-- 
    Document   : index
    Created on : Jan 18, 2016, 6:19:24 PM
    Author     : HuyTCM1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            body {
                background-color: #eee;
                margin: 0;
            }
            #topbar {
                width: 100%;
                height: 50px;
                background-color: activeborder;
                display: block;
            }
            #topbar .nav-logo {
                width: 100px;
                height: 100%;
                background: #1E1E1E;
                text-align: center;
                display: inline-block;
            }
            #topbar .nav-user {
                display: inline-block;
                float: right;

            }
            .user-pro {
                display: inline-block;
                text-align: center;
                height: 100%;
                text-decoration: none;
            }
            .ava-img {
                border-radius: 50%;
            }
            .user-name {
                position: relative;
                margin-top: 0;
                color: #ffffff;
                font-size: 25px;
            }
            #logo {
                color: #ffffff;
                width: 100%;
                padding-top: 15px;
                text-decoration: none;
            }
            #logo .logo-text {
                font-size: 30px;
            }
            .container {
                padding-right: 15px;
                padding-left: 15px;
                margin-right: auto;
                margin-left: auto;
            }
            .login-form {
                max-width: 330px;
                padding: 15px;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <c:set var="context" value="${pageContext.request.contextPath}" />
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:if test="${not empty user}">
            <div class="container">
                <form action="" method="POST" class="login-form">
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
        </c:if>
        <c:if test="${empty user}">
            <nav id="topbar">
                <div class="nav-logo">
                    <a id="logo" href="index.jsp">
                        <span class="logo-text">CarTrip</span>
                    </a>
                </div>
                <div class="nav-user">
                    <a data-hover="dropdown" href="#" class="user-pro">
                        <img src="${context}/images/48.jpg" alt="" class="ava-img"/>
                        <span class="user-name">Robert John</span>
                    </a>
                </div>
            </nav>
        </c:if>
    </body>
</html>
