<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        <div id="elementos">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Producto</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="lista" varStatus="status">
                        <tr>
                            <td class="left">${lista.id}</td>
                            <td>${lista.nombre}</td>
                            <td>${lista.precio}</td>
                            <td>
                                <a href="#" onclick="enviar_datos('${lista.id}');">
                                    Eliminar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
        </div>
    </body>
</html>