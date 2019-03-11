var modalDay = document.getElementById('myModal');
var btnDay = document.getElementById("popUp");



btnDay.onclick = function() {
    modalDay.style.display = "block";
}

window.onclick = function(event) {
    if (event.target == modalDay) {
        modalDay.style.display = "none";
    }
}