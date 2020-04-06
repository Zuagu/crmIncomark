
package arcade.controller;

import arcade.data.MenuDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//==============================================================================
/* @author ARCADE Software Group® */
//==============================================================================



public class ManageMenu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
//==============================================================================
        if ("cargar_menu".equals(accion)) {
            String renglon = MenuDao.cargar_menu(
                    Integer.parseInt(request.getParameter("id_perfil")),
                    Integer.parseInt(request.getParameter("id_usuario"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglon);
            writer.flush();
            writer.close();

        }
//==============================================================================
    } /* FIN DEL METODO ManageMenu2 (ACCIONES)*/

} /* FIN DEL SERVLET*/
