/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelDataCuentaAxtel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zuagu
 */
public class ControllerDataCuentaAxtel extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Usamos el metodo del get para generar la pantalla del predictivo
        String cuenta = request.getParameter("cuenta");

        String telefono = request.getParameter("telefono");
        String id_usuario = request.getParameter("id_usuario");
        System.out.println("cuenta: " + cuenta + " id_usuario: " + id_usuario + " telefono: " + telefono);

        request.setAttribute("telefono", telefono);
        request.setAttribute("id_usuario", id_usuario);
        request.setAttribute("cuenta", cuenta);
        getServletContext().getRequestDispatcher("/predictivo_axtel.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
//        System.out.println(action);
        if (action.equals("datos_cuenta_axtel")) {
            String Respuesta = ModelDataCuentaAxtel.datosCuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("guardarGestion")) {
            String Respuesta = ModelDataCuentaAxtel.guardarGestion(
                    request.getParameter("")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_buscar_cuentas")) {
            String Respuesta = ModelDataCuentaAxtel.select_buscar_cuentas(
                    request.getParameter(""),
                    Integer.parseInt(request.getParameter(""))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_gestiones_cuenta")) {
            String Respuesta = ModelDataCuentaAxtel.select_gestiones_cuenta(
                    request.getParameter(""),
                    request.getParameter("")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_convenios_cuenta")) {
            String Respuesta = ModelDataCuentaAxtel.select_convenios_cuenta(
                    request.getParameter("")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("insertar_convenio")) {
            String Respuesta = ModelDataCuentaAxtel.insertar_convenio(
                    request.getParameter("")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
