package ManagementPackage;

import static ManagementPackage.EmployeeManagement.*;
import static ManagementPackage.Statistics.statistics;
import static ManagementPackage.Employee.*;

import java.util.Scanner;

public class MyMain {

    public static void main(String[] args) {

        boolean run = true;

        loadDb();
        //Laddar upp 5 employees.

        while (run) {

            System.out.println("Welcome to Employee Management ");
            System.out.println("Please choose:  ");
            System.out.println("(1) Employee Management");
            System.out.println("(2) Management statistics");
            System.out.println("(3) End Program");


            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    EmployeeManagement();

                    break;

                case "2":
                    statistics();

                    break;

                case "3":

                    run = false;

                    break;
                default:
                    System.out.println("Felinmatning, välj ett av menyvalen 1-3");
                    run = true;


            }
        }
    }
}

