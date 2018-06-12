package ch02.ex;

import java.lang.IllegalArgumentException;

public class Car {
    private double efficiency, fuel, x;

    Car (final double argEfficiency) {
        this.efficiency = argEfficiency;
        this.x = 0;
        this.fuel = 0;
    }

    /**
     * Gets the value of efficiency, in unit of miles/gallons
     *
     * @return the value of efficiency
     */
    public final double getEfficiency() {
        return this.efficiency;
    }

    /**
     * Sets the value of efficiency
     *
     * @param argEfficiency Value to assign to this.efficiency, has to be positive
     */
    public final void setEfficiency(final double argEfficiency) throws IllegalArgumentException {
        if (argEfficiency <= 0) {
            throw new IllegalArgumentException("Efficiency must be positive");
        }
        this.efficiency = argEfficiency;
    }

    /**
     * Gets the value of fuel, in unit of gallon
     *
     * @return the value of fuel
     */
    public final double getFuel() {
        return this.fuel;
    }

    /**
     * add fuel to the oil box
     *
     * @param argFuel Value to add to this.fuel, has to be positive
     */
    public final void addFuel(final double argFuel) throws IllegalArgumentException {
        if (argFuel <= 0) {
            throw new IllegalArgumentException("fuel must be positive");
        }
        this.fuel += argFuel;
    }

    /**
     * Gets the position of Car, in unit of mile
     *
     * @return the value of x
     */
    public final double getX() {
        return this.x;
    }

    /**
     * Drives the Car
     */
    public final void drive(final double distance) throws IllegalArgumentException {
        if (distance <= 0) {
            throw new IllegalArgumentException("distance must be positive");
        }
        double limit = this.fuel * this.efficiency;
        if (distance > limit) {
            System.out.printf("You're run out of gas. %f miles left.\n", distance - limit);
            this.x += limit;
            this.fuel = 0;
        } else {
            System.out.printf("You drived %f miles.\n", distance);
            this.x += distance;
            this.fuel -= distance / this.efficiency;
        }
    }

    
    public static void main(String[] args) {
        System.out.println("Here is the car with efficiency 0.5.");
        Car car = new Car(0.5);
        System.out.println("Add 2 gallon gas.");
        car.addFuel(2);
        System.out.printf("Your fuel: %f\n", car.getFuel());
        System.out.println("Drive 100 miles.");
        car.drive(100);
        System.out.printf("Your position: %f\n", car.getX());
        System.out.printf("Your fuel: %f\n", car.getFuel());

        System.out.println("Add 300 gallon gas.");
        car.addFuel(300);
        System.out.printf("Your fuel: %f\n", car.getFuel());
        System.out.println("Drive 100 miles.");
        car.drive(100);
        System.out.printf("Your fuel: %f\n", car.getFuel());
        System.out.printf("Your position: %f\n", car.getX());
        System.out.println("This should NOT be an immutable class.");
    }

}
