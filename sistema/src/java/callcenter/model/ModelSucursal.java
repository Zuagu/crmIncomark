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
 * @author zuagu
 */
public class ModelSucursal {
    public static String select_sucursales() {
        try {

            StartConexion ic = new StartConexion();
            String sql = "select * from arcade_sucursales where f_deleted = 0";
            System.out.println(sql);
            ic.rs = ic.st.executeQuery(sql);
            JSONArray listSucrusales = new JSONArray();
            // GESTOR, CUENTA, NOMBRE, GERENTE, ESTATUS_LLAMADA, CONVENIO, PAGOS, FECHA, ESTATUS_PAGO, FECHA_PAGO
            while (ic.rs.next()) {
                JSONObject objSucursal = new JSONObject();
                objSucursal.put("id_sucursal", ic.rs.getString("id_sucursal"));
                objSucursal.put("sucursal", ic.rs.getString("sucursal"));
                objSucursal.put("f_deleted", ic.rs.getString("f_deleted"));
                listSucrusales.add(objSucursal);
            }
            ic.rs.close();
            ic.st.close();
            ic.conn.close();
            return listSucrusales.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al traer los datos de la cuenta azteca Code Error: " + e;
        }
    }
    public static String deleted_sucursales(String id_sucursal) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "update arcade_sucursales set f_deleted = 1 where id_sucursal = '"+id_sucursal+"';";
            System.out.println(sql);
            ic.st.executeUpdate(sql);
            JSONObject objSucursal = new JSONObject();
            objSucursal.put("message", "Sucursal eliminado");
            ic.st.close();
            ic.conn.close();
            return objSucursal.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al eliminar azteca Code Error: " + e;
        }
    }
    public static String agregar_sucursal(String nombre_sucursal) {
        try {
            StartConexion ic = new StartConexion();
            String sql = "insert into arcade_sucursales(sucursal, f_deleted) values('" + nombre_sucursal + "',0);";
            System.out.println(sql);
            ic.st.executeUpdate(sql);
            JSONObject objSucursal = new JSONObject();
            objSucursal.put("message", "Sucursal Agregado");
            ic.st.close();
            ic.conn.close();
            return objSucursal.toJSONString();
        } catch (SQLException e) {
            return "SQL: Error al insertar azteca Code Error: " + e;
        }
    }
}
