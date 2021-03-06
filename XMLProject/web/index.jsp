<%-- 
    Document   : index
    Created on : Jan 18, 2016, 6:19:24 PM
    Author     : HuyTCM1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body onload="changeTrip()">
        <c:set var="user" value="${sessionScope.USER}"/>
        <jsp:include page="header.jsp"/>
        <c:if test="${not empty user}">
            <div class="main-container col-lg-11">
                <div>
                    <c:import var="xmldoc" url="trips.xml"/>
                    <c:import var="busXSLT" url="/WEB-INF/BusDDL.xsl"/>
                    Tuyến: <select name="ddlBuses" id="ddlBuses" onchange="changeTrip()">
                        <c:if test="${not empty xmldoc}">
                            <x:transform doc="${xmldoc}" xslt="${busXSLT}"/>
                        </c:if>
                    </select>
                    ---
                    <c:import var="dateXSLT" url="/WEB-INF/DateDDL.xsl"/>
                    Chuyến: <select name="ddlTrip" id="ddlTrip" onchange="changeTrip()">
                        <c:if test="${not empty xmldoc}">
                            <x:transform doc="${xmldoc}" xslt="${dateXSLT}"/>
                        </c:if>
                    </select>
                </div>
                <div class="col-lg-6">
                    <div id="resultTime"></div>
                </div>
                <div class="col-lg-5">
                    <table border="1" class="car table table-bordered" id="mapSeat">
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
                                <td id="3" onclick="chooseSeat(3)" class="">
                                    3
                                    <input type="checkbox" name="chkSeat" value="3" hidden="" id="seatNum-3"/>
                                </td>
                                <td class="disabled"></td>
                                <td id="4" onclick="chooseSeat(4)" class="">
                                    4
                                    <input type="checkbox" name="chkSeat" value="4" hidden="" id="seatNum-4"/>
                                </td>
                                <td id="5" onclick="chooseSeat(5)" class="">
                                    5
                                    <input type="checkbox" name="chkSeat" value="5" hidden="" id="seatNum-5"/>
                                </td>
                            </tr>
                            <tr>
                                <td id="6" onclick="chooseSeat(6)" class="">
                                    6
                                    <input type="checkbox" name="chkSeat" value="6" hidden="" id="seatNum-6"/>
                                </td>
                                <td id="7" onclick="chooseSeat(7)" class="">
                                    7
                                    <input type="checkbox" name="chkSeat" value="7" hidden="" id="seatNum-7"/>
                                </td>
                                <td class="disabled"></td>
                                <td id="8" onclick="chooseSeat(8)" class="">
                                    8
                                    <input type="checkbox" name="chkSeat" value="8" hidden="" id="seatNum-8"/>
                                </td>
                                <td id="9" onclick="chooseSeat(9)" class="">
                                    9
                                    <input type="checkbox" name="chkSeat" value="9" hidden="" id="seatNum-9"/>
                                </td>
                            </tr>
                            <tr>
                                <td id="10" onclick="chooseSeat(10)" class="">
                                    10
                                    <input type="checkbox" name="chkSeat" value="10" hidden="" id="seatNum-10"/>
                                </td>
                                <td id="11" onclick="chooseSeat(11)" class="">
                                    11
                                    <input type="checkbox" name="chkSeat" value="11" hidden="" id="seatNum-11"/>
                                </td>
                                <td class="disabled"></td>
                                <td id="12" onclick="chooseSeat(12)" class="">
                                    12
                                    <input type="checkbox" name="chkSeat" value="12" hidden="" id="seatNum-12"/>
                                </td>
                                <td id="13" onclick="chooseSeat(13)" class="">
                                    13
                                    <input type="checkbox" name="chkSeat" value="13" hidden="" id="seatNum-13"/>
                                </td>
                            </tr>
                            <tr>
                                <td id="14" onclick="chooseSeat(14)" class="">
                                    14
                                    <input type="checkbox" name="chkSeat" value="14" hidden="" id="seatNum-14"/>
                                </td>
                                <td id="15" onclick="chooseSeat(15)" class="">
                                    15
                                    <input type="checkbox" name="chkSeat" value="15" hidden="" id="seatNum-15"/>
                                </td>
                                <td class="disabled"></td>
                                <td id="16" onclick="chooseSeat(16)" class="">
                                    16
                                    <input type="checkbox" name="chkSeat" value="16" hidden="" id="seatNum-16"/>
                                </td>
                                <td id="17" onclick="chooseSeat(17)" class="">
                                    17
                                    <input type="checkbox" name="chkSeat" value="17" hidden="" id="seatNum-17"/>
                                </td>
                            </tr>
                            <tr>
                                <td id="18" onclick="chooseSeat(18)" class="">
                                    18
                                    <input type="checkbox" name="chkSeat" value="18" hidden="" id="seatNum-18"/>
                                </td>
                                <td id="19" onclick="chooseSeat(19)" class="">
                                    19
                                    <input type="checkbox" name="chkSeat" value="19" hidden="" id="seatNum-19"/>
                                </td>
                                <td class="disabled"></td>
                                <td id="20" onclick="chooseSeat(20)" class="">
                                    20
                                    <input type="checkbox" name="chkSeat" value="20" hidden="" id="seatNum-20"/>
                                </td>
                                <td id="21" onclick="chooseSeat(21)" class="">
                                    21
                                    <input type="checkbox" name="chkSeat" value="21" hidden="" id="seatNum-21"/>
                                </td>
                            </tr>
                            <tr>
                                <td id="22" onclick="chooseSeat(22)" class="" colspan="2">
                                    22
                                    <input type="checkbox" name="chkSeat" value="22" hidden="" id="seatNum-22"/>
                                </td>
                                <td id="23" onclick="chooseSeat(23)" class="">
                                    23
                                    <input type="checkbox" name="chkSeat" value="23" hidden="" id="seatNum-23"/>
                                </td>
                                <td id="24" onclick="chooseSeat(24)" class="" colspan="2">
                                    24
                                    <input type="checkbox" name="chkSeat" value="24" hidden="" id="seatNum-24"/>
                                </td>
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
                new Transformation().setXml("trips.xml").setXslt("Time.xsl").transform("resultTime", bus, trip);
                document.getElementById("form-Time").value = "";
                setSeat(null);
            }
            function chooseTime(timeId) {
                var time = document.getElementsByName("timeRadio");

                for (i = 0; i < time.length; i++) {
                    if (time.item(i).value === timeId) {
                        time.item(i).checked = true;
                        document.getElementById("" + time.item(i).value).classList.add("selected");
                        document.getElementById("form-Time").value = time.item(i).value;
                    } else {
                        time.item(i).checked = false;
                        document.getElementById("" + time.item(i).value).classList.remove("selected");
                    }
                }
                setSeat(timeId);
            }
            function setSeat(timeId) {
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        var data = xhr.responseXML;
                        setUpData(data, timeId);
                    }
                };
                xhr.open('GET', 'trips.xml', true);
                xhr.send(null);
            }
            function setUpData(data, timeId) {
                var xPath = "trips/trip[@id='" + timeId + "']/seats";
                var xpResult = data.evaluate(xPath, data, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null);
                var DOM = xpResult.singleNodeValue;
                if (DOM === null) {
                    var chkSeats = document.getElementsByName("chkSeat");
                    for (var i = 0; i < chkSeats.length; i++) {
                        var parentNode = document.getElementById(chkSeats.item(i).value);
                        parentNode.className = "";
                    }
                    return;
                }
                if (DOM.localName === 'seats') {
                    var nodes = DOM.childNodes;
                    for (var i = 0; i < nodes.length; i++) {
                        var item = nodes.item(i);
                        if (item.nodeName === 'seat') {
                            var attr = item.attributes;
                            var status = attr.getNamedItem('available').nodeValue;
                            var id = attr.id.nodeValue;
                            var parentNode = document.getElementById(id);
                            parentNode.setAttribute('class', status);
                        }
                    }
                }
            }
            function chooseSeat(index) {
                var checked = document.getElementById("seatNum-" + index).checked;
                if (document.getElementById("" + index).classList.contains('true')) {
                    if (!checked) {
                        document.getElementById("seatNum-" + index).checked = true;
                        document.getElementById("" + index).classList.add("selected");
                    } else {
                        document.getElementById("seatNum-" + index).checked = false;
                        document.getElementById("" + index).classList.remove("selected");
                    }
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
                        seats += "&seats=" + (i + 1);
                        isValidate = true;
                    }
                }
                if (!isValidate) {
                    alert("Vui lòng chọn ghế!");
                    return false;
                }
                var xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function() {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        var data = xhr.responseText;
                        if (data !== 'true') {
                            alert(data);
                            window.location.href = "http://localhost:8080/index.jsp";
                        }
                    }
                };
                xhr.open('GET', 'CheckSeats?txtTripID=' + tripID + seats, false);
                xhr.send(null);
            }
            function Transformation() {
                var xml;
                var xmlDoc;
                var xslt;
                var xsltDoc;
                var callback = function() {
                };
                var transformed = false;
                this.getXml = function() {
                    return xml;
                };
                this.getXmlDocument = function() {
                    return xmlDoc;
                };
                this.setXml = function(x) {
                    xml = x;
                    return this;
                };
                this.getXslt = function() {
                    return xslt;
                };
                this.getXsltDocument = function() {
                    return xsltDoc;
                };
                this.setXslt = function(x) {
                    xslt = x;
                    return this;
                };
                this.getCallback = function() {
                    return callback;
                };
                this.setCallback = function(c) {
                    callback = c;
                    return this;
                };
                this.transform = function(target, param_bus, param_date) {
                    if (!browserSupportsXSLT()) {
                        return;
                    }
                    var str = /^\s*</;
                    var t = this;
                    if (document.recalc) {
                        var change = function() {
                            var c = 'complete';
                            if (xm.readyState === c && xs.readyState === c) {
                                window.setTimeout(function() {
                                    xmlDoc = xm.XMLDocument;
                                    xsltDoc = xs.XMLDocument;
                                    callback(t);
                                    document.all[target].innerHTML = xm.transformNode(xs.XMLDocument);
                                }, 50);
                            }
                        };

                        var xm = document.createElement('xml');
                        xm.onreadystatechange = change;
                        xm[str.test(xml) ? "innerHTML" : "src"] = xml;

                        var xs = document.createElement('xml');
                        xs.onreadystatechange = change;
                        xs[str.test(xslt) ? "innerHTML" : "src"] = xslt;

                        with (document.body) {
                            insertBefore(xm);
                            insertBefore(xs);
                        }
                        ;
                    }
                    else {
                        var transformed = false;

                        var xm = {
                            readyState: 4
                        };
                        var xs = {
                            readyState: 4
                        };
                        var change = function() {
                            if (xm.readyState === 4 && xs.readyState === 4 && !transformed) {
                                xmlDoc = xm.responseXML;
                                xsltDoc = xs.responseXML;
                                var resultDoc;
                                var processor = new XSLTProcessor();

                                if (typeof processor.transformDocument === 'function') {
                                    // obsolete Mozilla interface
                                    resultDoc = document.implementation.createDocument("", "", null);
                                    processor.setParameter(null, 'param_bus', param_bus);
                                    processor.setParameter(null, 'param_date', param_date);
                                    processor.transformDocument(xm.responseXML, xs.responseXML, resultDoc, null);
                                    var out = new XMLSerializer().serializeToString(resultDoc);
                                    callback(t);
                                    document.getElementById(target).innerHTML = out;
                                }
                                else {
                                    processor.importStylesheet(xs.responseXML);
                                    processor.setParameter(null, 'param_bus', param_bus);
                                    processor.setParameter(null, 'param_date', param_date);
                                    resultDoc = processor.transformToFragment(xm.responseXML, document);
                                    callback(t);
                                    document.getElementById(target).innerHTML = '';
                                    document.getElementById(target).appendChild(resultDoc);
                                }

                                transformed = true;
                            }
                        };

                        if (str.test(xml)) {
                            xm.responseXML = new DOMParser().parseFromString(xml, "text/xml");
                        }
                        else {
                            xm = new XMLHttpRequest();
                            xm.onreadystatechange = change;
                            xm.open("GET", xml);
                            xm.send(null);
                        }

                        if (str.test(xslt)) {
                            xs.responseXML = new DOMParser().parseFromString(xslt, "text/xml");
                            change();
                        }
                        else {
                            xs = new XMLHttpRequest();
                            xs.onreadystatechange = change;
                            xs.open("GET", xslt);
                            xs.send(null);
                        }
                    }
                };
            }
            function browserSupportsXSLT() {
                var support = false;
                if (document.recalc) { // IE 5+
                    support = true;
                }
                else if (window.XMLHttpRequest !== undefined && window.XSLTProcessor !== undefined) { // Mozilla 0.9.4+, Opera 9+
                    var processor = new XSLTProcessor();
                    if (typeof processor.transformDocument === 'function') {
                        support = window.XMLSerializer !== undefined;
                    }
                    else {
                        support = true;
                    }
                }
                return support;
            }
        </script>
    </body>
</html>
