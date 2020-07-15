
var options_estatus_llamadas = "";
var options_estatus_cuenta = "";
$('#filtro').addClass('hide');
$('#resultado_menu').addClass('hide');
$('#unico_filtro').empty();
$('#unico_filtro').append($('#div_input_gestor_tiempos').html());
$('#div_input_gestor_tiempos').remove();
$(document).ready(function () {
//iniciar el dropdown del menu
    $('.fixed-action-btn').floatingActionButton();
    $('select').formSelect();
    $('.modal').modal();
    $(".dropdown-trigger").dropdown({constrainWidth: false});
    $('.sidenav').sidenav();
//    document.getElementById('foto_perfil').src = "http://gruposicsa.com/fotos/" + id_usuario + ".jpg";
    $(".sidenav").empty();
    // funcion que pinta el menu
    for (indice in menu) {
        $(".sidenav").append('<li><a onclick="verSubmenu(' + indice + ')"><i class="material-icons white-icon tooltipped" data-position="right"  data-tooltip="' + menu[indice].name + '">' + menu[indice].icono + '</i></a></li>');
    }
    $('.tooltipped').tooltip({margin: 20});
    $("#info_gestor").fadeIn(1500);
    $('.tabs').tabs();
    $('.datepicker').datepicker({
        container: "body",
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year,
        today: 'Today',
        clear: 'Clear',
        close: 'Ok',
        autoClose: true,
        closeOnSelect: true, // Close upon selecting a date,
        format: "yyyy-mm-dd"
    });
    $('.timepicker').timepicker({
        default: 'now',
        twelveHour: false,
        container: 'body'
    });
    $("#tiempo_actual").val("00:00:00");
    $("#retraso_actual").val("00:00:00");
});
window.onload = function () {
    
//    alert( $("#ID_CLIENTE").val() );
    select_datos_cuenta( $("#ID_CLIENTE").val() );
//    select_cuenta_siguiente(id_usuario);
//    select_llamadas_gestor(id_usuario);
    options_estatus_llamadas = '<option value="0"  selected>Selecciona Codigo</option>' +
            '<option value="1">1A (promesa de Pago)</option>' +
            '<option value="2">3D (Contacto con Titular)</option>' +
            '<option value="3">3A (Contacto con Familiar)</option>' +
            '<option value="4">3B (No Contacto)</option>' +
            '<option value="5">3E (Llamada Entrante)</option>' +
            '<option value="6">2A (Gestion de Visita)</option>' +
            '<option value="7">1B (Pago Parcial)</option>' +
            '<option value="8">1C (Cuenta Liquidada)</option>' +
            '<option value="9">1D (Pendiente Reactivar)</option>' +
            '<option value="10">3C (No Gestion)</option>' +
            '<option value="11">4A (Buzon Voz)</option>' +
            '<option value="12">4B (Tel No Existe)</option>' +
            '<option value="13">4C (Tel Suspendido)</option>' +
            '<option value="14">4D (No Conoce a Titular)</option>' +
            '<option value="15">4F (Cambio Domicilio)</option>' +
            '<option value="16">4G (Ilocalizable)</option>' +
            '<option value="17">4E (A Peticion de Famsa)</option>' +
            '<option value="18">4H (Dictaminada)</option>' +
            '<option value="19">4J (No Contesta Predictivo)</option>' +
            '<option value="20">2B (Segunda Gestion Visita)</option>' +
            '<option value="21">3F (Tercera Gestion Visita)</option>';
    $("#codigo_llamada").append(options_estatus_llamadas);
    options_estatus_cuenta = `<option id='1'>1.1 CUENTA LIQUIDADA</option>
            <option value='2'>1.3 DEFUNCION</option>
            <option value='3'>2.1 PROMESA INCUMPLIDA</option>
            <option value='4'>2.2 PLAN INCUMPLIDO</option>
            <option value='5'>2.3 PLAN CANCELADO</option>
            <option value='6'>3.1 PROMESA DE PAGO</option>
            <option value='7'>3.2 PROMESA PAGO INICIAL</option>
            <option value='8'>3.3 PROMESA PAGO PARCIAL</option>
            <option value='9'>3.3 PROMESA PAGO PARCIAL</option>
            <option value='10'>3.4 PROMESA RECURRENTE</option>
            <option value='11'>3.5 PLAN ACTIVO</option>
            <option value='12'>3.5 PLAN ACTIVO</option>
            <option value='13'>3.6 REESTRUCTURA</option>
            <option value='14'>3.7 LIQUIDACION</option>
            <option value='15'>4.1 CLIENTE NO DEFINE</option>
            <option value='16'>4.2 AVAL NO DEFINE</option>
            <option value='17'>4.3 SEGUIMIENTO</option>
            <option value='18'>4.4 NEGATIVA DE PAGO</option>
            <option value='19'>4.5 CLIENTE COLGO</option>
            <option value='20'>5.1 MENSAJE FAMILIAR</option>
            <option value='21'>5.2 MENSAJE TERCERO</option>
            <option value='22'>5.3 MENSAJE EN BUZON</option>
            <option value='23'>6.1 CLIENTE NO VIVE AHI</option>
            <option value='24'>6.2 CUELGA LLAMADA</option>
            <option value='25'>6.2 CUELGA LLAMADA</option>
            <option value='26'>6.3 FUERA DE SERVICIO</option>
            <option value='27'>6.4 NO LO CONOCE</option>
            <option value='28'>6.4 NO LO CONOCE</option>
            <option value='29'>6.5 NUMERO OCUPADO</option>
            <option value='30'>6.6 NO CONTESTA</option>
            <option value='31'>6.7 NO DISPONIBLE</option>
            <option value='32'>6.7 NO DISPONIBLE</option>
            <option value='33'>7.8 NO EXISTE</option>
            <option value='34'>7.8 NO EXISTE</option>
            <option value='35'>7.9 SIN DATOS</option>
            <option value='36'>8.1 SIN CLASIFICAR</option>`;
    $("#estatus").append(options_estatus_cuenta);
    $('select').formSelect();

}


