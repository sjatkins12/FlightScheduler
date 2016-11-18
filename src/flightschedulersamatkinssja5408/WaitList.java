/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightschedulersamatkinssja5408;
import java.util.LinkedList;
import java.sql.*;
/**
 *
 * @author samatkins
 */
public class WaitList {
    private LinkedList waitList;
    private final Flight flight;
    
    public WaitList(Flight flight)
    {
        waitList = new LinkedList<Customer>();
        this.flight = flight;
    }
    
    public void addCustomer(Customer customer)
    {
        waitList.add(customer);
        
        try 
        {
            Connection connection = DriverManager.getConnection(
            FlightSchedulerSamAtkinssja5408.URL, "java", "java");
            PreparedStatement insertQuery = connection.prepareStatement(
                    "INSERT INTO WaitList (flightId, customerId)"
                    + " VALUES (?, ?)");
            insertQuery.setString(1, "" + flight.getFlightId());
            insertQuery.setString(2, "" + customer.getCustomerId());
            insertQuery.executeQuery();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public Customer popFront()
    {
        Customer ret = (Customer) waitList.pop();
        try 
        {
            Connection connection = DriverManager.getConnection(
            FlightSchedulerSamAtkinssja5408.URL, "java", "java");
            PreparedStatement deleteQuery = connection.prepareStatement(
                    "DELETE FROM WaitList WHERE customerId = ?");
            deleteQuery.setString(1, "" + ret.getCustomerId());
            deleteQuery.executeQuery();
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return (ret);
    }
}
