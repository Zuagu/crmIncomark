package arcade.data;

import java.sql.SQLException;

/* @author Luis Cortez */
public class MenuDao {
    /* ====================================================================== */

    public static String cargar_menu(int id_perfil, int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_cargar_menu(" + id_perfil + "," + id_usuario + ");";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================
}