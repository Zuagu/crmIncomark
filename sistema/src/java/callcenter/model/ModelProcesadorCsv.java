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
            String sql = "LOAD DATA LOCAL INFILE '" + dirFile + "' INTO TABLE BASEGENERAL_BANCO_AZTECA_TEMPORAL \n"
                    + "FIELDS TERMINATED BY ',' \n"
                    + "LINES TERMINATED BY '\\n' \n"
                    + "IGNORE 1 ROWS (@col1, @col2, @col3, @col4, @col5, @col6, @col7, @col8, @col9, @col10,\n"
                    + "@col11, @col12, @col13, @col14, @col15, @col16, @col17, @col18, @col19, @col20,\n"
                    + "@col21, @col22, @col23, @col24, @col25, @col26, @col27, @col28, @col29, @col30,\n"
                    + "@col31, @col32, @col33, @col34, @col35, @col36, @col37, @col38, @col39, @col40,\n"
                    + "@col41, @col42, @col43, @col44) \n"
                    + "set\n"
                    + "cliente_id=@col1,PLAN=@col2,STATUS=@col3,GRUPO=@col4,NOMBRE=@col5,\n"
                    + "EDAD=@col6,RANGO_DE_EDAD=@col7,ATRASO_MAXIMO=@col8,ETAPA=@col9,SCORE=@col10,\n"
                    + "SALDO=@col11,RANGO=@col12,MORATORIOS=@col13,SALDO_TOTAL=@col14,ZONA=@col15,\n"
                    + "REGION=@col16,GERENCIA=@col17,DIA_DE_PAGO=@col18,PRODUCTO=@col19,MICRO=@col20,\n"
                    + "ITALIKA=@col21,CANAL=@col22,FECHA_PAGO=@col23,ANO_PAGO=@col24,IMPORTE=@col25,\n"
                    + "AVAL=@col26,NOMBRE_AVAL=@col27,MIGRADO_A_CYBER=@col28,CUADRANTE=@col29,ZONA_GEO=@col30,\n"
                    + "RFC=@col31,TEL_AVAL=@col32,TIPO_TEL_AVAL=@col33,TEL1=@col34,TIPO1=@col35,\n"
                    + "TEL2=@col36,TIPO2=@col37,TEL3=@col38,TIPO3=@col39,TEL4=@col40,\n"
                    + "TIPO4=@col41,FECHA_INICIO=@col42,FECHA_RETIRO=@col3243,FECHA_REINGRESO=@col44;";
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
