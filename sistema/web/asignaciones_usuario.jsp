<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="image/logoInco.fw.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Usuarios</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/usuarios.css">
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor.css">

    </head>

    <body>
        <jsp:include page="header.jsp"/>

        <div class="row">
            <div class="col s10 m10 l10 offset-s1 options offset-m1 offset-l1 right-align">
                <div class="col s12 m12 l12">
                    <a class="waves-effect waves-light btn blue modal-trigger add_user" href="#modal_nuevo_usuario">Nuevo</a>
                </div>
            </div>

            <div class="col s10 m10 l10 offset-s1 offset-m1 offset-l1">
                <div id="table_user" class="col s12 m12 table_user z-depth-2 inner white">

                </div>
            </div>
        </div>


        <script src="js/js/jquery-2.2.4.min.js"></script>
        <script src="js/js/materialize.min.js"></script>
        <script src="js/js/menu.js"></script>
        <script src="js/js/users.js"></script>
    </body>

</html>