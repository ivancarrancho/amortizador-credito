/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "credit", urlPatterns = {"/credit"})
public class Credit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession misession= (HttpSession) request.getSession();
        Producto miproducto= (Producto) misession.getAttribute("producto");
        PrintWriter pw= response.getWriter();
        pw.println("<html><body>"+ miproducto.getId()+ "," +miproducto.getConcepto()+","+ miproducto.getImporte());
        pw.close();
        
        try (PrintWriter out = response.getWriter()) {

            String amount = request.getParameter("amount");
            int _amount = Integer.parseInt(amount);
            int result = 0;
            
            result = (int) (Math.random() * 9);
            
            ArrayList duesArray = new ArrayList();
            ArrayList balanceArray = new ArrayList();
            ArrayList duePositionArray = new ArrayList();
            ArrayList inverseArray = new ArrayList();

            /*
            for (int i = 1; i <= _dues_quantity; i++) {
                acumulado = acumulado + _dues;
                duesArray.add(_dues);
                inverseArray.add(acumulado);
                balanceArray.add(total_2);
                duePositionArray.add(i);
                total_2 = total_2 - _dues;
            }

            request.setAttribute("_dues_quantity", _dues_quantity);
            request.setAttribute("_dues", _dues);
            request.setAttribute("new_amount", new_amount);
            */
            request.setAttribute("duesArray", duesArray);
            request.setAttribute("balanceArray", balanceArray);
            request.setAttribute("duePositionArray", duePositionArray);
            request.setAttribute("inverseArray", inverseArray);

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
