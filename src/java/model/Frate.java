/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Frate {
    private Integer idFrate;
    private String nomen;
    private String cognomen;
    private String oppidum_et_natio;
    private String dioecesis;
    private String patris;
    private String matris;
    private Date nativ;
    private Date vest;
    private Date profTemp;
    private Circoscrizioni idCircoscrizione;

    public Frate() {
    }

    public Integer getIdFrate() {
        return idFrate;
    }

    public void setIdFrate(Integer idFrate) {
        this.idFrate = idFrate;
    }

    public String getNomen() {
        return nomen;
    }

    public void setNomen(String nomen) {
        this.nomen = nomen;
    }

    public String getCognomen() {
        return cognomen;
    }

    public void setCognomen(String cognomen) {
        this.cognomen = cognomen;
    }

    public String getOppidum_et_natio() {
        return oppidum_et_natio;
    }

    public void setOppidum_et_natio(String oppidum_et_natio) {
        this.oppidum_et_natio = oppidum_et_natio;
    }

    public String getDioecesis() {
        return dioecesis;
    }

    public void setDioecesis(String dioecesis) {
        this.dioecesis = dioecesis;
    }

    public String getPatris() {
        return patris;
    }

    public void setPatris(String patris) {
        this.patris = patris;
    }

    public String getMatris() {
        return matris;
    }

    public void setMatris(String matris) {
        this.matris = matris;
    }

    public Date getNativ() {
        return nativ;
    }

    public void setNativ(Date nativ) {
        this.nativ = nativ;
    }

    public Date getVest() {
        return vest;
    }

    public void setVest(Date vest) {
        this.vest = vest;
    }

    public Date getProfTemp() {
        return profTemp;
    }

    public void setProfTemp(Date profTemp) {
        this.profTemp = profTemp;
    }

   

    public Circoscrizioni getIdCircoscrizione() {
        return idCircoscrizione;
    }

    public void setIdCircoscrizione(Circoscrizioni idCircoscrizione) {
        this.idCircoscrizione = idCircoscrizione;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idFrate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Frate other = (Frate) obj;
        if (!Objects.equals(this.idFrate, other.idFrate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Frate{" + "nomen=" + nomen + ", cognomen=" + cognomen + '}';
    }
    
    
    
}
