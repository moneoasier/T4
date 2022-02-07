
$(document).ready(function () {

    var id = $("#employee").data("id");
    ($("#employee").val(id));
});

$("#employee").on('change', function () {
    var emp = ($("#employee").val());
    window.location.href = "/Home/PartidakEmployee/" + emp;
});