/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.view;

import edunova.model.Grupe;
import java.util.Comparator;

/**
 *
 * @author jbalog8
 */
public class GrupaComparator implements Comparator<Grupe>  {

    @Override
    public int compare(Grupe o1, Grupe o2) {
         Integer prvi = o1.getPolaznici() == null ? 0 : o1.getPolaznici().size();
        Integer drugi = o2.getPolaznici() == null ? 0 : o2.getPolaznici().size();
        return drugi.compareTo(prvi);
    }
    
    
}
