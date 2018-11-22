/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperaturas;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author win 10
 */
@WebService(serviceName = "temperatures")
public class temperatures {

    //convertir grados F a C
    @WebMethod(operationName = "convFahrACent")
    public double convFahrACent(@WebParam(name="gFahr")double gFahr)
    {
        return((gFahr - 32.0)*5.0)/9.0;
    }
    //convertir grados C a F
    @WebMethod(operationName = "convCentAFahr")
    public double convCentAFahr(@WebParam(name="gCent")double gCent)
    {
        return 9.0/5.0* gCent + 32.0;
    }
}
