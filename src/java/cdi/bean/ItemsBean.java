/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author informatica
 */
@Named(value = "itemsBean")
@ViewScoped
public class ItemsBean implements Serializable{

  private List<String> items = new ArrayList<>();
  private String selectedItem;
    
    public ItemsBean() {
    }
    
 
  @PostConstruct
  public void postInit() {
      items.add("Watch");
      items.add("Bottle");
      items.add("Book");
      items.add("Radio");
  }
  
   public String getSelectedItem() {
      return selectedItem;
  }

  public void setSelectedItem(String selectedItem) {
      this.selectedItem = selectedItem;
  }

  public List<String> getItems() {
      return items;
  }
    
}
