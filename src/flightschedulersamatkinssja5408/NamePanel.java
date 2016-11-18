/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightschedulersamatkinssja5408;
import static flightschedulersamatkinssja5408.FlightSchedulerSamAtkinssja5408.bookingPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author samatkins
 */
public class NamePanel extends JPanel {
    private JTextArea first;
    private JTextArea second;
    private String name;
    private JPanel centerPan = new JPanel(new FlowLayout());
    private JButton enter = new JButton("Enter Name");
    private JButton changeName = new JButton("Change Name");
    private JLabel label = new JLabel();
    private Customer curr;
 
    
    public NamePanel()
    {
        super();
        setLayout(new BorderLayout());
        add(centerPan, BorderLayout.NORTH);
        first = new JTextArea("First Name", 2, 10);
        second = new JTextArea("Last Name", 2, 10);
        centerPan.add(first);
        centerPan.add(second);
        centerPan.add(enter);
        enter.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                
                name = first.getText() + " " + second.getText();
                centerPan.removeAll();
                label.setText("Welcome " + getName());
                curr = new Customer(name);
                bookingPanel = new BookingPanel(curr);
                centerPan.add(label);
                centerPan.add(changeName);
                centerPan.repaint();
                centerPan.setVisible(true);
                add(bookingPanel, BorderLayout.CENTER);
                getTopLevelAncestor().setVisible(true);
                
            }
        });
        changeName.addActionListener(
        new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                name = "";
                curr = null;
                centerPan.removeAll();
                remove(bookingPanel);
                if (BookingPanel.displayed)
                    getTopLevelAncestor().remove(BookingPanel.area);
                centerPan.add(first);
                centerPan.add(second);
                centerPan.add(enter);
                centerPan.repaint();
                centerPan.setVisible(true);
                getTopLevelAncestor().setVisible(true);
                
            }
        });
    }
    
    private void removeTextArea()
    {
        getTopLevelAncestor().remove(BookingPanel.area);
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
