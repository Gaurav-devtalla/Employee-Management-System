package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    // Text fields
    JTextField tfname, taddress, tphone, temail, tsalary, teducation, tdesignation;

    // Labels for non-editable data
    JLabel tname, taadhar, tempid, tdob;

    JButton update, back;

    String number;   // Employee ID

    UpdateEmployee(String number) {

        this.number = number;

        // Frame settings
        getContentPane().setBackground(new Color(163,255,188));
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(300,30,500,40);
        heading.setFont(new Font("SERIF",Font.BOLD,25));
        add(heading);

        // NAME
        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JLabel();
        tname.setBounds(200,150,150,30);
        add(tname);

        // FATHER NAME
        JLabel fname = new JLabel("Father Name:");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);

        // DOB
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        add(tdob);

        // SALARY
        JLabel salary = new JLabel("Salary:");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);

        // ADDRESS
        JLabel address = new JLabel("Address:");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);

        // PHONE
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);

        // EMAIL
        JLabel email = new JLabel("Email:");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);

        // EDUCATION
        JLabel education = new JLabel("Education:");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600,300,150,30);
        add(teducation);

        // DESIGNATION
        JLabel designation = new JLabel("Designation:");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        add(tdesignation);

        // AADHAR
        JLabel aadhar = new JLabel("Aadhar No:");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        taadhar = new JLabel();
        taadhar.setBounds(600,350,150,30);
        add(taadhar);

        // EMP ID
        JLabel empid = new JLabel("Employee Id:");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setForeground(Color.RED);
        add(tempid);

        // UPDATE BUTTON
        update = new JButton("Update");
        update.setBounds(250,500,150,40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        // BACK BUTTON
        back = new JButton("Back");
        back.setBounds(450,500,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Fetch data from database
        try{
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery(
                    "select * from employee where empId='"+number+"'");

            if(rs.next()){

                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                taadhar.setText(rs.getString("aadhar"));
                tempid.setText(rs.getString("empId"));
                tdesignation.setText(rs.getString("designation"));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        setSize(900,650);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==update){

            try{

                conn c = new conn();

                String query = "update employee set " +
                        "fname='"+tfname.getText()+"'," +
                        "salary='"+tsalary.getText()+"'," +
                        "address='"+taddress.getText()+"'," +
                        "phone='"+tphone.getText()+"'," +
                        "email='"+temail.getText()+"'," +
                        "education='"+teducation.getText()+"'," +
                        "designation='"+tdesignation.getText()+"' " +
                        "where empId='"+number+"'";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,
                        "Employee Details Updated Successfully");

                setVisible(false);
                new ViewEmployee();

            }catch(Exception ex){
                ex.printStackTrace();
            }

        }else{

            setVisible(false);
            new ViewEmployee();

        }
    }

    public static void main(String[] args){
        new UpdateEmployee("101");
    }
}