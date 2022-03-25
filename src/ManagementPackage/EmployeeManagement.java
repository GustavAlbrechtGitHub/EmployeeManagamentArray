package ManagementPackage;


import java.sql.SQLOutput;
import java.text.Collator;
import java.util.*;


public class EmployeeManagement  {


    static Employee[] employeeManagement = new Employee[100];

    static Scanner sc = new Scanner(System.in);

    static int nextFreePosition = 0;



    public static void registerEmployee() {
        Employee e = new Employee();

        System.out.print("Enter First Name: ");
        e.setFirstname(sc.nextLine());

        System.out.print("Enter Last Name: ");
        e.setLastname(sc.nextLine());

        System.out.print("Enter birthday(YYYYMMDD****): ");
        e.setBirthday(sc.nextLine());

        System.out.print("Enter salary: ");
        e.setSalary(sc.nextDouble());
        sc.nextLine();

        enterDepartment(e);

        employeeManagement[nextFreePosition] = e;
       nextFreePosition++;


        System.out.println(">>>Employee added");

        manageArraySize(e);

    }


    public static String enterDepartment(Employee e) {

        System.out.println("Please enter department");
        System.out.println("1.DBAdmin, 2.Developer, 3.Technician, 4.Marketing, 5.Secretary, 6.Web Designer 7. Chief");
        String choiceDepartment = sc.nextLine();

        switch (choiceDepartment) {

            case "1":
                e.setDepartment("DBAdmin");

                break;
            case "2":
                e.setDepartment("Developer");
                break;

            case "3":
                e.setDepartment("Technician");
                break;

            case "4":
                e.setDepartment("Marketing");
                break;

            case "5":
                e.setDepartment("Secretary");
                break;

            case "6":
                e.setDepartment("Web Designer");
                break;

            case "7":
                e.setDepartment("Chief");
                break;

            default:
                System.out.println("Felinmatning, välj ett av menyvalen.");
        }

        return e.getDepartment();
    }

    public static void deleteEmployee() {

        System.out.println("Please enter id: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nextFreePosition; i++) {

            if (employeeManagement[i].getId() == id) {

                System.out.println("Anställd: " + employeeManagement[i].getFirstname() + " " + employeeManagement[i].getLastname() + " togs bort. ");

                employeeManagement[i] = null;
                employeeManagement[i] = employeeManagement[nextFreePosition - 1];
                employeeManagement[nextFreePosition - 1] = null;
                nextFreePosition = nextFreePosition - 1;
            }

        }
    }

    public static void updateName() {

        System.out.println("Please enter id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New first name: ");
        String firstname = sc.nextLine();
        System.out.print("New last name: ");
        String lastname = sc.nextLine();


        for (int i = 0; i < nextFreePosition; i++) {


            employeeManagement[i].setFirstname(firstname);
            employeeManagement[i].setLastname(lastname);
        }

        System.out.println("Name has been updated!");

    }

    public static void updateBirthday() {
        System.out.println("Please enter id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new birthday(YYYYMMDD****): ");
        String birthday = sc.nextLine();

        for (int i = 0; i < nextFreePosition; i++) {

            if (employeeManagement[i].getId() == id) {

                employeeManagement[i].setBirthday(birthday);


            }
        }
        System.out.println("Birthday has been updated!");


    }

    public static void updateDepartment() {

        String department = null;
        System.out.println("Please enter id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter new department: ");
        System.out.println("1.DBAdmin, 2.Developer, 3.Technician, 4.Marketing, 5.Secretary, 6.Web Designer 7. Chief");
        String choice = sc.nextLine();

        switch (choice) {

            case "1":
                department = "DBAdmin";

                break;
            case "2":
                department = "Developer";
                break;

            case "3":
                department = "Technician";
                break;

            case "4":
                department = "Marketing";
                break;

            case "5":
                department = "Secretary";
                break;

            case "6":
                department = "Web Designer";
                break;

            case "7":
                department = "Chief";
                break;

            default:
                System.out.println("Felinmatning, välj ett av menyvalen.");
        }

        for (int i = 0; i < nextFreePosition; i++) {

            if (employeeManagement[i].getId() == id) {
                employeeManagement[i].setDepartment(department);

            }

        }
        System.out.println("Department has been updated!");


    }

