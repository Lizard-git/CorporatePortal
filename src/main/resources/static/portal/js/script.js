window.onload = function() {
    let hBlock = document.getElementById("widthRowCard").clientHeight;
    document.getElementById("setHeight").style.height = hBlock + "px";
}

window.onresize = function() {
    let hBlock = document.getElementById("widthRowCard").clientHeight;
    document.getElementById("setHeight").style.height = hBlock + "px";
}

