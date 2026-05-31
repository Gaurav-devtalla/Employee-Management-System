package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    // Dropdown for employee id
    Choice cempId;

    // Labels to display employee details
    JLabel tname, tphone, temail;

    // Buttons
    JButton delete, back;

    RemoveEmployee(){

        setLayout(null);

        // ================= BACKGROUND IMAGE =================
        // Background image load from icons folder
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i2 = i1.getImage().getScaledInstance(900,500,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,500);
        add(image);


        // ================= LOGO IMAGE =================
        // Logo image load from icons folder
        ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon logoScaled = new ImageIcon(logoImg);

        JLabel logo = new JLabel(logoScaled);
        logo.setBounds(600,150,200,200);
        image.add(logo);


        // ================= HEADING =================
        JLabel heading = new JLabel("Remove Employee");
        heading.setBounds(320,30,300,40);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        image.add(heading);


        // ================= EMPLOYEE ID =================
        JLabel lblid = new JLabel("Employee Id");
        lblid.setBounds(150,150,150,30);
        lblid.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        image.add(lblid);

        cempId = new Choice();
        cempId.setBounds(320,150,150,30);
        image.add(cempId);


        // ================= NAME =================
        JLabel name = new JLabel("Name");
        name.setBounds(150,200,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        image.add(name);

        tname = new JLabel();
        tname.setBounds(320,200,200,30);
        image.add(tname);


        // ================= PHONE =================
        JLabel phone = new JLabel("Phone");
        phone.setBounds(150,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        image.add(phone);

        tphone = new JLabel();
        tphone.setBounds(320,250,200,30);
        image.add(tphone);


        // ================= EMAIL =================
        JLabel email = new JLabel("Email");
        email.setBounds(150,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        image.add(email);

        temail = new JLabel();
        temail.setBounds(320,300,200,30);
        image.add(temail);


        // ================= FETCH EMPLOYEE IDs =================
        try{

            conn c = new conn();

            ResultSet rs = c.statement.executeQuery("select * from employee");

            // Add employee ids to dropdown
            while(rs.next()){
                cempId.add(rs.getString("empid"));
            }

            // Show first employee details
            rs = c.statement.executeQuery(
                    "select * from employee where empid='"+cempId.getSelectedItem()+"'");

            while(rs.next()){
                tname.setText(rs.getString("name"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }


        // ================= WHEN EMPLOYEE ID CHANGES =================
        cempId.addItemListener(new ItemListener(){

            public void itemStateChanged(ItemEvent ie){

                try{

                    conn c = new conn();

                    ResultSet rs = c.statement.executeQuery(
                            "select * from employee where empid='"+cempId.getSelectedItem()+"'");

                    while(rs.next()){

                        tname.setText(rs.getString("name"));
                        tphone.setText(rs.getString("phone"));
                        temail.setText(rs.getString("email"));

                    }

                }catch(Exception e){
                    e.printStackTrace();
                }

            }

        });


        // ================= DELETE BUTTON =================
        delete = new JButton("Delete");
        delete.setBounds(220,380,120,40);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        image.add(delete);


        // ================= BACK BUTTON =================
        back = new JButton("Back");
        back.setBounds(380,380,120,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);


        // ================= FRAME SETTINGS =================
        setSize(900,500);
        setLocation(300,150);
        setVisible(true);
    }


    // ================= BUTTON ACTION =================
    public void actionPerformed(ActionEvent ae){

        // Delete employee
        if(ae.getSource()==delete){

            try{

                conn c = new conn();

                String query = "delete from employee where empid='"+cempId.getSelectedItem()+"'";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Employee Deleted Successfully");

                setVisible(false);

                new ViewEmployee();

            }catch(Exception e){
                e.printStackTrace();
            }

        }
        // Back button
        else{

            setVisible(false);

            new Main_class();

        }

    }


    public static void main(String[] args){

        new RemoveEmployee();

    }
}
