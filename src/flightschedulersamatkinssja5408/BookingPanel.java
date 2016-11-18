/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightschedulersamatkinssja5408;
import static flightschedulersamatkinssja5408.FlightSchedulerSamAtkinssja5408.connection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 *
 * @author samatkins
 */
public class BookingPanel extends JPanel{
    private String flightName;
    private int flightId;
    private int dayId;
    private String date;
    protected static Boolean displayed = false;
    protected static TextArea area;
    private JComboBox<String> flightBox;
    private JComboBox<String> dateBox;
    private JButton flightStatus = new JButton("Flight Status");
    private JButton book = new JButton("Book");
    
    public BookingPanel(Customer customer)
    {
        flightBox = new JComboBox<String>();
        flightBox.addItemListener(
        new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                flightName = (String) e.getItem();
                flightId = flightBox.getSelectedIndex();
            }
            
        });
        dateBox = new JComboBox<String>();
        dateBox.addItemListener(
        new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) {
                date = (String) e.getItem();
                dayId = dateBox.getSelectedIndex();
            }
            
        });
        try
        {
            PreparedStatement selectQuery = connection.prepareStatement(
                    "SELECT name FROM Flights");
            ResultSet set = selectQuery.executeQuery();
            while (set.next())
            {
                flightBox.addItem(set.getString(1));
            }
            selectQuery = connection.prepareStatement(
                    "SELECT date FROM Days");
            set = selectQuery.executeQuery();
            while (set.next())
            {
                dateBox.addItem(set.getString(1));
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getStackTrace());
        }
        book.addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayed = true;
                String ret = "Flight: " + getFlightName() 
                        + "\tDate: " + getDate() + "\n";
                Bookings booking;
                booking = new Bookings(flightId, dayId, customer.getCustomerId());
                try
                {
                    ret += getStatus();
                }
                catch (SQLException sqlException)
                {
                    ret += "SQL Exception";
                    sqlException.printStackTrace();
                }
                createText(ret);
            }
        });
        flightStatus.addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayed = true;
                String ret = "Flight: " + getFlightName() 
                        + "\tDate: " + getDate() + "\n";
                try
                {
                    ret += getStatus();
                }
                catch (SQLException sqlException)
                {
                    ret += "SQL Exception";
                    sqlException.printStackTrace();
                }
                createText(ret);
            }
        });
        add(new JLabel("Flights: "));
        add(flightBox);
        add(new JLabel("Dates: "));
        add(dateBox);
        add(book);
        add(flightStatus);
    }
    
    private void createText(String ret)
    {
        area = new TextArea(ret);
        getTopLevelAncestor().add(area, BorderLayout.CENTER);
        getTopLevelAncestor().repaint();
        getTopLevelAncestor().validate();
    }
    
    private String getStatus() throws SQLException
    {
        String ret = "";
        PreparedStatement selectQuery = connection.prepareStatement(
            "SELECT name FROM Customers"
                    + " INNER JOIN Bookings ON Customers.customerId = "
                    + "Bookings.customerId"
                    + " WHERE Bookings.flightId = ? AND Bookings.dayId = ?");
        selectQuery.setString(1, "" + flightId);
        selectQuery.setString(2, "" + dayId);
        ResultSet set = selectQuery.executeQuery();
        while (set.next())
        {
            ret += set.getString(1);
            ret += "\n";
        }
        return (ret);
    }
    
    public void addFlight(Flight flight)
    {
        flightBox.addItem(flight.getName());
    }
    
    public void addDay(Day day)
    {
        dateBox.addItem(day.getDate());
    }
    /**
     * @return the flightName
     */
    public String getFlightName() {
        return flightName;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }
}
