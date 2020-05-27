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
public class StatisticaOrdinis {
        private Integer idStatistica;
	private Integer anno;
	private Boolean corrente;
	//private Integer idCircoDomicilio;
        private Circoscrizioni circoscrizioni;
	private String tipoAppartenenza;
	private Integer iDCircoAppartenenza;
	private Integer IdNazione;
	private Integer domii;
	private Integer episcopi;
	private Integer sacerdotiProfPerp;
	private Integer sacerdotiProfTemp;
	private Integer diacPermProfPerp;
	private Integer diacPermProfTemp;
	private Integer diacTransProfPerp;
	private Integer diacTransProfTemp;
	private Integer laiciProfPerp;
	private Integer laiciProfTemp;
	private Integer novicii;
	private Integer postulantes;
	private Integer tertiariiPerpetui;
	private Integer seminaristi;

    public StatisticaOrdinis() {
    }

    public Integer getIdStatistica() {
        return idStatistica;
    }

    public void setIdStatistica(Integer idStatistica) {
        this.idStatistica = idStatistica;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public Boolean getCorrente() {
        return corrente;
    }

    public void setCorrente(Boolean corrente) {
        this.corrente = corrente;
    }
/*
    public Integer getIdCircoDomicilio() {
        return idCircoDomicilio;
    }

    public void setIdCircoDomicilio(Integer idCircoDomicilio) {
        this.idCircoDomicilio = idCircoDomicilio;
    }*/

    public Circoscrizioni getCircoscrizioni() {
        return circoscrizioni;
    }

    public void setCircoscrizioni(Circoscrizioni circoscrizioni) {
        this.circoscrizioni = circoscrizioni;
    }
    
    

    public String getTipoAppartenenza() {
        return tipoAppartenenza;
    }

    public void setTipoAppartenenza(String tipoAppartenenza) {
        this.tipoAppartenenza = tipoAppartenenza;
    }

    public Integer getiDCircoAppartenenza() {
        return iDCircoAppartenenza;
    }

    public void setiDCircoAppartenenza(Integer iDCircoAppartenenza) {
        this.iDCircoAppartenenza = iDCircoAppartenenza;
    }

    public Integer getIdNazione() {
        return IdNazione;
    }

    public void setIdNazione(Integer IdNazione) {
        this.IdNazione = IdNazione;
    }

    public Integer getDomii() {
        return domii;
    }

    public void setDomii(Integer domii) {
        this.domii = domii;
    }

    public Integer getEpiscopi() {
        return episcopi;
    }

    public void setEpiscopi(Integer episcopi) {
        this.episcopi = episcopi;
    }

    public Integer getSacerdotiProfPerp() {
        return sacerdotiProfPerp;
    }

    public void setSacerdotiProfPerp(Integer sacerdotiProfPerp) {
        this.sacerdotiProfPerp = sacerdotiProfPerp;
    }

    public Integer getSacerdotiProfTemp() {
        return sacerdotiProfTemp;
    }

    public void setSacerdotiProfTemp(Integer sacerdotiProfTemp) {
        this.sacerdotiProfTemp = sacerdotiProfTemp;
    }

    public Integer getDiacPermProfPerp() {
        return diacPermProfPerp;
    }

    public void setDiacPermProfPerp(Integer diacPermProfPerp) {
        this.diacPermProfPerp = diacPermProfPerp;
    }

    public Integer getDiacPermProfTemp() {
        return diacPermProfTemp;
    }

    public void setDiacPermProfTemp(Integer diacPermProfTemp) {
        this.diacPermProfTemp = diacPermProfTemp;
    }

    public Integer getDiacTransProfPerp() {
        return diacTransProfPerp;
    }

    public void setDiacTransProfPerp(Integer diacTransProfPerp) {
        this.diacTransProfPerp = diacTransProfPerp;
    }

    public Integer getDiacTransProfTemp() {
        return diacTransProfTemp;
    }

    public void setDiacTransProfTemp(Integer diacTransProfTemp) {
        this.diacTransProfTemp = diacTransProfTemp;
    }

    public Integer getLaiciProfPerp() {
        return laiciProfPerp;
    }

    public void setLaiciProfPerp(Integer laiciProfPerp) {
        this.laiciProfPerp = laiciProfPerp;
    }

    public Integer getLaiciProfTemp() {
        return laiciProfTemp;
    }

    public void setLaiciProfTemp(Integer laiciProfTemp) {
        this.laiciProfTemp = laiciProfTemp;
    }

    public Integer getNovicii() {
        return novicii;
    }

    public void setNovicii(Integer novicii) {
        this.novicii = novicii;
    }

    public Integer getPostulantes() {
        return postulantes;
    }

    public void setPostulantes(Integer postulantes) {
        this.postulantes = postulantes;
    }

    public Integer getTertiariiPerpetui() {
        return tertiariiPerpetui;
    }

    public void setTertiariiPerpetui(Integer tertiariiPerpetui) {
        this.tertiariiPerpetui = tertiariiPerpetui;
    }

    public Integer getSeminaristi() {
        return seminaristi;
    }

    public void setSeminaristi(Integer seminaristi) {
        this.seminaristi = seminaristi;
    }
        
}
