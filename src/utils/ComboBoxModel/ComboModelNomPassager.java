/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.ComboBoxModel;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Axel
 */
public class ComboModelNomPassager extends AbstractListModel implements ComboBoxModel {
  
  List<String> ComputerComps ;

  String selection = null;

    public ComboModelNomPassager(List<String>  ComputerComps) {
        this.ComputerComps = ComputerComps;
    }

    public void setComputerComps(List<String>  ComputerComps) {
        this.ComputerComps = ComputerComps;
    }

  public Object getElementAt(int index) {
    return ComputerComps.get(index);
  }

  public int getSize() {
    return ComputerComps.size();
  }

  public void setSelectedItem(Object anItem) {
    selection = (String) anItem; // to select and register an
  } // item from the pull-down list

  // Methods implemented from the interface ComboBoxModel
  public Object getSelectedItem() {
    return selection; // to add the selection to the combo box
  }

    
}
