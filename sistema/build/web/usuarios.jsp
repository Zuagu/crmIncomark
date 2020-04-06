<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>ERP</title>

        <!--ICONS PARA MATERIALIZE-->
        <link rel="shortcut icon" href="http://leimihost.com/mx/images/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/arcade-style-frame.css" media="screen">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--ICONS PARA MATERIALIZE-->

        <!-- INICIA CALENDARIO -->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>       
        <link rel="stylesheet" href="datepicker/jquery-ui.css">
        <script src="datepicker/jquery-ui.js"></script>
        <script src="glDatePicker/glDatePicker.js"></script>
        <!--TERMINA CALENDARIO -->

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="js/arcade-curp.js"></script>
        <script type="text/javascript" src="js/arcade-fecha.js"></script>
        <script type="text/javascript" src="js/arcade-excel.js"></script>
        <script type="text/javascript" src="js/arcade-sucursal.js"></script>
        <script type="text/javascript" src="js/arcade-puesto.js"></script>
        <script type="text/javascript" src="js/arcade-contrato.js"></script>
        <!--ARCADE JS-->

        <!--MATERIALIZE-->
        <script type="text/javascript" src="materialize/js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <link rel="stylesheet" type="text/css" href="css/arcade-nav.css">
        <link rel="stylesheet" type="text/css" href="glDatePicker/styles/glDatePicker.darkneon.css">
        <!--MATERIALIZE-->

        <!-- HIGHCHARTS-->
        <script type="text/javascript" src="highcharts/highcharts.js"></script>
        <script type="text/javascript" src="highcharts/pareto.js"></script> 
        <script type="text/javascript" src="highcharts/exporting.js"></script>
        <!-- HIGHCHARTS-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript" src="js/arcade-usuario.js"></script>

        <style>
            .colori{
                background: green !important;
            }
            .usuario{
            }
            .usuario_selected{
                box-sizing: border-box;
                background: rgb(137, 222, 255) !important;
            }
            #eliminar_usuario{
                font-size: 1.2rem;
                color: #ABABAB;
                text-decoration: none;
                transition: .8s;
            }
            #eliminar_usuario:hover{
                font-size: 1.2rem;
                color: #FE5D49;
                text-decoration: none;
            }
            #update_usuario_rrhh{
                background:#1884D4;
                color:#FFF;
                margin-bottom: 10px;
                font-weight: bold;
            }
            #cancelar_regresar{
                font-size: 1.2rem;
                color: #ABABAB;
                text-decoration: none;
                transition: .8s;
            }
            #cancelar_regresar:hover{
                font-size: 1.2rem;
                color: #FE5D49;
                text-decoration: none;
            }
            .editar{
                width:430px;
                float: right;
                margin-right: 3%;
                background:transparent;
                border:none
            }
            #div_edicion{
                text-align: center;
                display: none;
            }
            #contratos{
                width:400px;
                height: 367px;
                float:left;
                margin-left: 7%;
                background:transparent;
                border:none;
            }
            #foto{
                width:210px;
                height: 337px;
                float: left;
                margin-left: 3%;
                background: transparent;
                border:none;
            }
            h2{
                margin:0px
            }
            .btns_inf{
                bottom:8px;
                float:right;
                margin-right:12%;
                display:block;
            }
            #regresar:hover{
                font-size: 1.2rem;
                color: #FE5D49;
                text-decoration: none;
            }
            #regresar{
                font-size: 1.2rem;
                color: #ABABAB;
                text-decoration: none;
                transition: .8s;
            }
            .contrato{
                width: 100px;
                display: inline-block;
                border-radius: 2px 0px 2px 0px;
                margin: 1%;
                text-align: left;
                color: #cc0000;
                border: none;
                background: transparent;
                float: left;
                cursor:pointer;
                transition: .5s;
            }
            .contrato:hover{
                width: 100px;
                display: inline-block;
                border-radius: 2px 0px 2px 0px;
                margin: 1%;
                text-align: left;
                color: red;
                border: none;
                background: transparent;
                float: left;
                cursor:pointer;
                transition: .5s;
            }
            div.core:nth-child(2) > div:nth-child(1) {
                background: linear-gradient(to bottom, #e71616 0%,#300303 98%,#622323 99%,#000 100%);
            }
            div.core:nth-child(3) {
                background: linear-gradient(to bottom, #e71616 0%,#300303 98%,#622323 99%,#000 100%);

            }
            div.core:nth-child(1) {
                background: linear-gradient(to bottom, #e71616 0%,#300303 98%,#622323 99%,#000 100%);

            }
        </style>

    </head>
    <body>
        <!--BEGIN TITLE & BREADCRUMB PAGE-->
        <div class="container-fluid">
            <div class="row">
                <nav id="ayuda_nav" class="grey lighten-4" >
                    <div class="nav-wrapper">
                        <a class="ayuda_name" class="brand-logo ">Usuarios</a>
                        <ul class="right hide-on-med-and-down"  style="margin-right:2%;">
                            <li id="pdf_horas-clase-maestro"><a href="#"><i id="nav_i" class="material-icons help">picture_as_pdf</i></a></li>
                            <li id="roboto">Manuales de usuario de este modulo</li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!--END TITLE & BREADCRUMB PAGE-->                       
            <!--BEGIN CONTENT-->
            <div class="row">
                <div id="div_usuario" style="width: 98%;margin: 0px auto;">
                    <div class="col s12" style="margin: 0px auto;margin-bottom:0px;">
                        <h5 class="center-align" style="margin-bottom: 0px;">LISTADO DE USUARIOS</h5>
                    </div>
                    <div class="col s12 center-align">
                        <input id="filtro" class="filtro  center-align" type="text"style="width:400px;" placeholder="Filtro">
                        <input id="usuario_contrato" class="filtro  center-align hide" type="text"style="width:400px;" placeholder="Filtro">
                    </div>
                    <div class="col s12" style="margin-top:25px;">
                        <div id="listado_usuarios" class="datagrid sombra" style="height: 343px;overflow: auto;margin: 0px auto;border: solid 1px #dadada;border-radius: 4px;"></div>
                    </div>
                    <div class="col s12" style="margin-top:25px;">
                        <!--<a id="nuevo_usuario" class="waves-effect waves-light btn blue z-depth-4" style="padding: 0px 1rem;margin-right: 7px;">NUEVO USUARIO</a>-->
                        <a class="waves-effect waves-light btn  green darken-3 z-depth-4" onclick="tableToExcel('listado_usuarios', 'LISTADO DE USUARIOS')" style="padding: 0px 1rem;margin-right: 7px;">xslx</a>
                        <input id="id_seleccion" type="hidden" value="0">
                        <input id="id_sucursales" type="hidden" value="0">
                        <a id="modal_editar" class="waves-effect waves-light btn blue z-depth-4"  style="width: 150px; float:right; display: none">EDITAR USUARIO</a>
                    </div>
                </div>
            </div>  
            <div class="row" style="margin-bottom:0px !important;">
                <div id="div_edicion" class="col s12">
                    <div id="foto" class="col s4" style="margin-top: 34px;" >                
                        <div class="card z-depth-3">
                            <div class="card-image">
                                <img id="imagen_empleado" class="materialboxed" onerror="this.src='images/1.jpg'">
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a href="#" id="btn_datos" style="color:#c30315;">Datos</a>
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a href="#" id="check_list" style="color:#c30315;">ARCHIVO</a>
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a href="#" id="btn_entradas" style="color:#c30315;">Entradas</a>
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a href="#" id="subir_foto" style="color:#c30315;">Subir foto</a>
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a id="btn_contrato" href="" style="color:#c30315;">Contrato</a>
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a  target="_blank" href="/sistema/memorandum.jsp" id="" style="color:#c30315;">Memorandum</a>
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a href="#" id="baja" style="color:#c30315;">Baja</a>
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a target="_blank" href="/sistema/reglamento_interno.jsp" id="" style="color:#c30315;">Reglamento</a>
                            </div>
                            <div class="card-action align-center" style="background:#fff">
                                <a href="#" id="cancelar_editar" style="color:#c30315;" onclick="window.location.reload(true)" >Regresar</a>
                            </div>
                        </div>                       
                    </div>
                    <div id="contratos" class="col s8" style="width: 810px; display:none;">
                        <div class="col s12">
                            <h5>Contratos</h5>
                        </div>
                        <div class="col s12">
                            <div id="contrato_actual" class="datagrid" style="border:none; background: transparent; overflow: auto;"></div>  
                        </div>
                        <div class="col s12">
                            <div id="contrato_nuevo" class="datagrid" style="display:none">
                                <table class="striped  highlight">
                                    <thead>
                                    <th colspan="2" style="text-align: center;">Ingrese los datos  </th>
                                    </thead>
                                    <tr>
                                        <td style="text-align:right;">TIPO CONTRATO:</td>
                                        <td> <select id='tipo_contrato'>
                                                <option value="EVENTUAL">EVENTUAL</option>
                                                <option value="INDEFINIDO">INDEFINIDO</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align:right;">F. INICIO:</td>
                                        <td><input id="fecha_inicio" type="text" class="datepicker" style="font-weight: bold;"></td>
                                    </tr>
                                    <tr id="tr_fecha_fin">
                                        <td style="text-align:right;">F. FIN:</td>
                                        <td><input id="fecha_fin" type="text" class="datepicker" style="font-weight: bold;"></td>
                                    </tr>
                                    <tr>
                                        <td style="float:right;">SALARIO DIARIO:</td>
                                        <td><input id="salario_diario" type="text" class="flotante" value="0.00" style="font-weight: bold;"></td>
                                    </tr>
                                    <tr>
                                        <td style="float:right;">HORAS x SEMANA:</td>
                                        <td><input id="horas_semana" type="text" class="48" style="font-weight: bold;"></td>
                                    </tr>
                                </table>
                            </div>
                            <div id="btns_inf2" style="display:none">
                                <br>
                                <a id="insert_contrato" class="waves-effect waves-light btn blue z-depth-4" style="padding: 0px 1rem;margin-right: 7px;">GENERAR CONTRATO</a>
                                <br>             
                                <a href="#" id="regresar" style="font-size:12px">Regresar</a>
                            </div>                        
                        </div>
                    </div>
                    <div id="datos" class="col s8" style="width:800px;  margin-left: 150px;float:left;">
                        <div class="col s12">
                            <h5>DATOS</h5>
                        </div>
                        <div id="modal" class="">
                            <table class="striped highlight">
                                <thead>
                                    <tr>
                                    </tr>
                                </thead>
                                <tr>                                
                                    <td colspan="2" >
                                        <label>NOMBRE:</label>
                                        <input id="dato1" type="text" style="font-weight: bold;" class="validate" style="text-transform: uppercase;">
                                    </td>
                                    <td>
                                        <label>ALIAS:</label>
                                        <input id="dato2" type="text" style="font-weight: bold;" class="validate">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>INGRESO:</label>
                                        <input id="dato3" type="text" class="datepicker" style="font-weight: bold;" class="validate">
                                    </td>
                                    <td>
                                        <label>SEXO:</label>
                                        <select id='dato4'class="validate"></select>
                                    </td>
                                    <td>
                                        <label>TELEFONO:</label>
                                        <input id="dato5" type="text" style="font-weight: bold;" class="validate">
                                    </td>
                                </tr>
                                <tr>   
                                    <td>
                                        <label>CELULAR:</label>
                                        <input id="dato6" type="text" style="font-weight: bold;" class="validate">
                                    </td>
                                    <td>
                                        <label>CORREO:</label>
                                        <input id="dato7" type="text" style="font-weight: bold;" class="validate">
                                    </td>
                                    <td>
                                        <label>JEFE INMEDIATO:</label>
                                        <select id='dato8'class="validate"></select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>TIPO EMPLEADO:</label>
                                        <select id='dato9'class="validate"></select>
                                    </td>
                                    <td>
                                        <label>SUCURSAL:</label>
                                        <select id='dato10' class="validate"></select>
                                    </td>
                                    <td>
                                        <label>F. NACIMIENTO:</label>
                                        <input id="dato11" type="text" class="datepicker" style="font-weight: bold;" class="validate">
                                    </td>
                                </tr>
                            </table>

                            <div class="col s4 left-align div_contratacion">
                                <label>STATUS CONTRATACION</label>
                                <select id="contratacion" disabled="" class="validate">
                                </select>
                            </div>
                            <div class="input-field col s8 texto div_contratacion">
                                <textarea id="comentario_con" readonly="" class="materialize-textarea"></textarea>
                                <label for="comentario_con">Observaciones finales</label>
                            </div>
                        </div>
                        <div>
                            <br><br>
                            <a id="update_usuario_rrhh" class="waves-effect waves-light btn blue z-depth-4" style="padding: 0px 1rem;margin-right: 7px;">GUARDAR CAMBIOS</a>
                            <br>
                            <a id="eliminar_usuario" href="#" style="font-size:12px">Eliminar usuario</a>
                        </div>
                    </div>
                    <!--contenedor del calendario entradas-->
                    <div id="entradas" class="col s8" style="display:none;">
                        <div class="col s12">
                            <h5>Entradas</h5>
                        </div>
                        <div class="col s12">
                            <div id="calendario_horario" class="col s12 m8 offset-m2 center-align">
                                <input type="text" id="mydate" gldp-id="mydate"/>
                                <div gldp-el="mydate" class="caja" style="width:801px; height:400px; position:absolute; top:70px; left:100px;"> </div>
                            </div>
                        </div>
                    </div>
                    <div id="foto_div" style="display:none" class="col s8 center-align">
                        <form action="subir-usuarios.jsp" enctype="multipart/form-data" method="post">
                            <input type="file" name="pic" accept="image/*">
                            <a class="waves-effect waves-light btn blue" id="enviar_foto"><input id="enviar_archivo" type="submit" value="CARGAR ARCHIVO" /></a>
                        </form> 
                    </div>
                    <div id="div_archivo" style="display:none" class="col s8 center-align">

                        <h3>Documentos</h3>

                        <form action="#">
                            <div class="col s4 offset-s1">
                                <p>
                                    <input type="checkbox" id="dato12"  />
                                    <label for="dato12">Acta de Nacimiento</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="dato13"  />
                                    <label for="dato13">IFE</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="dato14"  />
                                    <label for="dato14">Numero del Seguro Social</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="dato19"  />
                                    <label for="dato19">Fotos</label>
                                </p>
                            </div> 
                            <div class="col s4 ">
                                <p>
                                    <input type="checkbox" id="dato15"  />
                                    <label for="dato15">CURP</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="dato16"  />
                                    <label for="dato16">Comprobante de Estudios</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="dato17"  />
                                    <label for="dato17">Comprobante de Domicilio</label>
                                </p>
                            </div>
                            <div class="col s3 ">
                                <p>
                                    <input type="checkbox" id="dato18"  />
                                    <label for="dato18">Cartas de Referencia</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="dato20"  />
                                    <label for="dato20">No Infonavit</label>
                                </p>
                                <p>
                                    <input type="checkbox" id="dato21"  />
                                    <label for="dato21">RFC</label>
                                </p>
                            </div>
                        </form>
                        <div class="col s12" style="text-align: center; margin-top:20px;">
                            <a id="enviar_check" class="waves-effect waves-light btn blue z-depth-4" style="padding: 0px 1rem;margin-right: 7px;">GUARDAR CAMBIOS</a>
                        </div>
                    </div>

                </div>
            </div>
            <div id="div_nuevo_usuario" style="display:none">
                <div class="col s12 center-align" style="margin-bottom: 20px;">
                    <h5 >DATOS NUEVO USUARIO</h5>
                </div>
                <div class="col s12 align-center"  style="margin: 0px auto;">
                    <table class="striped highlight" style="border-spacing: 7px; width:90%;margin-left:5%">
                        <tbody>
                            <tr>
                                <td>
                                    <label>NOMBRE:</label>
                                    <input id="nombre" type="text"  class="validate">
                                </td>
                                <td>
                                    <label>ALIAS:</label>
                                    <input id="alias" type="text"  class="validate"></td>
                                <td>
                                    <label>SUCURSAL:</label>
                                    <select id="id_sucursal" class="validate"></select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>PUESTO:</label>
                                    <select id="id_puesto" class="validate"></select>
                                </td>
                                <td>
                                    <label>JEFE INMEDIATO:</label>
                                    <select id="id_jefe_inmediato" class="validate"></select>
                                </td>
                                <td>
                                    <label>SEXO:</label>
                                    <select id="sexo" class="validate">
                                        <option value="M">MUJER</option>
                                        <option value="H">HOMBRE</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>TELEFONO:</label>
                                    <input id="telefono" value="0" type="text" class="dato validate" maxlength="15" ></td>
                                <td>
                                    <label>CELULAR:</label>
                                    <input id="celular" value="0" type="text" class="dato entero" maxlength="10" style='width:100%;'></td>
                                <td>
                                    <label>E-MAIL:</label>
                                    <input id="email" value=" " type="text" class="dato" style='width:100%;'>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <br>
                <div class="col s12" style="text-align: center; margin-top:20px;">
                    <a id="insert_usuario"  name="accion" class="waves-effect waves-light btn blue z-depth-4" style="padding: 0px 1rem;">LISTO</a>
                    <br>
                    <a id="cancelar_regresar" style="font-size:12px;">Cancelar</a>
                </div>
            </div>

        </div>   
        <!--END CONTENT-->

        <!--END PAGE WRAPPER-->
    </div>

    <!--CORE JAVASCRIPT-->
    <script type="text/javascript">
        // ARCADE Software®
        //==================================================================
        $(document).ready(function () {
            select_usuario_tabla("listado_usuarios");
            select_usuario_combo(1, "id_jefe_inmediato");
            select_sucursal_combo("id_sucursal", false);
            select_puesto_combo("id_puesto", false);
            $('select').material_select();
            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15, // Creates a dropdown of 15 years to control year,
                today: 'Today',
                clear: 'Clear',
                close: 'Ok',
                closeOnSelect: false // Close upon selecting a date,
            });
            var mostrar_id = window.location.search.substring(1);
            $("#usuario_contrato").val(mostrar_id);
            console.log(mostrar_id);
        }
        );
        //==================================================================
        $(".help").on("click", function () {
            var src = location.href;
            var aux;
            var jsp;
            aux = src.split('/sistema/');
            jsp = aux[1];
            jsp = jsp.replace('.jsp', '');
            window.open("ayuda.jsp?tema=" + jsp, "_blank");
        });
        //==================================================================
        $("#filtro").on("keyup",
                function () {
                    select_usuario_filtro($('#filtro').val(), "listado_usuarios");
                }
        );
        //==================================================================
        $("#ver_usuario").live("click",
                function () {
                    select_usuario($(this).closest("tr").attr("id"));
                }
        );
        //==================================================================
        $("#id_paiss").live("change",
                function () {
                    $("#id_estados").empty();
                    arcade_select_estados_pais_combo($("#id_paiss").val(), "id_estados");
                }
        );
        //==================================================================
        $("#id_estados").live("change",
                function () {
                    $("#id_municipios").empty();
                    arcade_select_municipios_estado_combo($("#id_estados").val(), "id_municipios");
                }
        );
        //==================================================================
        $("#buscar_usuarios").click(
                function () {
                    buscar_usuarios();
                }
        );
        //==================================================================
        $("#update_usuario").live("click",
                function () {
                    _id_usuario = $(this).closest("tr").attr("id");
                    $("#dialog_2").dialog("open");
                }
        );
        //==================================================================
        $("#eliminar_usuario").live("click", function () {
            var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
            if (confirma) {
                delete_usuario($("#id_seleccion").val(), "listado_usuarios");
            }
        });
        //==================================================================
        $("#modal_editar").click(function () {
            $("#div_edicion").show();
            $("#div_usuario").hide();
            $("#imagen_empleado").attr("src", "images/empleados/" + $("#id_seleccion").val());

            select_datos_usuario($("#id_seleccion").val());
            select_contratos_usuario($("#id_seleccion").val(), "contrato_actual");
        });
        //==================================================================
        $(".usuario").live("click", function () {
            $("#id_seleccion").val($(this).closest("tr").attr("id"));
            $('#id_sucursales').val($(this).find(".getSucursal").html());
            $(".usuario").removeClass("usuario_selected");
            $(this).addClass("usuario_selected");
            console.log($("#id_sucursales").val());

            if ($("#id_seleccion").val() !== "0") {
                $("#modal_editar").show();
            }

        });
        //==================================================================
        $(".usuario").live("dblclick", function () {
            $("#id_seleccion").val($(this).closest("tr").attr("id"));

            $("#div_edicion").show();
            $("#div_usuario").hide();
//                var id_sucursal = $("#").val();
//                if ($("#id_sucursales").val() == "MONTERREY") {
            $("#imagen_empleado").attr("src", "images/usuarios/" + $("#id_seleccion").val() + "-min.png");

//                } else if($("#id_sucursales").val() == "PUEBLA") {
//                    $("#imagen_empleado").attr("src", "http://201.172.0.78:8080/archivosrh/" + $("#id_seleccion").val() + ".png");
//                    console.log($("#id_seleccion").val());
//                }


            select_datos_usuario($("#id_seleccion").val());
            select_contratos_usuario($("#id_seleccion").val(), "contrato_actual");
        });
        //==================================================================
        $("#cancelar_editar").click(function () {
            $("#div_usuario").show();
            $("#div_edicion").hide();
            $("#modal_editar").hide();

        });
        //==================================================================
        $("#cerrar_resumen").click(function () {
            $("#div_usuario").show();
            $("#div_resumen").hide();
        });
        //==================================================================
        $("#nuevo_usuario").click(function () {
            $("#div_nuevo_usuario").show();
            $("#div_usuario").hide();
        });
        //==================================================================
        $("#cancelar_regresar").click(function () {
            $("#div_usuario").show();
            $("#div_nuevo_usuario").hide();
        });
        //==================================================================
        $("#update_usuario_rrhh").on("click",
                function () {
                    $("#dato1").val(($("#dato1").val()).toUpperCase());
                    update_usuario_rrhh(
                            $("#id_seleccion").val(),
                            $("#dato1").val(),
                            $("#dato2").val(),
                            $("#dato3").val(),
                            $("#dato4").val(),
                            $("#dato5").val(),
                            $("#dato6").val(),
                            $("#dato7").val(),
                            $("#dato8").val(),
                            $("#dato9").val(),
                            $("#dato10").val(),
                            $("#dato11").val(),
                            $("#contratacion").val(),
                            $("#comentario_con").val()
                            );
                    $("#update_usuario_rrhh").addClass('colori');
                    $("#update_usuario_rrhh").html('Guardado');
                    window.setTimeout(() => {
                        $("#update_usuario_rrhh").removeClass('colori');
                        $("#update_usuario_rrhh").html('Guardar Cambios');
                    }, 2500);
                });
        //==================================================================
        $("#mostrar_contrato_nuevo").live("click", function () {
            $("#contrato_nuevo").show();
            $("#btns_inf2").show();
            $("#contrato_actual").hide();
        });
        //==================================================================
        $("#insert_contrato").live("click", function () {

            var confirma = confirm("PRESIONE ENTER PARA CONTINUAR...");
            if (confirma) {
                insert_contrato(
                        $('#usuario_sistema', parent.document).val(),
                        $("#id_seleccion").val(),
                        $("#fecha_inicio").val(),
                        $("#fecha_fin").val(),
                        $("#salario_diario").val(),
                        $("#horas_semana").val(),
                        $("#tipo_contrato").val()
                        );
            }
        });
        //==================================================================
        $("#insert_usuario").click(
                function () {
                    insert_usuario(
                            $("#nombre").val(),
                            $("#alias").val(),
                            $("#id_sucursal").val(),
                            $("#id_puesto").val(),
                            $("#id_jefe_inmediato").val(),
                            $("#sexo").val(),
                            $("#telefono").val(),
                            $("#celular").val(),
                            $("#email").val()
                            );
                }
        );
        //==================================================================
        $(".dato").blur(function () {
            if ($(this).val() == "") {
                $(this).val("0");
            }
        });
        //==================================================================
        $("#tipo_contrato").change(function () {
            if ($(this).val() == "INDEFINIDO") {
                $("#tr_fecha_fin").hide();
            } else {
                $("#tr_fecha_fin").show();
            }
        });
        //==================================================================
        $("#regresar").click(function () {
            $("#contrato_actual").show();
            $("#contrato_nuevo").hide();
            $("#btns_inf2").hide();
        });
        //==================================================================
        $("#btn_contrato").click(function () {
            var id = $("#id_seleccion").val();
            window.open("/sistema/contrato.jsp?" + id);
            $("#foto_div").hide();
            $("#datos").hide();
            $("#entradas").hide();
            $("#div_archivo").hide();
            $("#contratos").show();
        });
        //==================================================================
        $("#btn_datos").click(function () {
            $("#foto_div").hide();
            $("#contratos").hide();
            $("#entradas").hide();
            $("#div_archivo").hide();
            $("#datos").show();
        });
        //==================================================================falta ocultar foto_div
        $("#btn_entradas").click(function () {
            $("#datos").hide();
            $("#contratos").hide();
            $("#foto_div").hide();
            $("#div_archivo").hide();
            $("#entradas").show();
            fecha_hoy('mydate');
            select_calendario_entradas($("#id_seleccion").val(), '2018-07-05');
        });
        //==================================================================
        $("#subir_foto").on("click", function () {
            $("#foto_div").show();
            $("#contratos").hide();
            $("#datos").hide();
            $("#entradas").hide();
            $("#div_archivo").hide();
        });
        //==================================================================
        $("#check_list").on("click", function () {
            $("#div_archivo").show();
            $("#contratos").hide();
            $("#datos").hide();
            $("#entradas").hide();
        });
        //==================================================================
        $("#enviar_foto").on("click", () => {
            insert_cargar_archivo($("#fichero").text(), $('#usuario_sistema', parent.document).val(), "tabla_archivos");
        });
        //==================================================================
        $("#enviar_check").on("click", () => {
            update_chunnun(
                    $("#id_seleccion").val(),
                    $("#dato12").prop("checked"),
                    $("#dato13").prop("checked"),
                    $("#dato14").prop("checked"),
                    $("#dato15").prop("checked"),
                    $("#dato16").prop("checked"),
                    $("#dato17").prop("checked"),
                    $("#dato18").prop("checked"),
                    $("#dato19").prop("checked"),
                    $("#dato20").prop("checked"),
                    $("#dato21").prop("checked"));
            $("#enviar_check").addClass('colori');
            $("#enviar_check").html('Guardado');
            window.setTimeout(() => {
                $("#enviar_check").removeClass('colori');
                $("#enviar_check").html('Guardar Cambios');
            }, 2500);
        });
        $("#baja").click(function () {
            var url = window.location.origin;
            var url_dir = url + "/sistema/carta-baja.jsp?" + $("#id_seleccion").val();
            console.log(url_dir);
            window.open(url_dir);
        });
        //==================================================================
//            $("#test5").change(function(){
//            console.log($("#test5").val());
//            });
//            $("#test6").on("click", function(){
//            console.log($("#test6").val());
//            });
//            $("#test7").on("click", function(){
//            console.log($("#test7").val());
//            });
//        $('input[type="checkbox"]').click(function(){
//        if ($(this).prop("checked") == true){
//        console.log($(this).prop("checked"));
//        }
//        else if ($(this).prop("checked") == false){
//        console.log("0");
//        }
//        });


        // emmanuel y karen (putos)
    </script>
    <!--CORE JAVASCRIPT-->
</body>
</html>