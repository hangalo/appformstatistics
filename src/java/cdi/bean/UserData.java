/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author informatica
 */
@Named(value = "userData")
@SessionScoped
public class UserData implements Serializable {

    private String data = "1";

    /**
     * Creates a new instance of UserData
     */
    public UserData() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
