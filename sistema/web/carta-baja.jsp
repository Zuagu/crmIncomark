<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contrato</title>
        <!--ICONS PARA MATERIALIZE-->

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--ICONS PARA MATERIALIZE-->

        <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

        <!--MATERIALIZE-->
        <script type="text/javascript" src="materialize/js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="materialize/css/materialize.css">
        <script type="text/javascript" src="js/arcade-usuario.js"></script>
        <!--MATERIALIZE-->

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            .size_button{
                transform: scale(.8, .8);
                width: 150px;
            }
            .size_button2{
                transform: scale(.7, .7);
                width: 80px;
            }
            .size_button3{
                transform: scale(.6, .6);
            }
            .tam{
                transform: scale(.9, .9);
                width: 300px;
            }
            @media print {
                .hide_print {
                    display: none!important;
                }
            }
            .att input:not([type]) {
                border-bottom: 0px solid #9e9e9e;
            }
            .huella {
                border: 1px solid #9e9e9e;
                height: 13vh;
            }
            .texto {
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col s10 offset-s1 input-field" style="text-align:justify;">
                <input class="right-align" id="fecha_hoy" value="">
                <br>
                <br>
                <h6><b>SOLUCIONES INTEGRALES DE CREDITO Y COBRANZAS S.A DE C.V</b></h6>
                <h6><b>PRESENTE.-</b></h6>
                <p>Estimado Señores: </p>
                <p>
                    Por medio de la presente, me permito comunicarles, que con esta fecha y por convenir 
                    así a mis intereses, ME SEPARO VOLUNTARIAMENTE DEL TRABAJO que venía desempeñando para 
                    esta Empresa y Ustedes en lo personal, en términos del artículo 53 fracción I de la 
                    Ley Federal del Trabajo en vigor, es decir, renuncio en forma voluntaria a las labores 
                    que venía desempeñando y la relación de trabajo que nos vinculaba desde 
                    <b><input id="fecha_inicio"  style="text-align: center; width:250px;"></b> 
                    a traves del cual, les venia prestando servicios como <b>EJECUTIVO DE COBRANZA TELEFONICA.</b> 
                    Al mismo tiempo hago constar, que durante el lapso que estuve a su servicio y que me pagaron 
                    puntual y oportunamente mis salarios, séptimos días, días festivos vacaciones, prima vacacional, 
                    Aguinaldo y en general todas las prestaciones que me correspondieron conforme a la Ley, e 
                    igualmente, que se me dio de alta y mantuvo inscrito ante el IMSS, INFONAVIT Y SAR de acuerdo 
                    a mi salario y se realizaron el pago de cuotas y aportaciones, amén de que, no sufrí riesgo de trabajo alguno.
                </p>

                <p>
                    Agradezco las atenciones que siempre me brindaron mientras estuve a su servicio
                </p>
                <input id="id_user" type="hidden">

            </div>    
            <div class="col s4 offset-s4 input-field att">
                <p class="center-align">
                    <b>Atentamente</b>
                    <br>
                    <br>
                    <br>
                    ___________________________________________<br>
                    <input id="nombre" readonly="" style="text-align: center; width:80%;">
            </div>
            <div class="col s2 offset-s1 huella"></div>
            <br>
            <div class="col s10 offset-s1">
                <p>
                    En la misma fecha de <input id="fecha_hoy_2" style="width: auto;"> ratifico el contenido de esta renuncia, y reconozco como 
                    mías la firma y huella que la calzan
                </p>
            </div>
            <div class="col s4 offset-s4 input-field att">
                <p class="center-align">
                    <br>
                    <br>
                    ___________________________________________<br>
                    <input id="nombre2" readonly="" style="text-align: center; width:80%;">
            </div>
            <div class="col s2 offset-s1 huella"></div>
            <br>
            <div class="col s12 center-align">
                <a id="print" class="waves-effect waves-light btn pulse  hide_print" style="border-radius: 14px;margin-top: 14px;background:#c60516;"><i class="material-icons" style="margin: -10px;">print</i></a>
            </div>
        </div>
        <!---------------------------------- modales ------------------------------------------>
        <div id="modal1" class="modal encuesta">
            <div class="modal-content center-align">
                <div class="row">
                    <h5>Cometarios</h5>
                    <div class="input-field col s6">
                        <select id="status_contra">
                            <option value="" disabled selected>Seleciona</option>
                            <option value="1">Contratable</option>
                            <option value="0">No Contratable</option>
                        </select>
                        <label>Estaus de Contratacion</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="fecha_baja_real" type="text" class="datepicker">
                    </div>
                    <div class="input-field col s12 texto">
                        <textarea id="textarea1" class="materialize-textarea"></textarea>
                        <label for="textarea1">Observaciones finales</label>
                    </div>
                </div>

            </div>
            <div class="col s12 center-align">
                <a id='baja' class="modal-action modal-close waves-effect red btn">Dar de Baja</a>
                <br>
                <br>
            </div>
        </div>
        <!---------------------------------- Fin modales ------------------------------------------>

        <script type="text/javascript">
            // ARCADE Software®
            //==================================================================
            $(document).ready(function () {
                $('.modal').modal();
                var id = window.location.search.substring(1);
                $('#id_user').val(id);
                $('select').material_select();
                $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 15, // Creates a dropdown of 15 years to control year,
                today: 'Today',
                clear: 'Clear',
                close: 'Ok',
                closeOnSelect: false, // Close upon selecting a date,
                container:'body'
            });
                /*select_dato_contrato(id);
                 $("#hide_input").val(id);
                 window.setTimeout(() => {
                 $("#nombreFirma").text($("#dato21").val());
                 }, 1000);*/

                var dia = new Date();
                let nom_mes = [
                    "Enero",
                    "Febrero",
                    "Marzo",
                    "Abril",
                    "Mayo",
                    "Junio",
                    "Julio",
                    "Agosto",
                    "Septiembre",
                    "Octubre",
                    "Noviembre",
                    "Diciembre"
                ];

                $("#fecha_hoy").val("Monterrey, N.L. a " + dia.getDate() + " de " + nom_mes[dia.getMonth()] + " de " + dia.getFullYear());
                select_dato_carta_baja(id, nom_mes);

                $("#fecha_hoy_2").val(dia.getDate() + " de " + nom_mes[dia.getMonth()] + " de " + dia.getFullYear());
                
            });


            //==================================================================
            $("#print").on("click", function () {
                $('#modal1').modal('open');
//                window.focus();
//                window.print();

            });
            //==================================================================
            $("#baja").on("click", function () {
                baja_usuario($('#id_user').val(), $('#status_contra').val(),$('#fecha_baja_real').val(), $('#textarea1').val());

                window.setTimeout(() => {
                    window.focus();
                    window.print();
                }, 500);



            });

            //==================================================================

            // ARCADE Software®
        </script>
        <!--CORE JAVASCRIPT-->        
    </body>
</html>
