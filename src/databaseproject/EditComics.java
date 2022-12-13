package databaseproject;

import databaseproject.myDBCon;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


//This class creates the GUI for logging in to the system, and implements all the needed
//functions in order to veryify the user login is valid, giving the user access to the system


public class EditComics extends javax.swing.JFrame {

    LoginUser u;

    myDBCon con = new myDBCon();

    /**
     * Creates new form LoginForm
     */
    public EditComics(LoginUser luser) {
        initComponents();
        this.setLocationRelativeTo(null);
        clearErrorLabels();
        try {
            //populate mgr and deptno combo boxes
            con.rs = con.executeStatement("SELECT name FROM publisher ORDER BY name ASC");
            // populate mgr combo box
            while (con.rs.next()) {
                System.out.println(con.rs.getString("name"));
                cmbPublisher.addItem(con.rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditComics.class.getName()).log(Level.SEVERE, null, ex);
        }

        getNewData();
            
        u = luser;
    }
    
        private void getNewData() {

        try {
            con.rs = con.executeStatement("select * from comic");
            // populate rest of fields
            con.rs.beforeFirst();
            con.rs.first();
            populateFields();
            
            
        } catch (SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Display selected username.\n" + e.getMessage());
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void populateFields() {
        try {
            System.out.println(con.rs.getString("name"));
            System.out.println(con.rs.getString("publisher_name"));
            System.out.println(con.rs.getString("price"));
            System.out.println(con.rs.getString("quantity"));
            System.out.println(con.rs.getString("volume"));
            System.out.println(con.rs.getString("issue"));
            System.out.println(con.rs.getString("ISBN"));
            //populate fiels from ResultSet data
            nameText.setText(con.rs.getString("name"));
            priceText.setText(con.rs.getString("price"));
            quantityText.setText(con.rs.getString("quantity"));
            volumeText.setText(con.rs.getString("volume"));
            issueText.setText(con.rs.getString("issue"));
            ISBNText.setText(con.rs.getString("ISBN"));
            
//            con.rs2 = con.executeStatement2("select name from author, comic_authors where ssn=author_ssn and isbn='" + ISBNText.getText() + "'");
//            
//            con.rs2.next();
//            authorText.setText(con.rs2.getString("name"));
//            
//            while(con.rs2.next()){
//                authorText.setText(authorText.getText() + ", " + con.rs2.getString("name"));
//            }
//            
//            con.rs2.close();
            
            con.rs2 = con.executeStatement2("select name from author, comic_authors where ssn=author_ssn and isbn='" + ISBNText.getText() + "'");
            
            con.rs2.next();
            authorText.setText(con.rs2.getString("name"));

            
            while(con.rs2.next()){
                authorText.setText(authorText.getText() + ", " + con.rs2.getString("name"));
             
            }
            con.rs2 = con.executeStatement2("select i.name as iName from  Illustrator i, Comic_Illustrator ic where i.ssn = ic.illustrator_ssn  and ic.isbn='" + ISBNText.getText() + "'");
            con.rs2.next();
            illustratorText.setText(con.rs2.getString("iName"));

             while(con.rs2.next()){
               
                illustratorText.setText(illustratorText.getText() + ", " + con.rs2.getString("iName"));


            }
            
            con.rs2.close();
            

            
//            con.rs3 = con.executeStatement2("select name from Illustrator, Comic_Illustrator where ssn=Illustrator_ssn and isbn='" + ISBNText.getText() + "'");
//            
//            con.rs3.next();
//            illustratorText.setText(con.rs3.getString("name"));
//            
//            while(con.rs3.next()){
//                illustratorText.setText(illustratorText.getText() + ", " + con.rs3.getString("name"));
//            }
//            
//            con.rs3.close();
            
            EnableDisableButtons();
            
        } catch (SQLException ex) {
        }
    }
    
    private void MoveNext() {
        try {
            //if not the last row of the result set, move to next row
            if (!con.rs.isLast()) {

                con.rs.next();
                populateFields();

            }
        } catch (SQLException ex) {
        }
    }
    
    private void MovePrevious() {
        try {
            //if not the first row of the result set, move to previous row
            if (!con.rs.isFirst()) {
                con.rs.previous();
                populateFields();

            }
        } catch (SQLException ex) {
        }
    }

    private void EnableDisableButtons() {
        try {
            //if first row is displayed, disable the previous button. else, enable it
            if (con.rs.isFirst()) {
                btnPrevious.setEnabled(false);
            } else {
                btnPrevious.setEnabled(true);
            }
            //if last row is displayed, disable the next button. else, enable it
            if (con.rs.isLast()) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(updateLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        HomeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        authorText = new javax.swing.JTextField();
        volumeText = new javax.swing.JTextField();
        priceText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        ISBNText = new javax.swing.JTextField();
        volumeError = new javax.swing.JLabel();
        quantityError = new javax.swing.JLabel();
        priceError = new javax.swing.JLabel();
        nameError = new javax.swing.JLabel();
        publisherError = new javax.swing.JLabel();
        cmbPublisher = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        illustratorText = new javax.swing.JTextField();
        issueText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        issueError = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Data");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Author:");

        nameText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Edit Comic");

        HomeButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/databaseproject/home.png"))); // NOI18N
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Price:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Quantity:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Volume:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("ISBN:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Publisher:");

        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPrevious.setText("<< Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNext.setText("Next >>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        authorText.setEditable(false);
        authorText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        authorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTextActionPerformed(evt);
            }
        });

        volumeText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        volumeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volumeTextActionPerformed(evt);
            }
        });

