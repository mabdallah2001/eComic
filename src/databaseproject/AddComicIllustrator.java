package databaseproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//This class creates the GUI for adding an employee, and implements all the needed
//functions in order to veryify the user input is valid, and then adds it to the db

public class AddComicIllustrator extends javax.swing.JFrame {

    //instantiate a database connection
    myDBCon con = new myDBCon();
    ArrayList<String> illustratorSSN = new ArrayList<String>();
    ArrayList<String> comicISBN = new ArrayList<String>();

    public AddComicIllustrator() {
        
        initComponents();
        // center form in screen
        this.setLocationRelativeTo(null);
        try {
            //populate mgr and deptno combo boxes
            con.rs = con.executeStatement("SELECT * FROM Comic ORDER BY Name ASC");
            // populate mgr combo box
            while (con.rs.next()) {
                System.out.println(con.rs.getString("Name"));
                cmbBook.addItem(con.rs.getString("Name"));
                comicISBN.add(con.rs.getString("isbn"));
            }

            con.rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EditComics.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //populate mgr and deptno combo boxes
            con.rs = con.executeStatement("SELECT * FROM Illustrator ORDER BY name ASC");
            // populate mgr combo box
            while (con.rs.next()) {
                System.out.println(con.rs.getString("name"));
                cmbIllustrator.addItem(con.rs.getString("name"));
                illustratorSSN.add(con.rs.getString("ssn"));
            }

            con.rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(EditComics.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cmbBook = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbIllustrator = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Data");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add Comic Illustrator");

        submitButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        submitButton.setText("Add Illustrator");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        HomeButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/databaseproject/home.png"))); // NOI18N
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Comic:");

        cmbBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbBook.setMaximumRowCount(100);
        cmbBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBookActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Illustrator:");

        cmbIllustrator.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbIllustrator.setMaximumRowCount(100);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/databaseproject/pics/icons8-pow-50.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbIllustrator, 0, 492, Short.MAX_VALUE)
                            .addComponent(cmbBook, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 194, Short.MAX_VALUE)
                        .addComponent(submitButton)
                        .addGap(232, 232, 232)
                        .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(151, 151, 151)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cmbBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(cmbIllustrator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(submitButton)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //check if string is int
    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    //clear all error labels
    //check if data is valid
    //clear all the user inputs 

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        
        System.out.println(illustratorSSN.get(cmbIllustrator.getSelectedIndex()));
        System.out.println(comicISBN.get(cmbBook.getSelectedIndex()));
        
        try {
            
            int result = con.executePrepared("insert into Comic_Illustrator values ('" + comicISBN.get(cmbBook.getSelectedIndex()) + "','" + illustratorSSN.get(cmbIllustrator.getSelectedIndex()) + "')");
            
            if (result > 0){
                javax.swing.JLabel label = new javax.swing.JLabel("New comic illustrator added successfully.");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException ex) {
            
            if(ex.getMessage().contains("ORA-00001")){
                javax.swing.JLabel label = new javax.swing.JLabel(cmbIllustrator.getSelectedItem() + " is already an illustrator of the comic " + cmbBook.getSelectedItem() + "!");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
      
            }
            else{
                javax.swing.JLabel label = new javax.swing.JLabel(ex.getMessage());
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(AddComicIllustrator.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void cmbBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeButton;
    private javax.swing.JComboBox<String> cmbBook;
    private javax.swing.JComboBox<String> cmbIllustrator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}