/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.nerdexception.managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author slacky
 */
@ManagedBean(name = "navigationController")
@RequestScoped
public class NavigationController implements Serializable {
    
    private static final long serialVersionUID = 1L;
	
    @ManagedProperty(value="#{param.pageId}")
    private String pageId;   
   
    //process
    public String processPage1(){
            return "page";
    }

    public String processPage2(){
            return "page";
    }

    //generic
    public String showPage() {
        if (pageId == null) {
            return "home";
        }		
        if (pageId.equals("3")) {
                return "page3";
        } else if (pageId.equals("4")) {
                return "page4";
        } else if (pageId.equals("5")) {
                return "page5";
        }else if (pageId.equals("6")) {
                System.err.println("CAZZO");
                return "page6";
        } else {
                return "home";
        }
    }
    
    //getter setter
    public String getPageId() {
            return pageId;
    }

    public void setPageId(String pageId) {
            this.pageId = pageId;
    }
         
}