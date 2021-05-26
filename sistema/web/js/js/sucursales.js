/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    select_sucursales();
};
//var reporte_estiones = [];


$("#tbody_sucursales").on('click', '.elimimar_sucursal', function () {
    let id_sucursal = $(this).attr("id");
    
    deleted_sucursales(id_sucursal);
});
$("#agregar_nueva_sucursal").click (function () {
    let nombre_sucursal = $("#nombre_sucursal").val();
    agregar_sucursal(nombre_sucursal);
});


// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



function select_sucursales() {
    let params = {
        action: 'select_sucursales'
    };
    $.ajax({
        type: "POST",
        url: "ControllerSucursales",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            $('#tbody_sucursales').empty();
            for (let item of response) {
                $('#tbody_sucursales').append(`<tr class="center"><td>${item.id_sucursal}</td><td>${item.sucursal}</td><td><i id="${item.id_sucursal}" class="material-icons cursor_pointer elimimar_sucursal">delete</i></td></tr>`);
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function deleted_sucursales(_id_sucursal) {
    let params = {
        action: 'deleted_sucursales',
        id_sucursal:_id_sucursal
    };
    $.ajax({
        type: "POST",
        url: "ControllerSucursales",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            alert( response.message );
            select_sucursales();
        },
        error: function (error) {
            $('#error').empty();
            $('#error').append(error.responseText);
            console.log(error);
        }
    });
}


function agregar_sucursal(_nombre_sucursal) {
    let params = {
        action: 'agregar_sucursal',
        nombre_sucursal:_nombre_sucursal
    };
    $.ajax({
        type: "POST",
        url: "ControllerSucursales",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            alert( response.message );
            $("#nombre_sucursal").val("");
            select_sucursales();
        },
        error: function (error) {
            $('#error').empty();
            $('#error').append(error.responseText);
            console.log(error);
        }
    });
}


// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

var tableToExcel = (function () {
    var uri = 'data:application/vnd.ms-excel;base64,',
            template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
            base64 = function (s) {
                return window.btoa(unescape(encodeURIComponent(s)))
            },
            format = function (s, c) {
                return s.replace(/{(\w+)}/g, function (m, p) {
                    return c[p];
                })
            }
    return function (table, name) {
        if (!table.nodeType)
            table = document.getElementById(table);
        var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
        window.location.href = uri + base64(format(template, ctx))
    }
})()

