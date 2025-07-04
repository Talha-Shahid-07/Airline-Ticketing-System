/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
//Anoud i do hope you read this lol, yahan pr airline ky hisaab se kya required data
// wo tum add kr dena
//nvm maine kr diya khudi
package airlineticketingsystem;

/**
 *
 * @author Talha Shahid
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class AirlineRegistrationForm extends javax.swing.JFrame {

    /**
     * Creates new form AirlineRegistrationForm
     */
    public AirlineRegistrationForm() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    class AirlineRegistrationClass {

        ConnectionToDB conn = new ConnectionToDB();
        Connection con = conn.EstablishConnection();
        Statement stmt = null;

        public boolean addAirline(String name, String owner, String manager, String email, String password) {
            String registerQuery = "insert into Airlines(NameOfAirline,Owner,Manager,Email,Password) values ('" + name + "','" + owner + "','" + manager + "','" + email + "','" + password + "')";
            try {
                stmt = con.createStatement();
                int res = stmt.executeUpdate(registerQuery);
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Registered!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return false;
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

        lblUseRegForm = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhnum = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtOwner = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblPass1 = new javax.swing.JLabel();
        pwdAirline = new javax.swing.JPasswordField();
        txtManager = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));

        lblUseRegForm.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblUseRegForm.setForeground(new java.awt.Color(0, 0, 102));
        lblUseRegForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUseRegForm.setText("Airline Registration Form");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(45, 213, 171), 2));

        lblName.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 0, 102));
        lblName.setText("Name of Airline:");

        lblEmail.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 0, 102));
        lblEmail.setText("Managed by:");

        lblPhnum.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        lblPhnum.setForeground(new java.awt.Color(0, 0, 102));
        lblPhnum.setText("Owner/Parent Company:");

        lblPass.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        lblPass.setForeground(new java.awt.Color(0, 0, 102));
        lblPass.setText("Email of Manager:");

        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtOwner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblPass1.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        lblPass1.setForeground(new java.awt.Color(0, 0, 102));
        lblPass1.setText("Password:");

        pwdAirline.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));

        txtManager.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 2));
        txtManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManagerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPhnum)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pwdAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtManager, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmail)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPhnum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addGap(12, 12, 12)
                .addComponent(txtManager, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPass)
                .addGap(8, 8, 8)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPass1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btnBack.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(102, 204, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRegister.setBackground(new java.awt.Color(45, 213, 171));
        btnRegister.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblUseRegForm)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUseRegForm, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AirlineMainForm form = new AirlineMainForm();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String name = txtName.getText();
        String owner = txtOwner.getText();
        String manager = txtManager.getText();
        String email = txtEmail.getText();
        String password = String.valueOf(pwdAirline.getPassword());

        if (!name.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Invalid name! Please enter only alphabets for your name.");
            return; // Exit the method if validation fails
        }

        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Invalid email! Please enter a valid email address containing '@'.");
            return;
        }

        AirlineRegistrationClass register = new AirlineRegistrationClass();
        if (!register.addAirline(name, owner, manager, email, password)) {
            JOptionPane.showMessageDialog(null, "Airline could not be registered!");
        } else {
            AirlineLoginForm form = new AirlineLoginForm();
            form.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManagerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManagerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPass1;
    private javax.swing.JLabel lblPhnum;
    private javax.swing.JLabel lblUseRegForm;
    private javax.swing.JPasswordField pwdAirline;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtManager;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOwner;
    // End of variables declaration//GEN-END:variables
}
