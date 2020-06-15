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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Circoscrizioni;
import model.Frate;
import model.Nazione;

/**
 *
 * @author informatica
 */
@Named(value = "frateCDIBean")
@SessionScoped
public class FrateCDIBean implements Serializable {

    Frate frate = new Frate();
    FrateDAO frateDAO = new FrateDAO();
    private Circoscrizioni circoscrizioni = new Circoscrizioni();
    private List<Frate> fratesByCircoscrizione = new ArrayList<>();
    private Nazione nazione = new Nazione();

    @PostConstruct
    public void init() {

    }

    public FrateCDIBean() {
    }

    public String save() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String idCircoscrzione = (String) map.get("circo");

      //  frateDAO.save(frate);
        frate = new Frate();
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucess"+idCircoscrzione, "Sucess"));
        return "frate_registro";

    }

    /*   fratesByCircoscrizione = frateDAO.findFrateByCircoDomicilio(user.getCircoscrizioni().getIdCircoscrizione());*/
    public Frate getFrate() {
        return frate;
    }

    public void setFrate(Frate frate) {
        this.frate = frate;
    }

    public Circoscrizioni getCircoscrizioni() {
        return circoscrizioni;
    }

    public void setCircoscrizioni(Circoscrizioni circoscrizioni) {
        this.circoscrizioni = circoscrizioni;
    }

    public Nazione getNazione() {
        return nazione;
    }

    public void setNazione(Nazione nazione) {
        this.nazione = nazione;
    }

    public List<Frate> getFratesByCircoscrizione() {
        return fratesByCircoscrizione;
    }

    public void setFratesByCircoscrizione(List<Frate> fratesByCircoscrizione) {
        this.fratesByCircoscrizione = fratesByCircoscrizione;
    }

    public void dataTableFrateListener(ActionEvent event) {
        String title = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("circo");

        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Update Lista" + title, "Lista UPA"));
    }

}
