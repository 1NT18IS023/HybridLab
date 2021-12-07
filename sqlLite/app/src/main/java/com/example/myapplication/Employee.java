package com.example.myapplication;

public class Employee {
    private String employeeName;
    private String employeeDept;
    private String employeeAge;
    private  String employeePh;

    public Employee()
    {

    }

    public Employee(String employeeName,String employeeDept,String employeeAge,String employeePh)
    {
        this.employeeName = employeeName;
        this.employeeDept = employeeDept;
        this.employeeAge = employeeAge;
        this.employeePh = employeePh;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public String getEmployeeDept()
    {
        return employeeDept;
    }

    public String getEmployeeAge()
    {
        return employeeAge;
    }

    public String getEmployeePh()
    {
        return employeePh;
    }

    public void setEmployeeDept(String employeeDept)
    {
        this.employeeDept = employeeDept;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }
    public void setEmployeeAge(String employeeAge)
    {
        this.employeeAge = employeeAge;
    }

    public void setEmployeePh(String employeePh)
    {
        this.employeePh = employeePh;
    }
}
