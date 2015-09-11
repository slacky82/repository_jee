/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.nerdexception.managedbeans;

import it.nerdexception.util.Util;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 *
 * @author slacky
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class UserLogin implements Serializable {
    
    private String userName;
    private String password;
    
    private String loggedUserId;
    
    public String login(){
        if (checkLogin()) {
            HttpSession session = Util.getSession();
            session.setAttribute("username", userName);
            setLoggedUserId(userName);
            return "index.xhtml?faces-redirect";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Incorrect Username and Passowrd",
                        "Please enter correct username and Password"));
        return "login";
        }
    } 
    
    public void logout() {
        
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.invalidateSession();            
            ec.redirect(ec.getRequestContextPath() + "/login.xhtml");           
        } catch (Exception ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);           
        }       
    }
    
    private boolean checkLogin(){       
         return "fabrizio".equals(userName);                 
    }
    

    
    //getter setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 

    public String getLoggedUserId() {
        return loggedUserId;
    }

    public void setLoggedUserId(String loggedUserId) {
        this.loggedUserId = loggedUserId;
    }
    
    
}
