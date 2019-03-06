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

@WebServlet(name = "credit", urlPatterns = {"/credit"})
public class Credit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            String amount = request.getParameter("amount");
            String dues = request.getParameter("dues");
            String interest = request.getParameter("interest");
            
            double _amount = Double.parseDouble(amount);
            long _dues_quantity = Long.parseLong(dues);
            double _interest = Double.parseDouble(interest);
            
            double new_total_1 = 0;
            long _dues = 0;
            long total_1 = 0;
            long total_2 = 0;
            long acumulado = 0;
            long new_amount = 0;
            
            new_total_1 = (_amount * _interest) / 100;
            total_1 = (long) new_total_1;
            new_amount = (long) _amount;
            
            total_2 = total_1 + new_amount;
            _dues = total_2 / _dues_quantity;

            ArrayList duesArray = new ArrayList();
            ArrayList balanceArray = new ArrayList();
            ArrayList duePositionArray = new ArrayList();
            ArrayList inverseArray = new ArrayList();

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

            request.setAttribute("duesArray", duesArray);
            request.setAttribute("balanceArray", balanceArray);
            request.setAttribute("duePositionArray", duePositionArray);
            request.setAttribute("inverseArray", inverseArray);

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
