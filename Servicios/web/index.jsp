<%-- 
    Document   : index
    Created on : 14/11/2018, 12:00:41 AM
    Author     : Win 10
--%>
<%@page import="temperaturas.temperatures"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv= "Content-Type"
			content = "text/html; charset = UTF-8">
	<Title> Conversion grados C <--> F </title>
	</head>

	<body> 
	<div align = "center">
	<!-- Invocar al servicio web -->
        
        <%
            String sctGrados = request.getParameter("ctGrados");
            temperaturas.Temperatures_Service service;
            temperaturas.temperatures port = new temperaturas.temperatures();
            if (sctGrados != null && !sctGrados.isEmpty())
            {
                double nGrados = 0.0;
                
                
                try{
                    //Crear un objeto de la clase que implementa el servicio
                    service = new temperaturas .Temperatures_Service();
                    //Obtener el valor numérico escrito en la caja de texto
                    nGrados = Double.parseDouble(sctGrados);
                    //Realizar la conversión invocando al método correspondiente
                    //del objeto port de tipo SWConverTemps
                    String convertir = request.getParameter("bgGrados");
                    if (convertir.compareTo("aFahr") == 0) 
                        //Se compara que elm radiobutton seleccionado haya sido
                        //para convertir a Fahrenheit
                    {
                        nGrados = port.convCentAFahr(nGrados);
                    }
                    if (convertir.compareTo("aCent") == 0)
                        //Se compara que elm radiobutton seleccionado haya sido
                        //para convertir a Centígrados
                    {
                        nGrados = port.convFahrACent(nGrados);
                    }
                    //Mostrar el resultado en la caja de texto
                    Double objGrados = nGrados;
                    session.setAttribute("result", objGrados);
                
                } catch (NumberFormatException ex)
                {
                    //Se envía al log del servidor
                    System.out.println("Dato grados incorrecto\n");
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            %>
		<hr/>
		<form style = "font-familly:arial">
			Grados: <br>
		<input type = "text" name ="ctGrados" value ="${result}"
			style = "text-align:right" /> <br><br>

		<input type = "submit" value ="Convertir" name ="btConvertir" />
		<br><br>

		<input type = "radio" name="bgGrados" value="aFahr" checked="true" />

		Centigrados a Fahrenheit <br>

		<input type = "radio" name = "bgGrados" value ="aCent" />

		Fahrenheit a Centigrados <br>

	</form>
	<hr/>
	</div>
	</body>
</html>
