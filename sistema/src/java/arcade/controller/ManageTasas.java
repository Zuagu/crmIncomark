//==============================================================================
package arcade.controller;
//==============================================================================

import arcade.data.TasaDao;
//==============================================================================
import java.io.IOException;
import java.io.PrintWriter;
//==============================================================================
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//==============================================================================
/* @author Luis Cortez */
//==============================================================================

public class ManageTasas extends HttpServlet {
//==============================================================================

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
//==============================================================================

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //======================================================================
        String accion = request.getParameter("accion");
        //======================================================================
        if ("select_tasas_combo".equals(accion)) {
            String renglones = TasaDao.select_tasas_combo();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(renglones);
            writer.flush();
            writer.close();
        }
        //======================================================================
    }
}
