/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airlineticketingsystem;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Talha Shahid
 */
public class BookFlightForm extends javax.swing.JFrame {

    /**
     * Creates new form BookFlightForm
     */
    public BookFlightForm() {
        initComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        // Add focus listeners
        addPlaceholderStyle(txtFlightNumber, "Flight Number");

        // Initialize with placeholders
        initPlaceholders();
    }

    private void addPlaceholderStyle(javax.swing.JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void initPlaceholders() {
        txtFlightNumber.setText("Flight Number");
        txtFlightNumber.setForeground(Color.GRAY);
    }

    class BookFlight {

        ConnectionToDB conn = new ConnectionToDB();
        Connection con = conn.EstablishConnection();
        PreparedStatement pstmt = null;
        ResultSet res = null;

        public boolean bookFlight(String flightNumber, String username) {
            String userID, flightNumberToStore, to, from;
            String bookingQuery = "SELECT * FROM Flights WHERE flightNumber = ? AND NumberOfSeats > 0";
            boolean booked = false;
            try {
                pstmt = con.prepareStatement(bookingQuery);
                pstmt.setString(1, flightNumber);
                res = pstmt.executeQuery();
                if (res.next()) {
                    
                    userID = username;
                    flightNumberToStore = res.getString("flightNumber");
                    to = res.getString("arrivalCity");
                    from = res.getString("departureCity");

                    // Flight exists and has available seats
                    String updateSeatsQuery = "UPDATE Flights SET NumberOfSeats = NumberOfSeats - 1 WHERE FlightNumber = ?";
                    pstmt = con.prepareStatement(updateSeatsQuery);
                    pstmt.setString(1, flightNumber);
                    int rowsUpdated = pstmt.executeUpdate();
                    
                    storeBooking(userID, flightNumberToStore, to, from);
                    
                    if (rowsUpdated > 0) {
                        booked = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Flight either full or does not exist!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } finally {
                try {
                    if (res != null) {
                        res.close();
                    }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            return booked;
        }

        private boolean storeBooking(String userID, String flightNumberToStore, String to, String from) {
            
            boolean status = false;
            try{
            String insertBookingQuery = "INSERT INTO bookedFlights (UserID, flightNumber, from, to) VALUES (?, ?, ?, ?)";
            pstmt = con.prepareStatement(insertBookingQuery);
            pstmt.setString(1, userID);
            pstmt.setString(2, flightNumberToStore);
            pstmt.setString(3, from);
            pstmt.setString(4, to);
            int rowsInserted = pstmt.executeUpdate();
            
            if (rowsInserted > 0){
                status = true;
            }
            
            return rowsInserted > 0;
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error storing booking information!");
            }
            return status;
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

        lblTitle = new javax.swing.JLabel();
        txtFlightNumber = new javax.swing.JTextField();
        btnBook = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAvailableFlight = new javax.swing.JButton();
        lblFlightNumber = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblTitle.setText("Book Your Flight");

        txtFlightNumber.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtFlightNumber.setForeground(new java.awt.Color(0, 0, 102));
        txtFlightNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFlightNumberActionPerformed(evt);
            }
        });

        btnBook.setBackground(new java.awt.Color(45, 213, 171));
        btnBook.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnBook.setForeground(new java.awt.Color(255, 255, 255));
        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(102, 204, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAvailableFlight.setBackground(new java.awt.Color(45, 213, 171));
        btnAvailableFlight.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnAvailableFlight.setForeground(new java.awt.Color(255, 255, 255));
        btnAvailableFlight.setText("Show Available Flight");
        btnAvailableFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvailableFlightActionPerformed(evt);
            }
        });

        lblFlightNumber.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lblFlightNumber.setText("Enter Flight Number");

        txtUsername.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 102));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lblUsername.setText("Verify Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnAvailableFlight))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFlightNumber)
                                .addGap(53, 53, 53)
                                .addComponent(txtFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblUsername)
                                    .addGap(84, 84, 84)
                                    .addComponent(txtUsername))))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblTitle)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFlightNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFlightNumber))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addGap(18, 18, 18)
                .addComponent(btnBook)
                .addGap(24, 24, 24)
                .addComponent(btnAvailableFlight)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        UserDashboardForm form = new UserDashboardForm();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        String flightNumber = txtFlightNumber.getText();
        String userName = txtUsername.getText();

        if (flightNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a Flight number");
        }

        BookFlight book = new BookFlight();
        if (book.bookFlight(flightNumber,userName)) {
            JOptionPane.showMessageDialog(null, "Flight has been booked!");
            txtFlightNumber.setText("");
            txtUsername.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Flight not Booked");
        }

    }//GEN-LAST:event_btnBookActionPerformed

    private void btnAvailableFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvailableFlightActionPerformed
        AvailableFlights form = new AvailableFlights();
        form.setVisible(true);
    }//GEN-LAST:event_btnAvailableFlightActionPerformed

    private void txtFlightNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlightNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlightNumberActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvailableFlight;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBook;
    private javax.swing.JLabel lblFlightNumber;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtFlightNumber;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
