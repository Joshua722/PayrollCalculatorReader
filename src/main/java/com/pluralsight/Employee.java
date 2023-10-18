package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;
    private double grossPay;

    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = (employeeId);
        this.name = name;
        this.hoursWorked =(hoursWorked);
        this.payRate = (payRate);
        this.grossPay = grossPay;
    }

    public void setEmployeeId(){
        this.employeeId = employeeId;
    }
//setter and getters
    public int getEmployeeId() {
        return employeeId;
    }
    public void setName(){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setHoursWorked(double hoursWorked){
        this.hoursWorked = this.hoursWorked;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setPayRate(double payRate){
        this.payRate = this.payRate;
    }
    public double getPayRate() {
        return payRate;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getGrossPay() {
        return(payRate * hoursWorked);
    }
}
