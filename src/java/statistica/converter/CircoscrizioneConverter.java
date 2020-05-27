/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistica.converter;

import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import javax.faces.convert.Converter;
import model.Circoscrizioni;

/**
 *
 * @author informatica
 */
@FacesConverter(value = "circoscrizioneConverter")
public class CircoscrizioneConverter  implements Converter{
      private static Map<String, Circoscrizioni> mapa = new HashMap<String, Circoscrizioni>();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
               return mapa.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Circoscrizioni) {
            Circoscrizioni f = (Circoscrizioni) value;
            mapa.put(String.valueOf(f.getIdCircoscrizione()), f);
             return String.valueOf(f.getIdCircoscrizione());
        } else {
            return "";
        }
    }
}
