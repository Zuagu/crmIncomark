/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

import java.sql.SQLException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author Emmanuel Medina
 */
public class ModelDataCuentaAzteca {

    public static String datosCuenta() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "select * from basegeneral_banco_azteca_temporal where cliente_id = '1 - 6 - 8052 - 812';";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONObject objCuenta = new JSONObject();
            while (ic.rs.next()) {
                objCuenta.put("id_cuenta", ic.rs.getInt("id_cuenta"));
                objCuenta.put("cliente_id", ic.rs.getString("cliente_id"));
                objCuenta.put("PLAN", ic.rs.getString("PLAN"));
                objCuenta.put("STATUS", ic.rs.getString("STATUS"));
                objCuenta.put("GRUPO", ic.rs.getString("GRUPO"));
                objCuenta.put("NOMBRE", ic.rs.getString("NOMBRE"));
                objCuenta.put("EDAD", ic.rs.getString("EDAD"));
                objCuenta.put("RANGO_DE_EDAD", ic.rs.getString("RANGO_DE_EDAD"));
                objCuenta.put("ATRASO_MAXIMO", ic.rs.getString("ATRASO_MAXIMO"));
                objCuenta.put("ETAPA", ic.rs.getString("ETAPA"));
                objCuenta.put("SCORE", ic.rs.getString("SCORE"));
                objCuenta.put("SALDO", ic.rs.getString("SALDO"));
                objCuenta.put("RANGO", ic.rs.getString("RANGO"));
                objCuenta.put("MORATORIOS", ic.rs.getString("MORATORIOS"));
                objCuenta.put("SALDO_TOTAL", ic.rs.getString("SALDO_TOTAL"));
                objCuenta.put("ZONA", ic.rs.getString("ZONA"));
                objCuenta.put("REGION", ic.rs.getString("REGION"));
                objCuenta.put("GERENCIA", ic.rs.getString("GERENCIA"));
                objCuenta.put("DIA_DE_PAGO", ic.rs.getString("DIA_DE_PAGO"));
                objCuenta.put("PRODUCTO", ic.rs.getString("PRODUCTO"));
                objCuenta.put("MICRO", ic.rs.getString("MICRO"));
                objCuenta.put("ITALIKA", ic.rs.getString("ITALIKA"));
                objCuenta.put("CANAL", ic.rs.getString("CANAL"));
                objCuenta.put("FECHA_PAGO", ic.rs.getString("FECHA_PAGO"));
                objCuenta.put("ANO_PAGO", ic.rs.getString("ANO_PAGO"));
                objCuenta.put("IMPORTE", ic.rs.getString("IMPORTE"));
                objCuenta.put("AVAL", ic.rs.getString("AVAL"));
                objCuenta.put("NOMBRE_AVAL", ic.rs.getString("NOMBRE_AVAL"));
                objCuenta.put("MIGRADO_A_CYBER", ic.rs.getString("MIGRADO_A_CYBER"));
                objCuenta.put("CUADRANTE", ic.rs.getString("CUADRANTE"));
                objCuenta.put("ZONA_GEO", ic.rs.getString("ZONA_GEO"));
                objCuenta.put("RFC", ic.rs.getString("RFC"));
                objCuenta.put("TEL_AVAL", ic.rs.getString("TEL_AVAL"));
                objCuenta.put("TIPO_TEL_AVAL", ic.rs.getString("TIPO_TEL_AVAL"));
                objCuenta.put("TEL1", ic.rs.getString("TEL1"));
                objCuenta.put("TIPO1", ic.rs.getString("TIPO1"));
                objCuenta.put("TEL2", ic.rs.getString("TEL2"));
                objCuenta.put("TIPO2", ic.rs.getString("TIPO2"));
                objCuenta.put("TEL3", ic.rs.getString("TEL3"));
                objCuenta.put("TIPO3", ic.rs.getString("TIPO3"));
                objCuenta.put("TEL4", ic.rs.getString("TEL4"));
                objCuenta.put("TIPO4", ic.rs.getString("TIPO4"));
                objCuenta.put("FECHA_INICIO", ic.rs.getString("FECHA_INICIO"));
                objCuenta.put("FECHA_RETIRO", ic.rs.getString("FECHA_RETIRO"));
                objCuenta.put("FECHA_REINGRESO", ic.rs.getString("FECHA_REINGRESO"));
                objCuenta.put("IDENTIFICADOR", ic.rs.getString("IDENTIFICADOR"));
            }
            System.out.println(objCuenta.toString());
            return objCuenta.toString();
        } catch (SQLException e) {
            return "SQL: Error al ingresar los datos del CSV a la tabla Code Error: " + e;
        }
    }

}
