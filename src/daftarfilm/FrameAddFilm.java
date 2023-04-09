/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package daftarfilm;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Fachri Najm
 */
public class FrameAddFilm extends javax.swing.JFrame {
    private int id;
    private dbConnection db = new dbConnection();
    private FrameMenu frameMenu;
    String selectedImagePath = "";
    
    /**
     * Creates new form FrameAdd
     * @param frameMenu
     * @param id
     */
    // Update Frame
    public FrameAddFilm(FrameMenu frameMenu, int id) {
        initComponents();
        this.frameMenu = frameMenu;
        this.id = id;
        ImageIcon ii = null;
        ResultSet res = db.selectQuery("SELECT * FROM film WHERE id_film=" + this.id);
        try {
            if (res.next()) {
                TextFieldNama.setText(res.getString("NAMA_FILM"));
                TextFieldRating.setText(Integer.toString(res.getInt("RATING_FILM")));
                selectedImagePath = "src\\assets\\"+res.getString("GAMBAR_FILM");
                ii = new ImageIcon(selectedImagePath);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameAddFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image image = ii.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
 
        LabelImage.setIcon(new ImageIcon(image));
        LabelImage.setVerticalAlignment(SwingConstants.CENTER);
        if(this.frameMenu.getIsUpdated()){
            ButtonOk.setText("Update Data");
        }else{
            ButtonOk.setText("Add Data");
        }
    }
    // add Frame
    public FrameAddFilm(FrameMenu frameMenu) {
        initComponents();
        this.db = new dbConnection();
        this.frameMenu = frameMenu;
        if(this.frameMenu.getIsUpdated()){
            ButtonOk.setText("Update Data");
        }else{
            ButtonOk.setText("Add Data");
        }
    }

    
    private void notifyDataUpdated() {
        // Notify Frame1 that data has been updated
        frameMenu.onDataUpdated();
    }
    private void updateData(){
        
        // get data from form
//        int id = Integer.parseInt(TextFieldRating.getText());
        String nama = TextFieldNama.getText();
        int rating = Integer.parseInt(TextFieldRating.getText());
        String newPath = "src\\assets";
        File fileAwal = new File(selectedImagePath);
        String namaFile = this.selectedImagePath.substring(selectedImagePath.lastIndexOf('\\') + 1);
        File fileAkhir = new File( newPath+"\\"+ namaFile);
        System.out.println(fileAkhir);
        try {
            Files.copy(fileAwal.toPath(), fileAkhir.toPath());
        } catch (IOException ex) {
            Logger.getLogger(FrameAddFilm.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data belum lengkap!");
        } else {
            // Update Data in Database
            String sql = "UPDATE film SET nama_film='" + nama + "', rating_film='" + rating + "', gambar_film='" +namaFile+ "' WHERE id_film=" + this.id;
            int affectedRow = db.updateQuery(sql);
            notifyDataUpdated();
            dispose();
            if (affectedRow > 0) {

                // Show Information
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal diupdate!");
            }
        }
        
    }
    private void addData(){
        
        String nama = TextFieldNama.getText();
        int rating = Integer.parseInt(TextFieldRating.getText());
        String newPath = "src\\assets";
        File directory = new File(newPath);
        if(!directory.exists()){
            directory.mkdirs();
        }
//        String ext = this.selectedImagePath.substring(selectedImagePath.lastIndexOf('.') + 1);
        File fileAwal = new File(selectedImagePath);
        String namaFile = this.selectedImagePath.substring(selectedImagePath.lastIndexOf('\\') + 1);
        File fileAkhir = new File( newPath+"\\"+ namaFile);
        System.out.println(fileAkhir);
        try {
            Files.copy(fileAwal.toPath(), fileAkhir.toPath());
        } catch (IOException ex) {
            Logger.getLogger(FrameAddFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        // cek
        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data belum lengkap!");
        } else {
            // Add New Data
            String sql = "INSERT INTO film(nama_film, rating_film, gambar_film, jumlah_artis) VALUES ('"+nama+"', "+rating+" , '"+namaFile+"', 0)";
            db.updateQuery(sql);
            
            notifyDataUpdated();
            dispose();

            // Show Information
            System.out.println("Insert Success!");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNama = new javax.swing.JLabel();
        TextFieldNama = new javax.swing.JTextField();
        TextFieldRating = new javax.swing.JTextField();
        labelRating = new javax.swing.JLabel();
        ButtonOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ButtonBrowse = new javax.swing.JButton();
        LabelImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNama.setText("Nama Film");

        TextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldNamaActionPerformed(evt);
            }
        });

        TextFieldRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldRatingActionPerformed(evt);
            }
        });

        labelRating.setText("Rating Film");

        ButtonOk.setText("Add");
        ButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOkActionPerformed(evt);
            }
        });

        jLabel1.setText("Gambar");

        ButtonBrowse.setText("Browse//");
        ButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBrowseActionPerformed(evt);
            }
        });

        LabelImage.setText("          Photo");
        LabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(labelRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldRating, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonOk)
                    .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNama)
                            .addComponent(TextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRating)
                            .addComponent(TextFieldRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ButtonBrowse)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(ButtonOk)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldNamaActionPerformed

    private void TextFieldRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldRatingActionPerformed

    private void ButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOkActionPerformed
        // TODO add your handling code here:
        if(frameMenu.getIsUpdated()){
            updateData();
        }else{
            addData();
        }
        
    }//GEN-LAST:event_ButtonOkActionPerformed

    private void ButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser();
        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
 
        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            selectedImagePath = selectedImageFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null, selectedImagePath);
            //Display image on jlable 
            ImageIcon ii = new ImageIcon(selectedImagePath);
//            Resize image to fit jlabel
            Image image = ii.getImage().getScaledInstance(LabelImage.getWidth(), LabelImage.getHeight(), Image.SCALE_SMOOTH);
 
            LabelImage.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_ButtonBrowseActionPerformed

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
//            java.util.logging.Logger.getLogger(FrameAddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrameAddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrameAddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrameAddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrameAddFilm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBrowse;
    private javax.swing.JButton ButtonOk;
    private javax.swing.JLabel LabelImage;
    private javax.swing.JTextField TextFieldNama;
    private javax.swing.JTextField TextFieldRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelRating;
    // End of variables declaration//GEN-END:variables
}
