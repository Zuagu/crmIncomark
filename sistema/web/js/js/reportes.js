/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    select_options_territorios();
    select_options_zona();
};

$('#enviar_gestiones').click( function () {
    reporte_gestiones_tabla();
});

$('#enviar_convenios').click( function () {
    azteca_reporte_convenios();
});


$('#enviar_pagos').click( function () {
    azteca_reporte_pagos();
});



// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function select_options_territorios() {
    let params = {
        action:'select_options_territorios'
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            $('#id_ter_gestion').empty();
            $('#id_ter_convenio').empty();
            $('#id_ter_gestion').append(`<option value="0">Todos</option>`);
            $('#id_ter_convenio').append(`<option value="0">Todos</option>`);
            for (let item of response) {
                $('#id_ter_gestion').append(`<option value="${item}">${item}</option>`);
                $('#id_ter_convenio').append(`<option value="${item}">${item}</option>`);
            }
            $('select').formSelect();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function select_options_zona() {
    let params = {
        action:'select_options_zona'
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            $('#id_ter_pagos').empty();
            $('#id_ter_pagos').append(`<option value="0">Todos</option>`);
            for (let item of response) {
                $('#id_ter_pagos').append(`<option value="${item}">${item}</option>`);
            }
            $('select').formSelect();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function reporte_gestiones_tabla() {
    let params = {
        action:'reporte_gestiones_tabla',
        desde:$('#desde_gestiones').val(),
        hasta:$('#hasta_gestiones').val(),
        territorio:$('#id_ter_gestion').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#tbody_tabla_gestiones').empty();
            let cantidad = 0;
            for (let item of response) {
                $('#tbody_tabla_gestiones').append(`<tr>
                    <td>${item.ID_GESTION}</td>
                    <td>${item.HORA}</td>
                    <td>${item.TERRITORIO}</td>
                    <td>${item.CANAL}</td>
                    <td>${item.FECHA_LARGA}</td>
                    <td>${item.ATRASO_MAXIMO}</td>
                    <td>${item.CUENTA}</td>
                    <td>${item.NUMERO_MARCADO}</td>
                    <td>${item.ID_ESTATUS_CUENTA}</td>
                    <td>${item.ID_ESTATUS_LLAMADA}</td>
                    <td>${item.USUARIO}</td>
                    <td>${item.GESTION}</td>
                    <td>${item.DURACION}</td>
                    <td>${item.RETASO}</td>
                    <td>${item.PROMESA}</td>
                    <td>${item.F_PREDICTIVO}</td>
                    </tr>`);
                cantidad = cantidad + 1;
            }
            $('#cantidad_gestiones').empty();
            $('#cantidad_gestiones').append(cantidad + ' Cuentas');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function azteca_reporte_convenios() {
    let params = {
        action:'azteca_reporte_convenios',
        desde:$('#desde_gestiones').val(),
        hasta:$('#hasta_gestiones').val(),
        territorio:$('#id_ter_gestion').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#tbody_tabla_convenios').empty();
            let cantidad = 0;
            for (let item of response) {
                $('#tbody_tabla_convenios').append(`<tr>
                    <td>${item.ID_CONVENIO}</td>
                    <td>${item.CONVENIO}</td>
                    <td>${item.RESTO}</td>
                    <td>${item.APLICA}</td>
                    <td>${item.TERRITORIO}</td>
                    <td>${item.CANAL}</td>
                    <td>${item.ATRASO_MAXIMO}</td>
                    <td>${item.FECHA}</td>
                    <td>${item.USUARIO}</td>
                    <td>${item.CUENTA}</td>
                    <td>${item.ID_ESTATUS}</td>
                    <td>${item.FECHA_INSET}</td>
                    <td>${item.PAGOS}</td>
                    <td>${item.FECHA_PAGO}</td>
                    <td>${item.EFECTIVIDAD}</td>
                    <td>${item.ID_EQUIPO}</td>
                    </tr>`);
                cantidad = cantidad + 1;
            }
            $('#cantidad_convenios').empty();
            $('#cantidad_convenios').append(cantidad + ' Cuentas');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function azteca_reporte_pagos() {
    let params = {
        action:'azteca_reporte_pagos',
        desde:$('#desde_pagos').val(),
        hasta:$('#hasta_pagos').val(),
        zona:$('#id_ter_pagos').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#tbody_tabla_pagos').empty();
            let cantidad = 0;
            for (let item of response) {
                $('#tbody_tabla_pagos').append(`<tr>
                    <td>${item.CLIENTE_UNICO}</td>
                    <td>${item.ANIO}</td>
                    <td>${item.SEMANA}</td>
                    <td>${item.DIA}</td>
                    <td>${item.RECUPERACION_CAPITAL}</td>
                    <td>${item.RECUPERACION_MORATORIOS}</td>
                    <td>${item.SALDO_ACTUAL}</td>
                    <td>${item.MORATORIO}</td>
                    <td>${item.FECHA_GESTION}</td>
                    <td>${item.CARGO_AUTOMATICO}</td>
                    <td>${item.ZONA}</td>
                    <td>${item.GERENTE}</td>
                    </tr>`);
                cantidad = cantidad + 1;
            }
            $('#cantidad_pagos').empty();
            $('#cantidad_pagos').append(cantidad + ' Cuentas');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}


// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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

