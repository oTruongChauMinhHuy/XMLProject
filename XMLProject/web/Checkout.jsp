<%-- 
    Document   : Checkout
    Created on : Feb 7, 2016, 12:58:52 AM
    Author     : HuyTCM - Trương Châu Minh Huy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function getData() {
                var regexTime = /[\\?&]txtTripID=([^&#]*)/;
                var regex = new RegExp(regexTime);
                var results = regex.exec(window.location.href);
                var time = results[1];

                var regexSeat = /chkSeat=(.*?)&/g;
                var results1 = window.location.href.match(regexSeat).map(function(val) {
                    return val.replace('chkSeat=', '').replace('&', '');
                });
                setData(time, results1);
            }
            function setData(time, seats) {
                var form = document.getElementById("form-checkout");

                var locate = time.substring(0, 2) === 'LK' ? 'Long Khánh' : 'Sài Gòn';
                var tripText = locate + " : " + time.substring(2, 6) + "/" + time.substring(6, 8) + "/" + time.substring(8, 10)
                        + " Giờ: " + time.substring(10, 12) + ":" + time.substring(12, 14);
                document.getElementById('tripDecs').innerHTML = tripText;
                var inputTimeNode = document.createElement('input');
                inputTimeNode.setAttribute('type', 'hidden');
                inputTimeNode.setAttribute('name', 'txtTripID');
                inputTimeNode.setAttribute('value', time);
                form.appendChild(inputTimeNode);

                // Get table body
                var tableBody = document.getElementById("table-body");
                for (var i = 0; i < seats.length; i++) {
                    //Create table row        
                    var tr = document.createElement('tr');
                    // Table data No.
                    var tdNo = document.createElement('td');
                    var tdNoText = document.createTextNode(i + 1);
                    tdNo.appendChild(tdNoText);
                    tr.appendChild(tdNo);

                    // Table data seat's number
                    var tdSeatNum = document.createElement('td');
                    var tdSeatNumText = document.createTextNode(seats[i]);
                    tdSeatNum.appendChild(tdSeatNumText);
                    tr.appendChild(tdSeatNum);

                    // Table data unit price
                    var tdUnitPrice = document.createElement('td');
                    var tdUnitPriceText = document.createTextNode('50000');
                    tdUnitPrice.appendChild(tdUnitPriceText);
                    tr.appendChild(tdUnitPrice);

                    // Table data check box
                    var tdCheckBox = document.createElement('td');
                    var inputChk = document.createElement('input');
                    inputChk.setAttribute('type', 'checkbox');
                    inputChk.setAttribute('name', 'chkSeat');
                    inputChk.setAttribute('value', seats[i]);
                    inputChk.setAttribute('checked', true);
                    tdCheckBox.appendChild(inputChk);
                    tr.appendChild(tdCheckBox);

                    tableBody.appendChild(tr);

                    countDown(30);
                }
            }
            function countDown(i) {
                var num = setInterval(function() {
                    document.getElementById("countDown").innerHTML = i;
                    if (i-- <= 0) {
                        clearInterval(num);
                        var tripID = document.getElementsByName('txtTripID')[0].value;
                        var chkSeats = document.getElementsByName('chkSeat');
                        var seats = "";
                        for (var j = 0; j < chkSeats.length; j++) {
                            seats += "&chkSeat=" + chkSeats.item(j).value;
                        }
                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', 'CheckoutServlet?btAction=cancelSeat&txtTripID=' + tripID + seats, false);
                        xhr.send(null);
                        alert("Hết thời gian!\n Xin vui lòng chọn ghế lại!");
                        window.location.href = "index.jsp";
                    }
                }, 1000);
            }
            function validate() {
                var time = document.getElementById("countDown").innerHTML;
                if (isNaN(time) || time <= 0) {
                    alert("Hết thời gian thanh toán, vui lòng thử lại!");
                    window.location.href = "index.jsp";
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body onload="getData()">
        <jsp:include page="header.jsp"/>
    <c:set var="user" value="${sessionScope.USER}"/>
    <div class="main-container col-lg-11">
        <form id="form-checkout" action="CheckoutServlet" method="GET" onsubmit="return validate();">
            <div class="countDown">
                <p id="countDown" style="float: right; padding-right: 5px;"></p>
            </div>
            <p id="tripDecs"/>
            <table border="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Số ghế</th>
                        <th>Đơn giá</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="table-body">
                </tbody>
            </table>
            <input type="submit" value="Paid" name="btnAction" class="btn btn-primary" style="float: right; width: 100px;"/>
        </form>
    </div>
</body>
</html>
