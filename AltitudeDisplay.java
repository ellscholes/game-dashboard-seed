import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class AltitudeDisplay extends JPanel {
    private static final long serialVersionUID = 42l;
    
    /* TODO create GUI elements to display altitude and related
            information
    */
    private JLabel title, status;
    private ImageIcon red, green, grey, orange;
    private JTextField altBox;

    public AltitudeDisplay() {
        /* TODO apply layout manager,
                add GUI elements to Panel,
        */
        super( new FlowLayout( FlowLayout.LEFT, 5, 2));
	/*CREATE BORDER AND TITLE NAME*/
        setBorder( BorderFactory.createTitledBorder("Current Altitude"));
        
	/*CREATE AND ADD IMAGES TO VARIABLES*/
        red = new ImageIcon(getClass().getResource("led-red.png"));
        green = new ImageIcon(getClass().getResource("led-green.png"));
        grey = new ImageIcon(getClass().getResource("led-grey.png"));
        orange = new ImageIcon(getClass().getResource("led-orange.png"));
        
	/*CREATE TITLE FOR LABEL*/
        title = new JLabel();
        title.setText("Alt: ");
        add(title);
        
	/*CREATE AND ADD TEXT BOX ALONGSIDE FOR ALT DISPLAY*/
        altBox =  new JTextField(20);
        altBox.setEditable(false);
        add(altBox);
        
	/*CREATE AND SET STATUS IMAGE COLOUR*/
        status = new JLabel();
        add(status);
        status.setIcon(grey);
    }

    public void setAltitude(float alt, boolean fly) {

 	/* TODO update display with altitude value */
        altBox.setText("" + alt);
        
	/*IF ALT IS ABOVE 60 SHOW GREEN*/
        if(alt >= 60.00 && fly == true){
            status.setIcon(green);
        }
	/*IF ALT IS BELOW 60 & ABOVE 30 SHOW ORANGE*/
        else if(alt <= 59.99 && alt >= 30.00 && fly == true){
            status.setIcon(orange);
        }
	/*IF ALT IS BELOW 30 & ABOVE 0 SHOW RED*/
        else if(alt <= 29.99 && alt >= 0 && fly == true){
            status.setIcon(red);
        }
	/*IF LANDER IS NOT FLYING SET RED AND SHOW TEXT*/
        else if(fly == false){
            status.setIcon(red);
            altBox.setText("CRASH LANDING!");
        }
    }
    
}
