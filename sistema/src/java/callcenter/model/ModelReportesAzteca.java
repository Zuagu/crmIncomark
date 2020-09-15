/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author zuagu
 */
public class ModelReportesAzteca {

    public static String reporte_convenios_tabla(String desde, String hasta, String territrio) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "call azteca_reporte_convenios('" + desde + "', '" + hasta + "', '" + territrio + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listConvenios = new JSONArray();

            while (ic.rs.next()) {
                JSONObject objConvenio = new JSONObject();
                objConvenio.put("ID_CONVENIO", ic.rs.getString("ID_CONVENIO"));
                objConvenio.put("CONVENIO", ic.rs.getString("CONVENIO"));
                objConvenio.put("RESTO", ic.rs.getString("RESTO"));
                objConvenio.put("APLICA", ic.rs.getString("APLICA"));
                objConvenio.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objConvenio.put("CANAL", ic.rs.getString("CANAL"));
                objConvenio.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objConvenio.put("FECHA", ic.rs.getString("FECHA"));
                objConvenio.put("USUARIO", ic.rs.getString("USUARIO"));
                objConvenio.put("CUENTA", ic.rs.getString("CUENTA"));
                objConvenio.put("ID_ESTATUS", ic.rs.getString("ID_ESTATUS"));
                objConvenio.put("FECHA_INSET", ic.rs.getString("FECHA_INSET"));
                objConvenio.put("PAGOS", ic.rs.getString("PAGOS"));
                objConvenio.put("FECHA_PAGO", ic.rs.getString("FECHA_PAGO"));
                objConvenio.put("EFECTIVIDAD", ic.rs.getString("EFECTIVIDAD"));
                objConvenio.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                listConvenios.add(objConvenio);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listConvenios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String reporte_gestiones_tabla(String desde, String hasta, String territrio) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "call azteca_reporte_gestiones('" + desde + "', '" + hasta + "', '" + territrio + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listGestiones = new JSONArray();

            while (ic.rs.next()) {
                JSONObject objGestion = new JSONObject();
                objGestion.put("ID_GESTION", ic.rs.getString("ID_GESTION"));
                objGestion.put("HORA", ic.rs.getString("HORA"));
                objGestion.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objGestion.put("CANAL", ic.rs.getString("CANAL"));
                objGestion.put("FECHA_LARGA", ic.rs.getString("FECHA_LARGA"));
                objGestion.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objGestion.put("CUENTA", ic.rs.getString("CUENTA"));
                objGestion.put("NUMERO_MARCADO", ic.rs.getString("NUMERO_MARCADO"));
                objGestion.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objGestion.put("ID_ESTATUS_LLAMADA", ic.rs.getString("ID_ESTATUS_LLAMADA"));
                objGestion.put("USUARIO", ic.rs.getString("USUARIO"));
                objGestion.put("GESTION", ic.rs.getString("GESTION"));
                objGestion.put("DURACION", ic.rs.getString("DURACION"));
                objGestion.put("RETASO", ic.rs.getString("RETASO"));
                objGestion.put("PROMESA", ic.rs.getString("PROMESA"));
                objGestion.put("F_PREDICTIVO", ic.rs.getString("F_PREDICTIVO"));
                listGestiones.add(objGestion);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listGestiones.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String azteca_reporte_pagos(String desde, String hasta, String zona) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "call azteca_reporte_pagos('" + desde + "', '" + hasta + "',  '" + zona + "')";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listPagos = new JSONArray();

            while (ic.rs.next()) {
                JSONObject objPago = new JSONObject();
                objPago.put("ID_PAGO", ic.rs.getString("ID_PAGO"));
                objPago.put("ANIO", ic.rs.getString("ANIO"));
                objPago.put("SEMANA", ic.rs.getString("SEMANA"));
                objPago.put("DIA", ic.rs.getString("DIA"));
                objPago.put("PAIS", ic.rs.getString("PAIS"));
                objPago.put("CANAL", ic.rs.getString("CANAL"));
                objPago.put("SUCURSAL", ic.rs.getString("SUCURSAL"));
                objPago.put("FOLIO", ic.rs.getString("FOLIO"));
                objPago.put("RECUPERACION_CAPITAL", ic.rs.getString("RECUPERACION_CAPITAL"));
                objPago.put("RECUPERACION_MORATORIOS", ic.rs.getString("RECUPERACION_MORATORIOS"));
                objPago.put("SALDO_ACTUAL", ic.rs.getString("SALDO_ACTUAL"));
                objPago.put("MORATORIO", ic.rs.getString("MORATORIO"));
                objPago.put("FECHA_GESTION", ic.rs.getString("FECHA_GESTION"));
                objPago.put("CARGO_AUTOMATICO", ic.rs.getString("CARGO_AUTOMATICO"));
                objPago.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                objPago.put("ZONA", ic.rs.getString("ZONA"));
                objPago.put("GERENTE", ic.rs.getString("GERENTE"));
                objPago.put("ID_GESTOR", ic.rs.getString("ID_GESTOR"));
                listPagos.add(objPago);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listPagos.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String select_options_territorios() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT TERRITORIO FROM azteca_base_genenral_original GROUP BY TERRITORIO;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray territorios = new JSONArray();
            while (ic.rs.next()) {
                territorios.add(ic.rs.getString("TERRITORIO"));
//                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return territorios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String select_options_zona() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT ZONA FROM azteca_pagos GROUP BY ZONA;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray territorios = new JSONArray();
            while (ic.rs.next()) {
                territorios.add(ic.rs.getString("ZONA"));
//                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return territorios.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }

    }

    public static String select_options_territorios(String objContacto) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(objContacto);

            Object _CUENTA = jsonObject.get("_CUENTA");

            StartConexion ic = new StartConexion();
            String sql = "CALL azteca_reporte_convenios();";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
//                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return jsonObject.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModelGestor.class.getName()).log(Level.SEVERE, null, ex);
            return "SQL: Falla en el parser de JSONObject";
        }

    }

    public static String descargar_base() throws IOException {

        String filename = "/var/lib/tomcat8/webapps/sistema/excel/BaseAztecaCrm.csv";
        System.out.println("FILE NAME: " + filename);

        try {
            String resultado;
            FileWriter fw = new FileWriter(filename);
            StartConexion s = new StartConexion();
            String sql = "SELECT CLIENTE_UNICO,NOMBRE_CTE,CUADRANTE,ZONA_GEO,RFC_CTE,ID_DESPACHO,DIRECCION_CTE,NUM_EXT_CTE,NUM_INT_CTE,CP_CTE,\n"
                    + "COLONIA_CTE,POBLACION_CTE,ESTADO_CTE,CLASIFICACION_CTE,ATRASO_MAXIMO,SALDO,MORATORIOS,SALDO_TOTAL,DIA_DE_PAGO,FECHA_ULTIMO_PAGO,\n"
                    + "ANO,IMP_ULTIMO_PAGO,CALLE_EMPLEO,NUM_EXT_EMPLEO,NUM_INT_EMPLEO,COLONIA_EMPLEO,POBLACION_EMPLEO,ESTADO_EMPLEO,NOMBRE_AVAL,\n"
                    + "TELAVAL,CALLEAVAL,NUMEXTAVAL,COLONIAAVAL,CPAVAL,POBLACIONAVAL,ESTADOAVAL,DIA_PAGO,TELEFONO1,TIPOTEL1,TELEFONO2,TIPOTEL2,\n"
                    + "TELEFONO3,TIPOTEL3,TELEFONO4,TIPOTEL4,MIGRADO_A_CYBER,GERENCIA,GERENTE,TERRITORIO,CAMPANIA,CANAL,EDAD,SCORE,RANGO,RANGO_DE_EDAD,\n"
                    + "IDENTIFICADOR2,ID_ESTATUS_CUENTA,ID_ESTATUS_LLAMADA,NOM_TEL1,NOM_TEL2,NOM_TEL3,NOM_TEL4,TIPO_CONTACTO1,TIPO_CONTACTO2,\n"
                    + "TIPO_CONTACTO3,TIPO_CONTACTO4,PLAN,STATUS,GRUPO,ETAPA,PRODUCTO,MICRO,ITALICA,PROXIMAS_RETIRO,NOM_TEL5,TELEFONO5,TIPOTEL5,TELEFONO1_2,TELEFONO2_2,TELEFONO3_2,TELEFONO4_2,TELEFONO5_2,TIPOTEL1_2,TIPOTEL2_2,\n"
                    + "TIPOTEL3_2,TIPOTEL4_2,TIPOTEL5_2,TELAVAL2,TIPOTELAVAL2 FROM azteca_base_genenral_original LIMIT 100;";
            System.out.println(sql);
            fw.append("CLIENTE_UNICO");
            fw.append(',');
            fw.append("NOMBRE_CTE");
            fw.append(',');
            fw.append("CUADRANTE");
            fw.append(',');
            fw.append("ZONA_GEO");
            fw.append(',');
            fw.append("RFC_CTE");
            fw.append(',');
            fw.append("ID_DESPACHO");
            fw.append(',');
            fw.append("DIRECCION_CTE");
            fw.append(',');
            fw.append("NUM_EXT_CTE");
            fw.append(',');
            fw.append("NUM_INT_CTE");
            fw.append(',');
            fw.append("CP_CTE");
            fw.append(',');
            fw.append("COLONIA_CTE");
            fw.append(',');
            fw.append("POBLACION_CTE");
            fw.append(',');
            fw.append("ESTADO_CTE");
            fw.append(',');
            fw.append("CLASIFICACION_CTE");
            fw.append(',');
            fw.append("ATRASO_MAXIMO");
            fw.append(',');
            fw.append("SALDO");
            fw.append(',');
            fw.append("MORATORIOS");
            fw.append(',');
            fw.append("SALDO_TOTAL");
            fw.append(',');
            fw.append("DIA_DE_PAGO");
            fw.append(',');
            fw.append("FECHA_ULTIMO_PAGO");
            fw.append(',');
            fw.append("ANO");
            fw.append(',');
            fw.append("IMP_ULTIMO_PAGO");
            fw.append(',');
            fw.append("CALLE_EMPLEO");
            fw.append(',');
            fw.append("NUM_EXT_EMPLEO");
            fw.append(',');
            fw.append("NUM_INT_EMPLEO");
            fw.append(',');
            fw.append("COLONIA_EMPLEO");
            fw.append(',');
            fw.append("POBLACION_EMPLEO");
            fw.append(',');
            fw.append("ESTADO_EMPLEO");
            fw.append(',');
            fw.append("NOMBRE_AVAL");
            fw.append(',');
            fw.append("TELAVAL");
            fw.append(',');
            fw.append("CALLEAVAL");
            fw.append(',');
            fw.append("NUMEXTAVAL");
            fw.append(',');
            fw.append("COLONIAAVAL");
            fw.append(',');
            fw.append("CPAVAL");
            fw.append(',');
            fw.append("POBLACIONAVAL");
            fw.append(',');
            fw.append("ESTADOAVAL");
            fw.append(',');
            fw.append("DIA_PAGO");
            fw.append(',');
            fw.append("TELEFONO1");
            fw.append(',');
            fw.append("TIPOTEL1");
            fw.append(',');
            fw.append("TELEFONO2");
            fw.append(',');
            fw.append("TIPOTEL2");
            fw.append(',');
            fw.append("TELEFONO3");
            fw.append(',');
            fw.append("TIPOTEL3");
            fw.append(',');
            fw.append("TELEFONO4");
            fw.append(',');
            fw.append("TIPOTEL4");
            fw.append(',');
            fw.append("MIGRADO_A_CYBER");
            fw.append(',');
            fw.append("GERENCIA");
            fw.append(',');
            fw.append("GERENTE");
            fw.append(',');
            fw.append("TERRITORIO");
            fw.append(',');
            fw.append("CAMPANIA");
            fw.append(',');
            fw.append("CANAL");
            fw.append(',');
            fw.append("EDAD");
            fw.append(',');
            fw.append("SCORE");
            fw.append(',');
            fw.append("RANGO");
            fw.append(',');
            fw.append("RANGO_DE_EDAD");
            fw.append(',');
            fw.append("IDENTIFICADOR2");
            fw.append(',');
            fw.append("ID_ESTATUS_CUENTA");
            fw.append(',');
            fw.append("ID_ESTATUS_LLAMADA");
            fw.append(',');
            fw.append("NOM_TEL1");
            fw.append(',');
            fw.append("NOM_TEL2");
            fw.append(',');
            fw.append("NOM_TEL3");
            fw.append(',');
            fw.append("NOM_TEL4");
            fw.append(',');
            fw.append("TIPO_CONTACTO1");
            fw.append(',');
            fw.append("TIPO_CONTACTO2");
            fw.append(',');
            fw.append("TIPO_CONTACTO3");
            fw.append(',');
            fw.append("TIPO_CONTACTO4");
            fw.append(',');
            fw.append("PLAN");
            fw.append(',');
            fw.append("STATUS");
            fw.append(',');
            fw.append("GRUPO");
            fw.append(',');
            fw.append("ETAPA");
            fw.append(',');
            fw.append("PRODUCTO");
            fw.append(',');
            fw.append("MICRO");
            fw.append(',');
            fw.append("ITALICA");
            fw.append(',');
            fw.append("PROXIMAS_RETIRO");
            fw.append(',');
            fw.append("NOM_TEL5");
            fw.append(',');
            fw.append("TELEFONO5");
            fw.append(',');
            fw.append("TIPOTEL5");
            fw.append(',');
            fw.append("TELEFONO1_2");
            fw.append(',');
            fw.append("TELEFONO2_2");
            fw.append(',');
            fw.append("TELEFONO3_2");
            fw.append(',');
            fw.append("TELEFONO4_2");
            fw.append(',');
            fw.append("TELEFONO5_2");
            fw.append(',');
            fw.append("TIPOTEL1_2");
            fw.append(',');
            fw.append("TIPOTEL2_2");
            fw.append(',');
            fw.append("TIPOTEL3_2");
            fw.append(',');
            fw.append("TIPOTEL4_2");
            fw.append(',');
            fw.append("TIPOTEL5_2");
            fw.append(',');
            fw.append("TELAVAL2");
            fw.append(',');
            fw.append("TIPOTELAVAL2");
            fw.append('\n');

            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                fw.append(s.rs.getString("CLIENTE_UNICO"));
                fw.append(',');
                fw.append(s.rs.getString("NOMBRE_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("CUADRANTE"));
                fw.append(',');
                fw.append(s.rs.getString("ZONA_GEO"));
                fw.append(',');
                fw.append(s.rs.getString("RFC_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("ID_DESPACHO"));
                fw.append(',');
                fw.append(s.rs.getString("DIRECCION_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("NUM_EXT_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("NUM_INT_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("CP_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("COLONIA_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("POBLACION_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("ESTADO_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("CLASIFICACION_CTE"));
                fw.append(',');
                fw.append(s.rs.getString("ATRASO_MAXIMO"));
                fw.append(',');
                fw.append(s.rs.getString("SALDO"));
                fw.append(',');
                fw.append(s.rs.getString("MORATORIOS"));
                fw.append(',');
                fw.append(s.rs.getString("SALDO_TOTAL"));
                fw.append(',');
                fw.append(s.rs.getString("DIA_DE_PAGO"));
                fw.append(',');
                fw.append(s.rs.getString("FECHA_ULTIMO_PAGO"));
                fw.append(',');
                fw.append(s.rs.getString("ANO"));
                fw.append(',');
                fw.append(s.rs.getString("IMP_ULTIMO_PAGO"));
                fw.append(',');
                fw.append(s.rs.getString("CALLE_EMPLEO"));
                fw.append(',');
                fw.append(s.rs.getString("NUM_EXT_EMPLEO"));
                fw.append(',');
                fw.append(s.rs.getString("NUM_INT_EMPLEO"));
                fw.append(',');
                fw.append(s.rs.getString("COLONIA_EMPLEO"));
                fw.append(',');
                fw.append(s.rs.getString("POBLACION_EMPLEO"));
                fw.append(',');
                fw.append(s.rs.getString("ESTADO_EMPLEO"));
                fw.append(',');
                fw.append(s.rs.getString("NOMBRE_AVAL"));
                fw.append(',');
                fw.append(s.rs.getString("TELAVAL"));
                fw.append(',');
                fw.append(s.rs.getString("CALLEAVAL"));
                fw.append(',');
                fw.append(s.rs.getString("NUMEXTAVAL"));
                fw.append(',');
                fw.append(s.rs.getString("COLONIAAVAL"));
                fw.append(',');
                fw.append(s.rs.getString("CPAVAL"));
                fw.append(',');
                fw.append(s.rs.getString("POBLACIONAVAL"));
                fw.append(',');
                fw.append(s.rs.getString("ESTADOAVAL"));
                fw.append(',');
                fw.append(s.rs.getString("DIA_PAGO"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO1"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL1"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO2"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL2"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO3"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL3"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO4"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL4"));
                fw.append(',');
                fw.append(s.rs.getString("MIGRADO_A_CYBER"));
                fw.append(',');
                fw.append(s.rs.getString("GERENCIA"));
                fw.append(',');
                fw.append(s.rs.getString("GERENTE"));
                fw.append(',');
                fw.append(s.rs.getString("TERRITORIO"));
                fw.append(',');
                fw.append(s.rs.getString("CAMPANIA"));
                fw.append(',');
                fw.append(s.rs.getString("CANAL"));
                fw.append(',');
                fw.append(s.rs.getString("EDAD"));
                fw.append(',');
                fw.append(s.rs.getString("SCORE"));
                fw.append(',');
                fw.append(s.rs.getString("RANGO"));
                fw.append(',');
                fw.append(s.rs.getString("RANGO_DE_EDAD"));
                fw.append(',');
                fw.append(s.rs.getString("IDENTIFICADOR2"));
                fw.append(',');
                fw.append(s.rs.getString("ID_ESTATUS_CUENTA"));
                fw.append(',');
                fw.append(s.rs.getString("ID_ESTATUS_LLAMADA"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL1"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL2"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL3"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL4"));
                fw.append(',');
                fw.append(s.rs.getString("TIPO_CONTACTO1"));
                fw.append(',');
                fw.append(s.rs.getString("TIPO_CONTACTO2"));
                fw.append(',');
                fw.append(s.rs.getString("TIPO_CONTACTO3"));
                fw.append(',');
                fw.append(s.rs.getString("TIPO_CONTACTO4"));
                fw.append(',');
                fw.append(s.rs.getString("PLAN"));
                fw.append(',');
                fw.append(s.rs.getString("STATUS"));
                fw.append(',');
                fw.append(s.rs.getString("GRUPO"));
                fw.append(',');
                fw.append(s.rs.getString("ETAPA"));
                fw.append(',');
                fw.append(s.rs.getString("PRODUCTO"));
                fw.append(',');
                fw.append(s.rs.getString("MICRO"));
                fw.append(',');
                fw.append(s.rs.getString("ITALICA"));
                fw.append(',');
                fw.append(s.rs.getString("PROXIMAS_RETIRO"));
                fw.append(',');
                fw.append(s.rs.getString("NOM_TEL5"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO5"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL5"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO1_2"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO2_2"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO3_2"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO4_2"));
                fw.append(',');
                fw.append(s.rs.getString("TELEFONO5_2"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL1_2"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL2_2"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL3_2"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL4_2"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTEL5_2"));
                fw.append(',');
                fw.append(s.rs.getString("TELAVAL2"));
                fw.append(',');
                fw.append(s.rs.getString("TIPOTELAVAL2"));
                fw.append('\n');
            }

            fw.flush();
            fw.close();

            s.rs.close();
            s.st.close();
            s.conn.close();
            resultado = "{\"response\":\"Se ha generado la base general en CSV de manera correcta.\"}";
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

}
