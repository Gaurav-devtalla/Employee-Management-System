package employee.management.system;

import javax.swing.*;
import java.awt.*;

public class Ems extends JFrame {

    Ems() {

        // Load splash image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);

        // Frame settings
        setSize(1170,650);
        setLocation(100,50);
        setLayout(null);
        setVisible(true);

        // Timer to open login page after 4.5 seconds
        Timer timer = new Timer(4500, e -> {

            setVisible(false);
            new Login();

        });

        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {

        new Ems();

    }
}