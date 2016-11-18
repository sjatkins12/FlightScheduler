/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightschedulersamatkinssja5408;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author samatkins
 */
public class FlightSchedulerFrame extends JFrame {
    private TextArea area;
    
    
    public FlightSchedulerFrame()
    {
        super("Flight Scheduler");
        setLayout(new BorderLayout());
        add(new NamePanel(), BorderLayout.NORTH); 
    }
    
    
}
