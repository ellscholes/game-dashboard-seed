import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class LanderDash extends JFrame implements Runnable {
    public static final long serialVersionUID = 2L;
    public static void main ( String[] args ) throws UnknownHostException {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new LanderDash();
            }
        });
    }

    /* Information from Lander to Display */
    /*DECLARE VARIABLES FOR INFO FROM GAME CONTROLLER*/
    float fuel;
    float alt;
    boolean flying;
    int vX, vY;
    
    /*DECLARE PANELS TO DISPLAY*/
    AltitudeDisplay altitudeDisplay = new AltitudeDisplay();
    FuelDisplay fuelDisplay = new FuelDisplay();
    StatusDisplay statusDisplay = new StatusDisplay();
    VelocityDisplay velocityDisplay = new VelocityDisplay();
    
    /* Panel to display IP and port numnber */
    DatagramPanel connection = new DatagramPanel();


    public LanderDash(){
        super("Lunar Lander Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(
            new BoxLayout(getContentPane(),BoxLayout.Y_AXIS) );
        
        fuel = 0;
        alt = 0;
        
 	/* TODO add pannels to window */
        add(statusDisplay);
        add(altitudeDisplay);
        add(velocityDisplay);
        add(fuelDisplay);
	add( connection ) ;

        pack();
        setVisible(true);
         (new Thread(this)).start();
    }

    public void run(){
        try {
            InetAddress addr = InetAddress.getLocalHost();
            int portno = 65250;
            DatagramSocket socket = new DatagramSocket(portno, addr);
            connection.setAddress((InetSocketAddress)socket.getLocalSocketAddress());

            while(true){
                /* set up socket for reception */
                if(socket!=null){
                /* start with fresh datagram packet */
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive( packet );
                    /* extract message and pick appart into
                       lines and key:value pairs
                    */
                    String message = new String(packet.getData());

                    /*TODO adjust message parsing, if you're not
                        using key:value pairs in a line oriented
                        protocol
                    */
                    String[] lines = message.trim().split("\n");
                    for(String l : lines){
                        String[] pair = l.split(":");
 
 			/* TODO act on key value pairs,
                            setting properties to display */
                        if (pair[0].equals("altitude")){
                            alt = parseFloat(pair[1]);
                            
                        }
                        else if(pair[0].equals("fuel")){
                            fuel = parseFloat(pair[1]);

                        }
                        else if(pair[0].equals("flying")){
                            if (parseInt(pair[1]) == 1){
                                flying = true;
                            }
                            else if(parseInt(pair[1]) == 0){
                                flying = false;
                            }
                        }
                        else if(pair[0].equals("oVx")){
                            vX = parseInt(pair[1]);
                        }
                        else if(pair[0].equals("oVy")){
                            vY = parseInt(pair[1]);
                        }
                        }
                        fuelDisplay.setFuel(fuel, flying);
                        altitudeDisplay.setAltitude(alt, flying);
                        statusDisplay.setStatus(flying);
                        velocityDisplay.setVelocity(vX, vY);
                        }
                    
                
                try{Thread.sleep(100);}catch(InterruptedException e){}
            }
            }
        
        catch(Exception e) {
            System.err.println(e);
            System.err.println("in LanderDash.run()");
            System.exit(-1);
        }
    }
}
