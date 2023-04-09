/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package daftarfilm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fachri Najm
 */
public class FrameArtisFilm extends javax.swing.JFrame{
    private DefaultTableModel dtm;
    private Boolean isUpdate = false;
    private int selectedIDFilm;
    private int selectedIDArtis;
    private dbConnection db = new dbConnection();
    private dbConnection dbChild = new dbConnection();
    /**
     * Creates new form FrameArtisFilm
     */
    public FrameArtisFilm() {
        // Constructor
        initComponents();
        
        // Set Table
        BoxFilm.setModel(setComboBoxFilm());
        BoxArtis.setModel(setComboBoxArtis());
        tblMhs.setModel(setTable());
        tblMhs.getColumnModel().getColumn(1).setPreferredWidth(5);
        
        // Hide Delete button
        btnDelete.setVisible(false);
    }
    
    // set default model tabel
    public final DefaultTableModel setTable() {
        // Column Title
        Object[] column = {"Nama Film", "X", "Nama Artis"};
        DefaultTableModel dataTabel = new DefaultTableModel(null, column);
        ResultSet res = db.selectQuery("SELECT * FROM film_artis");
        
        try {
            while (res.next()) {
                Object[] row = new Object[3];
                ResultSet resFilm = dbChild.selectQuery("SELECT * FROM film WHERE id_film=" +res.getInt("id_film"));
                if(resFilm.next()){
                    row[0] = resFilm.getString("nama_film");
                }
                row[1] = "";
                ResultSet resArtis = dbChild.selectQuery("SELECT * FROM artis WHERE id_artis=" +res.getInt("id_artis"));
                if(resArtis.next()){
                    row[2] = resArtis.getString("nama_artis");
                }
                dataTabel.addRow(row);
            }
        } catch (SQLException ex) {
//            logger.getLogger(Menu.class.getName()).log();
            System.out.println(ex.getMessage());
        }

        return dataTabel;
    }
    
