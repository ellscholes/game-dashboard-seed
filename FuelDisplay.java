import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class FuelDisplay extends JPanel {
    private static final long serialVersionUID = 42l;
    
    /* TODO create GUI elements to display fuel state
            and related information
    */
    private JLabel title, status;
    private ImageIcon red, green, grey, orange;
    private JTextField percentBox;
    
	public FuelDisplay() {
        /* TODO apply layout manager,
                add GUI elements to Panel,
        */
        super( new FlowLayout( FlowLayout.LEFT, 5, 2));
        /*CREATE BORDER AND TITLE NAME*/
        setBorder( BorderFactory.createTitledBorder("Current Fuel % "));
        
	/*CREATE AND ADD IMAGES TO VARIABLES*/
        red = new ImageIcon(getClass().getResource("led-red.png"));
        green = new ImageIcon(getClass().getResource("led-green.png"));
        grey = new ImageIcon(getClass().getResource("led-grey.png"));
        orange = new ImageIcon(getClass().getResource("led-orange.png"));
        
	/*CREATE TITLE FOR LABEL*/
        title = new JLabel();
        title.setText("Fuel: ");
        add(title);
       
	/*CREATE AND ADD TEXT BOX ALONGSIDE FOR FUEL DISPLAY*/
        percentBox =  new JTextField(20);
        percentBox.setEditable(false);
        add(percentBox);
        
	/*CREATE AND SET STATUS IMAGE COLOUR*/
        status = new JLabel();
        add(status);
        status.setIcon(grey);
    }

    public void setFuel(float percent, boolean fly) {
        /* TODO update display with new fuel
                quantity value
        */
        String text =  "" + percent;
	percentBox.setText(text);

	/*IF FUEL IS BETWEEN 70-100, IMAGE GREEN AND SHOW THE PERCENTAGE*/
        if (percent <= 100.00 && percent >= 70.00 && fly == true){
            status.setIcon(green);
	   
        }
	/*IF FUEL IS BETWEEN 30-70, IMAGE ORANGE AND SHOW THE PERCENTAGE*/
        else if (percent <= 69.99 && percent >= 30.00 && fly == true ){
            status.setIcon(orange);
	   
        }
	/*IF FUEL IS BETWEEN 0-30, IMAGE RED AND SHOW THE PERCENTAGE*/
        else if (percent <= 29.99 && percent >= 0 && fly == true){
            status.setIcon(red);
	  
        }
	/*LANDER NOT IN FLIGHT SHOW CRASH TEXT*/
        else if (fly == false){
            status.setIcon(red);
            percentBox.setText("CRASH LANDING!");
        }
    }
}
