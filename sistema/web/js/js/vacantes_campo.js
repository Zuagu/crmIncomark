/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    azteca_select_requerimetos_campo();
//    select_clientes_cartera();
//    select_options_territorios_convenios();
//    select_options_territorios();
//    select_options_zona();
//    $('.contenedor_buscar').addClass('hide');
//    $('#buscar_cuentas').addClass('hide');
};
//var reporte_estiones = [];





// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

function azteca_select_requerimetos_campo() {
    let params = {
        action: 'azteca_select_requerimetos_campo'
    };
    $.ajax({
        type: "POST",
        url: "ControllerVacantes",
        data: params,
        dataType: "json",
        success: function (response) {
            $("#tbody_tabla_promesado_diario_org").empty();
            let tit_sum_zona = {};
            let orden = [];
            for (let row of response) {

                if (orden.includes(row.TERRITORIO)) {

                } else {
                    orden.push(row.TERRITORIO);
                }

                if (tit_sum_zona[row.TERRITORIO]) {
//                    console.log('si esta');
                    tit_sum_zona[row.TERRITORIO].valor += parseFloat(row.SALDO_TOTAL.replace(',', ''));
                    tit_sum_zona[row.TERRITORIO].cuentas += parseInt(row.CANTIDAD);
                } else {
//                    console.log('no esta');
                    tit_sum_zona[row.TERRITORIO] = {
                        valor: parseFloat(row.SALDO_TOTAL.replace(',', '')),
                        cuentas: parseInt(row.CANTIDAD)
                    };
                }


            }
//            console.log('jsoninf', tit_sum_zona);
//            console.log('orden', orden);
            let col1 = '0';

            for (let item of orden) {
//                console.log(item);
                $("#tbody_tabla_promesado_diario_org").append(`<tr class='grey'><th>${item}</th><th></th><th></th><th>${tit_sum_zona[item].cuentas} Cuentas</th><th></th><th>$ ${tit_sum_zona[item].valor.toFixed(2)} MNX</th><th></th> <tr>`);
                for (let row of response) {
//                    if (col1 === '0' || col1 !== row.TERRITORIO) {
//                        col1 = row.TERRITORIO;
////                    console.log(row.TERRITORIO);
//                        $("#tbody_tabla_promesado_diario_org").append(`<tr class='grey'><th>${item}</th><th></th><tr>`);
//                    }
                     if ( row.TERRITORIO === item ) {
                         
                         $("#tbody_tabla_promesado_diario_org").append(`<tr class='blue'>
                                <th>${row.LOCALIDAD_V}</th><th></th><th></th><th>${row.CANTIDAD} Cuentas</th><th></th><th>$ ${ parseFloat(row.SALDO_TOTAL).toFixed(2)} MNX</th><th></th> </tr>
                                <tr> <td>Cartero: </td><td>0/${row.CARTEROS}</td><td>0%</td><td>${row.RESULTADO_NA} NA</td><td>${(( parseFloat(row.RESULTADO_NA) / parseFloat(row.CANTIDAD) )*100).toFixed(2)}%</td><td>$ ${parseFloat(row.val_RESULTADO_NA).toFixed(2)}</td><td>% ${ (( parseFloat(row.val_RESULTADO_NA) / parseFloat(row.SALDO_TOTAL) * 100)).toFixed(2) }</td> </tr>
                                <tr> <td>Notificador: </td><td>0/${row.NOTIFICADOR}</td><td>0%</td><td>${row.RESULTADO_AP} AP</td><td>${(( parseFloat(row.RESULTADO_AP) / parseFloat(row.CANTIDAD) )*100).toFixed(2)}%</td><td>$ ${parseFloat(row.val_RESULTADO_AP).toFixed(2)}</td><td>% ${ (( parseFloat(row.val_RESULTADO_AP) / parseFloat(row.SALDO_TOTAL) * 100)).toFixed(2) }</td> </tr>
                                <tr> <td>Cerrador: </td><td>0/${row.CERRADOR}</td><td>0%</td><td>${row.RESULTADO_CCERRADOR} Contacto</td><td>${(( parseFloat(row.RESULTADO_CCERRADOR) / parseFloat(row.CANTIDAD) )*100).toFixed(2)}%</td><td>$ ${parseFloat(row.val_RESULTADO_CCERRADOR).toFixed(2)}</td><td>% ${ ( ( parseFloat(row.val_RESULTADO_CCERRADOR) / parseFloat(row.SALDO_TOTAL) * 100)).toFixed(2) }</td> </tr>
                            `);
                     }
                    
                }
            }


//            console.log(response);
            $("#cargando_datos").addClass('hide');

        },
        error: function (error) {
            console.log(error);
            $("#cargando_datos").addClass('hide');
        }
    });
}


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
function reporte_promesado_diario_org() {
    let params = {
        action: 'reporte_promesado_al_momento',
        desde: $('#fecha_promesado_al_momento_org').val(),
        territorio: $('#territorio_promesado_diario_org').val(),
        etapa: $('#etapa_promesado_diario_org').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#tbody_tabla_promesado_diario_org').empty();
            let cantidad = 0;
            let monto = 0;
            for (let item of response) {
                $('#tbody_tabla_promesado_diario_org').append(`<tr class="color_${item.ESTATUS_PAGO}">
                    <td>${item.GESTOR}</td>
                    <td>${item.CUENTA}</td>
                    <td>${item.NOMBRE}</td>
                    <td>${item.GERENTE}</td>
                    <td>${item.ESTATUS_LLAMADA}</td>
                    <td>${item.CONVENIO}</td>
                    <td>${item.FECHA_INSET}</td>
                    <td>${item.HORA}</td>
                    <td>${item.ESTATUS_PAGO}</td>
                    <td>${item.FECHA}</td>
                    <td>${item.ETAPA}</td>
                    </tr>`);
                monto += parseFloat(item.CONVENIO);
                cantidad = cantidad + 1;
            }
            $('#tbody_tabla_promesado_diario_org').append(`<tr class="">
                <td class="right-align" colspan="3"><h6></h6></td>
                <td class="right-align" colspan="3"><h6>${cantidad} Promesas</h6></td>
                <td class="right-align" colspan="3"><h6>Importe: $${monto}</h6></td>
            </tr>`);

        },
        error: function (error) {
            console.log(error);
        }
    });
}
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
function reporte_promesas_incumplidas_semana() {
    let params = {
        action: 'reporte_promesas_incumplidas',
        desde: $('#inicio_sem_promesas_incumplidas').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            $('#tbody_tabla_promesas_incumplidas').empty();
            let cumplidos = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
            let incumplidos = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
            let vigentes = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
            let dias = ["FECHA", "", "", "", "", "", "", "", ""];
            let gerente1 = response[0].GERENTE;
            let tabla_cum = [];
            let tabla_incum = [];
            let tabla_vig = [];
            cumplidos[0] = response[0].GERENTE;
            incumplidos[0] = response[0].GERENTE;
            vigentes[0] = response[0].GERENTE;
//            let cantidad = 0;
            for (let item of response) {
                dias[parseInt(item.DIA_SEM)] = item.FECHA;
                if (item.GERENTE === gerente1) {
                    if (item.ID_ESTATUS === "3") {
                        cumplidos[parseInt(item.DIA_SEM)] = item.TOTAL;
                    }
                    if (item.ID_ESTATUS === "2") {
                        incumplidos[parseInt(item.DIA_SEM)] = item.TOTAL;
                    }
                    if (item.ID_ESTATUS === "1") {
                        vigentes[parseInt(item.DIA_SEM)] = item.TOTAL;
                    }
                } else {
                    tabla_cum.push(cumplidos);
                    tabla_incum.push(incumplidos);
                    tabla_vig.push(vigentes);
                    cumplidos = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
                    ;
                    incumplidos = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
                    ;
                    vigentes = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
                    ;
                    cumplidos[0] = item.GERENTE;
                    incumplidos[0] = item.GERENTE;
                    vigentes[0] = item.GERENTE;
                    gerente1 = item.GERENTE;
                }

            }
            $('#tbody_tabla_promesas_incumplidas').append(`<tr class="color_CUMPLIDO">
                <td>${dias[0]}</td>
                <td>${dias[2]}</td>
                <td>${dias[3]}</td>
                <td>${dias[4]}</td>
                <td>${dias[5]}</td>
                <td>${dias[6]}</td>
                <td>${dias[7]}</td>
                <td>${dias[1]}</td>
                <td></td>
            </tr>`);
            for (let row of tabla_cum) {
                $('#tbody_tabla_promesas_incumplidas').append(`<tr class="color_CUMPLIDO">
                <td>${row[0]}</td>
                <td>${row[2]}</td>
                <td>${row[3]}</td>
                <td>${row[4]}</td>
                <td>${row[5]}</td>
                <td>${row[6]}</td>
                <td>${row[7]}</td>
                <td>${row[1]}</td>
                <td>${(parseInt(row[1]) + parseInt(row[2]) + parseInt(row[3]) + parseInt(row[4]) + parseInt(row[5]) + parseInt(row[6]) + parseInt(row[7]))}</td>
            </tr>`);
            }
            for (let row of tabla_incum) {
                $('#tbody_tabla_promesas_incumplidas').append(`<tr class="color_INCUMPLIDO">
                <td>${row[0]}</td>
                <td>${row[2]}</td>
                <td>${row[3]}</td>
                <td>${row[4]}</td>
                <td>${row[5]}</td>
                <td>${row[6]}</td>
                <td>${row[7]}</td>
                <td>${row[1]}</td>
                <td>${(parseInt(row[1]) + parseInt(row[2]) + parseInt(row[3]) + parseInt(row[4]) + parseInt(row[5]) + parseInt(row[6]) + parseInt(row[7]))}</td>
            </tr>`);
            }
            for (let row of tabla_vig) {
                $('#tbody_tabla_promesas_incumplidas').append(`<tr class="color_VIGENTE">
                <td>${row[0]}</td>
                <td>${row[2]}</td>
                <td>${row[3]}</td>
                <td>${row[4]}</td>
                <td>${row[5]}</td>
                <td>${row[6]}</td>
                <td>${row[7]}</td>
                <td>${row[1]}</td>
                <td>${(parseInt(row[1]) + parseInt(row[2]) + parseInt(row[3]) + parseInt(row[4]) + parseInt(row[5]) + parseInt(row[6]) + parseInt(row[7]))}</td>
            </tr>`);
            }
            console.log(dias);
//            console.log(tabla_cum);
//            console.log(tabla_incum);
//            console.log(tabla_vig);
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function reporte_promesas_por_gestor() {
    let params = {
        action: 'reporte_promesas_por_gestor',
        desde: $('#inicio_sem_promesas_incumplidas').val()
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
//            console.log(response);
            let user = ["ACAREVALO", "ACRUZ", "ADRODRIGUEZ", "AGARZA", "AJCANTU", "ALAYALA", "AMIRANDA", "AORDONEZ", "BDSANCHEZ", "BNSOLIS", "CSANCHEZ", "DAESPARZA", "DHSAAVEDRA", "DJESPARZA", "DJMARTINEZ"];
//            $('#tbody_tabla_promesas_incumplidas').empty();
            let gestor = {};
            for (let item of user) {
                gestor[item] = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
            }

            for (let row of response) {
                gestor[row.GESTOR][parseInt(row.DIA_SEM)] = row.PAGOS;
            }
            let cumplidos = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
            let incumplidos = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
            let vigentes = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
            let dias = ["FECHA", "", "", "", "", "", "", "", ""];
            let gerente1 = response[0].GERENTE;
            let tabla_cum = [];
            let tabla_incum = [];
            let tabla_vig = [];
            cumplidos[0] = response[0].GERENTE;
            incumplidos[0] = response[0].GERENTE;
            vigentes[0] = response[0].GERENTE;
//            let cantidad = 0;
            for (let item of response) {
                dias[parseInt(item.DIA_SEM)] = item.FECHA;
                if (item.GERENTE === gerente1) {
                    if (item.ID_ESTATUS === "3") {
                        cumplidos[parseInt(item.DIA_SEM)] = item.TOTAL;
                    }
                    if (item.ID_ESTATUS === "2") {
                        incumplidos[parseInt(item.DIA_SEM)] = item.TOTAL;
                    }
                    if (item.ID_ESTATUS === "1") {
                        vigentes[parseInt(item.DIA_SEM)] = item.TOTAL;
                    }
                } else {
                    tabla_cum.push(cumplidos);
                    tabla_incum.push(incumplidos);
                    tabla_vig.push(vigentes);
                    cumplidos = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
                    incumplidos = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
                    vigentes = ["", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", "0.00", ""];
                    cumplidos[0] = item.GERENTE;
                    incumplidos[0] = item.GERENTE;
                    vigentes[0] = item.GERENTE;
                    gerente1 = item.GERENTE;
                }
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}



function select_clientes_cartera() {
    let params = {
        action: 'select_clientes_cartera'
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log("Response de select_clientes_cartera: ", response);
            $("#id_etapa_gestion").empty();
            $("#id_etapa_gestion").append(`<option value="0">TODOS</option>`);
            $("#id_ter_etapa_2").append(`<option value="0">TODOS</option>`);
            $("#id_etapa_pagos").append(`<option value="0">TODOS</option>`);
            $("#etapa_promesado_diario_org").append(`<option value="0">TODOS</option>`);
            $("#etapa_promesado_diario").append(`<option value="0">TODOS</option>`);
            for (let item of response) {
                $("#id_etapa_gestion").append(`<option value="${item.ETAPA}">${item.ETAPA}</option>`);
                $("#id_ter_etapa_2").append(`<option value="${item.ETAPA}">${item.ETAPA}</option>`);
                $("#id_etapa_pagos").append(`<option value="${item.ETAPA}">${item.ETAPA}</option>`);
                $("#etapa_promesado_diario_org").append(`<option value="${item.ETAPA}">${item.ETAPA}</option>`);
                $("#etapa_promesado_diario").append(`<option value="${item.ETAPA}">${item.ETAPA}</option>`);
//                console.log(item.CLASIFICACION_CTE);
            }
            $('select').formSelect();
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

