/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

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
            String sql = "call azteca_reporte_convenios('"+desde+"', '"+hasta+"', '"+territrio+"');";
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
            String sql = "call azteca_reporte_gestiones('"+desde+"', '"+hasta+"', '"+territrio+"');";
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
    
    
    
    public static String azteca_reporte_pagos() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT * FROM azteca_pagos;";
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

}
