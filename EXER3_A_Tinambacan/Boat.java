public class Boat extends WaterTransport {
    String boatType;

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Displacement: " + displacement);
        System.out.println("Material: " + materialUsed);
        System.out.println("Work Range: " + workRange);
        System.out.println("Boat Type: " + boatType);
    }
}
