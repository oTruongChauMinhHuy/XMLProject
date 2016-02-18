<%-- 
    Document   : index
    Created on : Feb 14, 2016, 11:28:07 AM
    Author     : HuyTCM - Trương Châu Minh Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage page</title>
        <script type="text/javascript">
            function setData() {
                var currentDate = new Date();

                var ddlDate = document.getElementById("ddlDate");
                for (var i = 0; i < 3; i++) {
                    var optionDate = document.createElement("option");
                    var dateText = currentDate.getFullYear() + '-' +
                            (currentDate.getMonth() + 1) + '-' +
                            currentDate.getDate();
                    optionDate.setAttribute('value', dateText);
                    var dateTextNode = document.createTextNode(dateText);
                    optionDate.appendChild(dateTextNode);
                    currentDate = new Date(currentDate.getTime() + 24 * 60 * 60 * 1000);

                    ddlDate.appendChild(optionDate);
                }
            }
        </script>
    </head>
    <body onload="setData()">
        <c:set var="user" value="${sessionScope.USER}"/>
        <jsp:include page="${context}/header.jsp"/>
        <c:if test="${not empty user}">
            <div>
                <c:set var="trips" value="${requestScope.TRIPS}}"/>
                <form action="" method="GET">
                    Bus: <select name="ddlBus">
                        <c:if test="${not empty trips}">
                            <c:import var="xslt" url="/WEB-INF/BusDDL.xsl"/>
                            <x:transform doc="${trips}" xslt="${xslt}"/>
                        </c:if>
                    </select><br>
                    Date: <select name="ddlDate" id="ddlDate">
                    </select>
                    Hour: <input type="text" name="txtHour"/> Min: <input type="text" name="txtMin"/><br>
                    <c:set var="cars" value="${requestScope.CARS}"/>
                    <c:if test="${not empty cars}">
                        Car: <c:import var="xslt" url="/WEB-INF/CarDDL.xsl"/>
                        <x:transform doc="${cars}" xslt="${xslt}"/>
                    </c:if>
                </form>
            </div>
        </c:if>
    </body>
</html>
