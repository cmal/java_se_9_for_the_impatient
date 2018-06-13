package ch03.ex;

public class Employee implements Measurable {
    private double salary;
    private String name;

    Employee(String argName, double argSalary) {
        name = argName;
        salary = argSalary;
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
    
    public static void main(String[] args) {
        
        Measurable[] employees = new Measurable[]{
            new Employee("Tom", 5.0),
            new Employee("Jack", 4.0),
            new Employee("Lee", 6.0)
        };

        System.out.println(average(employees));
        
    }

}
