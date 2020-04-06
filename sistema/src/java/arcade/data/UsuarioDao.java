package arcade.data;

import arcade.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

public class UsuarioDao {

    //==========================================================================
    public static int iniciar_sesion(int id_perfil, int id_usuario, String password, String ip) {
        try {
            StartConn s = new StartConn();
            int resultado = 0;
            String sql = "call iniciar_sesion_con_ip('" + id_perfil + "','" + id_usuario + "', '" + password + "', '" + ip + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = Integer.parseInt(s.rs.getString("resultado"));
            }
            s.conn.close();
            s.rs.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    //==========================================================================
    public static String nombre_usuario(int id_usuario) {
        try {
            String resultado = "";
            StartConn s = new StartConn();
            String sql = "call arcade_nombre_usuario('" + id_usuario + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String color() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_color();";
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
    public static String franjaindex() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_franjaindex();";
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
    public static String color_menu() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_colormenu();";
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

    public static String nombre_cliente() {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_cliente();";
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

    public static String jsp_puesto(int id_empleado) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_jsp_puesto(" + id_empleado + ");";
            String resultado = "";
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================

    public static String cambiar_password(int id_perfil, int id, String password0) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_cambiar_password('" + id_perfil + "','" + id + "','" + password0 + "');";
            System.out.println(sql);
            String resultado = "";
            s.rs = s.st.executeQuery(sql);
            if (s.rs.next()) {
                resultado = s.rs.getString("resultado");
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String select_usuario_tabla() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuarios();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setSucursal(s.rs.getString("sucursal"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setSexo(s.rs.getString("sexo"));
                c.setTelefono(s.rs.getString("telefono"));
                c.setCelular(s.rs.getString("celular"));
                c.setEmail(s.rs.getString("email"));
                c.setJefe_inmediato(s.rs.getString("jefe_inmediato"));
                c.setActive(s.rs.getString("active"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table id='tabla_usuarios' class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>SUCURSAL</th>"
                    + "<th>PUESTO</th>"
                    + "<th>FECHA ALTA</th>"
                    + "<th>TELEFONO</th>"
                    + "<th>CELULAR</th>"
                    + "<th>JEFE INMEDIATO</th>"
                    + "<th>ESTATUS</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr class='usuario renglon' id='" + c.getId() + "' style='cursor: pointer;'>"
                        + "<td style='text-align:center;'>" + c.getId() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;' class='getSucursal'>" + c.getSucursal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPuesto() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_alta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getTelefono() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCelular() + "</td>"
                        + "<td>" + c.getJefe_inmediato() + "</td>"
                        + "<td>" + c.getActive() + "</td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //============================tabla_nomina==================================
    public static String select_usuario_tabla_nomina() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuarios();";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setSucursal(s.rs.getString("sucursal"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setSexo(s.rs.getString("sexo"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table id='tabla_usuarios'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>SUCURSAL</th>"
                    + "<th>PUESTO</th>"
                    + "<th>FECHA ALTA</th>"
                    + "<th>SEXO</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr id='" + c.getId() + "'>"
                        + "<td style='text-align:center;'>" + c.getId() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;'>" + c.getSucursal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPuesto() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_alta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getSexo() + "</td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_usuario_filtro(String _filtro) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuario_filtro('" + _filtro + "');";
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                c.setSucursal(s.rs.getString("sucursal"));
                c.setPuesto(s.rs.getString("puesto"));
                c.setFecha_alta(s.rs.getString("fecha_alta"));
                c.setSexo(s.rs.getString("sexo"));
                c.setTelefono(s.rs.getString("telefono"));
                c.setCelular(s.rs.getString("celular"));
                c.setEmail(s.rs.getString("email"));
                c.setJefe_inmediato(s.rs.getString("jefe_inmediato"));
                c.setActive(s.rs.getString("active"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table id='tabla_usuarios' class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "<th>SUCURSAL</th>"
                    + "<th>PUESTO</th>"
                    + "<th>FECHA ALTA</th>"
                    + "<th>TELEFONO</th>"
                    + "<th>CELULAR</th>"
                    + "<th>JEFE INMEDIATO</th>"
                    + "<th>ESTATUS</th>"
                    + "</tr></thead>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr class='usuario renglon' id='" + c.getId() + "' style='cursor: pointer;'>"
                        + "<td style='text-align:center;'>" + c.getId() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td style='text-align:center;'>" + c.getSucursal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getPuesto() + "</td>"
                        + "<td style='text-align:center;'>" + c.getFecha_alta() + "</td>"
                        + "<td style='text-align:center;'>" + c.getTelefono() + "</td>"
                        + "<td style='text-align:center;'>" + c.getCelular() + "</td>"
                        + "<td>" + c.getJefe_inmediato() + "</td>"
                        + "<td>" + c.getActive() + "</td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==============================================================================
    public static String select_usuario_combo(int f_active) {
        try {
            StartConn s = new StartConn();
            String renglones = "";
            String sql = "call arcade_select_usuario('" + f_active + "');";
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario e = new Usuario();
                e.setId(s.rs.getInt("id"));
                e.setNombre(s.rs.getString("nombre"));
                usuario.add(e);
            }
            for (Usuario c : usuario) {
                renglones += "<option value='" + c.getId() + "'>" + c.getNombre() + "</option>";
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static List<Usuario> select_usuario() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_usuario();";
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario e = new Usuario();
                e.setId(s.rs.getInt("id_usuario"));
                e.setNombre(s.rs.getString("usuario"));
                usuario.add(e);
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return usuario;
        } catch (SQLException ex) {
            return null;
        }
    }

    //==========================================================================
    public static String insert_usuario(String nombre, String alias, int id_sucursal, int id_puesto, int id_jefe_inmediato, String sexo, String telefono, String celular, String email
    ) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_insert_usuario("
                    + "'" + nombre + "',"
                    + "'" + alias + "',"
                    + "'" + id_sucursal + "',"
                    + "'" + id_puesto + "',"
                    + "'" + id_jefe_inmediato + "',"
                    + "'" + sexo + "',"
                    + "'" + telefono + "',"
                    + "'" + celular + "',"
                    + "'" + email + "'"
                    + ");";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_usuario('" + id_usuario + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String delete_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_delete_usuario('" + id_usuario + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_datos_usuario(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_select_datos_usuario('" + id_usuario + "');";
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================

    public static String update_usuario_rrhh(int id_seleccion, String d1, String d2, String d3, String d4, String d5, String d6, String d7, String d8, String d9, String d10, String d11, String contratacion, String con_contratacion) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_usuario_rrhh('" + id_seleccion + "', '" + d1 + "', '" + d2 + "', '" + d3 + "', '" + d4 + "', '" + d5 + "', '" + d6 + "', '" + d7 + "', '" + d8 + "', '" + d9 + "', '" + d10 + "','" + d11 + "','"+contratacion+"','"+con_contratacion+"');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_entrada_tabla(String fecha) {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_entrada('" + fecha + "');";
            System.out.println(sql);
            String renglones;
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id_usuario"));
                c.setId_registro(s.rs.getInt("id_registro"));
                c.setNombre(s.rs.getString("usuario"));
                c.setFecha(s.rs.getString("fecha"));
                c.setHora(s.rs.getString("hora"));
                c.setSalida(s.rs.getString("salida"));
                c.setHoras(s.rs.getString("horas"));
                c.setSucursal(s.rs.getString("sucursal"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table id='tabla_entradas' class='striped';><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th>SUCURSAL</th>"
                    + "<th style='text-align:center;'>ENTRADA</th>"
                    + "<th style='text-align:center;'>SALIDA</th>"
                    + "<th style='text-align:center;'>ID</th>"
                    + "<th style='text-align:center;'>USUARIO</th>"
                    + "<th style='text-align:center;'>TOTAL</th>"
                    + "</tr></thead><tbody>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr id='" + c.getId() + "' style='cursor: pointer;'>"
                        + "<td style='text-align:center;'>" + c.getSucursal() + "</td>"
                        + "<td style='text-align:center;'>" + c.getHora() + "</td>"
                        + "<td>" + c.getSalida() + "</td>"
                        + "<td>" + c.getId() + "</td>"
                        + "<td>" + c.getNombre() + "</td>"
                        + "<td>" + c.getHoras() + "</td>"
                        + "</tr>";
            }
            renglones += "</tbody></table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_resumen_usuario() {
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_resumen_usuario();";
            System.out.println(sql);
            String renglones = "";
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setRes_titulo(s.rs.getString("titulo"));
                c.setRes_valor(s.rs.getString("valor"));
                c.setRes_imagen(s.rs.getString("imagen"));
                usuario.add(c);
            }

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += "<div class='datagrid sombra'>"
                        + "<div style='float: left; width:26%;'>"
                        + "<img src='" + c.getRes_imagen() + "' alt='' > " // Esto que eso???? revisar mañana
                        + "</div>"
                        + "<div style='float: right;width: 74%; text-align: left; padding-top: 6px;padding-left: 7px;'>"
                        + "<span style='font-size: 1.8rem; color: #9b9999;'>" + c.getRes_titulo() + "</span>"
                        + "<br>"
                        + "<input type='text' value='" + c.getRes_valor() + "' readonly style='border: none; font-size: 3rem;'> "
                        + "</div>"
                        + "</div>";
            }

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }
    //==========================================================================

    public static String select_inactivos_tabla_filtro(String _filtro) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_user_inactive('" + _filtro + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "</tr></thead></tr>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr id='" + c.getId() + "' class='agregar_gestor renglon' style='cursor:pointer;'>"
                        + "<td style='text-align:left;'>" + c.getId() + "</td>"
                        + "<td style='text-align:left;'>" + c.getNombre() + "</td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_activos_tabla_filtro(String _filtro) {
        try {
            StartConn s = new StartConn();
            String renglones;
            String sql = "call arcade_select_user_active('" + _filtro + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setId(s.rs.getInt("id"));
                c.setNombre(s.rs.getString("nombre"));
                usuario.add(c);
            }

            renglones = ""
                    + "<table class='bordered striped highlight'><thead><tr>"
                    // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA
                    + "<th style='width: 2%'>ID</th>"
                    + "<th>NOMBRE</th>"
                    + "</tr></thead></tr>";

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                renglones += ""
                        + "<tr id='" + c.getId() + "' class='reasignar_gestor renglon' style='cursor:pointer;'>"
                        + "<td style='text-align:left;'>" + c.getId() + "</td>"
                        + "<td style='text-align:left;'>" + c.getNombre() + "</td>"
                        + "</tr>";
            }

            renglones += "</table>";

            s.rs.close();
            s.st.close();
            s.conn.close();
            return renglones;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String update_cargo(int id_usuario, int cargo) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_cargo(" + id_usuario + "," + cargo + ");";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    //==========================================================================
    // CONSULTA PARA MOD_USUARIOS SECCION ENTRADAS
    // traer datos para hacer un reporte de entradas para cada usuario de un mes
    public static String select_calendario_entradas(int id_usuario, String fecha) {
        fecha = fecha.replace(" ", "");
        System.out.println(fecha);
        try {
            StartConn s = new StartConn();
            String sql = "call arcade_select_datos_entrada_usuario('" + id_usuario + "','" + fecha + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            List<Usuario> usuario = new ArrayList<Usuario>();
            while (s.rs.next()) {
                Usuario c = new Usuario();
                // ESTOS SON LOS ENCABEZADOS DE LA COLUMNA DE LA TABLA EN MYSQL
                c.setFecha(s.rs.getString("fecha"));
                c.setDia_fech(s.rs.getInt("dia_fech"));
                c.setDia_sem(s.rs.getInt("dia_sem"));
                c.setDia(s.rs.getInt("dia"));
                c.setHora_entrada(s.rs.getString("hora_entrada"));
                c.setHora_llegada(s.rs.getString("hora_llegada"));
                c.setMes(s.rs.getString("mes"));
                c.setColor(s.rs.getString("color"));
                usuario.add(c);
            }

            String fechas = "", status = "";
            int limite = usuario.size(), i = 0;

            // CUEPRO DE LA TABLA
            for (Usuario c : usuario) {
                i++;
                String datos[] = c.getFecha().split("-");
                fechas += datos[0] + ", " + datos[1] + ", " + Integer.parseInt(datos[2]) + (limite == i ? "#corte#" : "##");
                status += c.getColor() + (limite == i ? "" : "#c#");
            }

            System.out.println(fechas);

            s.rs.close();
            s.st.close();
            s.conn.close();
            return fechas + status;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_datos_contrato(int id_usuario) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call select_datos_contrato(" + id_usuario + ");";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);
            while (s.rs.next()) {
                resultado = (s.rs.getString("resultado"));
            }
            System.out.println(resultado);
            s.rs.close();
            s.st.close();
            s.conn.close();
            return resultado;
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    public static String select_datos_carta_baja(int id) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "select * from arcade_usuarios where id = " + id + ";";
            System.out.println(sql);
            JSONObject usuario = new JSONObject();
            s.rs = s.st.executeQuery(sql);

            while (s.rs.next()) {
                usuario.put("nombre", s.rs.getString("nombre"));
                usuario.put("fecha_ingreso", s.rs.getString("fecha_ingreso"));
            }
            s.rs.close();
            s.st.close();
            s.conn.close();
            return usuario.toJSONString();
        } catch (SQLException ex) {
            return "SQL COde:" + ex;
        }
    }

    //==========================================================================
    //==========================================================================
    public static String update_chunnun(
            int id_usuario,
            boolean acta,
            boolean ife,
            boolean nss,
            boolean curp,
            boolean comp_est,
            boolean comp_dom,
            boolean cartas,
            boolean fotos,
            boolean infonavit,
            boolean rfc
    ) {
        try {
            StartConn s = new StartConn();
            String resultado = "";
            String sql = "call arcade_update_chunnun('" + id_usuario + "','" + acta + "','" + ife + "','" + nss + "','" + curp + "','" + comp_est + "','" + comp_dom + "','" + cartas + "','" + fotos + "','" + infonavit + "','" + rfc + "');";
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
            System.out.println();
            return "SQL Code: " + ex;
        }
    }

    //==========================================================================
    public static String baja_usuario(int id_usuario, int status, String fecha_baja, String comentarios) {
        try {
            StartConn s = new StartConn();
            String resultado = "asdasd";
            String sql = "call baja_usuario(" + id_usuario + ", " + status + ",'" + fecha_baja + "', '" + comentarios + "');";
            System.out.println(sql);
            s.rs = s.st.executeQuery(sql);

            s.conn.close();
            s.st.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println();
            return "SQL Code: " + ex;
        }
    }
    //==========================================================================

}
