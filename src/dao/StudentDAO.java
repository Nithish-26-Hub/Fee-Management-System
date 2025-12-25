package dao;

import java.sql.*;
import db.DBConnection;
import model.Student;

public class StudentDAO {

    public static boolean insertStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO students(name, roll, course, total_fee, paid_fee, balance) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setString(2, s.getRoll());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getTotalFee());
            ps.setInt(5, s.getPaidFee());
            ps.setInt(6, s.getBalance());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Insert Error: " + e);
        }

        return false;
    }

    public static void getStudent(String roll) {

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE roll=?");
            ps.setString(1, roll);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n--- Student Fee Details ---");
                System.out.println("Name      : " + rs.getString("name"));
                System.out.println("Course    : " + rs.getString("course"));
                System.out.println("Total Fee : " + rs.getInt("total_fee"));
                System.out.println("Paid Fee  : " + rs.getInt("paid_fee"));
                System.out.println("Balance   : " + rs.getInt("balance"));
            } else {
                System.out.println("Student Not Found");
            }

        } catch (Exception e) {
            System.out.println("Fetch Error: " + e);
        }
    }

public static Student findStudent(String roll){
    Student s = null;

    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE roll=?");
        ps.setString(1, roll);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            s = new Student(
                rs.getString("name"),
                rs.getString("roll"),
                rs.getString("course"),
                rs.getInt("total_fee"),
                rs.getInt("paid_fee")
            );
            s.setId(rs.getInt("id"));
            s.setBalance(rs.getInt("balance"));
        }

    } catch (Exception e) {
        System.out.println("Fetch Error: " + e);
    }

    return s;
}
}
