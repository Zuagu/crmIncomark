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
        <style>
            .encabezados_csv span {
                background-color: rgba(0, 0, 0, 0.13);
                margin: 0.5rem;
                width: 200px;
                display: inline-block;
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
                    
                    <div class="encabezados_csv center-align">
                        <h4>Encabezados del archivo CSV</h4>
                        <span>cliente_id</span>
                        <span>PLAN</span>
                        <span>STATUS</span> 
                        <span>GRUPO</span> 
                        <span>NOMBRE</span>
                        <span>EDAD</span>
                        <span>RANGO_DE_EDAD</span>
                        <span>ATRASO_MAXIMO</span>
                        <span>ETAPA</span>
                        <span>SCORE</span>
                        <span>SALDO</span> 
                        <span>RANGO</span> 
                        <span>MORATORIOS</span> 
                        <span>SALDO_TOTAL</span> 
                        <span>ZONA</span> 
                        <span>REGION</span>
                        <span>GERENCIA</span>
                        <span>DIA_DE_PAGO</span>
                        <span>PRODUCTO</span>
                        <span>MICRO</span>
                        <span>ITALIKA</span>
                        <span>CANAL</span>
                        <span>FECHA_PAGO</span>
                        <span>ANO_PAGO</span>
                        <span>IMPORTE</span>
                        <span>AVAL</span>
                        <span>NOMBRE_AVAL</span>
                        <span>MIGRADO_A_CYBER</span>
                        <span>CUADRANTE</span>
                        <span>ZONA_GEO</span>
                        <span>RFC</span>
                        <span>TEL_AVAL</span>
                        <span>TIPO_TEL_AVAL</span>
                        <span>TEL1</span>
                        <span>TIPO1</span>
                        <span>TEL2</span>
                        <span>TIPO2</span>
                        <span>TEL3</span>
                        <span>TIPO3</span>
                        <span>TEL4</span>
                        <span>TIPO4</span>
                        <span>FECHA_INICIO</span>
                        <span>FECHA_RETIRO</span>
                        <span>FECHA_REINGRESO</span>
                    </div>
                </div>
                <div class="col s12 m10 l10 offset-m1 offset-l1">
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
                <div class="col s12 m10 l10 offset-m1 offset-l1 card">
                    <div class="card-content">
                        <a href="#" id="llamar_cuenta" class="btn waves-effect blue-grey">ver cuenta</a>
                        <p id="datos_cuenta"></p>
                    </div>
                </div>
            </div>
        </div>


        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <script>
            
            $("#llamar_cuenta").click( function () {
                $.ajax({
                    type: 'POST',
                    url: "ControllerDataCuentaAzteca",
                    data: {action:"datos_cuenta_azteca"},
                    dataType: 'json',
                    success: function (data, textStatus, jqXHR) {
                        console.log(data);
                        $("#datos_cuenta").empty();
                        $("#datos_cuenta").append( JSON.stringify(data) );
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert(textStatus);
                    }
                });
            });
        </script>
    </body>
</html>
