/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package urban.sales;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

/**
 *
 * @author vicky
 */
public class JpanelLoader {
    
    public void jPanelLoader(JPanel Main,JPanel setPanel){
    Main.removeAll();
    
      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(Main);
      Main.setLayout(layout);
      layout.setHorizontalGroup(
       layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        
       .addComponent(setPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.DEFAULT_SIZE)
       
       );
      layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              

        .addComponent(setPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.DEFAULT_SIZE)
         
              );
      
      System.gc();
      
      
    }
}
