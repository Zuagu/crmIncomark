<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Solicitudes_ivrs</title>
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
            #tbody_actual {
                border: 1px solid grey;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row" id="contenido"></div>

        <div class="row">
            <div class="col s12 m12 l12">
                <div class=""><h5>VACANTES DE CAMPO</h5></div>
                <div class="col s12 m12 l12">
                    <div id="test-swipe-0" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s10 hide_print">
                                <div class="input-field col s3" >
                                    <select id="territorio_ivr" multiple type="text"></select>
                                    <label for="territorio_ivr">Territorio</label>
                                </div>
                                <div class="input-field col s3" >
                                    <select id="etapa_ivr" multiple type="text"></select>
                                    <label for="etapa_ivr">Etapa</label>
                                </div>
                                <input id="tipo" type="hidden" value="vacantes_visitador_rh">
                                <a id="getTableivrs" class="waves-effect waves-light btn blue margin_top_btn"><i class="material-icons right">send</i>Consultar</a> 
                                <a onclick="tableToExcel('datos_tabla_ivr', 'SOLICITUDES IVR')" class="waves-effect waves-light btn green margin_top_btn"><i class="material-icons right">explicit</i>Exportar</a> 
                            </div>
                            <div id="ivr_diario" class="col s12 m12 l12">
                                <div id="datos_tabla_promesado_diario_org" class="z-depth-2 dt">
                                    <div id="cargando_datos" class="progress">
                                        <div class="indeterminate"></div>
                                    </div>
                                    <table class="highlight col s12 m6 l6 center">
                                        <thead>
                                            <tr class="lime lighten-5">
                                                <th>Id</th>
                                                <th>Cliente Unico</th>
                                                <th>Nombre</th>
                                                <th>Telefono</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tbody_solicitud_ivr">
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
                <script type="text/javascript" src="js/js/solicitud_ivr.js"></script>
                </body>
                </html>
