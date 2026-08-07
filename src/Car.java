public class Car extends Vehicle {
    // TODO 1: field only cars have
    private int numberOfDoors;

    // TODO 2: constructor, calls Vehicle's constructor via super(...)
    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year); // reuse Vehicle's constructor
        this.numberOfDoors = numberOfDoors;
    }

    // TODO 3: override displayInfo()
    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + " (" + year + ") - " + numberOfDoors + " doors");
    }
}