//funcion cerrar sesion con boton
$("#cerrar").click(function () {
    Cerrar(id_usuario);
});
//actualizar el estatus de f_logeado al cerar pestaña
function Cerrar(id) {
    $.ajax({
        type: "POST",
        url: "/sistema/ControllerUsuario",
        data: {action: "cerrar_sesion", id_usuario: id}
    });
}

// funcion que lanza el menu lateral
$(".img_log").click(function () {
    $('.sidenav').sidenav('open');
});
// funcion que pinta los submenus al dar click
function verSubmenu(indice) {
    $("#contenido").empty();
    for (row in menu[indice].submenus) {
        $("#contenido").append('<div class="col s6 m4 l4">' +
                '<div class="col s10 offset-s1 padding_submenus" >' +
                '<div class="s12 center-align background_submenus_title">' + menu[indice].submenus[row] + '</div>' +
                '<div class="s12 center-align background_submenus"><a href="' + menu[indice].jsp[row] + '"><i class="medium material-icons white-icon">' + menu[indice].iconosSubmenus[row] + '</i></a><br></div>' +
                '</div>' +
                '</div>'
                );
    }
}

// Funciones para rl buscador
$("#filtro").click(function () {
    $("#resultado_menu").removeClass("hide");
    $("#colect").empty();
    for (p in menu) {
        for (r in menu[p].submenus) {
            $("#colect").append('<a href="' + menu[p].jsp[r] + '" class="collection-item">' + menu[p].submenus[r] + '</a>');
        }
    }
});
function myFunction_buscar() {
    var query = $("#filtro").val();
    var li = document.querySelectorAll('#resultado_menu div a');
    for (var i = 0; i < li.length; i++) {
        var a = li[i];
        if (a.textContent.toLowerCase().indexOf(query.toLowerCase().trim()) > -1) {
            a.style.display = "";
        } else {
            a.style.display = "none";
        }
    }
}
// funcion que esconde el menu 
$("#colect").delegate('.collection-item', 'click', function () {
    $("#resultado_menu").addClass("hide");
});
$(".row").click(function () {
    $("#resultado_menu").addClass("hide");
});
// funciones del pantalla del gestor
//pagos_diarios tab
$("#tab_pagos_diarios").click(function () {
    $(".rango_fechas_pagos_diarios").removeClass("hide");
    $(".div_tabla_pagos_diarios").addClass("hide");
});
$("#mostrar_pagos_diarios").click(function () {
    $(".rango_fechas_pagos_diarios").addClass("hide");
    $(".div_tabla_pagos_diarios").removeClass("hide");
});
//visitas tab
$("#mostrar_visitas").click(function () {
    $(".rango-fechas-visitas").addClass("hide");
    $("#tabla_visitas").removeClass("s10 m10 l10");
    $("#tabla_visitas").addClass("s12 m12 l12");
});
$("#tab_visitas").click(function () {
    $(".rango-fechas-visitas").removeClass("hide");
    $("#tabla_visitas").removeClass("s12 m12 l12");
    $("#tabla_visitas").addClass("s10 m10 l10");
});
//convenios tab
$("#mostrar_convenios").click(function () {
    $(".rango-fechas-convenios").addClass("hide");
    $("#tabla_convenios").removeClass("s10 m10 l10");
    $("#tabla_convenios").addClass("s12 m12 l12");
});
$("#tab_convenios").click(function () {
    $(".rango-fechas-convenios").removeClass("hide");
    $("#tabla_convenios").removeClass("s12 m12 l12");
    $("#tabla_convenios").addClass("s10 m10 l10");
});
//estadisticas tab
$("#mostrar_estadisticas").click(function () {
    $(".rango-fechas-estadisticas").addClass("hide");
    $("#tabla_estadisticas").removeClass("s10 m10 l10");
    $("#tabla_estadisticas").addClass("s12 m12 l12");
});
$("#tab_estadisticas").click(function () {
    $(".rango-fechas-estadisticas").removeClass("hide");
    $("#tabla_estadisticas").removeClass("s12 m12 l12");
    $("#tabla_estadisticas").addClass("s10 m10 l10");
});
//agendas tab
$("#mostrar_agendas").click(function () {
    $(".rango-fechas-agendas").addClass("hide");
    $("#tabla_agendas").removeClass("s10 m10 l10");
    $("#tabla_agendas").addClass("s12 m12 l12");
});
$("#tab_agendas").click(function () {
    $(".rango-fechas-agendas").removeClass("hide");
    $("#tabla_agendas").removeClass("s12 m12 l12");
    $("#tabla_agendas").addClass("s10 m10 l10");
});
//funcion de buscador
function buscar_cuentas_gestor(_busqueda, _id_puesto, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_central.gif' width='100%'>");
    var params = {
        action: "select_buscar_cuentas",
        busqueda: _busqueda,
        id_puesto: _id_puesto
    };
//    console.log();
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (cuentas) {
//            console.log(cuentas);
            $("#" + _div).empty();
            for (var i in cuentas) {
                $("#" + _div).append('<div class="col s12 m12 l12 hoverable z-depth-2 div-res">' +
                        '<input class="val_cuenta" type="hidden" value="' + cuentas[i].CLIENTE_UNICO + ',' + cuentas[i].CLIENTE_UNICO + '">' +
                        '<span class="black-text cuentas_data "><b>Cuenta: </b><span>' + cuentas[i].CLIENTE_UNICO + '</span></span>' +
                        '<span class="black-text cuentas_data"><b>&nbsp;&nbsp;&nbsp; Exp:</b> ' + cuentas[i].NOMBRE_AVAL + '</span> <br>' +
                        '<span class="black-text cuentas_data"><b>Nombre:</b> ' + cuentas[i].NOMBRE_CTE + '</span> <br>' +
                        '<span class="black-text cuentas_data"><b>TELAVAL:</b> ' + cuentas[i].TELAVAL + '</span>' +
                        '<span class="black-text cuentas_data"><b>&nbsp;&nbsp;&nbsp; TEL1: </b> ' + cuentas[i].TELEFONO1 + '</span>' +
                        '<span class="black-text cuentas_data"><b>&nbsp;&nbsp;&nbsp; TEL2: </b> ' + cuentas[i].TELEFONO2 + '</span><br>' +
                        '<span class="black-text cuentas_data"><b>TEL3: </b> ' + cuentas[i].TELEFONO3 + '</span><br>' +
                        '<span class="black-text cuentas_data"><b>TEL4: </b> ' + cuentas[i].TELEFONO4 + '</span>' +
                        '</div>');
            }
        }
    });
}
;
$("#buscador_cuentas_gestor").keyup(function (e) {

    if (e.keyCode === 13) {
        if ($("#buscador_cuentas_gestor").val().length > 5) {
//limipiar inputs info_gestor, info_gestor_secundario
//            $("#info_gestor input, #info_gestor_secundario input").val("");
//            $("#tbody_tabla_convenios, #tbody_tabla_gestiones, #tbody_tabla_pagos").empty();

            $("#div_cuentas_encontradas").removeClass("hide");
            $("#div_telefonos_cuenta").addClass("hide");
//            $(".div_search_gestor").addClass("s3 m3 l3");
//            $(".div_search_gestor").removeClass("s2 m2 l2");
//            $(".contenido-datos").addClass("s9 m9 l9");
//            $(".contenido-datos").removeClass("s10 m10 l10");
            buscar_cuentas_gestor($("#buscador_cuentas_gestor").val(), id_puesto_usuario, "div_cuentas_encontradas");
        } else {
            $("#modal_alerta").modal("open");
            $("#mensaje_alerta").empty();
            $("#mensaje_alerta").append("<br>El criterio de busqueda es muy corto");
        }
    }
});
$("#buscador_cuentas_gestor").click(function () {
//    $("#div_cuentas_encontradas").empty();
});
// funciones de datos cuenta
function select_datos_cuenta(_cuenta) {
    var params = {
        action: "datos_cuenta_azteca",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
            console.log(datos_cuenta);
            for (var dato in datos_cuenta) {
                $("#" + dato).empty();
                $("#" + dato).val(datos_cuenta[dato]);
            }
            $("#estatus").empty();
            $("#estatus").append('<option value="0"  selected>Selecciona Estatus</option>' + options_estatus_cuenta);
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();
            $("#div_telefonos_cuenta").empty();
            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");
            $("#DIRECCION").val(`${datos_cuenta.DIRECCION_CTE} ·#${datos_cuenta.NUM_EXT_CTE} colonia. ${datos_cuenta.COLONIA_CTE} ${datos_cuenta.COLONIA_CTE} C.P. ${datos_cuenta.CP_CTE} Estado ${datos_cuenta.ESTADO_CTE}`);
            $("#div_telefonos_cuenta").append('<div class="div-telefonos hoverable z-depth-1 card">' +
                    '<span class="black-text"><b>Telefonos</b></span><br>' +
                    '<span class="">TELEFONO 1: <a class="tell" href="zoiper://' + datos_cuenta["TELEFONO1"].replace(/ /g, "") + '">' + datos_cuenta["TELEFONO1"] + '</a></span><br>' +
                    '<span class="">TELEFONO 2: <a class="tell" href="zoiper://' + datos_cuenta["TELEFONO2"].replace(/ /g, "") + '">' + datos_cuenta["TELEFONO2"] + '</a></span><br>' +
                    '<span class="">TELEFONO 3: <a class="tell" href="zoiper://' + datos_cuenta["TELEFONO3"].replace(/ /g, "") + '">' + datos_cuenta["TELEFONO3"] + '</a></span><br>' +
                    '<span class="">TELEFONO 4: <a class="tell" href="zoiper://' + datos_cuenta["TELEFONO4"].replace(/ /g, "") + '">' + datos_cuenta["TELEFONO4"] + '</a></span><br>' +
                    '<span class="">TELAVAL: <a class="tell" href="zoiper://' + datos_cuenta["TELAVAL"].replace(/ /g, "") + '">' + datos_cuenta["TELAVAL"] + '</a></span>' +
                    '</div>');
//            var f_inicio = datos_cuenta["inicio_deudor"].split(" ");
            select_gestiones_cuenta(datos_cuenta["CLIENTE_UNICO"], "0000-00-00", "tbody_tabla_gestiones");
//            select_pagos_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_pagos");
        }
    });
}




