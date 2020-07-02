package callcenter.model;

import java.sql.SQLException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

/**
 *
 * @author zuagu
 */
public class ModelUsuario {

    //==========================================================================
    public static int iniciar_sesion(int id_perfil, int id_usuario, String password, String ip) {
        try {
            StartConexion inicioConexion = new StartConexion();
            int resultado = 0;
            String sql = "call sic_iniciar_sesion_con_ip('" + id_perfil + "','" + id_usuario + "', '" + password + "', '" + ip + "');";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                resultado = Integer.parseInt(inicioConexion.rs.getString("resultado"));
            }
            inicioConexion.conn.close();
            inicioConexion.rs.close();
            inicioConexion.st.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    //==========================================================================
    public static void cerrar_sesion(int id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            int resultado = 0;
            String sql = "call sic_cerrar_sesion(" + id_usuario + ");";
            System.out.println(sql);
            inicioConexion.st.executeQuery(sql);

            inicioConexion.conn.close();
            inicioConexion.st.close();
//            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex);
//            return 0;
        }
    }
    //==========================================================================

    public static String jsp_puesto(int id_empleado) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String sql = "call sic_jsp_puesto(" + id_empleado + ");";
            String resultado = "";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            if (inicioConexion.rs.next()) {
                resultado = inicioConexion.rs.getString("resultado");
            }

            inicioConexion.rs.close();
            inicioConexion.st.close();
            inicioConexion.conn.close();
//            System.out.println(resultado);
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    /* ====================================================================== */
    public static String cargar_menu(int id_perfil, int id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String resultado = "";
            String sql = "call cargar_menu(" + id_perfil + "," + id_usuario + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                resultado = inicioConexion.rs.getString("resultado");
            }
            inicioConexion.conn.close();
            inicioConexion.rs.close();
            inicioConexion.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String id_puesto(int id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String resultado = "";
            String sql = "select id_puesto_usuario(" + id_usuario + ");";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                resultado = inicioConexion.rs.getString(1);
            }
            inicioConexion.conn.close();
            inicioConexion.rs.close();
            inicioConexion.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String id_puesto2(int id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String resultado = "";
            String sql = "select id_puesto2 from arcade_usuarios where id = " + id_usuario + ";";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                resultado = inicioConexion.rs.getString(1);
            }
            inicioConexion.conn.close();
            inicioConexion.rs.close();
            inicioConexion.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String id_puesto3(int id_usuario) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String resultado = "";
            String sql = "select id_puesto3 from arcade_usuarios where id = " + id_usuario + ";";
//            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            while (inicioConexion.rs.next()) {
                resultado = inicioConexion.rs.getString(1);
            }
            inicioConexion.conn.close();
            inicioConexion.rs.close();
            inicioConexion.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_usuarios_cargo(int puesto, int puesto2, int puesto3) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String cadena_puesto = puesto + "," + puesto2 + "," + puesto3 ;
            
            String sql = "select u.id, u.nombre from arcade_usuarios u\n"
                    + "left join sic_puestos p on (u.id_puesto = p.id_puesto or u.id_puesto2 = p.id_puesto or u.id_puesto3 = p.id_puesto)\n"
                    + "where p.id_padre in (" + cadena_puesto + ") and p.id_padre != 0;";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray gestores = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject gestor = new JSONObject();
                gestor.put("id", inicioConexion.rs.getInt("id"));
                gestor.put("nombre", inicioConexion.rs.getString("nombre"));
                gestores.add(gestor);
            }
            inicioConexion.conn.close();
            inicioConexion.rs.close();
            inicioConexion.st.close();
            return gestores.toJSONString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================
    //==========================================================================
    public static String select_usuarios_cargo_filtro(int puesto, int puesto2, int puesto3, String filtro) {
        try {
            StartConexion inicioConexion = new StartConexion();
            String cadena_puesto = puesto + "," + puesto2 + "," + puesto3 ;
            
            String sql = "select u.id, u.nombre from arcade_usuarios u\n"
                    + "left join sic_puestos p on (u.id_puesto = p.id_puesto or u.id_puesto2 = p.id_puesto or u.id_puesto3 = p.id_puesto)\n"
                    + "where p.id_padre in (" + cadena_puesto + ") and p.id_padre != 0 and (u.id like '%"+ filtro +"%' or u.nombre like '%"+ filtro +"%');";
            System.out.println(sql);
            inicioConexion.rs = inicioConexion.st.executeQuery(sql);
            JSONArray gestores = new JSONArray();
            while (inicioConexion.rs.next()) {
                JSONObject gestor = new JSONObject();
                gestor.put("id", inicioConexion.rs.getInt("id"));
                gestor.put("nombre", inicioConexion.rs.getString("nombre"));
                gestores.add(gestor);
            }
            inicioConexion.conn.close();
            inicioConexion.rs.close();
            inicioConexion.st.close();
            return gestores.toJSONString();
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================
}
