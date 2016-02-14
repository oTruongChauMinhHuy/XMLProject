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

//        getCars();
    }
}
//function getCars() {
//    var url = "http://localhost:8080//webresources/xml/getCars";
//    $.ajax({
//        url: url
//    }).done(function setCar(result) {
//        alert(result);
//    });
//}