package airlineticketingsystem;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionToDB {

    Connection con = null;

    public Connection EstablishConnection() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // Use getResource to get the relative path
            String url = "C:\\Users\\Talha Shahid\\Desktop\\AirlineTicketingSystem\\AirlineTicketingSystem\\AirlineTicketingSystem\\src\\Resources\\Information.accdb";
            
            // Connect to the database
            con = DriverManager.getConnection("jdbc:ucanaccess://" + url);
            System.out.println("Connected!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
