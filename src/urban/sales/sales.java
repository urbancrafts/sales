/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * sales.java
 *
 * Created on Apr 27, 2020, 9:15:59 PM
 */
package urban.sales;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vicky
 */
public class sales extends javax.swing.JPanel {
    
    public static String barcode_c = "0";
    public static String cus_id = "0";
    

    /** Creates new form sales */
    public sales() {
        initComponents();
        data_load();   
        load_invoice();
    }
    
public void data_load(){
//load customer
   try{
    
      DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
      dt.setRowCount(0);
       
   Statement s = (Statement) db.mycon().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM customer ");  
    Vector v = new Vector();
    while(rs.next()){
    v.add(rs.getString("name"));
    
    DefaultComboBoxModel com = new DefaultComboBoxModel(v);
    s_cus_name.setModel(com);
    
    }
   }catch(Exception e){
   System.out.println(e);
   }
   
   try{
   
    Statement s = (Statement) db.mycon().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM product ");  
    Vector v = new Vector();
    while(rs.next()){
    v.add(rs.getString("name"));
    
    DefaultComboBoxModel com = new DefaultComboBoxModel(v);
    s_pro.setModel(com);
    
    }  
       
   }catch(Exception e){
   System.out.println(e);
   }
   
   
   
  
   
}

public void load_invoice(){
    //load last invoice number
 try{
    Statement s = (Statement) db.mycon().createStatement();
    ResultSet rs = s.executeQuery("SELECT * FROM invoice WHERE id=1 ");  
    
    if(rs.next()){
       inid.setText(rs.getString("val"));
    }
    
   }catch(Exception e){
   System.out.println(e);
   }
   
   int i = Integer.valueOf(inid.getText());
   i++;
   inid.setText(String.valueOf(i));
}

    
public void pro_tot_cal(){
//get product total calculation
    Double qt = Double.valueOf(s_qnty.getText());
    Double price = Double.valueOf(uni_price.getText());
    
    Double tot;
    
    tot = qt * price;
    tot_price.setText(String.valueOf(tot));
    
}

public void cart_total(){
//get cart total
    int numofrow = jTable1.getRowCount();
    
    double total = 0;
    
    for(int i = 0; i < numofrow; i++){
    
        double value = Double.valueOf(jTable1.getValueAt(i, 5).toString());
        total += value;
        
    }
   bill_tot.setText(Double.toString(total));
   
   //total qnty count
   
   int numofrows = jTable1.getRowCount();
   
   double totals = 0;
   
  for(int i = 0; i < numofrows; i++){
    double values = Double.valueOf(jTable1.getValueAt(i, 3).toString());
    totals += values;
  }
 total_qnty.setText(Double.toString(totals));
}

public void tot(){

    Double paid = Double.valueOf(bill_paid.getText());
    Double tot = Double.valueOf(bill_tot.getText());
    Double due;
    
    due = paid - tot;
    bill_bal.setText(String.valueOf(due));
    
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        uni_price = new javax.swing.JLabel();
        s_cus_name = new javax.swing.JComboBox();
        s_pro = new javax.swing.JComboBox();
        s_qnty = new javax.swing.JTextField();
        tot_price = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        p_bcode = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        bill_paid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        bill_tot = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bill_bal = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        total_qnty = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18));
        jLabel1.setText("INVOICE NO :");

        inid.setFont(new java.awt.Font("Arial", 1, 18));
        inid.setText("01");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inid, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(688, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inid))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel3.setText("Customer :");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel4.setText("Product :");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel5.setText("Qnty :");

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel6.setText("Unit price :");

        uni_price.setFont(new java.awt.Font("Arial Black", 1, 12));
        uni_price.setText("00.00");

        s_cus_name.setFont(new java.awt.Font("Tahoma", 1, 14));
        s_cus_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        s_cus_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_cus_nameActionPerformed(evt);
            }
        });

        s_pro.setFont(new java.awt.Font("Tahoma", 1, 14));
        s_pro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        s_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_proActionPerformed(evt);
            }
        });

        s_qnty.setFont(new java.awt.Font("Tahoma", 1, 18));
        s_qnty.setText("0");
        s_qnty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                s_qntyKeyReleased(evt);
            }
        });

        tot_price.setFont(new java.awt.Font("Arial Black", 1, 12));
        tot_price.setText("00.00");

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12));
        jLabel7.setText("Total price :");

        p_bcode.setFont(new java.awt.Font("Arial Black", 1, 14));
        p_bcode.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1155, 1155, 1155)
                        .addComponent(p_bcode, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s_cus_name, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s_qnty, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uni_price, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tot_price, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(p_bcode))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(s_cus_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(s_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_qnty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uni_price)
                    .addComponent(jLabel7)
                    .addComponent(tot_price)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "INID", "Name", "Bar Code", "Qnty", "Unit Price", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bill_paid.setFont(new java.awt.Font("Tahoma", 1, 18));
        bill_paid.setText("0");
        bill_paid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bill_paidKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel8.setText("Paid Amount :");

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel9.setText("Total Amount :");

        bill_tot.setFont(new java.awt.Font("Arial", 1, 12));
        bill_tot.setText("00.00");
        bill_tot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Balance/Due :");

        bill_bal.setFont(new java.awt.Font("Arial", 1, 12));
        bill_bal.setText("00.00");
        bill_bal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bill_bal, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(bill_tot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bill_bal)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel13.setText("Total Qnty:");

        total_qnty.setFont(new java.awt.Font("Arial", 1, 12));
        total_qnty.setText("00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bill_paid, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_qnty)
                .addGap(48, 48, 48)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(total_qnty))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(bill_paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton4.setText("Save & Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, 0, 974, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3))))
                .addGap(240, 240, 240))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// Initialize remove all cart btn
    
    
    DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
    dt.setRowCount(0);
    
    
   cart_total();
   tot();
    
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
    try{
       
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        int rc = dt.getRowCount();
        
        for (int i = 0; i < rc; i++){
        String inid = dt.getValueAt(i, 0).toString(); //get INID
        String p_name = dt.getValueAt(i, 1).toString(); //get product name
        String bcode = dt.getValueAt(i, 2).toString(); //get barcode
        String qnty = dt.getValueAt(i, 3).toString(); //get product qnty
        String uni_price = dt.getValueAt(i, 4).toString(); //get unit price
        String tot_price = dt.getValueAt(i, 5).toString(); //get total price
         
        
        //cart DB query
            Statement s = (Statement) db.mycon().createStatement();
            s.executeUpdate(" INSERT INTO cart (INID,product_name,barcode,qnty,unit_price,total_price) VALUES ('"+inid+"','"+p_name+"','"+bcode+"','"+qnty+"','"+uni_price+"','"+tot_price+"') ");
        
       
       
        }
        
    
    }catch(Exception e){
    System.out.println(e);
    }
   
   try{
   //sales DB query
       DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
       
       String inv_id = inid.getText();
       String cname = s_cus_name.getSelectedItem().toString();
       String totalQnty = total_qnty.getText();
       String tot_bil = bill_tot.getText();
       String balance = bill_bal.getText();
       String status = null;
       
       
       Double tot = Double.valueOf(bill_tot.getText());
       Double pid = Double.valueOf(bill_paid.getText());
       
       if(pid.equals(0.0)){
       status = "Unpaid";
       }else if(tot > pid){
       status = "Partial";
       }else if(tot <= pid){
       status = "Paid";
       }
       if(tot.equals(0.0)){
       JOptionPane.showMessageDialog(null, "Please add products to cart before creating a record");
       }else{
    Statement ss = (Statement) db.mycon().createStatement();
    ss.executeUpdate(" INSERT INTO sales (INID,cid,customer_name,total_qnty,total_bill,status,balance) VALUES ('"+inv_id+"','"+cus_id+"','"+cname+"','"+totalQnty+"','"+tot_bil+"','"+status+"','"+balance+"') ");
      JOptionPane.showMessageDialog(null, "Recode created");  
    ss.executeUpdate("UPDATE invoice SET val='"+inv_id+"' WHERE id=1 ");//update invoice table for invoice count
    dt.setRowCount(0); 
       }   
   }catch(Exception e){
   System.out.println(e);
   }
   
   
   // Initialize remove all cart items
   cart_total();
   tot();
    
    load_invoice();//load new invoice number
}//GEN-LAST:event_jButton4ActionPerformed

private void s_cus_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_cus_nameActionPerformed
//get customer name
    String name = s_cus_name.getSelectedItem().toString();
    
    
    try{
    
    Statement s = (Statement) db.mycon().createStatement();
    ResultSet rs = s.executeQuery("SELECT id,name FROM customer WHERE name='"+name+"'");
    
    if(rs.next()){
        
     cus_id = rs.getString("id");
    
    }
    
    }catch(Exception e){
    System.out.println(e);
    }
    
}//GEN-LAST:event_s_cus_nameActionPerformed

