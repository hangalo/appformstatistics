/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi.bean;

import dao.StatisticaDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.StatisticaOrdinis;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author informatica
 */
@Named(value = "statisticaOrdinisBean")
@SessionScoped
public class StatisticaOrdinisBean implements Serializable {

    private List<StatisticaOrdinis> statisticaOrdinis = new ArrayList<>();
     private List<StatisticaOrdinis> statisticaNewOrdinis = new ArrayList<>();
    StatisticaDAO dao = new StatisticaDAO();
    
    @PostConstruct
    public void postInit() {
        statisticaOrdinis = dao.findAll();
        this.statisticaOrdinis.add(new StatisticaOrdinis());
    }

    public List<StatisticaOrdinis> getStatisticaOrdinis() {
        return statisticaOrdinis;
    }

    public void setStatisticaOrdinis(List<StatisticaOrdinis> statisticaOrdinis) {
        this.statisticaOrdinis = statisticaOrdinis;
    }

    public List<StatisticaOrdinis> getStatisticaNewOrdinis() {
        return statisticaNewOrdinis;
    }

    public void setStatisticaNewOrdinis(List<StatisticaOrdinis> statisticaNewOrdinis) {
        this.statisticaNewOrdinis = statisticaNewOrdinis;
    }
    
    
    
    
    public String saveStatistics() {
      
       
        


        for (StatisticaOrdinis st : statisticaOrdinis) {
           
            dao.save(st);
        }
        statisticaOrdinis.clear();
        statisticaOrdinis = null;
        FacesMessage msg = new FacesMessage("Detagli Salvati com sucesso", ">>>>>>" );
        FacesContext.getCurrentInstance().addMessage(null, msg);

        //  JSFUtil.refresh();
        return null;

    }
    

    public void onRowEdit(RowEditEvent<StatisticaOrdinis> event) {
        FacesMessage msg = new FacesMessage("Car Edited", event.getObject().getAnno().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<StatisticaOrdinis> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getAnno().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void newLine(ActionEvent actionEvent) {
        this.statisticaOrdinis.add(new StatisticaOrdinis());
    }

    public String getEpiscopiPerpetui() {
        int total = 0;
        for (StatisticaOrdinis st : getStatisticaOrdinis()) {
            if (st.getEpiscopi() != null) {

                total += st.getEpiscopi();
            }

        }
        return new DecimalFormat("###,###.###").format(total);

    }

    public String getSacerdotesPerpetui() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getSacerdotiProfPerp() != null) {
                total += st.getSacerdotiProfPerp();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }

    public String getDiaconiPermanentePerpetui() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getDiacPermProfPerp() != null) {
                total += st.getDiacPermProfPerp();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }

    public String getDiaconiTranseuntesPerpetui() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getDiacTransProfPerp() != null) {
                total += st.getDiacTransProfPerp();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }

    public String getLaiciPerpetui() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getLaiciProfPerp() != null) {
                total += st.getLaiciProfPerp();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }

    
     
     
     
     //TEMPORANEI
    
    
    
     public String getSacerdotesTemporanei() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getSacerdotiProfTemp() != null) {
                total += st.getSacerdotiProfTemp();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }

    public String getDiaconiPermanenteTemporanei() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getDiacPermProfTemp() != null) {
                total += st.getDiacPermProfTemp();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }

    public String getDiaconiTranseuntesTemporanei() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getDiacTransProfTemp() != null) {
                total += st.getDiacTransProfTemp();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }

    public String getLaiciTemporanei() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getLaiciProfTemp() != null) {
                total += st.getLaiciProfTemp();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }

   // 	Non professi	
    
      public String getNovicii() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getNovicii() != null) {
                total += st.getNovicii();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }
      
       public String getPostulantes() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getPostulantes() != null) {
                total += st.getPostulantes();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }
       
       
        public String getTertiariiPerpetui() {
        int total = 0;

        for (StatisticaOrdinis st : statisticaOrdinis) {

            if (st.getTertiariiPerpetui() != null) {
                total += st.getTertiariiPerpetui();
            }
        }

        return new DecimalFormat("###,###.###").format(total);
    }
}
