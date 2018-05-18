
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;

import java.net.*;
import java.io.*;

/* Place holder for ip-address and port number for internet addressing */
public class DatagramPanel extends JPanel {
    public static final long serialVersionUID = 2L;

    JTextField addressname, port;

    public DatagramPanel() {
        /* create a JPanel populated with border and text fields */
        super( new FlowLayout( FlowLayout.LEFT, 20, 10));
        setBorder( BorderFactory.createTitledBorder("Socket Address"));
        add(new JLabel("IP:        "));
        addressname = new JTextField(15);
        add(this.addressname);
        add(new JLabel("Port:      "));
        port = new JTextField(15);
        add(this.port);
    }
    void setAddress(InetSocketAddress where){
        addressname.setText(where.getHostString());
        port.setText( Integer.toString(where.getPort()) );
    }
}
