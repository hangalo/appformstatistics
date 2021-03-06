/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi.bean;

import model.Circoscrizioni;
import dao.StatisticaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author informatica
 */
@Named(value = "circoscrizioniBean")
@ViewScoped
public class CircoscrizioniBean implements Serializable{

    List<Circoscrizioni> circoscrizionis = new ArrayList<>();
    
    StatisticaDAO dao = new StatisticaDAO();

    @PostConstruct
    public void postInit() {
       
    }

    public List<Circoscrizioni> getCircoscrizionis() {
        return circoscrizionis;
    }

    public void setCircoscrizionis(List<Circoscrizioni> circoscrizionis) {
        this.circoscrizionis = circoscrizionis;
    }
    
    
    
       public List<SelectItem> getSelectCircoscrizionis() {
        List<SelectItem> items = new ArrayList<>();
        for (Circoscrizioni c : dao.findAllCircoscrizioni()) {

            items.add(new SelectItem(c, c.getNomeItaliano()));
        }

        return items;
    }
    
}
