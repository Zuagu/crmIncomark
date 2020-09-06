/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelReportesAzteca;
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
public class ControllerReportesAzteca extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        System.out.println(action);
        
        if(action.equals("reporte_gestiones_tabla")) {
            String Respuesta = ModelReportesAzteca.reporte_gestiones_tabla(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("territorio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("azteca_reporte_convenios")) {
            String Respuesta = ModelReportesAzteca.reporte_convenios_tabla(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("territorio")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_options_territorios")) {
            String Respuesta = ModelReportesAzteca.select_options_territorios();
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("azteca_reporte_pagos")) {
            String Respuesta = ModelReportesAzteca.azteca_reporte_pagos(
                    request.getParameter("desde"),
                    request.getParameter("hasta"),
                    request.getParameter("zona")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        }
        else if (action.equals("select_options_zona")) {
            String Respuesta = ModelReportesAzteca.select_options_zona();
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
