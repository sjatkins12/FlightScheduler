/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightschedulersamatkinssja5408;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author samatkins
 */
public class FlightSchedulerSamAtkinssja5408 {
    protected static final String URL = "jdbc:derby://localhost:1527/FlightSchedulerSamAkinssja5408";
    protected static Connection connection;
    protected static BookingPanel bookingPanel;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
             connection = DriverManager.getConnection(
                        FlightSchedulerSamAtkinssja5408.URL, "java", "java");
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
            }
            catch (ClassNotFoundException ex) {
                System.out.println(ex.getStackTrace());
            }
            Day day = new Day(03, 31, 16);
            Day dy = new Day(04, 01, 16);
            Day dayy = new Day(04, 02, 16);
            Flight flight = new Flight(2, "F101");
            Flight flights = new Flight(2, "D303");
            Flight fight = new Flight(2, "H445");
            //Customer customer = new Customer("Ben Gibson");
            //customer.addToFlight(flight);
            //System.out.print(flight.getStatus());
            FlightSchedulerFrame frame = new FlightSchedulerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 300);
            frame.setVisible(true);
            DriverManager.getConnection(URL +";shutdown=true");
        } 
        catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
    
    
}
