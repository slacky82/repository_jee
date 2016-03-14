/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.nerdexception.beans;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    public void businessMethod() {
        System.out.println("NewSessionBean says OK!!!");
    }

}
