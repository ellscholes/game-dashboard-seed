import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class StatusDisplay extends JPanel {
    private static final long serialVersionUID = 42l;

    /* TODO create GUI elements to display status and related
            information
    */
    private JLabel title, status;
    private ImageIcon red, green, grey;
    private JTextField feedback;

    public StatusDisplay(){
 	/* TODO apply layout manager,
                add GUI elements to Panel,
        */
        super( new FlowLayout( FlowLayout.LEFT, 5, 2));
	/*CREATE BORDER AND TITLE NAME*/
        setBorder( BorderFactory.createTitledBorder("Current Status"));

	/*CREATE AND ADD IMAGES TO VARIABLES*/
        red = new ImageIcon(getClass().getResource("led-red.png"));
        green = new ImageIcon(getClass().getResource("led-green.png"));
        grey = new ImageIcon(getClass().getResource("led-grey.png"));

	/*CREATE TITLE FOR LABEL*/
        title = new JLabel();
        title.setText("Status: ");
        add(title);

	/*CREATE AND ADD TEXT BOX ALONGSIDE FOR STATUS DISPLAY*/
        feedback =  new JTextField(20);
        feedback.setEditable(false);
        add(feedback);

	/*CREATE AND SET STATUS IMAGE COLOUR*/
        status = new JLabel();
        add(status);
        status.setIcon(grey);
    }

    public void setStatus(boolean flying){
	/* TODO update display with status value */

	/*IF LANDER IS FLYING SHOW FLIGHT TEXT AND GREEN IMAGE*/
        if(flying){
            feedback.setText("In Flight");
            status.setIcon(green);
        }
	/*IF LANDER IS NOT FLYING SHOW CRASHED TEXT AND RED IMAGE*/
        else{
            feedback.setText("CRASH LANDING!");
            status.setIcon(red);
        }
    }
}
