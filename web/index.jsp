<%-- 
    Document   : index
    Created on : 26/02/2019, 01:26:44 PM
    Author     : EAlonso
--%>
<%@page import="java.util.Iterator"%>
<%@page import="radial.radiales"%> 
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
    <body>

        <div class="row">
            <div class="col col-md"></div>
            <div class="col-10 col-md-10">
                <form action="radiales" method="get">
                    <br>
                    <div class="form-group"><h2>Calcular y amortizar crédito</h2></div>
                    <div class="form-group">
                        <label>Monto del crédito: </label>
                        <input type="number" class="form-control" name="amount" min="0" max="5000000000">
                        <label>Número de cuotas:</label>
                        <input type="number" class="form-control" name="dues" min="1" max="500">
                        <label>Interés (%): </label>
                        <input type="number" class="form-control" name="interest" min="1" max="100">
                    </div>

                    <input type="submit" class="btn btn-success" value="Enviar">
                </form>
                <br>

                <c:if test="${_amount != null}">
                    <div class="centered">
                        <p>Para un crédito de $<b>${_amount}</b> diferido en <b>${_dues_quantity}</b> cuotas, se debe pagar cada cuota de $<b>${_dues}</b></p>
                    </div>
                </c:if>
            </div>
            <div class="col col-md"></div>
        </div>
        
        <table class="table table-bordered table-striped" style="margin-top: 40px;">
            <thead>
                <tr class="filters">
                    <th>Cuota No.</th>
                    <th>Valor de las cuotas</th>
                    <th>Deuda</th>

                </tr> 
            <tbody>
                <tr>
                    <td>
                        <c:forEach items="${duePositionArray}" var="item">
                            ${item} <br>
                        </c:forEach>
                    </td>
                    <td>

                        <c:forEach items="${duesArray}" var="item">
                            ${item} <br>
                        </c:forEach>
                    </td>
                    <td>

                        <c:forEach items="${balanceArray}" var="item">
                            ${item} <br>
                        </c:forEach>

                    </td>
                </tr>
            </tbody>
        </table>
</html>