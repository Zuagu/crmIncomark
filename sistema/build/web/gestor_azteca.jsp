
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cierre Asignacion</title>
        <link rel="shortcut icon" href="image/logoInco.fw.png">
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style.css">
    </head>

    <body style="background: #fafafa">
        <jsp:include page="header.jsp"/>
        <div class="row" id="contenido">
            <div class="container-fluid">
                <div class="col s10 m10 l10 contenido-datos">
                    <input id="id_cuenta" type="hidden">
                    <input id="numero_marcado_deudor" type="hidden">
                    <input id="ID_SUCURSAL" type="hidden">
                    <input id="ID_CLIENTE" type="hidden">
                    <input id="TERRITORIO" type="hidden">
                    <input id="CANAL" type="hidden">
                    <input id="ID_EQUIPO" type="hidden">
                    <div id="info_gestor" class=" col s8 m8 l8 div_input_gestor_info  z-depth-1">
                        <div class="col s12 m12 l12">
                            <h6>Informacon General</h6>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="CLIENTE_UNICO" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="CLIENTE_UNICO">Cuenta</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="NOMBRE_CTE" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="NOMBRE_CTE">Titular</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="GERENTE" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="GERENTE">Gerente</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="RFC" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="RFC">RFC</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="CAMPANIA" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="CAMPANIA">Producto</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="SUBCAMPANA" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="SUBCAMPANA">Subprodcuto</label>
                        </div>
                        <div class="input-field col s12 m12 l12">
                            <input id="DIRECCION" type="text" class="validate" placeholder="" readonly="readonly" value="">
                            <label for="">Direccion</label>
                        </div>
                    </div>
                    <div id="info_gestor_secundario" class="col s4 m4 l4 div_input_gestor_tiempos z-depth-1 div_info_secundaria">
                        <div class="col s12 m12 l12">
                            <h6>Info. Economica</h6>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="ATRASO_MAXIMO" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="ATRASO_MAXIMO">Semanas</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="DIA_DE_PAGO" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="DIA_DE_PAGO">Dia de Pago</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="FECHA_ULTIMO_PAGO" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="FECHA_ULTIMO_PAGO">Fecha Ultimo Pago</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="IMP_ULTIMO_PAGO" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="IMP_ULTIMO_PAGO">Ult. Pago $</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="SALDO" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="SALDO">Capital</label>
                        </div>
                        <div class="input-field col s6 m6 l6">
                            <input id="MORATORIOS" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="MORATORIOS">Moratorios</label>
                        </div>
                        <div class="input-field col s12 m12 l12">
                            <input id="SALDO_TOTAL" type="text" class="validate" placeholder="" readonly="readonly"  value="">
                            <label for="SALDO_TOTAL">Saldo Total</label>
                        </div>
                    </div>

                    <div class=" col s12 m12 l12  div_gestor_gestion">
                        <div class=" col s6 m6 l6 z-depth-1 div_gestor_textarea grey lighten-5 input_gestion">
                            <textarea id="gestion" readonly="" class="materialize-textarea limpiar_texto" data-length="500" placeholder="Gestion"></textarea>
                        </div>
                        <div class=" col s6 m6 l6">
                            <div class="input-field col s6 m6 l6">
                                <div class=" input-field col s12 m12 l12  div_gestor_gestion">
                                    <select id="estatus">
                                        <option value="0" selected>Selecciona Estatus</option>
                                    </select>
                                    <select id="codigo_llamada"></select>
                                </div> 
                            </div>
                            <div class="col s6 m6 l6 ">
                                <div class="col s12 m12 l12 ">
                                    <a id="guardar_gestion" class="waves-effect waves-light btn btn_guardar_gestiones"><i class="material-icons right">save</i>Guardar.</a>
                                </div>
                                <div class="col s12 m12 l12">
                                    <a id="cuenta_siguiente" class="waves-effect waves-light btn btn_siguiente"><i class="material-icons right">send</i>Siguiente</a>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class=" col s12 m12 l12 div_tabs">
                        <ul id="tabs-swipe-demo" class="tabs hide_print ul_tabs">
                            <li class="tab col s1"><a id="tab_gestiones" class="active gestor_tab tooltipped" data-position="bottom" data-tooltip="Gestiones" href="#div_gestiones" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">contact_phone</i></a></li>
                            <li class="tab col s1"><a class="gestor_tab tooltipped " data-position="bottom" data-tooltip="Ref. Bancarias" href="#test-swipe-2" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">credit_card</i></a></li>
                            <li class="tab col s1"><a id="tab_pagos" class="gestor_tab tooltipped" data-position="bottom" data-tooltip="Pagos" href="#div_pagos" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">monetization_on</i></a></li>
                            <li class="tab col s1"><a id="tab_pagos_diarios" class="gestor_tab tooltipped" data-position="bottom" data-tooltip="Pagos_diarios" href="#div_pagos_diarios" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">attach_money</i></a></li>
                            <li class="tab col s1"><a id="tab_agendas" class="gestor_tab tooltipped" data-position="bottom" data-tooltip="Agenda" href="#div_agendas" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">insert_invitation</i></a></li>
                            <li class="tab col s1"><a id="tab_visitas" class="gestor_tab tooltipped" data-position="bottom" data-tooltip="Visitas" href="#div_visitas" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">location_on</i></a></li>
                            <li class="tab col s1"><a id="tab_convenios" class="gestor_tab tooltipped" data-position="bottom" data-tooltip="Convenios" href="#div_convenios" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">stars</i></a></li>
                            <li class="tab col s1"><a id="tab_saldos" class="gestor_tab tooltipped"data-position="bottom" data-tooltip="Saldos" href="#div_saldos" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">pie_chart</i></a></li>
                            <li class="tab col s1"><a id="tab_estadisticas" class="gestor_tab tooltipped" data-position="bottom" data-tooltip="Estadisticas" href="#div_estadisticas" style="color:#db040e"><i class="icon_gestor_tab tiny material-icons">poll</i></a></li>
                        </ul>
                    </div>    
                    <div id="div_gestiones" class="col s12 z-depth-1 div_gestor_contenido" style="margin-top:10px;"> 
                        <table class="highlight" id="tabla_gestiones">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td> <b>FECHA</b></td>
                                    <td> <b>HORA</b></td>
                                    <td> <b>NUMERO</b></td>
                                    <td> <b>AGENTE</b></td>
                                    <td> <b>ESTATUS</b></td>
                                    <td> <b>CODIGO</b></td>
                                    <td> <b>DISPOCISION</b></td>
                                    <td> <b>TIEMPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_gestiones">
                            </tbody>
                        </table>
                    </div>
                    <div id="test-swipe-2" class="col s12 z-depth-1 div_gestor_contenido" style="margin-top:10px;">
                        <ul class="collection">
                            <li class="collection-item avatar ref_banc">
                                <img src="image/logo-bancos/banamex.fw.png" alt="" class="circle">
                                <span class="title">Banamex</span>
                                <input id="ref_bancaria1" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                            <li class="collection-item avatar ref_banc">
                                <img src="image/logo-bancos/bancomer.fw.png" alt="" class="circle">
                                <span class="title">Bancomer</span>
                                <h6 class="">182251</h6>
                                <input id="ref_bancaria2" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                            <li class="collection-item avatar">
                                <img src="image/logo-bancos/hsbc.fw.png" alt="" class="circle">
                                <span class="title">HSBC</span>
                                <h6 class="">2904</h6>
                                <input id="ref_bancaria3" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                            <li class="collection-item avatar ref_banc">
                                <img src="image/logo-bancos/banorte.fw.png" alt="" class="circle">
                                <span class="title">Banorte</span>
                                <h6 class="">37478</h6>
                                <input id="ref_bancaria4" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                            <li class="collection-item avatar ref_banc">
                                <img src="image/logo-bancos/santander.fw.png" alt="" class="circle">
                                <span class="title">Santander</span>
                                <h6 class="">4565</h6>
                                <input id="ref_bancaria5" type="text" class="validate" placeholder="" readonly="readonly">
                            </li>
                        </ul>
                    </div>
                    <div id="div_pagos" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <table class="highlight" id="tabla_pagos">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>CUENTA</b></td>
                                    <td><b>FECHA PAGO</b></td>
                                    <td><b>ORIGEN</b></td>
                                    <td><b>IMPORTE</b></td>
                                    <td><b>FORMA</b></td>
                                    <td><b>ESTATUS</b></td>
                                    <td><b>FECHA APLICACION</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_pagos">
                            </tbody>
                        </table>
                    </div>
                    <div id="div_pagos_diarios" class="col s12 m12 l12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <div class="col s4 m4 l4 offset-s4 offset-m4 offset-l4 rango_fechas_pagos_diarios hide">
                            <input id="desde_pagos_gestor" type="text" class="datepicker input_date center-align" placeholder="desde">
                            <input id="hasta_pagos_gestor" type="text" class="datepicker input_date center-align" placeholder="hasta">
                            <a id="mostrar_pagos_diarios" class="waves-effect waves-light btn btn_gestiones green center">enviar</a>
                        </div>
                        <div class="div_tabla_pagos_diarios hide">
                            <table class="highlight striped" id="tabla_pagos_diarios">
                                <thead class="blue">
                                    <tr class="text-white">
                                        <td><b>CUENTA</b></td>
                                        <td><b>FECHA PAGO</b></td>
                                        <td><b>ORIGEN</b></td>
                                        <td><b>IMPORTE</b></td>
                                        <td><b>FORMA</b></td>
                                        <td><b>ESTATUS</b></td>
                                        <td><b>FECHA APLICACION</b></td>
                                    </tr>
                                </thead>
                                <tbody id="tbody_tabla_pagos_diarios">
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="div_agendas" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <div class="col s2 m2 l2 rango-fechas-agendas hide ">
                            <input type="text" class="datepicker input_date center-align" placeholder="Fecha">
                            <input type="text" class="timepicker input_date center-align" placeholder="Hora">
                            <a id="mostrar_agendas" class="waves-effect waves-light btn btn_gestiones green center">enviar</a>
                        </div>
                        <div id="tabla_agendas" class="col s12 m12 l12">jkshaksjdhkasjh</div>
                    </div>
                    <div id="div_visitas" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <div class="col s2 m2 l2 rango-fechas-visitas hide">
                            <input type="text" class="datepicker input_date center-align" placeholder="desde">
                            <input type="text" class="timepicker input_date center-align" placeholder="hasta">
                            <a id="mostrar_visitas" class="waves-effect waves-light btn btn_gestiones green center">enviar</a>
                        </div>
                        <div id="tabla_visitas" class="col s12 m12 l12">jkshaksjdhkasjh</div>
                    </div>
                    <div id="div_convenios" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <table class="highlight" id="tabla_convenios">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>CUENTA</b></td>
                                    <td><b>GESTOR</b></td>
                                    <td><b>CONVENIO</b></td>
                                    <td><b>FECHA GESTION</b></td>
                                    <td><b>PLAZO</b></td>
                                    <td><b>FECHA</b></td>
                                    <td><b>PAGOS</b></td>
                                    <td><b>FECHA PAGOS</b></td>
                                    <td><b>EFECTIVIDAD</b></td>
                                    <td><b>STATUS</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_convenios">
                            </tbody>
                        </table>
                    </div>
                    <div id="div_saldos" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <table class="highlight" id="tabla_equipos_usuario">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>ASIGNACION</b></td>
                                    <td><b>EQUIPO</b></td>
                                    <td><b>CUENTAS</b></td>
                                    <td><b>ASIGNADO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_equipos_usuario">
                            </tbody>
                        </table>
                        <table class="highlight hide" id="tabla_saldos_status">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>REGION</b></td>
                                    <td><b>ESTATUS</b></td>
                                    <td><b>CUENTAS</b></td>
                                    <td><b>VALOR</b></td>
                                    <td><b>ULTIMO TOQUE</b></td>
                                    <td><b>GRUPO</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_saldos_status">
                            </tbody>
                        </table>
                        <table class="highlight hide" id="tabla_cuentas_status">
                            <thead class="blue">
                                <tr class="text-white">
                                    <td><b>REGION</b></td>
                                    <td><b>CUENTA</b></td>
                                    <td><b>ESTATUS</b></td>
                                    <td><b>RESTO</b></td>
                                    <td><b>ULTIMO TOQUE</b></td>
                                </tr>
                            </thead>
                            <tbody id="tbody_tabla_cuentas_status">
                            </tbody>
                        </table>
                    </div>
                    <div id="div_estadisticas" class="col s12 z-depth-1 div_gestor_contenido center center-align" style="margin-top:10px;">
                        <div class="col s2 m2 l2 rango-fechas-estadisticas hide">
                            <input type="text" class="datepicker input_date center-align" placeholder="desde">
                            <input type="text" class="datepicker input_date center-align" placeholder="hasta">
                            <a id="mostrar_estadisticas" class="waves-effect waves-light btn btn_gestiones green center">enviar</a>
                        </div>
                        <div id="tabla_estadisticas" class="col s12 m12 l12">jkshaksjdhkasjh</div>
                    </div>
                    <div class="col s12 m12 l12 div_input_gestor_tiempos z-depth-1">
                        <div class="input-field col s2 m2 l2">
                            <input id="primera_llamada" type="text" class="validate" placeholder="" readonly="readonly" value="00:00:00">
                            <label for="primera_llamada">P.llamada</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="tiempo_actual" type="text" class="validate" placeholder="" readonly="readonly" value="00:00:00">
                            <label for="tiempo_actual">Actual</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="retraso_actual" type="text" class="validate" placeholder="" readonly="readonly" value="00:00:00">
                            <label for="retraso_actual">R. Actual</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="cuentas_tocadas" type="text" class="validate" placeholder="" readonly="readonly" value="0000">
                            <label for="cuentas_tocadas">Cuentas</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="llamadas_realizadas" type="text" class="validate" placeholder="" readonly="readonly" value="0000">
                            <label for="llamadas_realizadas" class="centro">Llamadas</label>
                        </div>
                        <div class="input-field col s2 m2 l2">
                            <input id="convenios" type="text" class="validate" placeholder="" readonly="readonly" value="0000">
                            <label for="convenios">Convenios</label>
                        </div>
                    </div>

                </div>
                <div class="col s2 m2 l2 z-depth-2 div_search_gestor inner">
                    <div class="input-field col s12 m12 l12">
                        <input id="buscador_cuentas_gestor" class="search_cuentas center-align" type="text" placeholder="Buscar">
                    </div>
                    <div id="div_cuentas_encontradas" class=" col s12 m12 l12 hide">

                    </div>
                    <div id="div_telefonos_cuenta" class=" col s12 m12 l12 hide">

                    </div>
                </div>  
            </div>
            <div id="modal_convenio" class="modal scale-transition">
                <div class="modal-content">
                    <h3 class="center">Generar Convenio</h3>
                    <h6 id="alerta_convenio" class="red-text center"></h6>
                    <div class="input-field col s12 m4 l4 offset-m2 offset-l2">
                        <input id="importe_convenio" type="text" class="validate limpiar_numero">
                        <label for="importe_convenio">Importe</label>
                    </div>
                    <div class="input-field col s12 m4 l4 offset-m1 offset-l1">
                        <input id="fecha_convenio" type="text" class="datepicker" placeholder="Fecha del convenio">
                    </div>
                    <div class="col s12 center">
                        <br>
                        <a id="cancelar_convenio" class="waves-effect waves-light btn red modal-close btn_gestiones "><i class="material-icons right">cancel</i>Cancel</a>
                        <a id="insert_convenio" class="waves-effect waves-light btn green btn_gestiones"><i class="material-icons right">save</i>Ok</a>
                        <br>
                        <br>
                    </div>
                </div>
            </div>
            <div id="modal_alerta" class="modal">
                <div class="modal-content">
                    <h3 class="center">Alerta</h3>
                    <h5 id="mensaje_alerta" class="mensaje_alerta">

                    </h5>
                </div>
            </div>
            <div class="fixed-action-btn">
                <a class="btn-floating btn-large red">
                    <i class="large material-icons">mode_edit</i>
                </a>
                <ul>
                    <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
                    <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
                    <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
                    <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
                </ul>
            </div>

        </div>	
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/highcharts-more.js"></script>
        <script src="https://code.highcharts.com/modules/solid-gauge.js"></script>
        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/Script_Azteca.js"></script>
    </body>
</html>