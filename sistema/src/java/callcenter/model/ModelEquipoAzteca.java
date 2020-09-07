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
            String sql = "SELECT * FROM azteca_equipos;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray equipos = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                JSONObject equipo = new JSONObject();
                equipo.put("ID_EQUIPO", inicioConexion.rs.getInt("ID_EQUIPO"));
                equipo.put("NOMBRE_EQUIPO", inicioConexion.rs.getString("NOMBRE_EQUIPO"));
                equipo.put("DESCRIPCION", inicioConexion.rs.getString("DESCRIPCION"));
                equipo.put("CUENTAS", inicioConexion.rs.getString("CUENTAS"));
                equipo.put("VALOR", inicioConexion.rs.getString("VALOR"));
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
    
    public static String agregar_gestor_a_equipo(String id_gestor, String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT * FROM azteca_equipos;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray equipos = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                JSONObject equipo = new JSONObject();
                equipo.put("ID_EQUIPO", inicioConexion.rs.getInt("ID_EQUIPO"));
                equipo.put("NOMBRE_EQUIPO", inicioConexion.rs.getString("NOMBRE_EQUIPO"));
                equipo.put("DESCRIPCION", inicioConexion.rs.getString("DESCRIPCION"));
                equipo.put("CUENTAS", inicioConexion.rs.getString("CUENTAS"));
                equipo.put("VALOR", inicioConexion.rs.getString("VALOR"));
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
