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
import models.Departemen;
import models.Karyawan;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/updateServlet"})
public class UpdateServlet extends HttpServlet {

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
        String id = request.getParameter("id");
        String nama = request.getParameter("nama");
        String telp = request.getParameter("telp");
        String mail = request.getParameter("mail");
        String tgl = request.getParameter("tgl");
        String dept = request.getParameter("dept");
        String man = request.getParameter("man");
        String sisa = request.getParameter("sisa");
        String banyak = request.getParameter("banyak");
        String  photo = request.getParameter("photo");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//            GeneralController<Karyawan> ic = new GeneralController<Karyawan>(sessionFactory, Karyawan.class);           
//            Karyawan karyawan = ic.getById("10001"); 
//            GeneralController<Departemen> generalDept = new GeneralController(sessionFactory, Departemen.class);
//            Departemen d = generalDept.getById(new Integer("200"));
            String message = "Gagal Update";

            GeneralController<Karyawan> generalController = new GeneralController(sessionFactory, Karyawan.class);
//        
        Karyawan k = generalController.getById("10004");
//        System.out.println(k.getAwalGabung());
//        
//        System.out.println("update");
        GeneralController<Departemen> generalDept = new GeneralController(sessionFactory, Departemen.class);
        Departemen d = generalDept.getById(new Integer("200"));
                    out.print("1"+k+" - "+nama +" - "+telp +" - "+mail +" - "+ tgl +" - "+ dept +" - "+man +" - "+
                        sisa +" - "+ banyak +" - "+
                        photo +" - "+
                        d);
//                    k = new Karyawan("10003", nama, telp, mail, new Date(tgl), man, null,
//                        new Integer(sisa), new Integer(banyak), 
//                        new byte[100], 
//                        d);
//                    generalController.saveOrUpdate(k);
//                k = new Karyawan("10004", nama, telp, mail, new Date(tgl), man, null,
//                        new Integer(sisa), new Integer(banyak), 
//                        new byte[new Integer(photo)], 
//                        d);
//        k = new Karyawan("10004", "Eko Siswadya", "085725123234", "eks12@gmail.com",
//                    new Date("09/01/2018"), "10000", "qwerty456", 10, 10, new byte [100],d);
        //k.setIdDepartemen(new Departemen(100));
                    out.print(generalController.saveOrUpdate(k));
        
//            if(karyawan==null){
//                karyawan = new Karyawan("10001", nama, telp, mail, new Date(tgl), man, null,
//                        new Integer(sisa), new Integer(banyak), 
//                        new byte[new Integer(photo)], 
//                        d);
//                out.print("2"+id+" - "+nama +" - "+telp +" - "+mail +" - "+ tgl +" - "+ dept +" - "+man +" - "+
//                        sisa +" - "+ banyak +" - "+
//                        photo +" - "+
//                        d);
////            karyawan = new Karyawan("10000", "Eksis", "085725101243", "eksiwanto25@gmail.com",
////                    new Date("09/01/2018"), "10000", "qwerty123", 10, 10, new byte [100],d);
//            if(ic.saveOrUpdate(karyawan))
//                 out.print("3"+id+" - "+nama +" - "+telp +" - "+mail +" - "+ tgl +" - "+ dept +" - "+man +" - "+
//                        sisa +" - "+ banyak +" - "+
//                        photo +" - "+
//                        d);
//                out.print(ic.saveOrUpdate(karyawan));message = "sukses update/save";}
////                session.setAttribute("pesan", message);
////                dispatcher = request.getRequestDispatcher("./karyawan");
////                dispatcher.forward(request, response);
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
