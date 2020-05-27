/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.User;

/**
 *
 * @author informatica
 */
@Named(value = "userLoged")
@SessionScoped
public class UserLoged implements Serializable {

   private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   
    
}
