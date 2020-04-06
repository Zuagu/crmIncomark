<%-- 
    Document   : main.jsp
    Created on : 12/02/2015, 12:09:28 AM
    Author     : Luis Cortez
    Agency     : ARCADE Software
--%>

<%@page import="arcade.data.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ARCADE Software :: ERP</title>

        <!--FAVICON AND IPHONE ICONS-->
        <link rel="shortcut icon" href="images/arcade-favicon.ico">

        <link rel="apple-touch-icon-precomposed" sizes="57x57" href="http://leimihost.com/favicons/arcade/arcade-57.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://leimihost.com/favicons/arcade/arcade-114.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://leimihost.com/favicons/arcade/arcade-72.png" />
        <!--FAVICON AND IPHONE ICONS-->

        <!--ARCADE CSS-->
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-default.css">
        <link type="text/css" rel="stylesheet" href="css/arcade-responsive-740.css">

        <!-- <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css"> -->

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <link type="text/css" rel="stylesheet" href="styles/all.css">
        <link type="text/css" rel="stylesheet" href="styles/main.css">
        <!--ARCADE CSS-->


        <%
            int id_perfil = -1;
            int id_usuario = -1;
            String password = "-1";
            String puesto = "inicio";
            String tema = ""; // COLOR DEL DIV
            String cliente = "";
            if (request.getParameter("id_usuario") == null || request.getParameter("id_usuario").isEmpty()
                    || request.getParameter("password") == null || request.getParameter("password").isEmpty()) {
                response.sendRedirect("index.jsp");
            } else {
                id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
                id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
                password = request.getParameter("password");
                tema = UsuarioDao.color();
                cliente = UsuarioDao.nombre_cliente();
                if (id_perfil == 1) {
                    puesto = "inicio";
                } else {
                    puesto = UsuarioDao.jsp_puesto(id_usuario);
                }
            }
            String color_menu = UsuarioDao.color_menu();
        %>

        <style>
            .menu ul {
                background-color: <%= color_menu%>;
            }

            @media print {
                .hide_print {
                    display: none!important;
                }

                .show_print{
                    display: block;
                }


            }
            .collection {
                border: 0px solid #e0e0e0;
            }
            #buscar_menu {
                height: 3.4rem;
                background-color: #FFF;
                text-align: center;
                border-radius: 5px;
                margin: 4px 0 4px 0;
                color: #000;
                font-size: 18px;
            }
            /* label focus color */
            .chuni[type=text]:not(.browser-default):focus:not([readonly]) {
                border-bottom: 1px solid #b70f1f;
                box-shadow: 0 1px 0 0 #b70f1f;
            }

        </style>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--ARCADE JS-->
        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="materialize/js/materialize.js"></script>

        <script language="javascript" src="js/arcade-main.js"></script>
        <script language="javascript" src="js/arcade-news.js"></script>
        <!--ARCADE JS-->

    </head>
    <body>

        <!-- LOGO CLIENTE -->
        <img id="gohome" src="images/logo_pdv2.png" style="position: absolute;right: 0px;top: 0px;cursor: pointer;"><!--
        -->        <input id="usuario_sistema" class="perfilanduser" type="hidden" value="<%= id_usuario%>" readonly="readonly" disabled="disabled"/>
        <input id="" class="perfilanduser" type="hidden" value="<%= id_usuario%>" readonly="readonly" disabled="disabled"/>
        <input id="perfil_usuario" class="perfilanduser" type="hidden" value="<%= id_perfil%>" readonly="readonly" disabled="disabled"/>
        <!--         LOGO CLIENTE 
        
                 ENCABEZADO ARCADE
                <div id='principalito' style="background-color: <%= tema%>; height: 40px;float: left;width: 100%;">
                    <label id="gotohome" href="inicio.jsp" target="centro" style="color: #FFF;font-family: helvetica;font-weight: bolder;font-size: 23px;margin: 5px 15px;cursor:pointer;"><%= cliente%></label>
        
                     NOTICIAS 
                    <div id="div_noticias">
                        <input id="label_noticia" type="text" value="" style="border: none;background-color: transparent;width: 98%;">
                        <div id="div_noticias_barrido"></div>
                        <input id="noticia1" type="hidden">
                        <input id="noticia2" type="hidden">
                        <input id="noticia3" type="hidden">
                        <input id="noticia4" type="hidden">
                        <input id="noticia5" type="hidden">
                    </div>
                     NOTICIAS 
                </div>-->
        <!-- ENCABEZADO ARCADE-->

        <!-- INICIA MENU -->

<!--        <ul id="menu" class="menu" style="background-color: <%= color_menu%>;"></ul>
        <div id="ajuste_resposive"></div>-->
        <!-- TERMINA MENU -->

        <!-- menu lateral -->
        <ul id="slide-out" class="side-nav">
            <li><div class="user-view" style="padding-left: 2px;">
                    <div class="background">
                        <img src="images/office.png" style="height:200px;">
                    </div>
                    <a href="#!user"><img id="imagen_empleado" class="circle responsive-img materialboxed" onerror="this.src='images/1.jpg'" style="height: 100px;width: 100px;"></a>
                    <!--                    <a href="#!email"><span class="white-text email">jdandturk@gmail.com</span></a>-->
                    <br>
                </div>
            </li>
            <input placeholder="Buscar" id="buscar_menu" onkeyup="myFunction_buscar()" type="text" class="validate chuni">
        </ul>

        <a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons" style="display:none;">menu</i></a>
        <!-- TERMINA LATERAL -->

        <iframe src="<%= puesto%>.jsp" id="centro" name="centro" frameborder="0" style="width:100%;float: left;height:100%!important;"></iframe>

        <script>
            var menu_origonal;
            $("#gohome").on("click", function () {
                top.frames['centro'].location.href = 'inicio.jsp';

            });

            var sidenav = false;

            $(".button-collapse").sideNav({
                onClose: function (el) {
                    sidenav = false
                }
            });

            $("body").on("mousemove", function (event) {
                if (event.pageX < 1 && sidenav == false) {
                    sidenav = true;
                    $(".button-collapse").sideNav('show');
                    menu_origonal = $('#slide-out').html();
                }
            });



            //==================================================================
            /* _________________________________________________________________________ */
            function myFunction_buscar() {
                var text_buscar = $("#buscar_menu").val();
                if (text_buscar.length > 0) {
                    $('#slide-out .collapsible-header').remove();
                    $("li div.collapsible-body").addClass("collection");
//                        $("a").removeClass("signout");
                    $("ul").removeClass("collapsible collapsible-accordion");
                    $("li").removeClass("no-padding");
                    $("li div.collection").removeClass("collapsible-body");

                    $("a").addClass("collection-item");
                } else {
                    $('#slide-out').empty();
                    $('#slide-out').append(menu_origonal);
//                        console.log("regresa ek menu original" + menu_origonal);
                }


                //elimina todo lo que tenga la clase collapsible-header que estan dentro de la etiqueta con id slide-out

                //
                var input, filter, ul, li, a, i;
                input = document.getElementById("buscar_menu");
                filter = input.value.toUpperCase();
                ul = document.getElementById("slide-out");
                li = ul.getElementsByTagName("li");
                // console.log(li);
                for (i = 0; i < li.length; i++) {
                    a = li[i].getElementsByTagName("a")[0];
                    // console.log(a);
                    if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
                        a.parentElement.style.display = "";
                    } else {
                        a.parentElement.style.display = "none";
                    }
                }
            }
            /* _________________________________________________________________________ */
            //==================================================================


        </script>

    </body>
</html>