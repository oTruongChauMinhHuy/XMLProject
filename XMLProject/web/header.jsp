<%-- 
    Document   : header
    Created on : Feb 7, 2016, 12:52:04 AM
    Author     : HuyTCM - Trương Châu Minh Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${context}/lib/bootstrap.min.css" />
<c:set var="user" value="${sessionScope.USER}"/>

<c:if test="${empty user}">
    <jsp:forward page="${context}/Login.jsp"/>
</c:if>
<c:if test="${not empty user}">
    <nav id="topbar">
        <div class="nav-logo">
            <a id="logo" href="index.jsp">
                <span class="logo-text">CarTrip</span>
            </a>
        </div>
        <div class="nav-user">
            <a data-hover="dropdown" href="#" class="user-pro">
                <img src="${context}/images/48.jpg" alt="" class="ava-img"/>
                <span class="user-name">${user}</span>
            </a>
        </div>
    </nav>
</c:if>