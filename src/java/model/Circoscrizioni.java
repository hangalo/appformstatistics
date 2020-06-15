/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author informatica
 */
public class Circoscrizioni {
    private Integer idCircoscrizione;
    private String nomeLatino;
    private String nomeItaliano;

    public Circoscrizioni() {
    }

    public Integer getIdCircoscrizione() {
        return idCircoscrizione;
    }

    public void setIdCircoscrizione(Integer idCircoscrizione) {
        this.idCircoscrizione = idCircoscrizione;
    }

    public String getNomeLatino() {
        return nomeLatino;
    }

    public void setNomeLatino(String nomeLatino) {
        this.nomeLatino = nomeLatino;
    }

    public String getNomeItaliano() {
        return nomeItaliano;
    }

    public void setNomeItaliano(String nomeItaliano) {
        this.nomeItaliano = nomeItaliano;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idCircoscrizione);
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
        final Circoscrizioni other = (Circoscrizioni) obj;
        if (!Objects.equals(this.idCircoscrizione, other.idCircoscrizione)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return this.nomeLatino;
    }
	
    
}
