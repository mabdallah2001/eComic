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


public class BrowseComics extends javax.swing.JFrame {

    LoginUser u;

    myDBCon con = new myDBCon();

    /**
     * Creates new form LoginForm
     */
    public BrowseComics(LoginUser luser) {
        initComponents();
        this.setLocationRelativeTo(null);
        getNewData();
        u = luser;
        
       
        
        if(luser.type == 0){
            buyButton.setEnabled(false);
        }
        
 
        
    }
    
    private void getNewData() {

        try {
            con.rs = con.executeStatement("select * from comic");
            //con.rs = con.executeStatement("select name, address, phone, username from customer where username like '"+ txtUsername.getText()+"'");
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
            publisherText.setText(con.rs.getString("publisher_name"));
            priceText.setText(con.rs.getString("price"));
            quantityText.setText(con.rs.getString("quantity"));
            volumeText.setText(con.rs.getString("volume"));
            issueText.setText(con.rs.getString("issue"));
            ISBNText.setText(con.rs.getString("ISBN"));
            
           
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
            //Logger.getLogger(updateLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            //Logger.getLogger(updateLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            //Logger.getLogger(updateLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        buyButton = new javax.swing.JButton();
        authorText = new javax.swing.JTextField();
        volumeText = new javax.swing.JTextField();
        publisherText = new javax.swing.JTextField();
        priceText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        ISBNText = new javax.swing.JTextField();
        illustratorText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        issueText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Online Bookstore Sign In Page");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Author:");

        nameText.setEditable(false);
        nameText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Browse Comics");

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

        buyButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        buyButton.setText("Add to Cart");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        authorText.setEditable(false);
        authorText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        authorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTextActionPerformed(evt);
            }
        });

        volumeText.setEditable(false);
        volumeText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        volumeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volumeTextActionPerformed(evt);
            }
        });

        publisherText.setEditable(false);
        publisherText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        publisherText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherTextActionPerformed(evt);
            }
        });

        priceText.setEditable(false);
        priceText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextActionPerformed(evt);
            }
        });

        quantityText.setEditable(false);
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

        illustratorText.setEditable(false);
        illustratorText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        illustratorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                illustratorTextActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Illustrator:");

        issueText.setEditable(false);
        issueText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        issueText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueTextActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Issue:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/databaseproject/pics/icons8-pow-50.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(513, 513, 513)
                                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(illustratorText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(authorText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(volumeText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(publisherText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(issueText, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3))
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(authorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(illustratorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publisherText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volumeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyButton)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void publisherTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publisherTextActionPerformed

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
    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        // TODO add your handling code here:
                //confirm user wants to update login user
        String conf = JOptionPane.showInputDialog("Quantity to add to cart: ");

        int orderNo = 0;
        
        System.out.println(conf);
        if(conf.isEmpty()){
            //if user doesn't enter "YES", do nothing
            return;
        } else if(!isInteger(conf)){
            JOptionPane.showMessageDialog(null, "Must be an integer input!");
            return;
        } else if (isInteger(conf)){
            if(Integer.parseInt(conf)<=0){
                JOptionPane.showMessageDialog(null, "CANT BE 0 OR A NEGATIVE NUMBER!");
                return;
            }
            else if (Integer.parseInt(conf)<= Integer.parseInt(quantityText.getText())){
                try {
                    double cost = Double.parseDouble(priceText.getText())*Integer.parseInt(conf);
                    con.rs = con.executeStatement("select * from Orders where username = '" + u.username +"' and status=0");
                    if(con.rs.next()){
                        orderNo = Integer.parseInt(con.rs.getString("orderno"));
                        double tempTotal = Double.parseDouble(con.rs.getString("total"));
                        cost = cost+tempTotal;
                        System.out.println("update Orders set total =" + cost + " where username = '" + u.username +"' and status=0");
                        con.executePrepared("update Orders set total =" + cost + " where username = '" + u.username +"' and status=0");
                    }
                    else{
                        con.executePrepared("insert into Orders(Total, TimeStamp, Username, Status) values (" + cost + "0,current_timestamp,'" + u.username + "','0')");
                        con.rs = con.executeStatement("select * from Orders where username = '" + u.username +"' and status=0");
                        if(con.rs.next()){
                            orderNo = Integer.parseInt(con.rs.getString("orderno"));
                        }
                    }
                    //we have an orderNo
                System.out.println("OrderNo: " + orderNo);
                
                con.rs = con.executeStatement("select * from comic_order where orderno =" + orderNo + "and isbn='" + ISBNText.getText().trim() + "'");
                
                if(con.rs.next()){
                    int tempQuantity = Integer.parseInt(con.rs.getString("quantity")) + Integer.parseInt(conf);
                    con.executePrepared("update Comic_Order set quantity=" + tempQuantity + "where orderNo = " + orderNo + " and ISBN = '" + ISBNText.getText().trim() + "'");
                } else {
                    con.executePrepared("insert into Comic_Order values ('" + orderNo + "', '" + ISBNText.getText().trim() + "', " + Integer.parseInt(conf) + ")");
                }
                
                } catch (SQLException ex) {
                    Logger.getLogger(BrowseComics.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                getNewData();
                
                JOptionPane.showMessageDialog(null, "Added to cart!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Must be less than available quantity!");
                return;
            }
        }
        
    }//GEN-LAST:event_buyButtonActionPerformed

    private void illustratorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_illustratorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_illustratorTextActionPerformed

    private void issueTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issueTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeButton;
    private javax.swing.JTextField ISBNText;
    private javax.swing.JTextField authorText;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton buyButton;
    private javax.swing.JTextField illustratorText;
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
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField priceText;
    private javax.swing.JTextField publisherText;
    private javax.swing.JTextField quantityText;
    private javax.swing.JTextField volumeText;
    // End of variables declaration//GEN-END:variables
}