        priceText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextActionPerformed(evt);
            }
        });

        quantityText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantityText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextActionPerformed(evt);
            }
        });

        ISBNText.setEditable(false);
        ISBNText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ISBNText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBNTextActionPerformed(evt);
            }
        });

        volumeError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        volumeError.setForeground(new java.awt.Color(255, 0, 0));
        volumeError.setText("error label");

        quantityError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        quantityError.setForeground(new java.awt.Color(255, 0, 0));
        quantityError.setText("error label");

        priceError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        priceError.setForeground(new java.awt.Color(255, 0, 0));
        priceError.setText("error label");

        nameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        nameError.setForeground(new java.awt.Color(255, 0, 0));
        nameError.setText("error label");

        publisherError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        publisherError.setForeground(new java.awt.Color(255, 0, 0));
        publisherError.setText("error label");

        cmbPublisher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbPublisher.setMaximumRowCount(100);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Illustrator:");

        illustratorText.setEditable(false);
        illustratorText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        illustratorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                illustratorTextActionPerformed(evt);
            }
        });

        issueText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        issueText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueTextActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Issue:");

        issueError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        issueError.setForeground(new java.awt.Color(255, 0, 0));
        issueError.setText("error label");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/databaseproject/pics/icons8-pow-50.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameText, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorText, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameError, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(illustratorText)
                .addGap(218, 218, 218))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceText)
                            .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(volumeText, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publisherError, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceError, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityError, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volumeError, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(246, 246, 246)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(issueText, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(issueError, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(illustratorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityError)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(publisherError)
                            .addComponent(cmbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(priceError))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volumeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(volumeError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(issueError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(updateButton)
                        .addComponent(btnNext)
                        .addComponent(btnPrevious)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        MovePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        MoveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void authorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorTextActionPerformed

    private void volumeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volumeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volumeTextActionPerformed

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextActionPerformed

    private void quantityTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTextActionPerformed

    private void ISBNTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNTextActionPerformed
    //check if string is int
    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable
            if (isValidData()) {
                //if user input is valid, create SQL command to insert tuple
                
                con.prepStatement = con.con.prepareStatement("update comic set price = ?, name = ?, volume = ?, issue = ?, publisher_name = ?, quantity = ? where isbn = ?");
                
                con.prepStatement.setDouble(1, Double.parseDouble(priceText.getText().trim()));
                con.prepStatement.setString(2, nameText.getText());
                con.prepStatement.setInt(3, Integer.parseInt(volumeText.getText().trim()));
                con.prepStatement.setInt(4, Integer.parseInt(issueText.getText().trim()));
                con.prepStatement.setString(5, cmbPublisher.getSelectedItem().toString());
                con.prepStatement.setInt(6, Integer.parseInt(quantityText.getText().trim()));
                con.prepStatement.setString(7, ISBNText.getText());
                                
                int result = con.executePrepared(con.prepStatement);
                
                if (result > 0) {
                    javax.swing.JLabel label = new javax.swing.JLabel("New comic added successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    
                    getNewData();
                } else {
                    // check validation errors
                }
                
                
            } else {

                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new comic\n" + e.getMessage());
        }
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void illustratorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_illustratorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_illustratorTextActionPerformed

    private void issueTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issueTextActionPerformed
    
    void clearErrorLabels() {
        nameError.setText("");
        priceError.setText("");
        volumeError.setText("");
        issueError.setText("");
        quantityError.setText("");
        publisherError.setText("");
    }
    
    boolean isValidData() {

        clearErrorLabels();
        boolean result = true;
        
        if (nameText.getText().trim().isEmpty() || (nameText.getText().trim().length() > 50)) {
            if (nameText.getText().trim().isEmpty()) {
                nameError.setText("Invalid. Cannot be empty.");
            } else if (nameText.getText().trim().length() > 50) {
                nameError.setText("Invalid. Must be <= 50 chars.");
            }
            System.out.println("Name Error");
            nameError.setVisible(true);
            result = false;
        }
        
        
        if (priceText.getText().trim().isEmpty() || !isDouble(priceText.getText().trim()) || (priceText.getText().trim().length() > 6)) {
            if (priceText.getText().trim().isEmpty()) {
                priceError.setText("Invalid. Cannot be empty.");
            } else if (priceText.getText().trim().length() > 6) {
                priceError.setText("Invalid. Must be < $999.99");
            }
            System.out.println("Price Error");
            priceError.setVisible(true);
            result = false;
        }
        
        if (volumeText.getText().trim().isEmpty() || !isInteger(volumeText.getText().trim()) || (volumeText.getText().trim().length() >= 4)) {
            if (volumeText.getText().trim().isEmpty()) {
                volumeError.setText("Invalid. Cannot be empty.");
            } else if (volumeText.getText().trim().length() >= 4) {
                volumeError.setText("Invalid. Must be < 4 integers.");
            }
            System.out.println("Volume Error");
            volumeError.setVisible(true);
            result = false;
        }
        
        if (issueText.getText().trim().isEmpty() || !isInteger(issueText.getText().trim()) || (issueText.getText().trim().length() >= 4)) {
            if (issueText.getText().trim().isEmpty()) {
                issueError.setText("Invalid. Cannot be empty.");
            } else if (issueText.getText().trim().length() >= 4) {
                issueError.setText("Invalid. Must be < 4 integers.");
            }
            System.out.println("Issue Error");
            issueError.setVisible(true);
            result = false;
        }
        
        if (quantityText.getText().trim().isEmpty() || !isInteger(quantityText.getText().trim()) || (quantityText.getText().trim().length() > 5)) {
            if (quantityText.getText().trim().isEmpty()) {
                quantityError.setText("Invalid. Cannot be empty.");
            } else if (quantityText.getText().trim().length() != 5) {
                quantityError.setText("Invalid. Must be < 6 integers.");
            }
            System.out.println("Quantity Error");
            quantityError.setVisible(true);
            result = false;
        }
        
        return result;
    }
    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeButton;
    private javax.swing.JTextField ISBNText;
    private javax.swing.JTextField authorText;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JComboBox<String> cmbPublisher;
    private javax.swing.JTextField illustratorText;
    private javax.swing.JLabel issueError;
    private javax.swing.JTextField issueText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel nameError;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel priceError;
    private javax.swing.JTextField priceText;
    private javax.swing.JLabel publisherError;
    private javax.swing.JLabel quantityError;
    private javax.swing.JTextField quantityText;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel volumeError;
    private javax.swing.JTextField volumeText;
    // End of variables declaration//GEN-END:variables
}
