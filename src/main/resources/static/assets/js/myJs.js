function refreshPage() {
    $.ajax({
        "url": window.location.pathname,
        "method": "GET"
    }).done(function (data) {
        var newDoc = document.open("text/html", "replace");
        newDoc.write(data);
        newDoc.close();
    });
}

$(document).ready(function () {
    $("form").submit(function (e) {
        if (!$(e).hasClass("ignore")){
            e.preventDefault();
            var formData = new FormData($(this)[0]);
            $.ajax({
                "url": $(this).attr("action"),
                "method": $(this).attr("method") || "POST",
                "data": formData,
                "cache": false,
                "contentType": false,
                "processData": false
            }).done(refreshPage);
        }
    });
});

function deleteMoneda(moneda_id) {
    $.ajax({
        "url": "/"+"moneda/"+"delete/"+ moneda_id,
        "method": "DELETE",
    }).done(refreshPage);
}

function removeEjemplar(moneda_id,ejemplar_id) {
    $.ajax({
        "url": "/" +"moneda/" + "remove/" + moneda_id + "/" + ejemplar_id,
        "method": "DELETE",
    }).done(refreshPage);
}

function removeProveedor(ejemplar_id) {
    $.ajax({
        "url": "/" +"ejemplar/" + "remove/" +  ejemplar_id,
        "method": "DELETE",
    }).done(refreshPage);
}

function deleteEjemplar(ejemplar_id) {
    $.ajax({
        "url": "/" +"ejemplar/" + "delete/" +  ejemplar_id,
        "method": "DELETE",
    }).done(refreshPage);
}

function deleteProveedor(proveedor_id) {
    $.ajax({
        "url": "/" +"proveedor/" + "delete/" +  proveedor_id,
        "method": "DELETE",
    }).done(refreshPage);
}

/*function findByCIF() {
    $.ajax({
        "url": "/" +"proveedor/" + "CIF",
        "method": "POST",
    }).done(refreshPage);
}

function findByMonedaID() {
    $.ajax({
        "url": "/" +"moneda/" + "ascDes",
        "method": "POST",
    }).done(refreshPage);
}

function findByMonedaValorFacial() {
    $.ajax({
        "url": "/" +"moneda/" + "val",
        "method": "POST",
    }).done(refreshPage);
}

function findByProveedorNombre() {
    $.ajax({
        "url": "/" +"proveedor/" + "nombre",
        "method": "POST",
    }).done(refreshPage);
}*/