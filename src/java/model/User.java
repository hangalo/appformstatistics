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
public class User {
    private Integer idUser;
    private String login;
    private String password;
    private String nome;
    private String cognome;
    private Circoscrizioni circoscrizioni;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    
    
    
    public Circoscrizioni getCircoscrizioni() {
        return circoscrizioni;
    }

    public void setCircoscrizioni(Circoscrizioni circoscrizioni) {
        this.circoscrizioni = circoscrizioni;
    }
    
    
    
}
