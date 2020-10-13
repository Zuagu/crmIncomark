<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Reportes Azteca</title>
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor.css">
        <style>
            .encabezados_csv span {
                background-color: rgba(0, 0, 0, 0.13);
                margin: 0.5rem;
                width: 200px;
                display: none;
                text-align: center;
                padding: 4px;
                border-radius: 3px;
            }
            .dt {
                overflow: auto;
                height: 70vh;
            }
            .div_resumen {
                overflow: auto;
                height: 50vh;
            }
            .div_resumen table {
                margin-top: 0.7rem;
            }
            td, th {
                padding: 5px 5px !important;

            }
            td {
                font-size: 13px;
            }
            .margin_top_btn {
                margin-top: 20px;
                margin-right: 10px;
            }
            .color_VIGENTE {
                background-color: #ffff8d;
            }
            .color_INCUMPLIDO {
                background-color: #ff9e80;
            }
            .color_CUMPLIDO {
                background-color: #69f0ae;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row" id="contenido"></div>

        <div class="row">
            <div class="col s12 m12 l12">
                <div class="col s12 m12 l12">
                    <ul id="tabs-swipe-demo" class="tabs hide_print">
                        <li class="tab col s3"><a class="active" href="#test-swipe-1" style="color:#db040e">Promesado Diario</a></li>
                        <li class="tab col s3"><a class="active" href="#test-swipe-2" style="color:#db040e">Promesas Incumplidas</a></li>
                        <li class="tab col s2"><a class="active" href="#test-swipe-3" style="color:#db040e">Promesado x Gestor</a></li>

                    </ul>
                    <div id="test-swipe-1" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s10 hide_print">
                                <div class="input-field col s3" >
                                    <select id="territorio_promesado_diario"  type="text"></select>
                                    <label for="territorio_promesado_diario">Territorio</label>
                                </div>
                                <div class="input-field col s3" >
                                    <input id="fecha_promesado_diario" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly=""></td>
                                    <label class="" for="fecha_promesado_diario"></label>
                                </div>
                                <a id="obt_promesado_diario" class="waves-effect waves-light btn blue margin_top_btn"><i class="material-icons right">send</i>Consultar</a> 
                                <a onclick="tableToExcel('datos_tabla_promesado_diario', 'PROMESADO DIARIO')" class="waves-effect waves-light btn green margin_top_btn"><i class="material-icons right">explicit</i>Exportar</a> 
                            </div>
                            <div id="promesado_diario" class="col s12 m12 l12">
                                <div id="datos_tabla_promesado_diario" class="col s12 z-depth-2 dt">
                                    <table class="highlight" id="tabla_pagos">
                                        <thead class="blue">
                                            <tr class="text-white">
                                                <td><b>GESTOR</b></td>
                                                <td><b>CEUNTA</b></td>
                                                <td><b>NOMBRE</b></td>
                                                <td><b>GERENTE</b></td>
                                                <td><b>ESTATUS</b></td>
                                                <td><b>MONTO</b></td>
                                                <td><b>FECHA</b></td>
                                                <td><b>ESTATUS PAGO</b></td>
                                                <td><b>FECHA PAGO</b></td>
                                            </tr>
                                        </thead>
                                        <tbody id="tbody_tabla_promesado_diario">
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="test-swipe-2" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s10 hide_print">
                                
                                <div class="input-field col s3 hide" >
                                    <select id="ter" name="id_region"></select>
                                    <label>Territorio</label>
                                </div>
                                <div class="input-field col s3" >
                                    <input id="inicio_sem_promesas_incumplidas" type="text" class="validate datepicker" readonly=""></td>
                                    <label for="inicio_sem_promesas_incumplidas">Inicio de Semana</label>
                                </div>
                                <a id="enviar_promesas_incumplidas" class="waves-effect waves-light btn blue margin_top_btn"><i class="material-icons right">send</i>Consultar</a> 
                                <a onclick="tableToExcel('datos_tabla_promesas_incumplidas', 'incumplidas')" class="waves-effect waves-light btn green margin_top_btn"><i class="material-icons right">explicit</i>Exportar</a> 
                                
                            </div>
                            <div id="datos_tabla_promesas_incumplidas" class="col s12 z-depth-2 dt">
                                <table class="highlight">
                                    <thead class="blue">
                                        <tr class="text-white">
                                            <td><b>PROMESAS SEMANALES</b><br>ESTATUS/REGION</td>
                                            <td><b>LUNES</b></td>
                                            <td><b>MARTES</b></td>
                                            <td><b>MIERCOLES</b></td>
                                            <td><b>JUEVES</b></td>
                                            <td><b>VIERNES</b></td>
                                            <td><b>SABADO</b></td>
                                            <td><b>DOMINGO</b></td>
                                            <td><b>TOTAL</b></td>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody_tabla_promesas_incumplidas">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div id="test-swipe-3" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s10 offset-s1 hide_print">
                                <div class="input-field col s2 offset-l2" >
                                    <select id="id_ter_pagos" name="id_region"></select>
                                    <label>ZONA</label>
                                </div>
                                <div class="input-field col s7" >
                                    <input id="desde_pagos" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;"></td>
                                    <label class="" for="desde_pagos"></label>
                                    <input id="hasta_pagos" name="fecha" type="text" class="validate datepicker" placeholder="Hasta" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;"></td>
                                    <label class="" for="hasta_pagos"></label>
                                    <a id="enviar_pagos" class="waves-effect waves-light btn blue" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">send</i></a> 
                                    <a onclick="tableToExcel('datos_tabla_pagos', 'PAGOS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a> 
                                    <a id="ver_resumen_pagos" class="btn-small blue">ver resumen</a>
                                    <a id="ver_lista_pagos" class="btn-small blue hide">lista gestiones</a>
                                </div>
                            </div>

                            <div id="resumen_pagos" class="col s12 z-depth-2 hide">
                                <h5 id="cantidad_pagos" class="right-align"></h5>
                                <table>
                                    <thead>
                                        <tr class="green accent-2">
                                            <th>ZONA</th>
                                            <th>GERENTES</th>
                                            <th>PAGOS</th>
                                            <th>RECUPERACION CAPITAL</th>
                                            <th>RECUPERACION MORATORIOS</th>
                                            <th>SALDO ACTUAL</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tb_resumen_pagos">

                                    </tbody>

                                </table>
                            </div>
                            <div id="datos_tabla_pagos" class="col s12 z-depth-2 dt">
                                <table class="highlight" id="tabla_pagos">
                                    <thead class="blue">
                                        <tr class="text-white">
                                            <td><b>CLIENTE UNICO</b></td>
                                            <td><b>AÑO</b></td>
                                            <td><b>SEMANA</b></td>
                                            <td><b>DIA</b></td>
                                            <td><b>RECUPERACION_CAPITAL</b></td>
                                            <td><b>RECUPERACION_MORATORIOS</b></td>
                                            <td><b>SALDO_ACTUAL</b></td>
                                            <td><b>MORATORIO</b></td>
                                            <td><b>FECHA_GESTION</b></td>
                                            <td><b>CARGO_AUTOMATICO</b></td>
                                            <td><b>ZONA</b></td>
                                            <td><b>GERENTE</b></td>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody_tabla_pagos">
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
            <script type="text/javascript" src="js/js/materialize.min.js"></script>
            <script type="text/javascript" src="js/js/menu.js"></script>
            <script type="text/javascript" src="js/js/reportes.js"></script>
    </body>
</html>
