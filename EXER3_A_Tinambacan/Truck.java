public class Truck extends LandTransport {
    double loadCapacity;

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Wheels: " + numberOfWheels);
        System.out.println("Terrain: " + terrainType);
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}