function select_gestiones_cuenta(_cuenta, _fecha_inico, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_gestiones_cuenta",
        cuenta: _cuenta,
        fecha_inico: _fecha_inico
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (gestiones) {
            $("#" + _div).empty();
            for (var i in gestiones) {
                $("#" + _div).append('<tr>' +
                        '<td>' + gestiones[i].FECHA_LARGA + '</td>' +
                        '<td>' + gestiones[i].HORA + '</td>' +
                        '<td>' + gestiones[i].NUMERO_MARCADO + '</td>' +
                        '<td>' + gestiones[i].ID_USUARIO + '</td>' +
                        '<td>' + gestiones[i].ID_ESTATUS_CUENTA + '</td>' +
                        '<td>' + gestiones[i].ID_ESTATUS_LLAMADA + '</td>' +
                        '<td>' + gestiones[i].GESTION + '</td>' +
                        '<td>' + gestiones[i].DURACION + '</td>' +
                        '</tr>'
                        );
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }

    });
}

function select_pagos_cuenta(_cuenta, _fecha_inico, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_pagos_cuenta",
        cuenta: _cuenta,
        fecha_inico: _fecha_inico
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "",
        data: params,
        dataType: "json",
        success: function (pagos) {
            $("#" + _div).empty();
//            console.log(pagos.length);
            if (pagos.length === 0) {
                $("#" + _div).append("Esta cuenta no tiene ningun pago");
            } else {
                for (var i in pagos) {
                    $("#" + _div).append('<tr>' +
                            '<td>' + pagos[i].cuenta + '</td>' +
                            '<td>' + pagos[i].fecha_pago + '</td>' +
                            '<td>' + pagos[i].origen + '</td>' +
                            '<td>' + pagos[i].importe + '</td>' +
                            '<td>' + pagos[i].forma + '</td>' +
                            '<td>' + pagos[i].status + '</td>' +
                            '<td>' + pagos[i].fecha_aplicacion + '</td>' +
                            '</tr>'
                            );
                }
            }

        }
    });
}
$("#div_cuentas_encontradas").delegate(".div-res", "click", function () {
    var cuenta = $(".val_cuenta", this).val().split(",");
//    console.log(cuenta);
    if (cuenta[0] !== "0") {
        select_datos_cuenta(cuenta[0]);
    } else {
        alert(cuenta[1]);
//        select_datos_cuenta_relacionada(cuenta[1]);
    }
    
    $("#div_cuentas_encontradas").addClass("hide");
    $("#div_telefonos_cuenta").removeClass("hide");
});


