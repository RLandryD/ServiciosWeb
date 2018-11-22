/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author win 10
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of prueba.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String gethtml(@QueryParam("bgGrados") String convertir, @QueryParam("sctGrados") String sctGrados) {
        //TODO return proper representation object
        double nGrados = 0.0;
        Double objGrados = null;
        
        try{
            nGrados = Double.parseDouble(sctGrados);
            if (convertir.compareTo("aFahr") == 0)
                    {
                        nGrados = 9.0    / 5.0  * nGrados + 32.0;
                    }
                    if (convertir.compareTo("aCent") == 0)
                    {
                        nGrados = ((nGrados - 32.0) * 5.0) / 9.0;
                    }
                    //Mostrar el resultado en la caja de texto
                    objGrados = nGrados;
                    
                } catch (NumberFormatException ex)
                {
                    System.out.println("Dato Grados incorrectos");
            } catch (Exception ex){
                System.out.println(ex.getMessage());
        }
        
        return objGrados.toString();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void puthtml(String content) {
    }
}
