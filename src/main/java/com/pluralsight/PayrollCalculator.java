package com.pluralsight;
import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class PayrollCalculator {
    public static void main(String[] args){

        Scanner myScanner = new Scanner(System.in);
        String filedCreated;
        String file;


        System.out.println("Enter the name of the file employee file to process: ");
        file = myScanner.nextLine().trim();
        System.out.println("Enter the name of the payroll file to create(end with .csv or .json): ");
        filedCreated = myScanner.nextLine();
        while (filedCreated.equals("employees.csv")) {
            System.out.println("You cannot overwrite existing file");
            System.out.println("Enter the name of the file you want to create");
            myScanner.nextLine();

            if (filedCreated.equals("employees.csv")) {
                System.out.println("You cannot overwrite existing file 'employees.csv', Type another file name.");
            }
            myScanner.nextLine();
        }


        try {
            FileReader fileReader = new FileReader("src/main/resources/"+ file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;
            FileWriter fileWriter = new FileWriter(filedCreated);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            int count = 0;

            while ((input = bufferedReader.readLine()) != null) {

                String[] employee = input.split("\\|");

                int id = Integer.parseInt(employee[0]);
                String name = employee[1];
                double hoursWorked = Double.parseDouble(employee[2]);
                double payRate = Double.parseDouble(employee[3]);
                Employee employees = new Employee(id, name, hoursWorked, payRate);
                double grossPay = employees.getGrossPay();
                String fGrossPay = String.format("%.2f", grossPay);
                System.out.printf("Employee ID: %d | Name: %s | Gross Pay: $%.2fn", id, name, employees.getGrossPay());
                if (count < 1) {
                    bufWriter.write("id|name|hours-worked|pay-rate \n");
                    count++;
                }
                bufWriter.write(id + "|" + name + "|" + "$" + fGrossPay);
            }
            bufferedReader.close();
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}