    // set defalut model combo box
    public final DefaultComboBoxModel setComboBoxFilm(){
        // value dari combo box
        ResultSet res = db.selectQuery("SELECT * FROM film");
        
        
        DefaultComboBoxModel filmList = new DefaultComboBoxModel();
        try {
            while (res.next()) {
                filmList.addElement(new Item(res.getInt("id_film"), res.getString("nama_film")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameArtisFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        filmList.addElement("Select Film");
        filmList.setSelectedItem("Select Film");
        
        
        return filmList;
    }
    public final DefaultComboBoxModel setComboBoxArtis(){
        // value dari combo box
        ResultSet res = db.selectQuery("SELECT * FROM artis");
        
        
        DefaultComboBoxModel filmList = new DefaultComboBoxModel();
        try {
            while (res.next()) {
                filmList.addElement(new Item(res.getInt("id_artis"), res.getString("nama_artis")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameArtisFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        filmList.addElement("Select Artis");
        filmList.setSelectedItem("Select Artis");
        
        
        return filmList;
    }

 
    class Item
    {
        private int id;
        private String description;
 
        public Item(int id, String description)
        {
            this.id = id;
            this.description = description;
        }
 
        public int getId()
        {
            return id;
        }
 
        public String getDescription()
        {
            return description;
        }
 
        @Override
        public String toString()
        {
            return description;
        }
    }
    
    // untuk menambahkan data 
    public void insertData() {
        // get data from form
        int film = ((Item)BoxFilm.getSelectedItem()).getId();
        int artis = ((Item)BoxArtis.getSelectedItem()).getId();
        
        // Add New Data
        String sql = "INSERT INTO film_artis VALUES ("+film+", "+artis+")";
        db.updateQuery(sql);

        // Update Table
        tblMhs.setModel(setTable());
        resetForm();

        // Show Information
        System.out.println("Insert Success!");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
    }
//    
//    // untuk opdate data
    public void updateData() {
        // get data from form
        int film = ((Item)BoxFilm.getModel().getSelectedItem()).getId();
        int artis = ((Item)BoxArtis.getModel().getSelectedItem()).getId();

//        if{
        // Update Data in Database
        String sql = "UPDATE film_artis SET id_film=" + film + ", id_artis=" + artis + " WHERE id_film =" + selectedIDFilm + " AND id_artis=" + selectedIDArtis;
        int affectedRow = db.updateQuery(sql);

        if (affectedRow > 0) {
            // Update Table
            tblMhs.setModel(setTable());

            resetForm();

            // Show Information
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
        } else {
            JOptionPane.showMessageDialog(null, "Data gagal diupdate!");
        }
//        }
    }
//    
//    // untuk delete data
    public void deleteData() {

            // Delete Data in Database
            String sql = "DELETE FROM film_artis WHERE id_film=" + selectedIDFilm + " AND id_artis=" + selectedIDArtis;
            int affectedRow = db.updateQuery(sql);

            if (affectedRow > 0) {
                // Update Table
                tblMhs.setModel(setTable());

                resetForm();

                // Show Information
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus!");
            }
    }
    
//    // method untuk reset form
    public void resetForm() {
        BoxFilm.setSelectedItem("Select Film");
        BoxArtis.setSelectedItem("Select Artis");
    }
//    
    public boolean checkInput(){
        // Validate input data
        if(BoxFilm.getSelectedItem() == "Select Film" || BoxArtis.getSelectedItem() == "Select Artis"){
            JOptionPane.showMessageDialog(null, 
                    "Pilih Film dan pilih artis", 
                    "Warning", 
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMhs = new javax.swing.JTable();
        BoxArtis = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        BoxFilm = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMhs);

        jLabel1.setText("X");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        BoxFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxFilmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BoxFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(BoxArtis, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoxArtis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(BoxFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(checkInput() == false){
            return;
        }
        
        // If Add (data not clicked)
        if (isUpdate == false) {
            insertData();
            // set default selected item to "Pilih gender"
            resetForm();
        } else {
            updateData();
            btnAdd.setText("Add");
            btnDelete.setVisible(false);
            // set default selected item to "Pilih gender"
            resetForm();
            this.isUpdate = false;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        btnAdd.setText("Add");
        btnDelete.setVisible(false);
        // set default selected item to "Pilih gender"
        this.isUpdate = false;
        
        // Reset Form
        resetForm();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (isUpdate == true) {
            // display confirmation message
            int result = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to delete this data?", 
                    "Confirmation", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
            
            if (result == JOptionPane.YES_OPTION) {
                // if user confirms deletion
                deleteData();
                btnAdd.setText("Add");
                btnDelete.setVisible(false);
                // set default selected item to "Pilih gender"
                resetForm();
                this.isUpdate = false;
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void BoxFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxFilmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxFilmActionPerformed

    private void tblMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMhsMouseClicked
        // TODO add your handling code here:
        // If data clicked
        this.isUpdate = true;

        // Get Selected Data
        int row = tblMhs.getSelectedRow();
        String sql = "SELECT * FROM film_artis LIMIT " + row + ", 1";
        ResultSet res = db.selectQuery(sql);
        try {
            if(res.next()){
                selectedIDFilm = res.getInt("id_film");
                selectedIDArtis = res.getInt("id_artis");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameArtisFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        selectedIDFilm = Integer.parseInt(tblMhs.getModel().getValueAt(row, 0).toString());
//        selectedIDArtis = Integer.parseInt(tblMhs.getModel().getValueAt(row, 2).toString());
        
        // Search Data in Database
        sql = "SELECT * FROM film_artis WHERE id_film =" + selectedIDFilm + " AND id_artis=" + selectedIDArtis;
        res = db.selectQuery(sql);
        BoxFilm.setSelectedItem("sialan");
        try {
            if (res.next()) {
                // Set Form Value
                ResultSet resFilm = dbChild.selectQuery("SELECT * FROM film WHERE id_film=" +res.getInt("id_film"));
                if(resFilm.next()){
                    BoxFilm.getModel().setSelectedItem(new Item(resFilm.getInt("id_film"), resFilm.getString("nama_film")));
                }
                ResultSet resArtis = dbChild.selectQuery("SELECT * FROM artis WHERE id_artis=" +res.getInt("id_artis"));
                if(resArtis.next()){
                    BoxArtis.getModel().setSelectedItem(new Item(resArtis.getInt("id_artis"),resArtis.getString("nama_artis")));
                }
                

                btnAdd.setText("Update");
                btnDelete.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_tblMhsMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrameArtisFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrameArtisFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrameArtisFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrameArtisFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrameArtisFilm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Item> BoxArtis;
    private javax.swing.JComboBox<Item> BoxFilm;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMhs;
    // End of variables declaration//GEN-END:variables
}
