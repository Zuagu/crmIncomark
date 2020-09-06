/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function () {
    select_equipo_tabla();
};










//=================================================================
function select_equipo_tabla(_div) {
    $("#" + _div).empty();
    $("#" + _div).append("<img src='image/preloader_lineal.gif' width='40%'>");
    var params = {
        action: "select_usuarios"
    };
//    console.log(params);
    $.ajax({
        type: "POST",
        url: "ControllerUsuario",
        data: params,
        dataType: "json",
        success: function (equipos) {
            
        }
    });
}