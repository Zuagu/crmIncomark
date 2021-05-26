/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    select_options_territorios();
    select_etapas_cartera();
    
    azteca_select_requerimetos_campo();
};
//var reporte_estiones = [];


$("#getTableRequerimentos").click( function () {
    azteca_select_requerimetos_campo();
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
            $('#territorio_visitas').empty();
            $('#territorio_visitas').append(`<option value="0" selected>TODOS</option>`);
            for (let item of response) {
                $('#territorio_visitas').append(`<option value="${item}">${item}</option>`);
            }
            $('select').formSelect();
        },
        error: function (error) {
            console.log(error);
        }
    });
}


function select_etapas_cartera() {
    let params = {
        action: 'select_clientes_cartera'
    };
    $.ajax({
        type: "POST",
        url: "ControllerReportesAzteca",
        data: params,
        dataType: "json",
        success: function (response) {
            console.log("Response de etapas: ", response);
            $("#etapa_visitas").empty();
            $("#etapa_visitas").append(`<option value="0" selected>TODOS</option>`);
            for (let item of response) {
                
                $("#etapa_visitas").append(`<option value="${item.ETAPA}">${item.ETAPA}</option>`);
//                console.log(item.CLASIFICACION_CTE);
            }
            $('select').formSelect();
        },
        error: function (error) {
            console.log(error);
        }
    });
}


function azteca_select_requerimetos_campo() {
    $("#tbody_tabla_promesado_diario_org").empty();
    $("#cargando_datos").removeClass('hide');
    let params = {
        action: 'azteca_select_requerimetos_campo',
        territorio: JSON.stringify($("#territorio_visitas").val() || '0').replace(/"/gm, "'").replace(/\\|\[|]/gm, ""),
        etapa: JSON.stringify($("#etapa_visitas").val()  || '0').replace(/"/gm, "'").replace(/\\|\[|]/gm, "")
    };
    console.log(params);
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
                     if ( row.TERRITORIO === item ) {
                         
                         $("#tbody_tabla_promesado_diario_org").append(`<tr class='blue'>
                                <th>${row.LOCALIDAD_V}</th><th></th><th></th><th>${row.CANTIDAD} Cuentas</th><th></th><th>$ ${ parseFloat(row.SALDO_TOTAL).toFixed(2)} MNX</th><th></th> </tr>
                                <tr> <td>Cartero: </td><td>0/${row.CARTEROS}</td><td>0%</td><td>${row.RESULTADO_NA} NA</td><td>${(( parseFloat(row.RESULTADO_NA) / parseFloat(row.CANTIDAD) )*100).toFixed(2)}%</td><td>$ ${parseFloat(row.val_RESULTADO_NA).toFixed(2)}</td><td>${ (( parseFloat(row.val_RESULTADO_NA) / parseFloat(row.SALDO_TOTAL) * 100)).toFixed(2) }%</td> </tr>
                                <tr> <td>Notificador: </td><td>0/${row.NOTIFICADOR}</td><td>0%</td><td>${row.RESULTADO_AP} AP</td><td>${(( parseFloat(row.RESULTADO_AP) / parseFloat(row.CANTIDAD) )*100).toFixed(2)}%</td><td>$ ${parseFloat(row.val_RESULTADO_AP).toFixed(2)}</td><td>${ (( parseFloat(row.val_RESULTADO_AP) / parseFloat(row.SALDO_TOTAL) * 100)).toFixed(2) }%</td> </tr>
                                <tr> <td>Cerrador: </td><td>0/${row.CERRADOR}</td><td>0%</td><td>${row.RESULTADO_CCERRADOR} Contacto</td><td>${(( parseFloat(row.RESULTADO_CCERRADOR) / parseFloat(row.CANTIDAD) )*100).toFixed(2)}%</td><td>$ ${parseFloat(row.val_RESULTADO_CCERRADOR).toFixed(2)}</td><td>${ ( ( parseFloat(row.val_RESULTADO_CCERRADOR) / parseFloat(row.SALDO_TOTAL) * 100)).toFixed(2) }%</td> </tr>
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

