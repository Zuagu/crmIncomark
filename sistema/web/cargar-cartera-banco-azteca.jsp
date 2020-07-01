<%-- 
    Document   : cargar-cartera-banco-azteca
    Created on : 30/06/2020, 07:51:12 AM
    Author     : zuagu
--%>

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
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row" id="contenido"></div>

        <div class="col s12 m12 l12">
            <div class="col s12 m12 l12">
                <form method="POST" action="ControllerUploadFiles" enctype="multipart/form-data">
                    <div class="file-field input-field">
                        <div class="btn">
                            <span>Archivo csv</span>
                            <input type="file" name="uploadFile" accept=".csv">
                        </div>
                        <div class="file-path-wrapper">
                            <input class="file-path validate" type="text">
                        </div>
                        <div>
                            <button class="btn waves-effect waves-purple" type="submit" name="action">Cargar<i class="material-icons right">send</i></button>
                        </div>
                    </div>
                </form>
            </div>
        </div>


        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
    </body>
</html>
