package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    // Text fields for user input
    JTextField tusername;
    JPasswordField tpassword;

    // Buttons
    JButton login, back;

    Login(){

        // USERNAME LABEL
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        // USERNAME TEXTFIELD
        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        // PASSWORD LABEL
        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        // PASSWORD FIELD
        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        // LOGIN BUTTON
        login = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        // BACK BUTTON
        back = new JButton("Back");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        // RIGHT SIDE IMAGE
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350,10,600,400);
        add(imgg);

        // BACKGROUND IMAGE
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        // FRAME SETTINGS
        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // LOGIN BUTTON CLICK
        if(e.getSource() == login){

            try{

                // Getting user input
                String username = tusername.getText();
                String password = new String(tpassword.getPassword());

                // Database connection
                conn c = new conn();

                // SQL Query
                String query = "select * from login where username='"
                        + username + "' and password='" + password + "'";

                ResultSet resultSet = c.statement.executeQuery(query);

                // If record found
                if(resultSet.next()){

                    setVisible(false);
                    new Main_class();

                }else{

                    JOptionPane.showMessageDialog(null,
                            "Invalid Username Or Password ❌");

                }

            }catch(Exception ex){

                ex.printStackTrace();

            }

        }

        // BACK BUTTON CLICK
        else if(e.getSource() == back){

            System.exit(0);

        }
    }

    public static void main(String[] args) {

        new Login();

    }
}