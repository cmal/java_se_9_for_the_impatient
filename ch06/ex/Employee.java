package ch06.ex;

public class Employee implements Comparable<Employee> {

    private String name;

    Employee(String name) {
        this.name = name;
    }

    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("A");
        Employee e2 = new Employee("B");
        System.out.println(e1.compareTo(e2));
    }

}

// javap ch06/ex/Employee.class
// public class ch06.ex.Employee implements java.lang.Comparable<ch06.ex.Employee> {
//   ch06.ex.Employee(java.lang.String);
//   public int compareTo(ch06.ex.Employee); // <-
//   public static void main(java.lang.String[]);
//   public int compareTo(java.lang.Object); // <- synthesized
// }
