package jaxws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author win 10
 */
@WebService(serviceName = "SWConverTemps")
public class SWConverTemps {

    
    //Convertir grados F a C
    @WebMethod(operationName = "ConvFahrACent")
    public double ConvFahrACent(@WebParam(name = "gFahr") double gFahr) {
        return ((gFahr - 32.0) * 5.0 / 9.0);
    }
    
    //Convertir grados C a F
    @WebMethod(operationName = "ConvCentAFahr")
    public double ConvCentAFahr (@WebParam(name = "gCent") double gCent){
        return 9.0 / 5.0 * gCent + 32.0;
    }
}
