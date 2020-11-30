/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * invoice.java
 *
 * Created on May 2, 2020, 3:56:22 PM
 */
package urban.sales;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicky
 */
public class invoice extends javax.swing.JPanel {

    /** Creates new form invoice */
    public invoice() {
        initComponents();
        
        dataload();
    }

    
    
    public void dataload(){
    
        try{
    
      DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
      dt.setRowCount(0);
      
    Statement s = (Statement) db.mycon().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM sales ");  
    
    while(rs.next()){
    Vector v = new Vector();
    
    v.add(rs.getString(1));
    v.add(rs.getString(2));
    v.add(rs.getString(3));
    v.add(rs.getString(4));
    v.add(rs.getString(5));
    v.add(rs.getString(6));
    v.add(rs.getString(7));
    v.add(rs.getString(8));
    
    dt.addRow(v);
    
    }
    
    }catch(Exception e){
    System.out.println(e);
    }
        
        
    }
    
    
    public void search_para(String arg){
    
    
    try{
        
    DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
    dt.setRowCount(0);
      
    Statement s = (Statement) db.mycon().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM sales WHERE INID LIKE '%"+arg+"%' OR customer_name LIKE '%"+arg+"%' OR status = '"+arg+"'");  
    
    while(rs.next()){
    Vector v = new Vector();
    
    v.add(rs.getString(1));
    v.add(rs.getString(2));
    v.add(rs.getString(3));
    v.add(rs.getString(4));
    v.add(rs.getString(5));
    v.add(rs.getString(6));
    v.add(rs.getString(7));
    v.add(rs.getString(8));
    
    dt.addRow(v);
    
    }
    
    }catch(Exception e){
    System.out.println(e);
    dataload();
    }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        s_status = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "INID", "CID", "Customer Name", "Total Qnty", "Total Bill", "Status", "Balance"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1227, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14));
        jLabel5.setText("INID :");

        inid.setFont(new java.awt.Font("Tahoma", 1, 14));
        inid.setText("0");
        inid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inidKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14));
        jLabel6.setText("Customer Name :");

        c_name.setFont(new java.awt.Font("Tahoma", 1, 14));
        c_name.setText("0");
        c_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_nameKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14));
        jLabel7.setText("Status :");

        s_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unpaid", "Partial", "Paid" }));
        s_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_statusActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inid, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(s_status, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1105, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(s_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void inidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inidKeyReleased
// Initialize INID textfield
    String inv_id = inid.getText();
    
    search_para(inv_id);
   
}//GEN-LAST:event_inidKeyReleased

private void c_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_nameKeyReleased
// TODO add your handling code here:
    String cname = c_name.getText();
    
    search_para(cname);
}//GEN-LAST:event_c_nameKeyReleased

private void s_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_statusActionPerformed
// TODO add your handling code here:
    String stat = s_status.getSelectedItem().toString();
    search_para(stat);
}//GEN-LAST:event_s_statusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField c_name;
    private javax.swing.JTextField inid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox s_status;
    // End of variables declaration//GEN-END:variables
}