    public static void updateSalary() {
        System.out.println("Please enter id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter new salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        for (int i = 0; i < nextFreePosition; i++) {

            if (employeeManagement[i].getId() == id) {
                employeeManagement[i].setSalary(salary);

            }

        }
        System.out.println("Salary has been updated!");

    }

    public static void searchEmployeeName() {

        boolean searchLoop = false;


        System.out.println("Search employee first name: ");

        String search = sc.nextLine();


        for (int i = 0; i < nextFreePosition; i++) {

            if (search.equalsIgnoreCase(employeeManagement[i].getFirstname())) {
                searchLoop = true;
                System.out.println("Your search gave a hit for: " + employeeManagement[i].toString());
            }

             else if (searchLoop==false) {
                System.out.println("Search was not found.");

            }
            searchLoop = true;
        }


    }

    public static void searchEmployeeIdNumber() {
        boolean searchLoop = false;

        try {
            System.out.print("Search employee id number: ");

            int search = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < nextFreePosition; i++) {

                if (employeeManagement[i].getId() == search) {
                    System.out.println("Your search gave a hit for employee: " + employeeManagement[i].toString());
                    searchLoop = true;

                } else if (searchLoop == false) {

                    System.out.println("Search was not found.");

                }
                searchLoop = true;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Incorrect input, Please input number.");
        }
    }

    public static void searchDepartment() {
        boolean searchLoop = false;

        String department = null;
        System.out.println("Which Department do you want to Search for: ");
        System.out.println("1.DBAdmin, 2.Developer, 3.Technician, 4.Marketing, 5.Secretary, 6.Web Designer 7. Chief");
        String choice = sc.nextLine();
        switch (choice) {

            case "1":
                department = "DBAdmin";

                break;
            case "2":
                department = "Developer";
                break;

            case "3":
                department = "Technician";
                break;

            case "4":
                department = "Marketing";
                break;

            case "5":
                department = "Secretary";
                break;

            case "6":
                department = "Web Designer";
                break;

            case "7":
                department = "Chief";
                break;

            default:
                System.out.println("Felinmatning, välj ett av menyvalen.");
        }

        for (int i = 0; i < nextFreePosition; i++) {

            if (department.equalsIgnoreCase(employeeManagement[i].getDepartment())) {

            System.out.println("Employees in this department: " + employeeManagement[i].toString());
            searchLoop = true;

        } else if (searchLoop == false){
        System.out.println("No Employee in this department.");
         }
            searchLoop = true;
        }

    }

    public static void displayEmplyoees() {

        for (int i = 0; i < nextFreePosition; i++) {
           System.out.println(employeeManagement[i].toString());
       }

    }

    public static void manageArraySize(Employee e) {

        if (nextFreePosition == employeeManagement.length) {
            Employee[] temp = new Employee[employeeManagement.length * 2];

            for (int i = 0; i < nextFreePosition; i++) {
                temp[i] = employeeManagement[i];

            }
            employeeManagement = temp;


            employeeManagement[nextFreePosition] = e;
            nextFreePosition = nextFreePosition + 1;
        }
    }


    public static void EmployeeManagement() {
        boolean run2 = true;

        System.out.println("Please choose an option: ");
        System.out.println("1. Register Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. Update name");
        System.out.println("4. Update Birthday");
        System.out.println("5. Update  Department");
        System.out.println("6. Update Salary");
        System.out.println("7. Search Employee By Name");
        System.out.println("8. Search Employee By Id Number");
        System.out.println("9. Search Department");
        System.out.println("10. Show All Employees");

       String choice = sc.nextLine();
        while (run2) {

            switch (choice) {
                case "1":
                    registerEmployee();

                    break;
                case "2":
                    deleteEmployee();

                    break;

                case "3":
                    updateName();

                    break;

                case "4":
                    updateBirthday();

                    break;

                case "5":
                    updateDepartment();

                    break;

                case "6":
                    updateSalary();


                    break;

                case "7":
                    searchEmployeeName();


                    break;
                case "8":
                    searchEmployeeIdNumber();


                    break;

                case "9":
                    searchDepartment();


                    break;

                case "10":
                    displayEmplyoees();
                    break;

                case "0":
                    run2 = false;
                    break;
                default:
                    System.out.println("Felinmatning, välj ett av menyvalen.");
            }

            run2 = false;
        }
    }
}

