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
import java.util.Random;
import java.util.Vector;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");
        
        HttpSession s =request.getSession();
        
        int loginAttempt;
        int result;
        
        if (s.getAttribute("loginCount") == null) {
            s.setAttribute("loginCount", 1);
            loginAttempt = (Integer) s.getAttribute("loginCount");
            Random random = new Random();
            result = random.nextInt(9);            
            s.setAttribute("result", result);
        }else {
            loginAttempt = (Integer) s.getAttribute("loginCount");
            result = (Integer) s.getAttribute("result");
            s.setAttribute("loginCount",loginAttempt++);
        } 
        
        int _amount = Integer.parseInt(amount);
        boolean resp = false;
    
        if (loginAttempt <= 3){
            if (_amount == result) {
                resp = true;
                s.setAttribute("resp", resp);
                s.setAttribute("_amount", _amount);                                      
                s.setAttribute("result", result);                                      
                s.setAttribute("loginCount",loginAttempt++);
                System.out.println(s.getAttribute("loginCount"));
                
            }else{
                resp = false;
                s.setAttribute("loginCount",loginAttempt++);
                s.setAttribute("resp", resp);     
                s.setAttribute("result", result);
                s.setAttribute("_amount", _amount);                   
                System.out.println(s.getAttribute("loginCount"));
            }
        }else{
            resp = false;
            s.setAttribute("loginCount",loginAttempt++);
            s.setAttribute("resp", resp);
            s.setAttribute("result", result);
            s.setAttribute("_amount", _amount);                 
            s.removeAttribute("loginCount");
        }
        
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
