package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    // Table to show employee data
    JTable table;

    // Dropdown to select employee id
    Choice choiceEmp;

    // Buttons
    JButton searchbtn, print, update, back;

    ViewEmployee() {

        // Frame background color
        getContentPane().setBackground(new Color(255,131,122));

        // Label for search
        JLabel search = new JLabel("Search by Employee Id");
        search.setBounds(20,20,150,20);
        add(search);

        // Dropdown for employee ID
        choiceEmp = new Choice();
        choiceEmp.setBounds(180,20,150,20);
        add(choiceEmp);

        // Fetch employee IDs from database
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");

            while(resultSet.next()){
                choiceEmp.add(resultSet.getString("empId"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        // JTable for displaying data
        table = new JTable();

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");

            // Convert ResultSet to TableModel
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        // Scroll pane for table
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        // SEARCH BUTTON
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        // PRINT BUTTON
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        // UPDATE BUTTON
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        // BACK BUTTON
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

        // Frame properties
        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // SEARCH BUTTON ACTION
        if(e.getSource() == searchbtn){

            String query = "select * from employee where empId = '"
                    + choiceEmp.getSelectedItem() + "'";

            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(resultSet));

            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

        // PRINT BUTTON ACTION
        else if(e.getSource() == print){

            try{
                table.print();
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

        // UPDATE BUTTON ACTION
        else if(e.getSource() == update){

            setVisible(false);

            // Open Update Employee window
            new UpdateEmployee(choiceEmp.getSelectedItem());

        }

        // BACK BUTTON ACTION
        else{

            setVisible(false);

            // Go back to main screen
            new Main_class();
        }
    }

    public static void main(String[] args) {

        new ViewEmployee();

    }
}