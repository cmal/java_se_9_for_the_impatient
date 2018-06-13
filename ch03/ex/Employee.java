package ch03.ex;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Employee implements Measurable {
    private double salary;
    private String name;

    Employee(String argName, double argSalary) {
        name = argName;
        salary = argSalary;
    }

    /**
     * Gets the value of salary
     *
     * @return the value of salary
     */
    public final double getSalary() {
        return this.salary;
    }

    /**
     * Sets the value of salary
     *
     * @param argSalary Value to assign to this.salary
     */
    public final void setSalary(final double argSalary) {
        this.salary = argSalary;
    }

    /**
     * Gets the value of name
     *
     * @return the value of name
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Sets the value of name
     *
     * @param argName Value to assign to this.name
     */
    public final void setName(final String argName) {
        this.name = argName;
    }
    
    public double getMeasure() {
        return 10 * salary;
    }

    public static double average(Measurable[] objects) {
        int cnt = objects.length;
        int sum = 0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }
        return sum / cnt;
    }

    public static Measurable largest(Measurable[] objects) {
        double salary = -1;
        Measurable cur = null;
        for (Measurable obj : objects) {
            Employee employee = (Employee)obj;
            if (salary < employee.getSalary()) {
                cur = (Measurable)employee;
            }
        }
        return cur;
    }

    public String toString() {
        return name + "\t" + salary;
    }
    
    public static void main(String[] args) {
        
        // Measurable[] employees = new Measurable[]{
        //     new Employee("Tom", 5.0),
        //     new Employee("Jack", 4.0),
        //     new Employee("Simpson", 4.0),
        //     new Employee("Alice", 4.0),
        //     new Employee("Lee", 6.0)
        // };

        // System.out.println(average(employees));
        // Employee employee = (Employee)largest(employees);
        // System.out.println(employee.getName());

        Employee[] staff = {
            new Employee("Tom", 5.0),
            new Employee("Jack", 4.0),
            new Employee("Simpson", 4.0),
            new Employee("Alice", 4.0),
            new Employee("Lee", 6.0)
        };
        
        Comparator<Employee> compSalary = new Comparator<Employee>() {
                @Override
                public int compare(Employee e1, Employee e2) {
                    Double d1 = new Double(e1.salary);
                    Double d2 = new Double(e2.salary);
                    return Double.compare(d1, d2);
                }
            };

        Comparator<Employee> comp = compSalary
            .thenComparing((e1, e2) -> e1.name.compareTo(e2.name));
        
        Arrays.sort(staff, comp);
        for (Employee e : staff) {
            System.out.println(e);
        }
    }
    
}
