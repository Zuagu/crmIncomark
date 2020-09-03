<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cargar Cartera Banco Azteca</title>
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style.css">
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
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row" id="contenido"></div>

        <div class="row">
            <div class="col s12 m12 l12">
                <div class="col s12 m12 l12">
                    <ul id="tabs-swipe-demo" class="tabs hide_print">
                        <li class="tab col s3"><a class="active" href="#test-swipe-1" style="color:#db040e">Gestiones</a></li>
                        <li class="tab col s3"><a class="active" href="#test-swipe-2" style="color:#db040e">Convenios</a></li>
                        <li class="tab col s3"><a class="active" href="#test-swipe-3" style="color:#db040e">Pagos</a></li>
                    </ul>
                    <div id="test-swipe-1" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s10 offset-s1 hide_print">
                                <div class="input-field col s3 offset-l2" >
                                    <select id="id_ter_gestion" name="id_region"></select>
                                    <label>Territorio</label>
                                </div>
                                <div class="input-field col s5" >
                                    <input id="desde_gestiones" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;"></td>
                                    <label class="" for="desde_gestiones"></label>
                                    <input id="hasta_gestiones" name="fecha" type="text" class="validate datepicker" placeholder="Hasta" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;"></td>
                                    <label class="" for="hasta_gestiones"></label>
                                    <a id="enviar_gestiones" class="waves-effect waves-light btn blue" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">send</i></a> 
                                    <a onclick="tableToExcel('datos_tabla', 'GESTIONES')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a> 

                                </div>
                            </div>
                            <div id="datos_tabla" class="col s12 z-depth-2"></div>
                        </div>
                    </div>
                    <div id="test-swipe-2" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s10 offset-s1 hide_print">
                                <div class="input-field col s3 offset-l2" >
                                    <select id="id_ter_convenio" name="id_region"></select>
                                    <label>Territorio</label>
                                </div>
                                <div class="input-field col s5" >
                                    <input id="desde_convenios" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;"></td>
                                    <label class="" for="desde_convenios"></label>
                                    <input id="hasta_convenios" name="fecha" type="text" class="validate datepicker" placeholder="Hasta" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;"></td>
                                    <label class="" for="hasta_convenios"></label>
                                    <a id="enviar_convenios" class="waves-effect waves-light btn blue" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">send</i></a> 
                                    <a onclick="tableToExcel('datos_tabla', 'CONVENIOS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a> 

                                </div>
                            </div>
                            <div id="datos_tabla" class="col s12 z-depth-2"></div>
                        </div>
                    </div>
                    <div id="test-swipe-3" class="col s12" style="margin-top:10px;"> 
                        <div class="row">
                            <div class="col s10 offset-s1 hide_print">
                                <div class="input-field col s3 offset-l2" >
                                    <select id="id_ter_pagos" name="id_region"></select>
                                    <label>Territorio</label>
                                </div>
                                <div class="input-field col s5" >
                                    <input id="desde_pagos" name="fecha" type="text" class="validate datepicker" placeholder="desde" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;margin-left: 10px;"></td>
                                    <label class="" for="desde_pagos"></label>
                                    <input id="hasta_pagos" name="fecha" type="text" class="validate datepicker" placeholder="Hasta" readonly="" style="text-align: center;border: solid 1px gray !important;border-radius: 4px !important;font-weight: bold; width:100px; padding:-5px;margin-bottom: -5px;height: 27px;"></td>
                                    <label class="" for="hasta_pagos"></label>
                                    <a id="enviar_pagos" class="waves-effect waves-light btn blue" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">send</i></a> 
                                    <a onclick="tableToExcel('datos_tabla', 'PAGOS')" class="waves-effect waves-light btn green" style="margin-left: 5px;width: 50px;border-radius: 4px;height:29px;margin-bottom: 5px;"><i class="material-icons" style="margin: -10px;">explicit</i></a> 

                                </div>
                            </div>
                            <div id="datos_tabla" class="col s12 z-depth-2"></div>
                        </div>
                    </div>


                </div>
            </div>
        </div>



        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/js/menu.js"></script>
    </body>
</html>