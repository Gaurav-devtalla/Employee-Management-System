package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Addemployee extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;
    JButton add, back;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox<String> Boxeducation;

    Addemployee(){

        getContentPane().setBackground(new Color(163,255,188));
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(330,30,500,50);
        heading.setFont(new Font("SERIF",Font.BOLD,25));
        add(heading);

        // NAME
        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,150,30);
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        add(tname);

        // FATHER NAME
        JLabel fname = new JLabel("Father Name:");
        fname.setBounds(400,150,150,30);
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);

        // DATE OF BIRTH
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setBounds(50,200,150,30);
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        add(tdob);

        // SALARY
        JLabel salary = new JLabel("Salary:");
        salary.setBounds(400,200,150,30);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);

        // ADDRESS
        JLabel address = new JLabel("Address:");
        address.setBounds(50,250,150,30);
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);

        // PHONE
        JLabel phone = new JLabel("Phone:");
        phone.setBounds(400,250,150,30);
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);

        // EMAIL
        JLabel email = new JLabel("Email:");
        email.setBounds(50,300,150,30);
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);

        // EDUCATION
        JLabel education = new JLabel("Education:");
        education.setBounds(400,300,150,30);
        add(education);

        String items[]={"BCA","B.Tech","MBA","MCA","BBA","B.Com","MA","M.Tech","PHD"};

        Boxeducation = new JComboBox<>(items);
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);

        // DESIGNATION
        JLabel designation = new JLabel("Designation:");
        designation.setBounds(50,350,150,30);
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        add(tdesignation);

        // AADHAR
        JLabel aadhar = new JLabel("Aadhar No:");
        aadhar.setBounds(400,350,150,30);
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600,350,150,30);
        add(taadhar);

        // EMPLOYEE ID
        JLabel empid = new JLabel("Employee Id:");
        empid.setBounds(50,400,150,30);
        add(empid);

        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setForeground(Color.RED);
        add(tempid);

        // ADD BUTTON
        add = new JButton("Add");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add(add);

        // BACK BUTTON
        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==add){

            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String)Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String aadhar = taadhar.getText();
            String empid = tempid.getText();

            try{

                conn c = new conn();

                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empid+"')";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Employee Added Successfully");

                setVisible(false);
                new Main_class();

            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        if(e.getSource()==back){

            setVisible(false);
            new Main_class();

        }
    }

    public static void main(String[] args){

        new Addemployee();

    }
}
