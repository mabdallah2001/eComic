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


public class ShoppingCart extends javax.swing.JFrame {

    LoginUser u;
    
    myDBCon con = new myDBCon();

    /**
     * Creates new form LoginForm
     */
   public ShoppingCart(LoginUser luser) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
            
        u = luser;
       
       
       getNewData();
       
    }
    
        private void getNewData() {
            nameText.setText("");
            priceText.setText("");
            quantityText.setText("");
            ISBNText.setText("");
            totalText.setText("");
            quantityCost.setText("");
        try {
            
//            con.rs = con.executeStatement("select bo.orderno, b.Name, bo.quantity, b.price, o.total, b.ISBN from Book b, Book_Order bo, "
//                    + "orders o where b.isbn = bo.isbn and o.orderno = bo.orderno and o.status=0 and o.username='"
//                    + u.username + "' order by o.timestamp asc");
            con.rs = con.executeStatement("select bo.orderno, b.Name, bo.quantity, b.price, o.total, b.ISBN from Comic b, Comic_Order bo, orders o where b.isbn = bo.isbn and o.orderno = bo.orderno and o.status=0 and o.username='" + u.username+ "' order by o.timestamp asc");
            
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
            //populate fiels from ResultSet data
            nameText.setText(con.rs.getString("Name"));
            priceText.setText(con.rs.getString("price"));
            quantityText.setText(con.rs.getString("quantity"));
            ISBNText.setText(con.rs.getString("isbn"));
            totalText.setText(con.rs.getString("total"));
            double tempCost = Double.parseDouble(priceText.getText())*Double.parseDouble(quantityText.getText());
            quantityCost.setText(""+tempCost);
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
        nameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        HomeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        checkoutButton = new javax.swing.JButton();
        priceText = new javax.swing.JTextField();
        quantityText = new javax.swing.JTextField();
        ISBNText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        quantityCost = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Online Bookstore Sign In Page");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Name:");

        nameText.setEditable(false);
        nameText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Shopping Cart");

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("ISBN:");

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

        checkoutButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        checkoutButton.setText("Checkout");
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Cart Total:");

        totalText.setEditable(false);
        totalText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTextActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Cost of Comics:");

        quantityCost.setEditable(false);
        quantityCost.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantityCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityCostActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDelete.setText("Remove Comic");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/databaseproject/pics/icons8-pow-50.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(82, 82, 82)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(quantityText)
                                        .addComponent(ISBNText)
                                        .addComponent(priceText)
                                        .addComponent(quantityCost)
                                        .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(checkoutButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(198, 198, 198)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(quantityCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ISBNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNext)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPrevious)
                                .addComponent(btnDelete)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(checkoutButton)))
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

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextActionPerformed

    private void quantityTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTextActionPerformed

    private void ISBNTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNTextActionPerformed

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
        try {
            // TODO add your handling code here:
            // TODO add your handling code here:
            //con.rs.getString("orderno");
            
            /*
            select book_order where orderno = con.rs.getString("orderno")
            decrease the quantity of each book thats in that result set
            set status = 1 in orders where orderno = con.rs.getString("orderno")
            */
            
            con.rs = con.executeStatement("select * from comic_order where orderno = " + con.rs.getString("orderno"));
            
            while(con.rs.next()){
                con.rs2 = con.executeStatement2("select * from comic where ISBN='" + con.rs.getString("isbn") + "'");
                con.rs2.next();
                
                System.out.println("Current rs isbn: " + con.rs.getString("isbn"));
                System.out.println("Current rs2 isbn: " + con.rs2.getString("isbn"));
                
                int currentQuantity = Integer.parseInt(con.rs2.getString("quantity"));
                System.out.println("Before: " + currentQuantity);
                //do validation
                currentQuantity -= Integer.parseInt(con.rs.getString("quantity"));
                System.out.println("After: " + currentQuantity);
                if(currentQuantity>-1){
                    con.executePrepared("update comic set quantity = " + currentQuantity + " where ISBN='" + con.rs.getString("isbn") + "'");
                }
                else {
                    con.executePrepared("delete from comic_order where orderno = " + con.rs.getString("orderno") + " and ISBN='" + con.rs.getString("isbn") + "'");
                    javax.swing.JLabel label = new javax.swing.JLabel("ERROR: Comic with ISBN removed from cart!\nQuantity in cart is more than remaining stock!");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            con.executePrepared("update orders set status = 1 where username = '" + u.username + "'");
            
            
            javax.swing.JLabel label = new javax.swing.JLabel("Checkout completed! Clearing cart.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            
            getNewData();
            
            
        } catch (SQLException ex) {
            javax.swing.JLabel label = new javax.swing.JLabel("Cart is Empty!");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_checkoutButtonActionPerformed

    private void totalTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTextActionPerformed

    private void quantityCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityCostActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
                try {
            System.out.println(ISBNText.getText() + con.rs.getString("orderno"));
            con.executePrepared("delete from comic_order where orderno='" + con.rs.getString("orderno") + "' and isbn = '" + ISBNText.getText() + "'");
            getNewData();
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeButton;
    private javax.swing.JTextField ISBNText;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField priceText;
    private javax.swing.JTextField quantityCost;
    private javax.swing.JTextField quantityText;
    private javax.swing.JTextField totalText;
    // End of variables declaration//GEN-END:variables
}