// funciones de select convenios
function select_convenios_cuenta(_cuenta, _div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_convenios_cuenta",
        cuenta: _cuenta
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (convenios) {
            console.log(convenios);
            var color_status = ["", "yellow", "green", "red lighten-2"];
            $("#" + _div).empty();
            for (var i in convenios) {
                $("#" + _div).append('<tr class="' + color_status[ convenios[i].ID_CONVENIO ] + '">' +
                        '<td>' + convenios[i].CUENTA + '</td>' +
                        '<td>' + convenios[i].ID_USUARIO + '</td>' +
                        '<td>' + convenios[i].CONVENIO + '</td>' +
                        '<td>' + convenios[i].FECHA_INSET + '</td>' +
                        '<td>' + convenios[i].ATRASO_MAXIMO + '</td>' +
                        '<td>' + convenios[i].FECHA + '</td>' +
                        '<td>' + convenios[i].PAGOS + '</td>' +
                        '<td>' + convenios[i].FECHA_PAGO + '</td>' +
                        '<td>' + convenios[i].EFECTIVIDAD + '</td>' +
                        '<td>' + convenios[i].ID_ESTATUS + '</td>' +
                        '</tr>'
                        );
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}
$("#tab_convenios").click(function () {
    if ($("#cuenta_deudor").val() !== "") {
        select_convenios_cuenta($("#CLIENTE_UNICO").val(), "tbody_tabla_convenios");
    } else {
        $("#tbody_tabla_convenios").empty();
        $("#tbody_tabla_convenios").append("No hay una Cuenta Selecionada");
    }

});
// Conteo de llamadas del gestor
//function select_llamadas_gestor(_id_usuario) {
//    $.ajax({
//        type: 'POST',
//        url: "/sistema/ControllerGestor",
//        data: {action: "select_llamadas_gestor", id_usuario: _id_usuario},
//        dataType: 'json',
//        success: function (respuesta) {
//            console.log(respuesta);
//            $("#primera_llamada").val(respuesta.hora.substr(11, 15));
//            $("#cuentas_tocadas").val(respuesta.cuentas);
//            $("#llamadas_realizadas").val(respuesta.llamadas);
//            $("#convenios").val(respuesta.convenios);
//        }
//    });
//}

//function conteo_llamadas_guardar_gestion(_id_status_llamada) {
//    console.log(_id_status_llamada);
//    var llamadas = parseInt($("#llamadas_realizadas").val());
//    llamadas++;
//    $("#llamadas_realizadas").val(llamadas);
//    if (_id_status_llamada === "1") {
//        var convenios = parseInt($("#convenios").val());
//        convenios++;
//        $("#convenios").val(convenios);
//    }
//}
//function conteo_llamadas_cuenta_siguiente() {
//    var cuentas_tocadas = parseInt($("#cuentas_tocadas").val());
//    cuentas_tocadas++;
//    $("#cuentas_tocadas").val(cuentas_tocadas);
//}


// funciones de select Cuenta siguete
function select_cuenta_siguiente(_id_usuario) {
    var params = {
        action: "select_cuenta_siguiente",
        id_usuario: _id_usuario
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (datos_cuenta) {
            console.log(datos_cuenta);
            if (datos_cuenta.id_cuenta === 0) {
                alert("Sin cuentas");
            } else {
                $("#div_cuentas_encontradas").addClass("hide");
                $("#div_telefonos_cuenta").removeClass("hide");
                for (var dato in datos_cuenta) {
                    $("#" + dato).empty();
                    $("#" + dato).val(datos_cuenta[dato]);
                }
                $("#estatus").empty();
                $("#estatus").append('<option value="0"  selected>Selecciona Estatus</option>' + options_estatus_cuenta);
                $("#codigo_llamada").empty();
                $("#codigo_llamada").append(options_estatus_llamadas);
                $('select').formSelect();
                $("#div_telefonos_cuenta").empty();
                $("#numero_marcado_deudor, #gestion").val("");
                $("#tiempo_actual").val("00:00:00");
                $("#retraso_actual").val("00:00:00");
                $("#DIRECCION").val(`${datos_cuenta.DIRECCION_CTE} ·#${datos_cuenta.NUM_EXT_CTE} colonia. ${datos_cuenta.COLONIA_CTE} ${datos_cuenta.COLONIA_CTE} C.P. ${datos_cuenta.CP_CTE} Estado ${datos_cuenta.ESTADO_CTE}`);
                $("#div_telefonos_cuenta").append('<div class="div-telefonos hoverable z-depth-1 card">' +
                        '<span class="black-text"><b>Telefonos</b></span><br>' +
                        '<span class="">TELEFONO 1: <a class="tell" href="zoiper://' + datos_cuenta["TELEFONO1"].replace(/ /g, "") + '">' + datos_cuenta["TELEFONO1"] + '</a></span><br>' +
                        '<span class="">TELEFONO 2: <a class="tell" href="zoiper://' + datos_cuenta["TELEFONO2"].replace(/ /g, "") + '">' + datos_cuenta["TELEFONO2"] + '</a></span><br>' +
                        '<span class="">TELEFONO 3: <a class="tell" href="zoiper://' + datos_cuenta["TELEFONO3"].replace(/ /g, "") + '">' + datos_cuenta["TELEFONO3"] + '</a></span><br>' +
                        '<span class="">TELEFONO 4: <a class="tell" href="zoiper://' + datos_cuenta["TELEFONO4"].replace(/ /g, "") + '">' + datos_cuenta["TELEFONO4"] + '</a></span><br>' +
                        '<span class="">TELAVAL: <a class="tell" href="zoiper://' + datos_cuenta["TELAVAL"].replace(/ /g, "") + '">' + datos_cuenta["TELAVAL"] + '</a></span>' +
                        '</div>');
//                conteo_llamadas_cuenta_siguiente();
//                pintar_telefonos_cuenta(datos_cuenta["telefonos"]);
//                telefonos_relacionados(datos_cuenta["cuenta_deudor"]);
//                var f_inicio = datos_cuenta["inicio_deudor"].split(" ");
                select_gestiones_cuenta(datos_cuenta["CLIENTE_UNICO"], '0000-00-00', "tbody_tabla_gestiones");
//                select_pagos_cuenta(datos_cuenta["cuenta_deudor"], f_inicio[0], "tbody_tabla_pagos");
//                $("#gestion").attr("readonly", "readonly");
            }

        }
    });
}

$("#cuenta_siguiente").click(function () {
    select_cuenta_siguiente(id_usuario);
});
// Funciones para insert Gestion

//$(".limpiar_numero").keyup( function (evt) {
//    console.log(evt);
//});

$(".limpiar_texto").keyup(function () {
    var cadena = $(this).val().replace(/[&\/\#,+()$~%'":*?<>{}|]/g, '');
    cadena = cadena.toUpperCase();
    $(this).val(cadena);
});

function insertar_gestion(myObj) {
//    console.log(myObj);
    var params = {
        action: "guardar_gestion",
        datos: JSON.stringify(myObj)
    };
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (result) {
            alert("Gestion guardada");
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $("#gestion").val("");
            $('select').formSelect();
            $("#numero_marcado_deudor").val("");
            $("#gestion").attr("readonly", "readonly");
            $("#tiempo_actual").val("00:00:00");
            $("#retraso_actual").val("00:00:00");
//            conteo_llamadas_guardar_gestion(myObj.id_estatus_llamada);
            select_gestiones_cuenta(myObj["_CUENTA"], '0000-00-00', "tbody_tabla_gestiones");
        },
        error: function (error) {
            console.log(error);
        }
    });
}

$("#guardar_gestion").click(function () {
    if ($("#codigo_llamada").val() !== "0" && $("#gestion").val() !== "" && $("#numero_marcado_deudor").val() !== "" && $("#estatus").val() !== "") {
        var myObjGestion = {
            _ID_SUCURSAL: $('#ID_SUCURSAL').val(),
            _ID_CLIENTE: $('#ID_CLIENTE').val(),
            _TERRITORIO: $('#TERRITORIO').val(),
            _CANAL: $('#CANAL').val(),
            _ATRASO_MAXIMO: $('#ATRASO_MAXIMO').val(),
            _CUENTA: $('#CLIENTE_UNICO').val(),
            _NUMERO_MARCADO: $('#numero_marcado_deudor').val(),
            _ID_ESTATUS_CUENTA: $('#estatus').val(),
            _ID_ESTATUS_LLAMADA: $('#codigo_llamada').val(),
            _ID_USUARIO: id_usuario,
            _GESTION: $('#gestion').val(),
            _DURACION: $('#tiempo_actual').val(),
            _RETASO: $('#retraso_actual').val(),
            _ID_PUESTO: id_puesto_usuario,
            _PROMESA: 0,
            _F_PREDICTIVO: 1,
            _ID_EQUIPO: $('#ID_EQUIPO').val()
        };
//        console.log(myObjGestion);
        insertar_gestion(myObjGestion);
    } else {
        $("#modal_alerta").modal("open");
        $("#mensaje_alerta").empty();
        $("#mensaje_alerta").append('Favor de rellenar los sigientes campos<br><br>' +
                '- Disposicion <br>- Codigo de llamada <br>- Numero marcado');
    }
});
$("#div_telefonos_cuenta").delegate(".tell", "click", function () {
    $("#numero_marcado_deudor").val($(this).text());
    $(".tell").removeClass("numero_marcado");
    $(this).addClass("numero_marcado");
    $("#gestion").val($(this).text());
    $("#gestion").removeAttr("readonly");
});
// Insert Convenio 
function insertar_convenio(_myObjConvenio, _myObjGestion) {
    console.log(_myObjConvenio);
    console.log(_myObjGestion);
    var params = {
        action: "insertar_convenio",
        datos: JSON.stringify(_myObjConvenio)
    };
    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerDataCuentaAzteca",
        data: params,
        dataType: "json",
        success: function (respuesta) {
            console.log(respuesta);
            $("#alerta_convenio").empty();
            $("#alerta_convenio").append(respuesta.resultado);
            $("#importe_convenio").val("");
            $("#fecha_convenio").val("");
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();
            if (respuesta.resultado !== "NO PERMITIDO" && respuesta.resultado !== "VERIFICA FECHA" && respuesta.resultado !== "VERIFIQUE IMPORTE Y LA FECHA DEL CONVENIO") {
                insertar_gestion(_myObjGestion);
                $("#modal_convenio").modal("close");
            }
        }
    });
}

