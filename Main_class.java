package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){

        // HOME BACKGROUND IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        // HEADING
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,115,400,120);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);

        // ADD EMPLOYEE BUTTON
        JButton add = new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);

        add.addActionListener(e -> {

            new Addemployee(); // Open Add Employee Window
            setVisible(false);

        });

        img.add(add);

        // VIEW EMPLOYEE BUTTON
        JButton view = new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);

        view.addActionListener(e -> {

            new ViewEmployee(); // Open View Employee Window
            setVisible(false);

        });

        img.add(view);

        // REMOVE EMPLOYEE BUTTON
        JButton rem = new JButton("Remove Employee");
        rem.setBounds(450,370,150,40);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);

        rem.addActionListener(e -> {

            new RemoveEmployee(); // Open Remove Employee Window
            setVisible(false);

        });

        img.add(rem);

        // FRAME SETTINGS
        setSize(1120,630);
        setLocation(150,100);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Main_class();

    }
}