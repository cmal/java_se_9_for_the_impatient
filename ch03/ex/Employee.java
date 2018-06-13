package ch03.ex;

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
    
    public static void main(String[] args) {
        
        Measurable[] employees = new Measurable[]{
            new Employee("Tom", 5.0),
            new Employee("Jack", 4.0),
            new Employee("Lee", 6.0)
        };

        System.out.println(average(employees));
        Employee employee = (Employee)largest(employees);
        System.out.println(employee.getName());
    }

}
