/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    select_options_territorios();
    select_options_zona();
    $('.contenedor_buscar').addClass('hide');
    $('#buscar_cuentas').addClass('hide');
};
//var reporte_estiones = [];

$('#enviar_gestiones').click(function () {
    reporte_gestiones_tabla();
});

$('#enviar_convenios').click(function () {
    azteca_reporte_convenios();
});


$('#enviar_pagos').click(function () {
    azteca_reporte_pagos();
});

$('#enviar_tiempos').click(function () {
    azteca_reporte_operacion();
});

$('#ver_resumen_gestion').click(function () {
    $('#ver_lista_gestion').removeClass('hide');
    $('#ver_resumen_gestion').addClass('hide');
    $('#datos_tabla_gestiones').addClass('hide');
    $('#resumen_gestiones').removeClass('hide');
});
$('#ver_lista_gestion').click(function () {
    $('#ver_lista_gestion').addClass('hide');
    $('#ver_resumen_gestion').removeClass('hide');
    
    $('#datos_tabla_gestiones').removeClass('hide');
    $('#resumen_gestiones').addClass('hide');
});


$('#ver_resumen_pagos').click(function () {
    $('#ver_resumen_pagos').addClass('hide');
    $('#ver_lista_pagos').removeClass('hide');
    
    $('#resumen_pagos').removeClass('hide');
    $('#datos_tabla_pagos').addClass('hide');
});

$('#ver_lista_pagos').click(function () {
    $('#ver_lista_pagos').addClass('hide');
    $('#ver_resumen_pagos').removeClass('hide');
    
    $('#resumen_pagos').addClass('hide');
    $('#datos_tabla_pagos').removeClass('hide');
});

$('#descargar_base').click(function () {
    descargar_base();
});


// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function select_options_territorios() {
    let params = {
        action: 'select_options_territorios'
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
        action: 'select_options_zona'
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
        action: 'reporte_gestiones_tabla',
        desde: $('#desde_gestiones').val(),
        hasta: $('#hasta_gestiones').val(),
        territorio: $('#id_ter_gestion').val()
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
            let canal = {};
            let atraso_maximo = {};
            let gestor = {};
            let estatus_cuenta = {};
            let estatus_llamda = {};
            let territorio = {};
            for (let item of response) {
                if (canal[item.CANAL] >= 0) {
                    canal[item.CANAL] = canal[item.CANAL] + 1;
                } else {canal[item.CANAL] = 1;}
                
                if (gestor[item.USUARIO] >= 0) {
                    gestor[item.USUARIO] = gestor[item.USUARIO] + 1;
                } else {gestor[item.USUARIO] = 1;}
                
                if (atraso_maximo[item.ATRASO_MAXIMO] >= 0) {
                    atraso_maximo[item.ATRASO_MAXIMO] = atraso_maximo[item.ATRASO_MAXIMO] + 1;
                } else {atraso_maximo[item.ATRASO_MAXIMO] = 1;}
                
                if (estatus_cuenta[item.ID_ESTATUS_CUENTA] >= 0) {
                    estatus_cuenta[item.ID_ESTATUS_CUENTA] = estatus_cuenta[item.ID_ESTATUS_CUENTA] + 1;
                } else {estatus_cuenta[item.ID_ESTATUS_CUENTA] = 1;}
                
                if (estatus_llamda[item.ID_ESTATUS_LLAMADA] >= 0) {
                    estatus_llamda[item.ID_ESTATUS_LLAMADA] = estatus_llamda[item.ID_ESTATUS_LLAMADA] + 1;
                } else {estatus_llamda[item.ID_ESTATUS_LLAMADA] = 1;}
                
                if (territorio[item.TERRITORIO] >= 0) {
                    territorio[item.TERRITORIO] = territorio[item.TERRITORIO] + 1;
                } else {territorio[item.TERRITORIO] = 1;}

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
//            reporte_estiones.push(canal);
//            reporte_estiones.push(atraso_maximo);
//            reporte_estiones.push(gestor);
//            reporte_estiones.push(estatus_cuenta);
//            reporte_estiones.push(estatus_llamda);
//            reporte_estiones.push(territorio);
//            console.log(reporte_estiones);
            $('#tb_territorio').empty();
            for( let item in territorio){
                $('#tb_territorio').append(`<tr><td>${item}</td><td>${territorio[item]}</td></tr>`);
            }
            
            $('#tb_canal').empty();
            for( let item in canal){
                $('#tb_canal').append(`<tr><td>${item}</td><td>${canal[item]}</td></tr>`);
            }
            
            $('#tb_atraso_maximo').empty();
            for( let item in atraso_maximo){
                $('#tb_atraso_maximo').append(`<tr><td>${item}</td><td>${atraso_maximo[item]}</td></tr>`);
            }
            
            $('#tb_gestor').empty();
            for( let item in gestor){
                $('#tb_gestor').append(`<tr><td>${item}</td><td>${gestor[item]}</td></tr>`);
            }
            
            $('#tb_estatus_cuenta').empty();
            for( let item in estatus_cuenta){
                $('#tb_estatus_cuenta').append(`<tr><td>${item}</td><td>${estatus_cuenta[item]}</td></tr>`);
            }
            
            $('#tb_estatus_llamda').empty();
            for( let item in estatus_llamda){
                $('#tb_estatus_llamda').append(`<tr><td>${item}</td><td>${estatus_llamda[item]}</td></tr>`);
            }
            
            
            $('#cantidad_gestiones').empty();
            $('#cantidad_gestiones').append(cantidad + ' Gestiones');
        },
        error: function (error) {
            console.log(error);
        }
    });
}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function azteca_reporte_convenios() {
    let params = {
        action: 'azteca_reporte_convenios',
        desde: $('#desde_convenios').val(),
        hasta: $('#hasta_convenios').val(),
        territorio: $('#id_ter_convenio').val()
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
        error: function (error) {
            console.log(error);
        }
    });
}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function azteca_reporte_operacion() {
    let params = {
        action: 'azteca_reporte_operacion',
        desde: $('#desde_tiempos').val(),
        hasta: $('#hasta_tiempos').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#tbody_tabla_tiempos').empty();
            for (let item of response) {
                $('#tbody_tabla_tiempos').append(`<tr>
                    <td>${item.id_usuario}</td>
                    <td>${item.nombre}</td>
                    <td>${item.fecha}</td>
                    <td>${item.hora_inicial}</td>
                    <td>${item.tiempo_conectado}</td>
                    <td>${item.semana}</td>
                    </tr>`);
            }
            
        },
        error: function (error) {
            console.log(error);
        }
    });
}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function azteca_reporte_pagos() {
    let params = {
        action: 'azteca_reporte_pagos',
        desde: $('#desde_pagos').val(),
        hasta: $('#hasta_pagos').val(),
        zona: $('#id_ter_pagos').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            let dias = {};
            let zona = {};
            $('#tbody_tabla_pagos').empty();
            let cantidad = 0;
            
            for (let item of response) {
//                if(zona.hasOwnProperty(item.DIA)) {
//                
//                } else {
//                    dias[item.DIA] = {
//                        "":""
//                    }
//                }
                    
                if(zona.hasOwnProperty(item.ZONA)) {
                    zona[item.ZONA].pagos += 1;
                    zona[item.ZONA].importe_capital += parseFloat(item.RECUPERACION_CAPITAL);
                    zona[item.ZONA].importe_moatorios += parseFloat(item.RECUPERACION_MORATORIOS);
                    zona[item.ZONA].importe_saldo_actual += parseFloat(item.SALDO_ACTUAL);
                    zona[item.ZONA].importe_moratorio += parseFloat(item.MORATORIO);
                    let exist =  zona[item.ZONA].gerente.indexOf(item.GERENTE)
                    if (exist < 0) {
                        zona[item.ZONA].gerente.push(item.GERENTE);
                    }
                } else {
                    zona[item.ZONA] = {
                        "pagos": 1,
                        "importe_capital": parseFloat(item.RECUPERACION_CAPITAL),
                        "importe_moatorios": parseFloat(item.RECUPERACION_MORATORIOS),
                        "importe_saldo_actual": parseFloat(item.SALDO_ACTUAL),
                        "importe_moratorio": parseFloat(item.MORATORIO),
                        "gerente": []
                    };
                    zona[item.ZONA].gerente.push(item.GERENTE);
                }
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
            console.log(zona);
            
            $('#tb_resumen_pagos').empty();
            for (let z in zona) {
                $('#tb_resumen_pagos').append(`<tr>
                <td>${z}</td>
                <td>${ JSON.stringify(zona[z].gerente).replace(/\[|]|"/gi, "").replace(/,/gi,"<br>") }</td>
                <td>${zona[z].pagos}</td>
                <td>$ ${zona[z].importe_capital}</td>
                <td>$ ${zona[z].importe_moatorios}</td>
                <td>$ ${zona[z].importe_saldo_actual}</td>
                </tr>`);
            }
            
            $('#cantidad_pagos').empty();
            $('#cantidad_pagos').append(cantidad + ' Pagos');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}


// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function descargar_base() {
    let params = {
        action: 'descargar_base'
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log(response);
            window.open("excel/BaseAztecaCrm.csv");
        },
        error: function (error) {
            console.log(error);
        }
    });
}
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

