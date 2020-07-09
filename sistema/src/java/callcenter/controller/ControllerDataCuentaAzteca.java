/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callcenter.controller;

import callcenter.model.ModelDataCuentaAzteca;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emmanuel Medina
 */
public class ControllerDataCuentaAzteca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        System.out.println(action);
        
        if(action.equals("datos_cuenta_azteca")) {
            String Respuesta = ModelDataCuentaAzteca.datosCuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_buscar_cuentas")) {
            String Respuesta = ModelDataCuentaAzteca.select_buscar_cuentas(
                    request.getParameter("busqueda"),
                    Integer.parseInt(request.getParameter("id_puesto"))
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_datos_cuenta_relacionada")) {
            String Respuesta = ModelDataCuentaAzteca.select_datos_cuenta_relacionada(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_telefonos_cr")) {
            String Respuesta = ModelDataCuentaAzteca.select_telefonos_cr(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_gestiones_cuenta")) {
            String Respuesta = ModelDataCuentaAzteca.select_gestiones_cuenta(
                    request.getParameter("cuenta"),
                    request.getParameter("fecha_inico")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_pagos_cuenta")) {
            String Respuesta = ModelDataCuentaAzteca.select_pagos_cuenta(
                    request.getParameter("cuenta"),
                    request.getParameter("fecha_inico")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_convenios_cuenta")) {
            String Respuesta = ModelDataCuentaAzteca.select_convenios_cuenta(
                    request.getParameter("cuenta")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_cuenta_siguiente")) {
            String Respuesta = ModelDataCuentaAzteca.select_cuenta_siguiente(
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
            
        } else if (action.equals("guardar_gestion")) {
            String Respuesta = ModelDataCuentaAzteca.guardarGestion(
                    request.getParameter("datos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("insertar_convenio")) {
            String Respuesta = ModelDataCuentaAzteca.insertar_convenio(
                    request.getParameter("datos")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
            
        } else if (action.equals("select_saldos_gestores")) {
            String Respuesta = ModelDataCuentaAzteca.select_saldos_gestores(
                    request.getParameter("id_usuario"),
                    request.getParameter("id_equipo")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_cuentas_de_estaus")) {
            String Respuesta = ModelDataCuentaAzteca.select_cuentas_de_estaus(
                    request.getParameter("id_equipo"),
                    request.getParameter("id_status"),
                    request.getParameter("id_usuario")
            );
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(Respuesta);
            writer.flush();
            writer.close();
        } else if (action.equals("select_llamadas_gestor")) {
            String Respuesta = ModelDataCuentaAzteca.select_llamadas_gestor(
                    request.getParameter("id_usuario")
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