$("#codigo_llamada").change(function () {
    if ($("#codigo_llamada").val() === "1") {
        var validacion = 0;
        var myObjGestion = {
            id_cuenta: $("#id_cuenta_deudor").val(),
            id_asignacion: $("#id_asignacion_deudor").val(),
            id_region: $("#id_region_deudor").val(),
            id_cliente: $("#id_cliente_deudor").val(),
            fecha_fin: $("#fecha_fin_deudor").val(),
            fecha_inicio: $("#inicio_deudor").val(),
            numero_marcado: $("#numero_marcado_deudor").val().replace(/ /gi, ""),
            cuenta: $("#cuenta_deudor").val(),
            id_estatus_cuenta: $("#estatus").val(),
            id_estatus_llamada: $("#codigo_llamada").val(),
            id_usuario: id_usuario,
            id_puesto: id_puesto_usuario,
            gestion: $("#gestion").val().replace(/"|,|'|-/gi, ""),
            duracion: $("#tiempo_actual").val(),
            retraso_llamada: $("#retraso_actual").val(),
            expediente: $("#expediente_deudor").val(),
            f_predictivo: 0
        };
        for (var obj in myObjGestion) {
            if (myObjGestion[obj] === "") {
                validacion++;
            }
        }
        if ($("#codigo_llamada").val() === "1" && validacion === 0 && $("#estatus").val() !== "0") {
            $("#modal_convenio").modal("open");
        } else {
            $("#modal_alerta").modal("open");
            $("#mensaje_alerta").empty();
            $("#mensaje_alerta").append('Favor de rellenar los sigientes campos para poder agregar un convenio<br><br>' +
                    '- Disposicion <br>- Codigo de llamada <br>- Numero marcado <br>');
            $("#codigo_llamada").empty();
            $("#codigo_llamada").append(options_estatus_llamadas);
            $('select').formSelect();
        }
    }

});
$("#insert_convenio").click(function () {
    var myObjGestion = {
        _ID_SUCURSAL: $('#ID_SUCURSAL').val(),
        _ID_CLIENTE: $('#ID_CLIENTE').val(),
        _TERRITORIO: $('#TERRITORIO').val(),
        _CANAL: $('#CANAL').val(),
        _ATRASO_MAXIMO: $('#ATRASO_MAXIMO').val(),
        _CUENTA: $('#CLIENTE_UNICO').val(),
        _NUMERO_MARCADO: $('#numero_marcado_deudor').val().replace(/ /gi, ""),
        _ID_ESTATUS_CUENTA: $('#estatus').val(),
        _ID_ESTATUS_LLAMADA: $('#codigo_llamada').val(),
        _ID_USUARIO: id_usuario,
        _GESTION: $('#gestion').val().replace(/"|,|'|-/gi, ""),
        _DURACION: $('#tiempo_actual').val(),
        _RETASO: $('#retraso_actual').val(),
        _ID_PUESTO: id_puesto_usuario,
        _PROMESA: 1,
        _F_PREDICTIVO: 0,
        _ID_EQUIPO: $('#ID_EQUIPO').val()
    };
    var myObjConvenio = {
        CONVENIO: $("#importe_convenio").val(),
        FECHA: $("#fecha_convenio").val(),
        ID_USUARIO: id_usuario,
        CUENTA: $('#CLIENTE_UNICO').val(),
        TERRITORIO: $('#TERRITORIO').val(),
        CANAL: $('#CANAL').val(),
        ATRASO_MAXIMO: $('#ATRASO_MAXIMO').val(),
        ID_EQUIPO: $('#ID_EQUIPO').val()
    };
    var validacion = 0;
    for (var obj in myObjConvenio) {
        if (myObjConvenio[obj] === "") {
            validacion++;
        }
    }
    if (validacion === 0) {
        insertar_convenio(myObjConvenio, myObjGestion);
    } else {
        $("#alerta_convenio").empty();
        $("#alerta_convenio").append("Faltan datos por llenar");
    }
});
$("#importe_convenio, #fecha_convenio").click(function () {
    $("#alerta_convenio").empty();
});
$("#cancelar_convenio").click(function () {
    $("#alerta_convenio").empty();
    $("#importe_convenio").val("");
    $("#fecha_convenio").val("");
    $("#codigo_llamada").empty();
    $("#codigo_llamada").append(options_estatus_llamadas);
    $('select').formSelect();
});


// Controlar tiempos del gestor 
function cronometro_retraso_actual() {
    var datos = $("#retraso_actual").val().split(":");
    var horas = datos[0];
    var minutos = datos[1];
    var segundos = datos[2];
    horas = parseInt(horas);
    minutos = parseInt(minutos);
    segundos = parseInt(segundos);
    segundos++;
    if (segundos >= 60) {
        segundos = 0;
        minutos++;
    }
    if (minutos >= 60) {
        minutos = 0;
        horas++;
    }
    if (minutos <= 9)
        minutos = "0" + minutos;
    if (segundos <= 9)
        segundos = "0" + segundos;
    if (horas <= 9)
        horas = "0" + horas;
    $("#retraso_actual").val('');
    $("#retraso_actual").val(horas + ":" + minutos + ":" + segundos);
}

function cronometro_llamada_actual() {
    var datos = $("#tiempo_actual").val().split(":");
    var horas = datos[0];
    var minutos = datos[1];
    var segundos = datos[2];
    horas = parseInt(horas);
    minutos = parseInt(minutos);
    segundos = parseInt(segundos);
    segundos++;
    if (segundos >= 60) {
        segundos = 0;
        minutos++;
    }
    if (minutos >= 60) {
//        select_llamadas_gestor(_id_usuario);
        minutos = 0;
        horas++;
    }
    if (minutos <= 9)
        minutos = "0" + minutos;
    if (minutos >= 5 || horas > 0) {
        $(".div_input_gestor_tiempos").css("background-color", "#ffeb3b");
        cronometro_retraso_actual();
    }
    if (minutos === 10)
        $(".div_input_gestor_tiempos").css("background-color", "#f44336");
    if (segundos <= 9)
        segundos = "0" + segundos;
    if (horas <= 9)
        horas = "0" + horas;
    $("#tiempo_actual").val('');
    $("#tiempo_actual").val(horas + ":" + minutos + ":" + segundos);
}
var tiempo_llamada_actual = setInterval(function () {
    cronometro_llamada_actual();
}, 1000);
// funciones de Agenda
function insert_agenda() {
    var params = {
        action: "insert_agenda",
        fecha: "2019-12-06",
        hora: "12:30:00",
        descripcion: ""
    };
    $.ajax({
        type: "POST",
        url: "",
        data: params,
        dataType: "json",
        success: function (result) {
//            console.log(saldos);
        }
    });
}

function select_agenda_disponible() {
    var params = {
        action: "select_agenda_disponible",
        id_usuario: 69
    };
    $.ajax({
        type: "POST",
        url: "",
        data: params,
        dataType: "json",
        success: function (result) {
//            console.log(saldos);
        }
    });
}
