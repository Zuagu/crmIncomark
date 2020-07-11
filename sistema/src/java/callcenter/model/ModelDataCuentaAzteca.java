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
 * @author Emmanuel Medina
 */
public class ModelDataCuentaAzteca {

    public static String datosCuenta(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "select * from azteca_base_genenral_original where CLIENTE_UNICO = '" + cuenta + "';";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));
                objCuenta.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                objCuenta.put("NOMBRE_CTE", ic.rs.getString("NOMBRE_CTE"));
                objCuenta.put("CUADRANTE", ic.rs.getString("CUADRANTE"));
                objCuenta.put("ZONA_GEO", ic.rs.getString("ZONA_GEO"));
                objCuenta.put("RFC_CTE", ic.rs.getString("RFC_CTE"));
                objCuenta.put("ID_DESPACHO", ic.rs.getString("ID_DESPACHO"));
                objCuenta.put("DIRECCION_CTE", ic.rs.getString("DIRECCION_CTE"));
                objCuenta.put("NUM_EXT_CTE", ic.rs.getString("NUM_EXT_CTE"));
                objCuenta.put("NUM_INT_CTE", ic.rs.getString("NUM_INT_CTE"));
                objCuenta.put("CP_CTE", ic.rs.getString("CP_CTE"));
                objCuenta.put("COLONIA_CTE", ic.rs.getString("COLONIA_CTE"));
                objCuenta.put("POBLACION_CTE", ic.rs.getString("POBLACION_CTE"));
                objCuenta.put("ESTADO_CTE", ic.rs.getString("ESTADO_CTE"));
                objCuenta.put("CLASIFICACION_CTE", ic.rs.getString("CLASIFICACION_CTE"));
                objCuenta.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objCuenta.put("SALDO", ic.rs.getString("SALDO"));
                objCuenta.put("MORATORIOS", ic.rs.getString("MORATORIOS"));
                objCuenta.put("SALDO_TOTAL", ic.rs.getString("SALDO_TOTAL"));
                objCuenta.put("DIA_DE_PAGO", ic.rs.getString("DIA_DE_PAGO"));
                objCuenta.put("FECHA_ULTIMO_PAGO", ic.rs.getString("FECHA_ULTIMO_PAGO"));
                objCuenta.put("ANO", ic.rs.getString("ANO"));
                objCuenta.put("IMP_ULTIMO_PAGO", ic.rs.getString("IMP_ULTIMO_PAGO"));
                objCuenta.put("CALLE_EMPLEO", ic.rs.getString("CALLE_EMPLEO"));
                objCuenta.put("NUM_EXT_EMPLEO", ic.rs.getString("NUM_EXT_EMPLEO"));
                objCuenta.put("NUM_INT_EMPLEO", ic.rs.getString("NUM_INT_EMPLEO"));
                objCuenta.put("COLONIA_EMPLEO", ic.rs.getString("COLONIA_EMPLEO"));
                objCuenta.put("POBLACION_EMPLEO", ic.rs.getString("POBLACION_EMPLEO"));
                objCuenta.put("ESTADO_EMPLEO", ic.rs.getString("ESTADO_EMPLEO"));
                objCuenta.put("NOMBRE_AVAL", ic.rs.getString("NOMBRE_AVAL"));
                objCuenta.put("TELAVAL", ic.rs.getString("TELAVAL"));
                objCuenta.put("CALLEAVAL", ic.rs.getString("CALLEAVAL"));
                objCuenta.put("NUMEXTAVAL", ic.rs.getString("NUMEXTAVAL"));
                objCuenta.put("COLONIAAVAL", ic.rs.getString("COLONIAAVAL"));
                objCuenta.put("CPAVAL", ic.rs.getString("CPAVAL"));
                objCuenta.put("POBLACIONAVAL", ic.rs.getString("POBLACIONAVAL"));
                objCuenta.put("ESTADOAVAL", ic.rs.getString("ESTADOAVAL"));
                objCuenta.put("DIA_PAGO", ic.rs.getString("DIA_PAGO"));
                objCuenta.put("TELEFONO1", ic.rs.getString("TELEFONO1"));
                objCuenta.put("TIPOTEL1", ic.rs.getString("TIPOTEL1"));
                objCuenta.put("TELEFONO2", ic.rs.getString("TELEFONO2"));
                objCuenta.put("TIPOTEL2", ic.rs.getString("TIPOTEL2"));
                objCuenta.put("TELEFONO3", ic.rs.getString("TELEFONO3"));
                objCuenta.put("TIPOTEL3", ic.rs.getString("TIPOTEL3"));
                objCuenta.put("TELEFONO4", ic.rs.getString("TELEFONO4"));
                objCuenta.put("TIPOTEL4", ic.rs.getString("TIPOTEL4"));
                objCuenta.put("MIGRADO_A_CYBER", ic.rs.getString("MIGRADO_A_CYBER"));
                objCuenta.put("LATITUD", ic.rs.getString("LATITUD"));
                objCuenta.put("LONGITUD", ic.rs.getString("LONGITUD"));
                objCuenta.put("GERENCIA", ic.rs.getString("GERENCIA"));
                objCuenta.put("GERENTE", ic.rs.getString("GERENTE"));
                objCuenta.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objCuenta.put("CAMPANIA", ic.rs.getString("CAMPANIA"));
                objCuenta.put("IDENTIFICADOR", ic.rs.getString("IDENTIFICADOR"));
                objCuenta.put("CANAL", ic.rs.getString("CANAL"));
                objCuenta.put("EDAD", ic.rs.getString("EDAD"));
                objCuenta.put("SCORE", ic.rs.getString("SCORE"));
                objCuenta.put("RANGO", ic.rs.getString("RANGO"));
                objCuenta.put("RANGO_DE_EDAD", ic.rs.getString("RANGO_DE_EDAD"));
                objCuenta.put("IDENTIFICADOR2", ic.rs.getString("IDENTIFICADOR2"));
                objCuenta.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                objCuenta.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objCuenta.put("ID_ESTATUS_LLAMADA", ic.rs.getString("ID_ESTATUS_LLAMADA"));
                objCuenta.put("ID_SUCURSAL", ic.rs.getString("ID_SUCURSAL"));
                objCuenta.put("ID_CLIENTE", ic.rs.getString("ID_CLIENTE"));
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            System.out.println(objCuenta.toString());
            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String guardarGestion(String objGestion) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(objGestion);

            Object _ID_SUCURSAL = jsonObject.get("_ID_SUCURSAL");
            Object _ID_CLIENTE = jsonObject.get("_ID_CLIENTE");
            Object _TERRITORIO = jsonObject.get("_TERRITORIO");
            Object _CANAL = jsonObject.get("_CANAL");
            Object _ATRASO_MAXIMO = jsonObject.get("_ATRASO_MAXIMO");
            Object _CUENTA = jsonObject.get("_CUENTA");
            Object _NUMERO_MARCADO = jsonObject.get("_NUMERO_MARCADO");
            Object _ID_ESTATUS_CUENTA = jsonObject.get("_ID_ESTATUS_CUENTA");
            Object _ID_ESTATUS_LLAMADA = jsonObject.get("_ID_ESTATUS_LLAMADA");
            Object _ID_USUARIO = jsonObject.get("_ID_USUARIO");
            Object _GESTION = jsonObject.get("_GESTION");
            Object _DURACION = jsonObject.get("_DURACION");
            Object _RETASO = jsonObject.get("_RETASO");
            Object _ID_PUESTO = jsonObject.get("_ID_PUESTO");
            Object _PROMESA = jsonObject.get("_PROMESA");
            Object _F_PREDICTIVO = jsonObject.get("_F_PREDICTIVO");
            Object _ID_EQUIPO = jsonObject.get("_ID_EQUIPO");

            StartConexion ic = new StartConexion();
            String sql = "call azteca_insert_gestion(" + _ID_SUCURSAL + ", " + _ID_CLIENTE + ", '" + _TERRITORIO + "', '" + _CANAL + "', " + _ATRASO_MAXIMO + ", '" + _CUENTA + "', '" + _NUMERO_MARCADO + "', " + _ID_ESTATUS_CUENTA + ", " + _ID_ESTATUS_LLAMADA + ", " + _ID_USUARIO + ", '" + _GESTION + "', '" + _DURACION + "', '" + _RETASO + "', " + _ID_PUESTO + ", " + _PROMESA + ", " + _F_PREDICTIVO + ", " + _ID_EQUIPO + ");";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);

            JSONObject objRes = new JSONObject();
            System.out.println(objRes);
            while (ic.rs.next()) {
                objRes.put("response", ic.rs.getString("response"));

            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return objRes.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error: al insertar datos de gestion Code Error: " + e;
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModelGestor.class.getName()).log(Level.SEVERE, null, ex);
            return "SQL: Falla en el parser de JSONObject";
        }
    }

    public static String select_buscar_cuentas(String busqueda, int id_puesto) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "call azteca_buscar_cuentas('%" + busqueda.replace(";", "") + "%');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listCuentas = new JSONArray();

            while (ic.rs.next()) { //id_cuenta, CLIENTE_UNICO, NOMBRE_CTE, NOMBRE_AVAL, TELEFONO1, TELEFONO2, TELEFONO3, TELEFONO4, TELAVAL
                JSONObject objCuenta = new JSONObject();
                objCuenta.put("id_cuenta", ic.rs.getString("id_cuenta"));
                objCuenta.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                objCuenta.put("NOMBRE_CTE", ic.rs.getString("NOMBRE_CTE"));
                objCuenta.put("NOMBRE_AVAL", ic.rs.getString("NOMBRE_AVAL"));
                objCuenta.put("TELEFONO1", ic.rs.getString("TELEFONO1"));
                objCuenta.put("TELEFONO2", ic.rs.getString("TELEFONO2"));
                objCuenta.put("TELEFONO3", ic.rs.getString("TELEFONO3"));
                objCuenta.put("TELEFONO4", ic.rs.getString("TELEFONO4"));
                objCuenta.put("TELAVAL", ic.rs.getString("TELAVAL"));
                listCuentas.add(objCuenta);

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listCuentas.toString();
        } catch (SQLException e) {
            return "SQL: Error al buscar ceuntas Code Error: " + e;
        }
    }

    public static String select_datos_cuenta_relacionada(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            System.out.println(objCuenta.toString());

            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_telefonos_cr(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_gestiones_cuenta(String cuenta, String fecha_inico) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "CALL azteca_gestiones_cuenta('" + cuenta + "');";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listGestion = new JSONArray();
            while (ic.rs.next()) {
                JSONObject objGestion = new JSONObject();
                objGestion.put("ID_GESTION", ic.rs.getString("ID_GESTION"));
                objGestion.put("ID_SUCURSAL", ic.rs.getString("ID_SUCURSAL"));
                objGestion.put("HORA", ic.rs.getString("HORA"));
                objGestion.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objGestion.put("CANAL", ic.rs.getString("CANAL"));
                objGestion.put("FECHA_LARGA", ic.rs.getString("FECHA_LARGA"));
                objGestion.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objGestion.put("CUENTA", ic.rs.getString("CUENTA"));
                objGestion.put("NUMERO_MARCADO", ic.rs.getString("NUMERO_MARCADO"));
                objGestion.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objGestion.put("ID_ESTATUS_LLAMADA", ic.rs.getString("ID_ESTATUS_LLAMADA"));
                objGestion.put("ID_USUARIO", ic.rs.getString("ID_USUARIO"));
                objGestion.put("GESTION", ic.rs.getString("GESTION"));
                objGestion.put("DURACION", ic.rs.getString("DURACION"));
                objGestion.put("RETASO", ic.rs.getString("RETASO"));
                objGestion.put("ID_PUESTO", ic.rs.getString("ID_PUESTO"));
                objGestion.put("PROMESA", ic.rs.getString("PROMESA"));
                objGestion.put("F_PREDICTIVO", ic.rs.getString("F_PREDICTIVO"));
                objGestion.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                listGestion.add(objGestion);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return listGestion.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer las gestiones de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_pagos_cuenta(String cuenta, String fecha_inico) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_convenios_cuenta(String cuenta) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "call azteca_convenios_cuenta('" + cuenta + "');";
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
                objConvenio.put("ID_USUARIO", ic.rs.getString("ID_USUARIO"));
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

            return listConvenios.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_cuenta_siguiente(String id_usuario) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "SELECT * FROM azteca_base_genenral_original ORDER BY RAND() LIMIT 1;";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));
                objCuenta.put("CLIENTE_UNICO", ic.rs.getString("CLIENTE_UNICO"));
                objCuenta.put("NOMBRE_CTE", ic.rs.getString("NOMBRE_CTE"));
                objCuenta.put("CUADRANTE", ic.rs.getString("CUADRANTE"));
                objCuenta.put("ZONA_GEO", ic.rs.getString("ZONA_GEO"));
                objCuenta.put("RFC_CTE", ic.rs.getString("RFC_CTE"));
                objCuenta.put("ID_DESPACHO", ic.rs.getString("ID_DESPACHO"));
                objCuenta.put("DIRECCION_CTE", ic.rs.getString("DIRECCION_CTE"));
                objCuenta.put("NUM_EXT_CTE", ic.rs.getString("NUM_EXT_CTE"));
                objCuenta.put("NUM_INT_CTE", ic.rs.getString("NUM_INT_CTE"));
                objCuenta.put("CP_CTE", ic.rs.getString("CP_CTE"));
                objCuenta.put("COLONIA_CTE", ic.rs.getString("COLONIA_CTE"));
                objCuenta.put("POBLACION_CTE", ic.rs.getString("POBLACION_CTE"));
                objCuenta.put("ESTADO_CTE", ic.rs.getString("ESTADO_CTE"));
                objCuenta.put("CLASIFICACION_CTE", ic.rs.getString("CLASIFICACION_CTE"));
                objCuenta.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objCuenta.put("SALDO", ic.rs.getString("SALDO"));
                objCuenta.put("MORATORIOS", ic.rs.getString("MORATORIOS"));
                objCuenta.put("SALDO_TOTAL", ic.rs.getString("SALDO_TOTAL"));
                objCuenta.put("DIA_DE_PAGO", ic.rs.getString("DIA_DE_PAGO"));
                objCuenta.put("FECHA_ULTIMO_PAGO", ic.rs.getString("FECHA_ULTIMO_PAGO"));
                objCuenta.put("ANO", ic.rs.getString("ANO"));
                objCuenta.put("IMP_ULTIMO_PAGO", ic.rs.getString("IMP_ULTIMO_PAGO"));
                objCuenta.put("CALLE_EMPLEO", ic.rs.getString("CALLE_EMPLEO"));
                objCuenta.put("NUM_EXT_EMPLEO", ic.rs.getString("NUM_EXT_EMPLEO"));
                objCuenta.put("NUM_INT_EMPLEO", ic.rs.getString("NUM_INT_EMPLEO"));
                objCuenta.put("COLONIA_EMPLEO", ic.rs.getString("COLONIA_EMPLEO"));
                objCuenta.put("POBLACION_EMPLEO", ic.rs.getString("POBLACION_EMPLEO"));
                objCuenta.put("ESTADO_EMPLEO", ic.rs.getString("ESTADO_EMPLEO"));
                objCuenta.put("NOMBRE_AVAL", ic.rs.getString("NOMBRE_AVAL"));
                objCuenta.put("TELAVAL", ic.rs.getString("TELAVAL"));
                objCuenta.put("CALLEAVAL", ic.rs.getString("CALLEAVAL"));
                objCuenta.put("NUMEXTAVAL", ic.rs.getString("NUMEXTAVAL"));
                objCuenta.put("COLONIAAVAL", ic.rs.getString("COLONIAAVAL"));
                objCuenta.put("CPAVAL", ic.rs.getString("CPAVAL"));
                objCuenta.put("POBLACIONAVAL", ic.rs.getString("POBLACIONAVAL"));
                objCuenta.put("ESTADOAVAL", ic.rs.getString("ESTADOAVAL"));
                objCuenta.put("DIA_PAGO", ic.rs.getString("DIA_PAGO"));
                objCuenta.put("TELEFONO1", ic.rs.getString("TELEFONO1"));
                objCuenta.put("TIPOTEL1", ic.rs.getString("TIPOTEL1"));
                objCuenta.put("TELEFONO2", ic.rs.getString("TELEFONO2"));
                objCuenta.put("TIPOTEL2", ic.rs.getString("TIPOTEL2"));
                objCuenta.put("TELEFONO3", ic.rs.getString("TELEFONO3"));
                objCuenta.put("TIPOTEL3", ic.rs.getString("TIPOTEL3"));
                objCuenta.put("TELEFONO4", ic.rs.getString("TELEFONO4"));
                objCuenta.put("TIPOTEL4", ic.rs.getString("TIPOTEL4"));
                objCuenta.put("MIGRADO_A_CYBER", ic.rs.getString("MIGRADO_A_CYBER"));
                objCuenta.put("LATITUD", ic.rs.getString("LATITUD"));
                objCuenta.put("LONGITUD", ic.rs.getString("LONGITUD"));
                objCuenta.put("GERENCIA", ic.rs.getString("GERENCIA"));
                objCuenta.put("GERENTE", ic.rs.getString("GERENTE"));
                objCuenta.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                objCuenta.put("CAMPANIA", ic.rs.getString("CAMPANIA"));
                objCuenta.put("IDENTIFICADOR", ic.rs.getString("IDENTIFICADOR"));
                objCuenta.put("CANAL", ic.rs.getString("CANAL"));
                objCuenta.put("EDAD", ic.rs.getString("EDAD"));
                objCuenta.put("SCORE", ic.rs.getString("SCORE"));
                objCuenta.put("RANGO", ic.rs.getString("RANGO"));
                objCuenta.put("RANGO_DE_EDAD", ic.rs.getString("RANGO_DE_EDAD"));
                objCuenta.put("IDENTIFICADOR2", ic.rs.getString("IDENTIFICADOR2"));
                objCuenta.put("ID_EQUIPO", ic.rs.getString("ID_EQUIPO"));
                objCuenta.put("ID_ESTATUS_CUENTA", ic.rs.getString("ID_ESTATUS_CUENTA"));
                objCuenta.put("ID_ESTATUS_LLAMADA", ic.rs.getString("ID_ESTATUS_LLAMADA"));
                objCuenta.put("ID_SUCURSAL", ic.rs.getString("ID_SUCURSAL"));
                objCuenta.put("ID_CLIENTE", ic.rs.getString("ID_CLIENTE"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            System.out.println(objCuenta.toString());
            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta siguiente azteca Code Error: " + e;
        }
    }

    public static String insertar_convenio(String objConvenio) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(objConvenio);

            Object _CONVENIO = jsonObject.get("CONVENIO");
            Object _FECHA = jsonObject.get("FECHA");
            Object _ID_USUARIO = jsonObject.get("ID_USUARIO");
            Object _CUENTA = jsonObject.get("CUENTA");
            Object _TERRITORIO = jsonObject.get("TERRITORIO");
            Object _CANAL = jsonObject.get("CANAL");
            Object _ATRASO_MAXIMO = jsonObject.get("ATRASO_MAXIMO");
            Object _ID_EQUIPO = jsonObject.get("ID_EQUIPO");

            StartConexion ic = new StartConexion();
            String sql = "CALL azteca_insert_convenio( " + _CONVENIO + ", '" + _FECHA + "', " + _ID_USUARIO + ", '" + _CUENTA + "', '" + _TERRITORIO + "', '" + _CANAL + "' , " + _ATRASO_MAXIMO + ", " + _ID_EQUIPO + ");";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            // response
            JSONObject objResp = new JSONObject();
            while (ic.rs.next()) {
                objResp.put("response", ic.rs.getString("response"));

            }

            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return objResp.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al insertar datos de gestion Code Error: " + e;
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(ModelGestor.class.getName()).log(Level.SEVERE, null, ex);
            return "SQL: Falla en el parser de JSONObject";
        }
    }

    public static String select_saldos_gestores(String id_usuario, String id_equipo) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_cuentas_de_estaus(String id_equipo, String estatus, String id_usuario) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

    public static String select_llamadas_gestor(String id_usuario) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));

            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();

            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }

}
