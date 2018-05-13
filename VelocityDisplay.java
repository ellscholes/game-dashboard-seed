import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;


public class VelocityDisplay extends JPanel {
    private static final long serialVersionUID = 42l;
    
    /* TODO create GUI elements to display altitude and related
            information
    */
    private JLabel vX, vY;
    private JTextField vXBox, vYBox;
    
    public VelocityDisplay(){
        /* TODO apply layout manager,
                add GUI elements to Panel,
        */
        super( new FlowLayout( FlowLayout.LEFT, 5, 2));
        /*CREATE BORDER AND TITLE NAME*/
        setBorder( BorderFactory.createTitledBorder("Current Velocity "));
        
	/*CREATE TITLE FOR LABEL*/
        vX = new JLabel();
        vX.setText("Vx: ");
        add(vX);
        
	/*CREATE AND ADD FIELD DISPLAYING VELOCITY X AXIS*/
        vXBox =  new JTextField(20);
        vXBox.setEditable(false);
        add(vXBox);
        
	/*CREATE TITLE FOR LABEL*/
        vY = new JLabel();
        vY.setText("Vy: ");
        add(vY);
        
	/*CREATE AND ADD FIELD DISPLAYING VELOCITY Y AXIS*/
        vYBox =  new JTextField(20);
        vYBox.setEditable(false);
        add(vYBox);
    }
    
    public void setVelocity(int vX, int vY){
	/* TODO update display with velocity value */
        vXBox.setText("" + vX);
        vYBox.setText("" + vY);
    }
}
