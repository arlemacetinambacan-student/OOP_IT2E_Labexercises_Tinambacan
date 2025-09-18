public class Helicopter extends AirTransport {
    String rotorType;

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Flight Range: " + flightRange);
        System.out.println("Altitude Limit: " + altitudeLimit);
        System.out.println("Rotor Type: " + rotorType);
    }
}
