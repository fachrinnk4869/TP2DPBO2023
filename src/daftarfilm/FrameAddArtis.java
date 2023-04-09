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
public class FrameAddArtis extends javax.swing.JFrame {

    private int id;
    private dbConnection db = new dbConnection();
    private FrameMenu frameMenu;
    String selectedImagePath = "";

    /**
     * Creates new form FrameAddArtis
     */
    public FrameAddArtis(FrameMenu frameMenu, int id) {
        initComponents();
        this.frameMenu = frameMenu;
        this.id = id;
        ImageIcon ii = null;
        ResultSet res = db.selectQuery("SELECT * FROM artis WHERE id_artis=" + this.id);
        try {
            if (res.next()) {
                TextFieldNama.setText(res.getString("NAMA_ARTIS"));
//                TextFieldRating.setText(Integer.toString(res.getInt("RATING_FILM")));
                selectedImagePath = "src\\assets\\"+res.getString("GAMBAR_ARTIS");
                ii = new ImageIcon(selectedImagePath);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameAddArtis.class.getName()).log(Level.SEVERE, null, ex);
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
    public FrameAddArtis(FrameMenu frameMenu) {
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
//        int rating = Integer.parseInt(TextFieldRating.getText());
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
            String sql = "UPDATE artis SET nama_artis='" + nama + "', gambar_artis='" +namaFile+ "' WHERE id_artis=" + this.id;
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
//        int rating = Integer.parseInt(TextFieldRating.getText());
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
            String sql = "INSERT INTO artis(nama_artis, gambar_artis, jumlah_film) VALUES ('"+nama+"' , '"+namaFile+"', 0)";
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

        LabelImage = new javax.swing.JLabel();
        ButtonOk = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        TextFieldNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ButtonBrowse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelImage.setText("          Photo");
        LabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ButtonOk.setText("Add");
        ButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOkActionPerformed(evt);
            }
        });

        labelNama.setText("Nama Artis");

        TextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldNamaActionPerformed(evt);
            }
        });

        jLabel1.setText("Gambar");

        ButtonBrowse.setText("Browse//");
        ButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonOk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNama)
                            .addComponent(TextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBrowse)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(ButtonOk)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldNamaActionPerformed

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
//            java.util.logging.Logger.getLogger(FrameAddArtis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrameAddArtis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrameAddArtis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrameAddArtis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrameAddArtis().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBrowse;
    private javax.swing.JButton ButtonOk;
    private javax.swing.JLabel LabelImage;
    private javax.swing.JTextField TextFieldNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelNama;
    // End of variables declaration//GEN-END:variables
}
