/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi.bean;

import dao.FrateDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import model.Frate;

/**
 *
 * @author informatica
 */
@Named(value = "frateCDIBean")
@SessionScoped
public class FrateCDIBean implements Serializable {

    Frate frate = new Frate();
    FrateDAO frateDAO = new FrateDAO();

    @PostConstruct
    public void init() {

    }

    public FrateCDIBean() {
    }

    public String save() {
        frateDAO.save(frate);
        frate = new Frate();
        return "frate_registro";

    }

    public Frate getFrate() {
        return frate;
    }

    public void setFrate(Frate frate) {
        this.frate = frate;
    }
    
    
    
}
