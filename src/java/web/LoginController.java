/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sukanya
 */
@Named
@RequestScoped
public class LoginController extends AbstractController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @NotNull(message = "No username?  Seriously?")
    private String username;
    @NotNull(message = "No password?  Really?")
    @Size(min = 1, message = "Password must be at least 1 character in length.")
    private String password;

    public LoginController() {
    }

    @PostConstruct
    private void postConstruct() {
        super.postContruct();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemoteUser(){
        return facesContext.getExternalContext().getRemoteUser();
    }
    
    public boolean isAdmin() {
        return facesContext.getExternalContext().isUserInRole("admin");
    }

    public boolean isStudent() {
        return facesContext.getExternalContext().isUserInRole("stud");
    }

    public boolean isTeacher() {
        return facesContext.getExternalContext().isUserInRole("tech");
    }

    public String getPortalPathByRole() {
        if (isAdmin()) {
            return "/admin";
        } else if (isStudent()) {
            return "/studentPortal";
        } else if (isTeacher()) {
            return "/teacherPortal";
        } else {
            return "/";
        }
    }

    public String doLogin() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            req.login(username, password);
        } catch (ServletException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            facesContext.addMessage(null, new FacesMessage("Bad Login", "Detail: You made a bad login!"));
            return "/login.xhtml";
        }

        return getPortalPathByRole() + "/welcome.xhtml";
    }

    public String doLogout() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();

        try {
            req.logout();
        } catch (ServletException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            facesContext.addMessage(null, new FacesMessage("Bad Logout", "Bad Logout"));
            return "/error.xhtml";
        }

        return "/login.xhtml";
    }

}
