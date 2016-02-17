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
    </head>
    <body>
        <c:set var="user" value="${sessionScope.USER}"/>
        <jsp:include page="header.jsp"/>
        <c:if test="${not empty user}">
            <div class="main-container col-lg-11">
                <div>
                    Tuyến: <select name="ddlBuses" id="ddlBuses" onchange="changeTrip()">
                        <option value="1">Long Khánh - Sài Gòn</option>
                        <option value="2">Sài Gòn - Long Khánh</option>
                    </select>
                    ---
                    Chuyến: <select name="ddlTrip" id="ddlTrip" onchange="changeTrip()">
                        <option value="06022015">06/02/2015</option>
                        <option value="07022015">06/02/2015</option>
                    </select>
                </div>
                <div class="col-lg-6">
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Thời gian</th>
                                <th>Còn trống</th>
                                <th>Trạng thái</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="warning" onclick="chooseTime('LK070220150700')" id="LK070220150700">
                                <td>07:00</td>
                                <td>06</td>
                                <td>Sắp hết</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-5">
                    <table border="1" class="car table table-bordered">
                        <form action="Checkout.jsp" name="checkout-form" method="GET" onsubmit="return validate()">
                            <input id="form-Time" type="hidden" name="txtTripID"/>
                            <tr>
                                <td colspan="2" class="disabled">0</td>
                                <td class="disabled"></td>
                                <td id="1" colspan="2" onclick="chooseSeat(1)">
                                    1
                                    <input type="checkbox" name="chkSeat" value="1" hidden="" id="seatNum-1"/>
                                </td>
                            </tr>
                            <tr>
                                <td id="2" onclick="chooseSeat(2)" class="">
                                    2
                                    <input type="checkbox" name="chkSeat" value="2" hidden="" id="seatNum-2"/>
                                </td>
                                <td id="3" onclick="chooseSeat(3)" class="">3</td>
                                <td class="disabled"></td>
                                <td id="4" onclick="chooseSeat(4)" class="">4</td>
                                <td id="5" onclick="chooseSeat(5)" class="">5</td>
                            </tr>
                            <tr>
                                <td id="6" onclick="chooseSeat(6)" class="">6</td>
                                <td id="7" onclick="chooseSeat(7)" class="">7</td>
                                <td class="disabled"></td>
                                <td id="8" onclick="chooseSeat(8)" class="">8</td>
                                <td id="9" onclick="chooseSeat(9)" class="">9</td>
                            </tr>
                            <tr>
                                <td id="10" onclick="chooseSeat(10)" class="">10</td>
                                <td id="11" onclick="chooseSeat(11)" class="">11</td>
                                <td class="disabled"></td>
                                <td id="12" onclick="chooseSeat(12)" class="">12</td>
                                <td id="13" onclick="chooseSeat(13)" class="">13</td>
                            </tr>
                            <tr>
                                <td id="14" onclick="chooseSeat(14)" class="">14</td>
                                <td id="15" onclick="chooseSeat(15)" class="">15</td>
                                <td class="disabled"></td>
                                <td id="16" onclick="chooseSeat(16)" class="">16</td>
                                <td id="17" onclick="chooseSeat(17)" class="">17</td>
                            </tr>
                            <tr>
                                <td id="18" onclick="chooseSeat(18)" class="">18</td>
                                <td id="19" onclick="chooseSeat(19)" class="">19</td>
                                <td class="disabled"></td>
                                <td id="20" onclick="chooseSeat(20)" class="">20</td>
                                <td id="21" onclick="chooseSeat(21)" class="">21</td>
                            </tr>
                            <tr>
                                <td id="22" onclick="chooseSeat(22)" class="" colspan="2">22</td>
                                <td id="23" onclick="chooseSeat(23)" class="">23</td>
                                <td id="24" onclick="chooseSeat(24)" class="" colspan="2">24</td>
                            </tr>
                    </table>
                    <input type="submit" value="Checkout" name="btnAction" class="btn btn-success"/>
                    </form>
                </div>
            </div>
        </c:if>
        <script>
            function changeTrip() {
                var bus = document.getElementById("ddlBuses").value;
                var trip = document.getElementById("ddlTrip").value;
                var url = "?ddlBus=" + bus + "&ddlTrip=" + trip + "&btnAction=getTrip";
                //                                        $.ajax({
                //                                            url: url,
                //                                            dataType: 'text'
                //                                        }).done(function result(result) {
                //                                            alert(result);
                //                                        });

            }
            function chooseTime(timeId) {
                document.getElementById("form-Time").value = timeId;
                document.getElementById("" + timeId).className = '';
                document.getElementById("" + timeId).classList.add("info");
            }
            function chooseSeat(index) {
                var checked = document.getElementById("seatNum-" + index).checked;
                if (!checked) {
                    document.getElementById("seatNum-" + index).checked = true;
                    document.getElementById("" + index).classList.add("selected");
                } else {
                    document.getElementById("seatNum-" + index).checked = false;
                    document.getElementById("" + index).classList.remove("selected");
                }
            }
            function validate() {
                var tripID = document.forms['checkout-form']['txtTripID'].value;
                var chkSeat = document.forms['checkout-form']['chkSeat'];
                if (tripID === null || tripID === "") {
                    alert("Vui lòng chọn chuyến!");
                    return false;
                }
                var isValidate = false;
                var seats = "";
                for (var i = 0; i < chkSeat.length; i++) {
                    if (chkSeat[i].checked) {
                        seats += "&seats=" + i;
                        isValidate = true;
                    }
                }
                if (!isValidate) {
                    alert("Vui lòng chọn ghế!");
                }
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4) {
                        var data = xhr.responseText;
                        alert(data);
                    }
                }
                xhr.open('GET', 'CheckSeats?txtTripID='+tripID + seats, true);
                xhr.send(null);
                return isValidate;
            }
        </script>
    </body>
</html>
