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
import model.Nazione;

/**
 *
 * @author informatica
 */
@Named(value = "nazioneBean")
@ViewScoped
public class NazioneBean implements Serializable {

    List<Nazione> naziones = new ArrayList<>();

    StatisticaDAO dao = new StatisticaDAO();

    @PostConstruct
    public void postInit() {
        
    }

    public List<Nazione> getNaziones() {
        return naziones;
    }

    public void setNaziones(List<Nazione> naziones) {
        this.naziones = naziones;
    }

    public List<SelectItem> getSelectNaziones() {
        List<SelectItem> items = new ArrayList<>();
        for (Nazione n : dao.findAllNazioni()) {

            items.add(new SelectItem(n, n.getNomeItaliano()));
        }

        return items;
    }

}
