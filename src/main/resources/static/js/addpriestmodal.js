var modal = document.getElementById('modalPriest');
var btn = document.getElementById("priestAdd");



btn.onclick = function() {
    modal.style.display = "block";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}