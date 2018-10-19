/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.GeneralController;
import controller.InterfaceController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "UpdOrSavePermohonan", urlPatterns = {"/updOrSavePermohonan"})
public class UpdOrSavePermohonan extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                String getIdnya = request.getParameter("id");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            InterfaceController<Permohonan> ic = new GeneralController<Permohonan>(sessionFactory, Permohonan.class);           
            Permohonan permohonan = (Permohonan) ic.getById(getIdnya); 
            GeneralController<Karyawan> generalKary = new GeneralController(sessionFactory, Karyawan.class);
            Karyawan karyawan = (Karyawan) ic.getById("10001");
            GeneralController<JenisCuti> generalJenis = new GeneralController(sessionFactory, JenisCuti.class);
            JenisCuti jenisCuti = (JenisCuti) ic.getById("234");
            String message = "Gagal Update";
            if(permohonan!=null){
                //permohonan = new Permohonan(getIdnya, new Date("09/01/2018"), new Date("10/01/2018"), new Date("10/02/2018"), "kebelet kawin", "w");
            if(ic.saveOrUpdate(permohonan)) message = "sukses update/save";}
                session.setAttribute("pesan", message);
                dispatcher = request.getRequestDispatcher("./permohonan");
                dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
