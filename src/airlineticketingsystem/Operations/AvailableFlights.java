/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airlineticketingsystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Talha Shahid
 */
public class AvailableFlights extends javax.swing.JFrame {

    /**
     * Creates new form AvailableFlights
     */
    public AvailableFlights() {
        initComponents();
        displayFlights();
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public class FlightDatabase {

        public ArrayList<String[]> getFlights() {
            ArrayList<String[]> flightList = new ArrayList<>();
            ConnectionToDB conn = new ConnectionToDB();
            Connection con = conn.EstablishConnection();
            String query = "SELECT * FROM flights"; // Adjust the query based on your database schema

            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String[] flight = new String[9]; // Adjust the size based on the number of columns
                    flight[0] = rs.getString("flightNumber");
                    flight[1] = rs.getString("departureCity");
                    flight[2] = rs.getString("arrivalCity");
                    flight[3] = rs.getString("flightClass");
                    flight[4] = rs.getString("priceOfTicket");
                    flight[5] = rs.getString("departureDate");
                    flight[6] = rs.getString("returnDate");
                    flight[7] = rs.getString("numberOfSeats");
                    flight[8] = rs.getString("Company");
                    flightList.add(flight);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return flightList;
        }
    }

    public class FlightTableModel extends DefaultTableModel {

        private final String[] columnNames = {"Flight Number", "Departure City", "Arrival City", "Flight Class", "Price of Tickets", "Departure Date", "Return Date", "Number of Seats", "Company"};

        public FlightTableModel(ArrayList<String[]> flightData) {
            super();
            this.setColumnIdentifiers(columnNames);
            for (String[] flight : flightData) {
                this.addRow(flight);
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Make cells non-editable
        }
    }

    private void displayFlights() {
        FlightDatabase flightDb = new FlightDatabase();
        ArrayList<String[]> flights = flightDb.getFlights();
        FlightTableModel model = new FlightTableModel(flights);
        jTable1.setModel(model);
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
        jTable1 = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnBack))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
