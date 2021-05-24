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
 * @author zuagu
 */
public class ModelVacantes {
    //==========================================================================
    public static String azteca_select_requerimetos_campo() {
        try {
            StartConexion ic = new StartConexion();
            String sql = "CALL azteca_select_requerimetos_campo()";
            System.out.println(sql);
            
            ic.rs = ic.st.executeQuery(sql);
            
            JSONArray vacantes = new JSONArray();
            // TERRITORIO, LOCALIDAD_V, CANTIDAD, SALDO_TOTAL, RESULTADO_NA, RESULTADO_AP, RESULTADO_CCERRADOR, CARTEROS, NOTIFICADOR, CERRADOR
            while (ic.rs.next()) {
                JSONObject newObj = new JSONObject();
                newObj.put("TERRITORIO", ic.rs.getString("TERRITORIO"));
                newObj.put("LOCALIDAD_V", ic.rs.getString("LOCALIDAD_V"));
                newObj.put("CANTIDAD", ic.rs.getString("CANTIDAD"));
                newObj.put("SALDO_TOTAL", ic.rs.getString("SALDO_TOTAL"));
                newObj.put("RESULTADO_NA", ic.rs.getString("RESULTADO_NA"));
                newObj.put("val_RESULTADO_NA", ic.rs.getString("val_RESULTADO_NA"));
                newObj.put("RESULTADO_AP", ic.rs.getString("RESULTADO_AP"));
                newObj.put("val_RESULTADO_AP", ic.rs.getString("val_RESULTADO_AP"));
                newObj.put("RESULTADO_CCERRADOR", ic.rs.getString("RESULTADO_CCERRADOR"));
                newObj.put("val_RESULTADO_CCERRADOR", ic.rs.getString("val_RESULTADO_CCERRADOR"));
                newObj.put("CARTEROS", ic.rs.getString("CARTEROS"));
                newObj.put("NOTIFICADOR", ic.rs.getString("NOTIFICADOR"));
                newObj.put("CERRADOR", ic.rs.getString("CERRADOR"));
                vacantes.add(newObj);
                
            }
            ic.conn.close();
            ic.rs.close();
            ic.st.close();
            return vacantes.toJSONString();
        } catch (SQLException ex) {
            System.out.println(ex);
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + ex;
        }
    }
}
