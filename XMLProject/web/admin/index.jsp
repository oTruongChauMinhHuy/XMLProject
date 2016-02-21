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
            function setDate() {
                var currentDate = new Date();

                var ddlDate = document.getElementById("ddlDate");
                for (var i = 0; i < 3; i++) {
                    var optionDate = document.createElement("option");
                    var year = currentDate.getFullYear();
                    var month = currentDate.getMonth() > 9 ? (currentDate.getMonth() + 1) : "0" + (currentDate.getMonth() + 1);
                    var date = currentDate.getDate() < 10 ? "0" + currentDate.getDate() : currentDate.getDate();
                    var dateText = year + '-' + month + '-' + date;
                    optionDate.setAttribute('value', dateText);
                    var dateTextNode = document.createTextNode(dateText);
                    optionDate.appendChild(dateTextNode);
                    currentDate = new Date(currentDate.getTime() + 24 * 60 * 60 * 1000);

                    ddlDate.appendChild(optionDate);
                }
            }
        </script>
    </head>
    <body onload="setDate()">
        <c:set var="user" value="${sessionScope.USER}"/>
        <jsp:include page="${context}/header.jsp"/>
        <c:if test="${not empty user}">
            <div class="main-container col-lg-11">
                <div class="col-lg-5">
                    <form action="../ControllerServlet" method="GET">
                        <c:import var="xslt" url="/WEB-INF/BusDDL.xsl"/>
                        Bus: <select name="ddlBus">
                            <option value="LK">Long Khánh - Sài Gòn</option>
                            <option value="SG">Sài Gòn - Long Khánh</option>
                        </select><br>
                        Date: <select name="ddlDate" id="ddlDate">
                        </select>
                        Hour: <select name="txtHour" style="width: 40px;">
                            <c:forEach var="i" begin="4" end="18">
                                <c:if test="${i < 10}">
                                    <option value="0${i}">0${i}</option>
                                </c:if>
                                <c:if test="${i >= 10}">
                                    <option value="${i}">${i}</option>
                                </c:if>
                            </c:forEach>
                        </select> 
                        Min: <select name="txtMin" style="width: 40px;">
                            <option value="00">00</option>
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select><br>
                        <c:set var="cars" value="${requestScope.CARS}"/>
                        <c:if test="${not empty cars}">
                            Car: <c:import var="xslt" url="/WEB-INF/CarDDL.xsl"/>
                            <x:transform doc="${cars}" xslt="${xslt}"/>
                        </c:if>
                        <input type="submit" name="btnAction" value="AddTrip"/>
                    </form>
                </div>
                <div class="col-lg-11">
                    <c:import var="xmldoc" url="../trips.xml"/>
                    <c:import var="tripsXSLT" url="TripsDDL.xsl"/>
                    <c:if test="${not empty xmldoc}">
                        <x:transform doc="${xmldoc}" xslt="${tripsXSLT}"/>
                    </c:if>
                </div>
            </div>
        </c:if>
    </body>
</html>
