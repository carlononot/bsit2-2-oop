public class Motorcycle extends Vehicle {
    // TODO 4: field only motorcycles have
    private boolean hasSidecar;

    // TODO 5: constructor
    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    // TODO 6: override displayInfo()
    @Override
    public void displayInfo() {
        String sidecarText = hasSidecar ? "with sidecar" : "no sidecar";
        System.out.println("Motorcycle: " + brand + " (" + year + ") - " + sidecarText);
    }
}