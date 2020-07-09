<%
    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("id_usuario") != null) {
        out.write("<script>"
                + " var menu = " + sesion.getAttribute("menu") 
                + "; var id_usuario = " + sesion.getAttribute("id_usuario") 
                + "; var id_puesto_usuario = " + sesion.getAttribute("id_puesto") 
                + "; var id_puesto2_usuario = " + sesion.getAttribute("id_puesto2") 
                + "; var id_puesto3_usuario = " + sesion.getAttribute("id_puesto3") 
                + "; </script>");
    } else {
        out.write("<script>location.replace('index.jsp');</script>");
    }
%>

<ul id="dropdown1" class="dropdown-content">
    <li><a>Informacion Personal</a></li>
    <li><a>Cambiar Password</a></li>
    <li class="divider"></li>
    <li><a href="index.jsp" id="cerrar">Cerrar Sesion</a></li>
</ul>
<ul id="dropdown_app" class="dropdown-content">
    <li><a href="https://www.facebook.com/sicsacobranza/?ref=search&__tn__=%2Cd%2CP-R&eid=ARBzmVtC93taRRU_sstiWANxi7bZYBaTD4hJhfiPrrevKZ0r01Fnp8MqEMBelL_C7RR25fsXUWznu5iq"  class="center-align" target="_blank"><img class=" size_ul" src="image/facebook.png"></a></li>
    <li><a href="" class="center-align"><img class="size_ul" src="image/zoiper.png"></a></li>
    <li><a href="https://201.172.31.105:4446/"  class="center-align" target="_blank"><img class="width_ext size_ul" src="image/issabel_pue.fw.png"></a></li>
    <li><a href="https://192.168.0.6/index.php?menu=userlist"  class="center-align" target="_blank"><img class="width_ext size_ul" src="image/issabel_mty.fw.png"></a></li>
</ul>
<nav class="header_nav">
    <div class="nav-wrapper icon_nav">
        <ul>
            <a href="#!" class="logo_principal"><img src="image/logoInco.fw.png" alt="image/logoInco.fw.png" class="img_log"></a> 
        </ul>    
        <ul>
            <input id="filtro" class="search center-align grey lighten-5" onkeyup="myFunction_buscar()" type="text" placeholder="Buscar" style="width:50%">
            <div id="resultado_menu" class="div-resultado hide">
                <div id="colect" class="collection">
                </div>
            </div>
        </ul>
        <ul class="right size_ul ul_margin_top">      
            <li><a class="size_ul dropdown-trigger" href="#!" data-target="dropdown_app"><i class="material-icons size_ul">apps</i></a></li>
            <li><a class="size_ul dropdown-trigger" href="#!" data-target="dropdown1"><img id="foto_perfil" class="circle size_ul" src="image/icon-user.png"></a></li>
        </ul>
    </div>
</nav>
<ul id="slide-out" class="sidenav login1">
</ul>



