package ManagementPackage;

import java.text.*;

import java.util.Scanner;
import static ManagementPackage.EmployeeManagement.*;

public class Employee implements Comparable <Employee> {

    private String firstname;

    private String lastname;

    private String gender;

    private String birthday;

    private double salary;

    private String department;

    private int id;

    public static int nextFreeId = 1;

    Scanner sc = new Scanner(System.in);

    // static int counter = 1;

    public static int getNextFreeId() {

        return nextFreeId++;

    }

    public int compareTo(Employee e) {
       Collator col = Collator.getInstance();
       col.setStrength(Collator.PRIMARY);
       return col.compare(getFirstname(), e.getFirstname());

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(int id, String firstname, String lastname, String birthday, double salary, String department) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {
        this.id = getNextFreeId();
    }


     @Override
    public String toString() {

        return "Employee id: " + getId() + " Name: " + getFirstname() + " " + getLastname()
                + " Birthday: " + getBirthday() + " Salary: " + getSalary() + " Department: " + getDepartment();
    }

    public static void loadDb() {

        Employee e1 = new Employee(1, "Linda", "Danielsson", "199403051245", 25000, "Developer");
        Employee e2 = new Employee(2, "Rebecka", "Strand", " 199205062468", 30000, "Developer");
        Employee e3 = new Employee(3, "Sara", "Svensson", "199003203586", 20000, "Technician");
        Employee e4 = new Employee(4, "Julian", "Amandusson", "199605103576", 22000, "Technician");
        Employee e5 = new Employee(5, "Gustav", "Albrecht", "199409073014", 50000, "Chief");

        addEmployees(e1);
        addEmployees(e2);
        addEmployees(e3);
        addEmployees(e4);
        addEmployees(e5);
    }

    public static Employee addEmployees(Employee e) {

        e.setFirstname(e.firstname);

        e.setLastname(e.lastname);

        e.setBirthday(e.birthday);

        e.setSalary(e.salary);

        e.setDepartment(e.department);

        employeeManagement[nextFreePosition] = e;
        nextFreePosition++;

        manageArraySize(e);

        return e;

    }
}