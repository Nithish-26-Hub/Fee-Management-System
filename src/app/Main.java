package app;

import java.util.Scanner;
import service.FeeService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Fee Management System ---");
            System.out.println("1. Add Student Fee");
            System.out.println("2. Search Student Fee");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();  

            switch (ch) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Total Fee: ");
                    int total = sc.nextInt();

                    System.out.print("Enter Paid Fee: ");
                    int paid = sc.nextInt();

                    FeeService.addStudentFee(name, roll, course, total, paid);
                    break;

                case 2:
                    System.out.print("Enter Roll No: ");
                    String r = sc.nextLine();
                    FeeService.searchStudent(r);
                    break;

                case 3:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}