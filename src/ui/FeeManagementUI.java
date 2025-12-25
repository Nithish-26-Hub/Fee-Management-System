package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.FeeService;

public class FeeManagementUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fee Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton addFeeButton = new JButton("Add Student Fee");
        JButton searchFeeButton = new JButton("Search Student Fee");
        JButton exitButton = new JButton("Exit");

        panel.add(addFeeButton);
        panel.add(searchFeeButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);

        addFeeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        JTextField nameField = new JTextField();
        JTextField rollField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField totalFeeField = new JTextField();
        JTextField paidFeeField = new JTextField();

        Object[] message = {
            "Name:", nameField,
            "Roll No:", rollField,
            "Course:", courseField,
            "Total Fee:", totalFeeField,
            "Paid Fee:", paidFeeField
        };

        int option = JOptionPane.showConfirmDialog(
            frame,
            message,
            "Add Student Fee",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (option == JOptionPane.OK_OPTION) {

            try {
                String name = nameField.getText();
                String roll = rollField.getText();
                String course = courseField.getText();

                if(name.isEmpty() || roll.isEmpty() || course.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "All fields are required!");
                    return;
                }

                int totalFee = Integer.parseInt(totalFeeField.getText());
                int paidFee = Integer.parseInt(paidFeeField.getText());

                FeeService.addStudentFee(name, roll, course, totalFee, paidFee);
                JOptionPane.showMessageDialog(frame, "Student Fee Added Successfully!");
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(frame, "Invalid Input! Enter Valid Numbers");
            }
        }
    }
});


        searchFeeButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        String roll = JOptionPane.showInputDialog(frame, "Enter Roll No:");

        if(roll == null || roll.trim().isEmpty()){
            JOptionPane.showMessageDialog(frame, "Roll number cannot be empty!");
            return;
        }

        model.Student s = FeeService.getStudent(roll);

        if(s == null){
            JOptionPane.showMessageDialog(frame, "Student Not Found!");
        } 
        else {
            JOptionPane.showMessageDialog(frame,
                "Name: " + s.getName() +
                "\nCourse: " + s.getCourse() +
                "\nTotal Fee: " + s.getTotalFee() +
                "\nPaid Fee: " + s.getPaidFee() +
                "\nBalance: " + s.getBalance()
            );
        }
    }
});

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}