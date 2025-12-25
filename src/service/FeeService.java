package service;

import dao.StudentDAO;
import model.Student;

public class FeeService {

    public static void addStudentFee(String name, String roll, String course, int total, int paid) {

        Student s = new Student(name, roll, course, total, paid);

        if (StudentDAO.insertStudent(s)) {
            System.out.println("Fee Added Successfully");
        } else {
            System.out.println("Failed To Add Fee");
        }
    }

    // Old console search (can still keep if you want)
    public static void searchStudent(String roll) {
        StudentDAO.getStudent(roll);
    }

    // New method for Swing UI → returns Student Object
    public static Student getStudent(String roll){
        return StudentDAO.findStudent(roll);
    }
}
