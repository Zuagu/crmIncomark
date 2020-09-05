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
    <li><a href="https://incomarkpbx.systelvoice.com/index.php"  class="center-align" target="_blank"><img class="width_ext size_ul" src="image/issabel.png"></a></li>
</ul>
<nav class="header_nav blue darken-1">
    <div class="nav-wrapper icon_nav">
        <ul>
            <a href="#!" class="logo_principal"><img src="image/logoInco.fw.png" alt="image/logoInco.fw.png" class="img_log"></a> 
        </ul>    
        <ul id="unico_filtro" class="center-align temp ">
            <input id="filtro" class="search center-align grey lighten-5" onkeyup="myFunction_buscar()" type="text" placeholder="Buscar" style="width:50%">
            <div id="resultado_menu" class="div-resultado hide">
                <div id="colect" class="collection">
                </div>
            </div>
        </ul>
        <ul class="right size_ul ul_margin_top">      
            <li><a class="size_ul dropdown-trigger" href="#!" data-target="dropdown_app"><i class="material-icons size_ul margin_13_top">apps</i></a></li>
            <li><a class="size_ul dropdown-trigger" href="#!" data-target="dropdown1"><img id="foto_perfil" class="circle size_ul margin_17_top" src="image/icon-user.png"></a></li>
        </ul>
    </div>
</nav>
<ul id="slide-out" class="sidenav login1">
</ul>



