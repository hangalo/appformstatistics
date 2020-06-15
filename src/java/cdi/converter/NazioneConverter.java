/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi.converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import model.Circoscrizioni;
import model.Nazione;

/**
 *
 * @author informatica
 */
@FacesConverter(value = "nazioneConverter")
public class NazioneConverter implements Converter{
     private static Map<String, Nazione> mapa = new HashMap<String, Nazione>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Nazione) {
            Nazione c = (Nazione) value;
            mapa.put(String.valueOf(c.getIdNazione()), c);
            return String.valueOf(c.getIdNazione());
        } else {
            return "";
        }
    }
}
