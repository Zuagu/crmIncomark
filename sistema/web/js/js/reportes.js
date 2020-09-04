/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = function () {
    select_options_territorios();
};

$('#enviar_gestiones').click( function () {
    reporte_gestiones_tabla();
});

$('#enviar_convenios').click( function () {
    azteca_reporte_convenios();
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
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

