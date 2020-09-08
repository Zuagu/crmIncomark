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

    public static String select_usarios_equipo(String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT id, nombre\n"
                    + "	FROM arcade_usuarios \n"
                    + "    where \n"
                    + "		id_equipo1 = " + id_equipo + "\n"
                    + "		or id_equipo2 = " + id_equipo + "\n"
                    + "		or id_equipo3 = " + id_equipo + "\n"
                    + "		or id_equipo4 = " + id_equipo + "\n"
                    + "		or id_equipo5 = " + id_equipo + "\n"
                    + "    and f_active = 1";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray usuarios = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                JSONObject usuario = new JSONObject();
                usuario.put("id", inicioConexion.rs.getInt("id"));
                usuario.put("nombre", inicioConexion.rs.getString("nombre"));
                usuarios.add(usuario);
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return usuarios.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String agregar_gestor_a_equipo(String id_gestor, String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "CALL azteca_agregar_gestor_a_equipo(" + id_gestor + ", " + id_equipo + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject equipo = new JSONObject();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                equipo.put("response", inicioConexion.rs.getString("response"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipo.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String eliminar_gestor_de_equipo(String id_gestor, String id_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "CALL azteca_eliminar_gestor_a_equipo(" + id_gestor + ", " + id_equipo + ");";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONObject equipo = new JSONObject();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                equipo.put("response", inicioConexion.rs.getString("response"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipo.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_territorio_options() {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT TERRITORIO FROM azteca_base_genenral_original GROUP BY TERRITORIO;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray gerencia = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                gerencia.add(inicioConexion.rs.getString("TERRITORIO"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gerencia.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_gerente_options(String territorio) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT GERENTE FROM azteca_base_genenral_original WHERE TERRITORIO IN("+ territorio.replace("\"", "'") +") GROUP BY GERENTE;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray gerencia = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                gerencia.add(inicioConexion.rs.getString("GERENTE"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gerencia.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String select_etapas_options(String territorio, String gerente) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "SELECT ETAPA FROM azteca_base_genenral_original WHERE TERRITORIO IN ("+territorio+") AND GERENTE IN ("+gerente+") GROUP BY ETAPA;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);

            JSONArray gerencia = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                gerencia.add(inicioConexion.rs.getString("ETAPA"));
            }
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gerencia.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String crear_equipo(String nombre_equipo) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "INSERT INTO azteca_equipos(NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE) VALUES('" + nombre_equipo + "', 0, 0.00, '', 0);";
            System.out.println(sql);

            inicioConexion.st.executeUpdate(sql);

            JSONObject equipo = new JSONObject();
            equipo.put("resultado", "Equipo Creado");

            inicioConexion.st.close();
            inicioConexion.conn.close();

            return equipo.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

    public static String agregar_cuentas_equipo(String territorios, String gerentes, String etapa) {
        try {
            StartConexion inicioConexion = new StartConexion();
            
            String sql_ob_equi_max = "SELECT ID_EQUIPO FROM azteca_equipos order by ID_EQUIPO desc limit 1;";
            int id_max = 0; 
            System.out.println(sql_ob_equi_max);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql_ob_equi_max);

            JSONArray gerencia = new JSONArray();
            // ID_EQUIPO, NOMBRE_EQUIPO, CUENTAS, VALOR, DESCRIPCION, F_DELETE
            while (inicioConexion.rs.next()) {
                id_max = inicioConexion.rs.getInt("ID_EQUIPO");
            }
            
            System.out.println(id_max);
            
            String sql = "UPDATE azteca_base_genenral_original SET \n"
                    + "ID_EQUIPO = "+ id_max +"\n"
                    + "WHERE TERRITORIO IN (" + territorios.replace("\"", "'") + ") \n"
                    + "	AND GERENTE IN (" + gerentes.replace("\"", "'") + ") \n"
                    + "    AND ETAPA IN (" + etapa.replace("\"", "'") + ");";
            System.out.println(sql);
            inicioConexion.st.executeUpdate(sql);
            
            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();

            return gerencia.toString();
        } catch (SQLException e) {
            return "sql code" + e;
        }
    }

}
