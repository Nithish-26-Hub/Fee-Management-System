package model;

public class Student {

    private int id;
    private String name;
    private String roll;
    private String course;
    private int totalFee;
    private int paidFee;
    private int balance;

    public Student(String name, String roll, String course, int totalFee, int paidFee) {
        this.name = name;
        this.roll = roll;
        this.course = course;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
        this.balance = totalFee - paidFee;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getRoll() { return roll; }
    public String getCourse() { return course; }
    public int getTotalFee() { return totalFee; }
    public int getPaidFee() { return paidFee; }
    public int getBalance() { return balance; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setRoll(String roll) { this.roll = roll; }
    public void setCourse(String course) { this.course = course; }
    public void setTotalFee(int totalFee) { this.totalFee = totalFee; }
    public void setPaidFee(int paidFee) { this.paidFee = paidFee; }
    public void setBalance(int balance) { this.balance = balance; }

}
