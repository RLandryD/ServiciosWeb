/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author win 10
 */
@Stateless
@LocalBean
public class sumaBean {

    public int sumaBean (int a, int b){
        System.out.println(a+b);
        return (a + b);
    }
}
