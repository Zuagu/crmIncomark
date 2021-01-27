<%-- 
    Document   : admin_input_selects
    Created on : 26/01/2021, 09:26:55 PM
    Author     : zuagu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Admin Selects</title>
        <link rel="stylesheet" type="text/css" href="css/css/icons-material.css">
        <link rel="stylesheet" type="text/css" href="css/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/css/style_gestor.css">

    </head>
    <body>
        <div class="row">
            <div class="col s12 m12 l12 center-align">
                <h4>Administrador de selects</h4>
            </div>
            <div class="col s12 m10 l10 offset-m1 offset-l1">
                <div class="col s10 m4 l4 input-field">
                    <select id="sexo">
                        <option value="" disabled selected>Choose your option</option>
                    </select>
                    <label>SEXO</label>
                </div>
                <div class="col s10 m4 l4 input-field">
                    <select id="trabajo_call_center">
                        <option value="" disabled selected>Choose your option</option>
                    </select>
                    <label>EXPERIENCIA CALL CENTER</label>
                </div>
            </div>

            <div class="col s12 m10 l10 offset-m1 offset-l1">
                <div class="col s10 m4 l4 input-field">
                    <select id="modulo_jsp">
                        <option>Solicitud</option>
                        <option>Gestor</option>
                    </select>
                    <label>Modulo</label>
                </div>
                <div class="col s10 m3 l3 input-field">
                    <select id="campo">
                        <option>sexo</option>
                        <option>trabajo_call_center</option>
                    </select>
                    <label>campo</label>
                </div>
                <div class="col s10 m3 l3 input-field">
                    <input placeholder="valor" id="valor" type="text" class="validate">
                    <label for="valor">valor</label>
                </div>
                <div class="col s10 m2 l2 input-field">
                    <a class="btn waves-effect blue">Agregar</a>
                </div>
                <div class="col s12 m12 l12 grey lighten-3">
                    <table>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Valor</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody id="tb_body_selects">
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

        <script type="text/javascript" src="js/js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/js/materialize.min.js"></script>
        <!--<script type="text/javascript" src="js/js/menu.js"></script>-->
        <script>
            $(document).ready(function () {
                $('select').formSelect();
            });
            var data = [
                {
                    id_select: "sexo",
                    valor: "MASCULINO",
                    jsp: "solicitud"
                },
                {
                    id_select: "sexo",
                    valor: "FEMENINO",
                    jsp: "solicitud"
                },
                {
                    id_select: "sexo",
                    valor: "NO DEFINE",
                    jsp: "solicitud"
                },
                {
                    id_select: "trabajo_call_center",
                    valor: "SI",
                    jsp: "solicitud"
                },
                {
                    id_select: "trabajo_call_center",
                    valor: "NO",
                    jsp: "solicitud"
                }
            ];

            for (let row of data) {
                $('#' + row.id_select).append('<option>' + row.valor + '</option>');
            }
            for (let row of data) {
                $('#tb_body_selects').append('<tr>' +
                        '<td>' + row.id_select + '</td>' +
                        '<td>' + row.valor + '</td>' +
                        '<td><a class="btn red lighten-3 waves-effect">eliminar</a></td>' +
                        '</tr');
            }
            $('select').formSelect();
        </script>
    </body>
</html>
