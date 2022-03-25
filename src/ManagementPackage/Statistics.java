package ManagementPackage;
import java.util.Arrays;
import java.util.Scanner;

import static ManagementPackage.EmployeeManagement.employeeManagement;
import static ManagementPackage.EmployeeManagement.nextFreePosition;

public class Statistics {



    public static void statistics() {
        boolean run3 = true;

        System.out.println("Please choose an option: ");
        System.out.println("1. Average Wage");
        System.out.println("2. Maximum Salary");
        System.out.println("3. Minimum Salary");
        System.out.println("4. Array Sort By Name");
        System.out.println("5. Women Percentage");
        System.out.println("6. Men percentage On Department");


        String tal = sc.nextLine();

        while (run3) {



            switch (tal) {
                case "1":
                    averageWage();

                    break;
                case "2":
                    maximumSalary();

                    break;

                case "3":
                    minimumSalary();

                    break;

                case "4":
                    arraySortByName();

                    break;

                case "5":
                    womenPercentage();

                    break;

                case "6":
                    menPercentageDepartment();
                    break;

                case "0":
                    run3 = false;
                    break;

            }
            run3 = false;
        }
    }


    static Scanner sc = new Scanner(System.in);

    public static void averageWage() {
       double totalSalary = 0;
       double averageSalary = 0;

        for (int i = 0; i < nextFreePosition; i++) {
             totalSalary = totalSalary + employeeManagement[i].getSalary();

        }
        averageSalary = totalSalary/nextFreePosition;

        System.out.println("Average salary is: " + averageSalary );
    }

    public static void maximumSalary() {
        int maximum = 0;

        for (int i = 0; i < nextFreePosition; i++) {
            if(employeeManagement[i].getSalary() > employeeManagement[maximum].getSalary())
                maximum = i;


        }
        System.out.println("Maximum salary at your company is: " + employeeManagement[maximum].getSalary());
    }

    public static void minimumSalary() {
        int minimum = 0;

        for (int i = 0; i < nextFreePosition; i++) {
            if(employeeManagement[i].getSalary() < employeeManagement[minimum].getSalary())
                minimum = i;


        }
        System.out.println("Minimum salary at your company is: " + employeeManagement[minimum].getSalary());


    }

    public static void arraySortByName() {



        Arrays.sort(employeeManagement, 0, nextFreePosition);
        for (int i = 0; i < nextFreePosition; i++) {

        System.out.println(employeeManagement[i].toString());



        }
    }

    public static void womenPercentage() {
        double numberOfWomen = 0;

try {
    //charAt(int index);

    for (int i = 0; i < nextFreePosition; i++) {
        char s = employeeManagement[i].getBirthday().charAt(10);
        if (s % 2 == 0) {
            numberOfWomen++;
        }
    }
    double womenPercentage = (numberOfWomen / nextFreePosition) * 100;
    System.out.println("Percentage of women is: " + womenPercentage + "%");
}
catch (StringIndexOutOfBoundsException e) {
    System.out.println("Incorrect input of birthday, please update in update birthday option.");
}

    }

    public static void menPercentageDepartment(){
                double  numberOfMen = 0;
                double totalOnDepartment = 0;
                String department = null;
                try {
                    System.out.println("Please enter department: ");
                    System.out.println("1.DBAdmin, 2.Developer, 3.Technician, 4.Marketing, 5.Secretary, 6.Web Designer 7. Chief");
                    String choice = sc.nextLine();

                    switch (choice) {
                        case "1" -> department = "DBAdmin";
                        case "2" -> department = "Developer";
                        case "3" -> department = "Technician";
                        case "4" -> department = "Marketing";
                        case "5" -> department = "Secretary";
                        case "6" -> department = "Web Designer";
                        case "7" -> department = "Chief";
                        default -> System.out.println("Felinmatning, välj ett av menyvalen.");
                    }

                    for (int i = 0; i < nextFreePosition; i++) {
                        char s = employeeManagement[i].getBirthday().charAt(10);
                        if (s % 2 == 1 && department.equalsIgnoreCase(employeeManagement[i].getDepartment())) {
                            numberOfMen++;
                        }
                        if(department.equalsIgnoreCase(employeeManagement[i].getDepartment())){
                            totalOnDepartment++;
                        }
                    }
                    double menPercentage = (numberOfMen / totalOnDepartment) * 100;
                    System.out.println("Percentage of men is: " + menPercentage + "%");
                }
                catch (StringIndexOutOfBoundsException e){
                    System.out.println("Incorrect input of birthday, please update in update birthday option.");

                }
            }
}

