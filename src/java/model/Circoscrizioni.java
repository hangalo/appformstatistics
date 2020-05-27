/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    public String toString() {
        return this.nomeLatino;
    }
	
    
}
