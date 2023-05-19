window.onload = function() {
    let hBlock = document.getElementById("widthRowCard").clientHeight;
    document.getElementById("setHeight").style.height = hBlock + "px";

    $('.table tbody tr').each(function(i) {
        let number = i + 1;
        $(this).find('th:first').text(number+".");
    });

}

window.onresize = function() {
    let hBlock = document.getElementById("widthRowCard").clientHeight;
    document.getElementById("setHeight").style.height = hBlock + "px";
}