private void s_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_proActionPerformed
// get prodcut
   
    String name = s_pro.getSelectedItem().toString();
    
    try{
    
    Statement s = (Statement) db.mycon().createStatement();
    ResultSet rs = s.executeQuery("SELECT barcode,price FROM product WHERE name='"+name+"'");
    
    if(rs.next()){
        
    uni_price.setText(rs.getString("price"));
    p_bcode.setText(rs.getString("barcode"));
    pro_tot_cal();
    }
    
    }catch(Exception e){
    System.out.println(e);
    }
    
}//GEN-LAST:event_s_proActionPerformed

private void s_qntyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s_qntyKeyReleased
// initialize the s_qnty form field if data entered
    pro_tot_cal();
}//GEN-LAST:event_s_qntyKeyReleased

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// initialize add to cart bnt
    DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
    
    Vector v = new Vector();
    Double qnty = Double.valueOf(s_qnty.getText());
    if(qnty.equals(0.0) || qnty.equals("")){
    JOptionPane.showMessageDialog(null, "Please enter item qnty");
    }else{
    v.add(inid.getText());//get invoice id
    v.add(s_pro.getSelectedItem().toString());//get product name
    v.add(p_bcode.getText());//get barcode
    v.add(s_qnty.getText());//get qnty
    v.add(uni_price.getText());//get product unit price
    v.add(tot_price.getText());//get total price
    
    dt.addRow(v);
    }
    cart_total();
    tot();
    
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//Initialize Remove cart bnt
    try{
    DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
    int rw = jTable1.getSelectedRow();
    dt.removeRow(rw);
    
    }catch(Exception e){
    System.out.println(e);
    }
   cart_total();
   tot();
}//GEN-LAST:event_jButton2ActionPerformed

private void bill_paidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bill_paidKeyReleased
// TODO add your handling code here:
    tot();
}//GEN-LAST:event_bill_paidKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bill_bal;
    private javax.swing.JTextField bill_paid;
    private javax.swing.JLabel bill_tot;
    private javax.swing.JLabel inid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel p_bcode;
    private javax.swing.JComboBox s_cus_name;
    private javax.swing.JComboBox s_pro;
    private javax.swing.JTextField s_qnty;
    private javax.swing.JLabel tot_price;
    private javax.swing.JLabel total_qnty;
    private javax.swing.JLabel uni_price;
    // End of variables declaration//GEN-END:variables
}
