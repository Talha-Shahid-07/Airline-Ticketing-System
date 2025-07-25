/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airlineticketingsystem;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Talha Shahid
 */
public class UserFlights extends javax.swing.JFrame {

    /**
     * Creates new form UserFlights
     */
    public UserFlights() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        btnShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUsername.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 102));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lblUsername.setText("Verify Username");

        btnShow.setBackground(new java.awt.Color(45, 213, 171));
        btnShow.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnShow.setForeground(new java.awt.Color(255, 255, 255));
        btnShow.setText("Show Flights");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "User ID", "Flight Number", "From", "To"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addGap(84, 84, 84)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShow)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        String userName = txtUsername.getText();

        if (userName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your UserName!");
        }

        showUserFlights(userName);


    }//GEN-LAST:event_btnShowActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UserDashboardForm form = new UserDashboardForm();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showUserFlights(String username) {
        ConnectionToDB conn = new ConnectionToDB();
        Connection con = conn.EstablishConnection();
        String query = "SELECT * FROM bookedFlights WHERE UserID = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet res = pstmt.executeQuery();

            ArrayList<String[]> flightList = new ArrayList<>();
            while (res.next()) {
                String[] flight = new String[5];
                flight[0] = res.getString("BookingID");
                flight[1] = res.getString("UserID");
                flight[2] = res.getString("FlightNumber");
                flight[3] = res.getString("From");
                flight[4] = res.getString("To");
                flightList.add(flight);
            }
            displayFlights(flightList);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void displayFlights(ArrayList<String[]> flights) {
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"Booking ID", "User ID", "Flight Number", "From", "To"};
        model.setColumnIdentifiers(columnNames);
        for (String[] flight : flights) {
            model.addRow(flight);
        }
        jTable1.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
