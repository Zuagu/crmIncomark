package callcenter.model;

import java.sql.SQLException;

/**
 *
 * @author zuagu
 */
public class ModelProcesadorCsv {

    public static String cargar_base_azteca(String dirFile) {
        try {

            StartConexion ic = new StartConexion();
            String sql = "LOAD DATA LOCAL INFILE ' + dirFile + ' INTO TABLE basegeneral_banco_azteca_temporal \n"
                    + "FIELDS TERMINATED BY ',' \n"
                    + "LINES TERMINATED BY '\\\\n' \n"
                    + "IGNORE 1 ROWS (@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10,\n"
                    + "@col11, @col12, @col13, @col14, @col15, @col16, @col17, @col18, @col19, @col20,\n"
                    + "@col21, @col22, @col23, @col24, @col25, @col26, @col27, @col28, @col29, @col30,\n"
                    + "@col31, @col32, @col33, @col34, @col35, @col36, @col37, @col38, @col39, @col40,\n"
                    + "@col41, @col42, @col43, @col44, @col45, @col46, @col47, @col48, @col49, @col50),\n"
                    + "@col51, @col52, @col53, @col54, @col55, @col55, @col57, @col58, @col59, @col60)\n"
                    + "set \n"
                    + "CLIENTE_UNICO=col1,\n"
                    + "NOMBRE_CTE=col2,\n"
                    + "CUADRANTE=col3,\n"
                    + "ZONA_GEO=col4,\n"
                    + "RFC_CTE=col5,\n"
                    + "ID_DESPACHO=col6,\n"
                    + "DIRECCION_CTE=col7,\n"
                    + "NUM_EXT_CTE=col8,\n"
                    + "NUM_INT_CTE=col9,\n"
                    + "CP_CTE=col10,\n"
                    + "COLONIA_CTE=col11,\n"
                    + "POBLACION_CTE=col12,\n"
                    + "ESTADO_CTE=col13,\n"
                    + "CLASIFICACION_CTE=col14,\n"
                    + "ATRASO_MAXIMO=col15,\n"
                    + "SALDO=col16,\n"
                    + "MORATORIOS=col17,\n"
                    + "SALDO_TOTAL=col18,\n"
                    + "DIA_DE_PAGO=col19,\n"
                    + "FECHA_ULTIMO_PAGO=col20,\n"
                    + "ANO=col21,\n"
                    + "IMP_ULTIMO_PAGO=col22,\n"
                    + "CALLE_EMPLEO=col23,\n"
                    + "NUM_EXT_EMPLEO=col24,\n"
                    + "NUM_INT_EMPLEO=col25,\n"
                    + "COLONIA_EMPLEO=col26,\n"
                    + "POBLACION_EMPLEO=col27,\n"
                    + "ESTADO_EMPLEO=col28,\n"
                    + "NOMBRE_AVAL=col29,\n"
                    + "TELAVAL=col30,\n"
                    + "CALLEAVAL=col31,\n"
                    + "NUMEXTAVAL=col32,\n"
                    + "COLONIAAVAL=col33,\n"
                    + "CPAVAL=col34,\n"
                    + "POBLACIONAVAL=col35,\n"
                    + "ESTADOAVAL=col36,\n"
                    + "DIA_PAGO=col37,\n"
                    + "TELEFONO1=col38,\n"
                    + "TIPOTEL1=col39,\n"
                    + "TELEFONO2=col40,\n"
                    + "TIPOTEL2=col41,\n"
                    + "TELEFONO3=col42,\n"
                    + "TIPOTEL3=col43,\n"
                    + "TELEFONO4=col44,\n"
                    + "TIPOTEL4=col45,\n"
                    + "MIGRADO_A_CYBER=col46,\n"
                    + "LATITUD=col47,\n"
                    + "LONGITUD=col48,\n"
                    + "GERENCIA=col49,\n"
                    + "GERENTE=col50,\n"
                    + "TERRITORIO=col51,\n"
                    + "CAMPANIA=col52,\n"
                    + "IDENTIFICADOR=col53,\n"
                    + "CANAL=col54,\n"
                    + "EDAD=col55,\n"
                    + "SCORE=col56,\n"
                    + "RANGO=col57,\n"
                    + "RANGO_DE_EDAD=col58,\n"
                    + "IDENTIFICADOR2=col59;";
            System.out.println(sql);
            ic.st.executeUpdate(sql);

            ic.st.close();
            ic.conn.close();
            return "La base a sido cargada corectamente";
        } catch (SQLException e) {
            return "SQL: Error al ingresar los datos del CSV a la tabla Code Error: " + e;
        }
    }

}
