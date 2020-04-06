<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>

        <!--ARCADE CSS-->
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-740.css">

        <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="styles/all.css">
        <link type="text/css" rel="stylesheet" href="styles/main.css">
        <!--ARCADE CSS-->

        <!-- INICIA CALENDARIO -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>        
        <link rel="stylesheet" href="datepicker/jquery-ui.css">
        <script src="datepicker/jquery-ui.js"></script>
        <script>
            $(function () {
                $(".datepicker").datepicker({changeMonth: true, changeYear: true, numberOfMonths: 1});
            });
        </script>
        <!-- TERMINA CALENDARIO -->

        <!--ARCADE JS-->
        
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-organigrama.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            #div_organigrama .nodo{
                width: 230px;
                padding: 4px;
                border-radius: 8px;
                text-align: center;
                font-weight: bold;
                border: solid 1px #dadada;
                color: #2a2a2a;
                cursor: pointer;
                background: #FFF;
            }
            #div_organigrama .contenedor_hijos{
                border: none;
            }
            #div_organigrama .contenedor_hijos input, #div_organigrama .contenedor_hijos_not_dad input{
                border: none;
                width: 72%;
                text-align: center;
                padding-right: 2%;

            }
            #div_organigrama .contenedor_hijos_not_dad{
                border: none;
                background-image: url('images/back-diagrama.png');
                background-repeat: repeat-y;
                background-position-x: 0px;
                padding: 4px 0 0 0px;
                margin-left: 40px;
            }
            #div_organigrama .union_izquierda{
                border: none;
                padding-left: 40px;
                background-image: url('images/back-diagrama2.png');
                background-position-x: 0px;
                background-repeat: no-repeat;
                margin-left: 0px;
            }

            #draggable { width: 360px; height: 150px; }

            #div_contenidos table tbody tr td textarea{
                width: 100%;
                border-radius: 5px;
                border: solid 1px #dadada;
                resize: none;
                height: 46px;
            }
            .num_list{
                color: red;
                font-weight: bold;
            }
            .estatus_vacante{
                width: 20%;
                border-radius: 2px;
                display: inline;
                padding: 3px 9px;
                color:#FFF;
            }
        </style>

    </head>

    <body style="background-image: url('images/background-cliente.png')">

        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="page-title-breadcrumb option-demo">
            <div class="page-header pull-right">
                <div class="page-title">
                    Organigrama
                </div>
            </div>
            <ol class="breadcrumb page-breadcrumb pull-left">
                <li>Manual de usuario de este modulo:</li>
                <li id="pdf_horas-clase-maestro"><img class="help" src="images/help_pdf.png" style="cursor: pointer;"></li>

            </ol>
            <div class="clearfix">
            </div>
        </div>
        <!--END TITLE & BREADCRUMB PAGE-->

        <div class="contenedor-responsive">

            <!--BEGIN CONTENT-->
            <div style="width: 100%;box-sizing: border-box;background:transparent;padding: 5px 3%;text-align: right;">
                <!--<input id="organigrama" class="cambio_div" type="button" title="VER ORGANIGRAMA" value="VER ORGANIGRAMA" style="float: left;margin-right: 5px;background-color: #00A0E1;border: none;color: white;font-weight: bold;font-family: verdana;border-radius: 5px;height: 24px;padding: 0px 10px" class="sombra">-->
                <input id="insert_nodo" type="button" title="AGREGAR PUESTO AL NODO SELECCIONADO" value=" + " style="background-color: #099200;border: none;color: white;font-weight: bold;font-family: verdana;border-radius: 5px;height: 25px;width: 30px;padding: 0px 5px" class="sombra">
                <input id="delete_nodo" type="button" title="ELIMINAR PUESTO SELECCIONADO" value=" - " style="background-color: #D51717;border: none;color: white;font-weight: bold;font-family: verdana;border-radius: 5px;height: 25px;width: 30px;padding: 0px 5px" class="sombra">
                <input id="id_padre" value="0" readonly style="display: none;">
            </div>

            <div id="div_organigrama" class="esconder" style="width: 100%;margin: 0px auto;box-sizing: border-box;padding: 1% 3%;"></div>

            <div id="div_contenidos" class="sombra esconder" style="border-radius: 5px;border:solid 1px #dadada;width: 320px;box-sizing: border-box;background: #FFF;position: absolute;top: 100px;right: 30px;padding: 10px;display: none;">
                <a id="close_div" href="#" style="float:right;margin-right:3%;">[cerrar]</a>

                <br>
                <div class="datagrid sombra">
                    <table border="0">
                        <thead>
                            <tr>
                                <th colspan="3" style="text-align: center;">DEFINIR TIPO DE NODO</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>TIPO DE NODO:</td>
                                <td>
                                    <select id="id_tipo_nodo2">SELECCIONE...</select>
                                </td>
                                <td><img id="insert_contenidos_nodo" src="images/i_tick.png" alt="" title="DEFINIR ESTE NODO COMO ESTE TIPO" style="cursor:pointer;"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <br>
                <div id="contenidos_nodo" class="datagrid sombra"></div>
            </div>

            <!--END CONTENT-->

            <!--END PAGE WRAPPER-->
        </div>

        <!--CORE JAVASCRIPT-->
        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                select_nodos_organigrama(0, "div_organigrama");
                $("#div_contenidos").draggable();
                select_tipos_nodo_combo("id_tipo_nodo2");
            }
            );
            //==================================================================
            $("#insert_nodo").click(function () {
                var _desc_puesto = prompt("INGRESE EL NOMBRE DEL NODO");
                if (_desc_puesto != null) {
                    insert_nodo_organigrama(_desc_puesto, $("#id_padre").val());
                }
            });
            //==================================================================
            $("#delete_nodo").click(function () {

                var confirma = confirm("ESTO ELIMINADA EL NODO SELECCIONADO Y TODOS SUS HIJOS, PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_nodo_organigrama($("#id_padre").val());
                }

            });
            //==================================================================
            $(".nodo").live("click", function () {
                $("#id_padre").val($(this).attr("id"));
            });
            //==================================================================
            $("#config_nodo").click(function () {
                select_tipos_nodo("tipos_nodo");
                select_tipos_nodo_combo("id_tipo_nodo");
                select_tipos_nodo_combo("id_tipo_nodo2");

            });
            //==================================================================
            $(".nodo input").live("change", function () {
                update_nodo_organigrama($(this).closest("div").attr("id"), $(this).val());
                //                $("#id_padre").val($(this).attr("id"));
            });
            //==================================================================
            $(".nodo").live("click", function () {
                $(".nodo").removeClass("sombra");
                $(this).closest("div").addClass("sombra");
                $("#div_contenidos").show();
                select_contenidos_nodo($("#id_padre").val(), "contenidos_nodo");
            });
            //==================================================================
            $("#close_div").click(function () {
                $("#div_contenidos").hide();
            });
            //==================================================================
            $(".cambio_div").click(function () {
                $(".esconder").hide();
                $("#div_" + $(this).attr("id")).show();
            });
            //==================================================================
            $(".delete_tipo_nodo_organigrama").live("click", function () {

                var confirma = confirm("ESTO ELIMINA EL TIPO DE NODO, PRESIONE ENTER PARA CONTINUAR...");
                if (confirma) {
                    delete_tipo_nodo_organigrama($(this).closest("tr").attr("id"));
                }

            });
            //==================================================================
            $("#insert_tipo_nodo").live("click", function () {

                insert_tipo_nodo($("#tipo_nodo_toadd").val());

            });
            //==================================================================
            $("#insert_contenidos_nodo").click(function () {
                insert_contenidos_nodo($("#id_padre").val(), $("#id_tipo_nodo2").val());
            });
            //==================================================================
            $(".contenido_nodo").live("change", function () {
                update_contenido_nodo($(this).closest("tr").attr("id"), $(this).val());
            });
            //==================================================================
            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->
    </body>
</html>