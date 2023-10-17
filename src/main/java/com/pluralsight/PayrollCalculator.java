package com.pluralsight;

import java.io.*;
import java.nio.Buffer;

public class PayrollCalculator {
    public static void main(String[] args) {

       try{
           String input;
           FileReader filereader = new FileReader("src/main/resources/employees.csv");
           BufferedReader bufReader = new BufferedReader(filereader);

           while((input = bufReader.readLine()) != null){


               String[] employee = input.split("\\|");
               int id = Integer.parseInt(employee[0]);
               String name = employee[1];
               double hoursWorked = Double.parseDouble(employee[2]);
               double payRate = Double.parseDouble(employee[3]);

               Employee myEmployee = new Employee(id,name,hoursWorked,payRate);
               System.out.printf("Employee Id: %d, Name: %s, GrossPay: $%.2f%n", myEmployee.getEmployeeId() , myEmployee.getName(), myEmployee.getGrossPay());

           }
           bufReader.close();
       }
       catch (IOException e){
           System.out.println("File not found");
           e.printStackTrace();
       }

    }
}


