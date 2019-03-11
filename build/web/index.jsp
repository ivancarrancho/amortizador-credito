<%-- 
    Document   : index
    Created on : 26/02/2019, 01:26:44 PM
    Author     : EAlonso
--%>
<%@page import="java.util.Iterator"%>
<%@page import="credit.Credit"%> 
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


    </head>
    <body style="width: 70%; margin: 0 auto;">
        <div class="col-xs-1 center-block">
            <form action="credit" method="get">
                <br>
                <div class="form-group"><h1>Adivína el número</h1></div>
                <br>
                <br>
                <div class="form-group">
                    <label><h4>Ingresa número del 0 al 9</h4> </label>
                    <input type="number" class="form-control" name="amount" min="0" max="9" required>

                </div>

                <input type="submit" class="btn btn-success" value="Enviar">
            </form>
            <br>

            <c:if test="${new_amount == true}">
                <div class="centered">
                    <p>Para un crédito de $<b>${new_amount}</b> diferido en <b>${_dues_quantity}</b> cuotas, se debe pagar cada cuota de $<b>${_dues}</b></p>
                </div>
            </c:if>


            <table class="table table-bordered table-striped centered" style="margin-top: 40px;">
                <thead>
                    <tr class="filters">
                        <th>Cuota No.</th>
                        <th>Valor de las cuotas</th>
                        <th>Deuda</th>
                        <th>Abono</th>

                    </tr> 
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:forEach items="${duePositionArray}" var="item">
                                ${item} <br>
                            </c:forEach>
                        </td>
                        <td>

                            <c:forEach items="${duesArray}" var="item">
                                $ ${item} <br>
                            </c:forEach>
                        </td>
                        <td>

                            <c:forEach items="${balanceArray}" var="item">
                                $ ${item} <br>
                            </c:forEach>

                        </td>
                        <td>

                            <c:forEach items="${inverseArray}" var="item">
                                $ ${item} <br>
                            </c:forEach>

                        </td>                    
                    </tr>
                </tbody>
            </table>
        </div>
    </body>    
</html>
