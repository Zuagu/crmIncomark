                                                                                                                                                                                              


<%-- 
    Document   : index.jsp
    Created on : 28/02/2014, 01:14:39 PM
    Author     : ARCADE Software Group;
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grupo SICSA - Inicio</title>


        <!--FAVICON AND IPHONE ICONS-->
        <link rel="shortcut icon" href="images/sicsa-favicon.ico">

        <link rel="apple-touch-icon-precomposed" sizes="57x57" href="http://leimihost.com/favicons/sicsa/sicsa-57.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://leimihost.com/favicons/sicsa/sicsa-114.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://leimihost.com/favicons/sicsa/sicsa-72.png" />
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--FAVICON AND IPHONE ICONS-->

        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="js/arcade-alfanumerico.js"></script>
        <script type="text/javascript" src="materialize/js/materialize.js"></script>

        <link rel="stylesheet" type="text/css" href="css/arcade-style.css">
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">

        <script type="text/javascript" src="js/arcade-sesion.js"></script>



        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <style>
            
            /* label focus color */
            .input-field input:focus + label {
                color: #ffffff !important;
            }
            /* label underline focus color */
            .row .input-field input:focus {
                border-bottom: 1px solid #ff8706!important;
                box-shadow: 0 1px 0 0 #ff8706 !important;
            }
            /* icon prefix focus color */
            .input-field .prefix.active {
                color: #ffebee !important;
            }
            /* label focus color */
            .input-field input[type=text]:focus + label {
                color: #ffffff;
            }
            /*diseño del input*/
            .estilo{
                background:rgba(98, 110, 132,0.1);
                max-width:250px;
                margin:18px auto;
                border: solid.5px #626e84;
                border-radius:6px;
                max-height: 59px
            }

            .imagen{
                margin: 60px auto;
                width:330px;
            }

        </style>
    </head>
    <!-- PAGE CONTENT -->
    <body id="loginjsp" style="background-image: url('');background-size:100% auto;background-repeat: no-repeat; background-attachment: fixed;  -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover; ">
        <div class="outer" style="display: table;position: absolute;height: 100%;width: 100%;" >
            <div class="middle" style="display: table-cell;vertical-align: middle;width: 100%;"  >
                <div class="inner" style="margin-left: auto;margin-right: auto;width: 100%;">
                    <div class="container-fluid"  >

                        <div class="row" style="margin-left: auto;margin-right: auto;margin-bottom: 20px;" >
                            <div  class="col s12 m4 offset-m4 opacity_9"  style="background:rgba(255,255,255, 0.8);padding: 0.75rem;border-radius:2px; ">
                                <div> 
                                    <img class=" materialboxed responsive-img imagen" src="" alt="" >
                                </div>
                                <div>
                                    <form id="login" class="" style="" name="login" action="/sistema/main.jsp" method="post">
                                        <input id="ip" type="hidden">
                                        <div>
                                            <div class="input-field estilo" style="background-color: #2a010180;">
                                                <input id="id_usuario" class="validate entero" type="text" name="id_usuario" style="color: white; height: 2.5rem;">
                                                <label style="color:white;margin-left: 2%;">USUARIO</label>
                                            </div>
                                            <div class="input-field estilo" style="background-color: #2a010180;">         
                                                <input id="password" class="validate" type="password" name="password" style="color: white; height: 2.5rem;">
                                                <label style="color:white;margin-left: 2%;">PASSWORD</label>
                                            </div>

                                            <div style="text-align: center;" class="input-field">
                                                <a id="iniciar_sesion" class="waves-effect waves-orange btn" style="background:#5c0403;font-size: 15px;border-radius: 6px;height:39px;max-width:253px;;margin-top: 0px;" >INICIAR SESIÓN</a>
                                                <div id="cargando" class="preloader-wrapper big active" style="display: none;">
                                                    <div class="spinner-layer spinner-blue-only">
                                                        <div class="circle-clipper left">
                                                            <div class="circle"></div>
                                                        </div><div class="gap-patch">
                                                            <div class="circle"></div>
                                                        </div><div class="circle-clipper right">
                                                            <div class="circle"></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">

                                        </div>
                                        <div style=" left: 10px; width: auto; font-size: 10px; color:#2a010180;display:none;">
                                            <input id="id_perfil" value="2" type="hidden" name="id_perfil" tabindex="3">
                                            <div class="input-field ">
                                                <select id="marcacion" class="icons estilo center-align" style=";background-color: #2a010180;">
                                                    <option value="/sistema/main.jsp" data-icon="images/manual.png" class="left circle">     MANUAL</option>
                                                    <option value="/sistema/marcador.jsp" data-icon="images/pre.png" class="left circle">     PREDIC</option>
                                                </select>
                                            </div>
                                        </div>
                                    </form> 

                                </div>
                                <div>

                                </div>
                            </div>
                        </div>      
                    </div>
                </div>    
            </div>
        </div>     

        <script>
            //==================================================================
            $(document).ready(function () {
                $("#login").show(1500);
                $("#id_perfil").show();
                $('select').material_select();
                $("body").css('background-image', 'url("images/fondoindex.jpg")');
                $.getJSON('https://api.ipify.org?format=json', function (data) {
//                    console.log(data.ip);
                    $("#ip").val(data.ip);
                });
            });

            //==================================================================
        </script>
    </body>
</html>
