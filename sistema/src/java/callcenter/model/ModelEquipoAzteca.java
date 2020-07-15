/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.model;

import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Emmanuel Medina
 */
public class ModelEquipoAzteca {
    
    public static String select_equipos() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call azteca_select_equipo();";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray equipos = new JSONArray();
            // ID_EQUIPO, EQUIPO, DESCRIPCION, CUENTAS, IMPORTE
            while (inicioConexion.rs.next()) {
                JSONObject equipo = new JSONObject();
                equipo.put("ID_EQUIPO", inicioConexion.rs.getInt("ID_EQUIPO"));
                equipo.put("EQUIPO", inicioConexion.rs.getString("EQUIPO"));
                equipo.put("DESCRIPCION", inicioConexion.rs.getString("DESCRIPCION"));
                equipo.put("CUENTAS", inicioConexion.rs.getString("CUENTAS"));
                equipo.put("IMPORTE", inicioConexion.rs.getString("IMPORTE"));
                equipos.add(equipo);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipos.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }
    
}
