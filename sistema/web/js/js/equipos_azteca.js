/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function () {
    select_usuarios('listado_gestores');
    select_equipo_tabla('div_equipos');
    $('#id_equipo').val(0);
};


$('#div_equipos').on('click', '.row_equipos', function () {
    $('#id_equipo').val($('.id_equipo', this).text());
    $('#id_equi_select').empty();
    $('#id_equi_select').append(`${$('.nombre_equipo', this).text()}`);
});

$('#listado_gestores').on('click', '.row_gestor', function () {
    let id_equipo = $('#id_equipo').val();
    console.log(id_equipo);
    if (id_equipo === '0' || id_equipo === '') {
        alert('Selecione el Equipo para poder agregar el gestor');
    } else {
        $('#id_ges_select').empty();
        $('#id_ges_select').append(`${$('.nombre_gestor', this).text()}`);
        agregar_gestor_a_equipo( $('.id_gestor', this).text(), id_equipo);
    }

});










//==============================================================================
function select_usuarios(_div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    let params = {
        action: "select_usuarios",
        filtro: ""
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerUsuario",
        data: params,
        dataType: "json",
        success: function (users) {
            $("#" + _div).empty();
            for (let user of users) {
                $("#" + _div).append(`<tr class='row_gestor'>
                    <td class='id_gestor'>${user.id}</td>
                    <td class='nombre_gestor'>${user.nombre}</td>
                </tr>`);
            }
        }
    });
}

//==============================================================================
function agregar_gestor_a_equipo(_id_gestor, _id_equipo) {
    let params = {
        action: "agregar_gestor_a_equipo",
        id_gestor: _id_gestor,
        id_equipo: _id_equipo
    };
    console.log(params);
//    $.ajax({
//        type: "POST",
//        url: "ControllerEquiposAzteca",
//        data: params,
//        dataType: "json",
//        success: function (response) {
//            console.log('');
//        }
//    });
}
//==============================================================================
function select_equipo_tabla(_div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    let params = {
        action: "select_equipo_tabla"
    };
//    console.log(params); // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
    $.ajax({
        type: "POST",
        url: "ControllerEquiposAzteca",
        data: params,
        dataType: "json",
        success: function (equipos) {
            $("#" + _div).empty();
            for (let equipo of equipos) {
                console.log(equipo);
                $("#" + _div).append(`<tr class='row_equipos'>
                    <td class='id_equipo'>${equipo.ID_EQUIPO}</td>
                    <td class='nombre_equipo'>${equipo.NOMBRE_EQUIPO}</td>
                    <td>${equipo.DESCRIPCION}</td>
                    <td>${equipo.CUENTAS}</td>
                    <td>${equipo.VALOR}</td>
                </tr>`);

            }
        }
    });
}