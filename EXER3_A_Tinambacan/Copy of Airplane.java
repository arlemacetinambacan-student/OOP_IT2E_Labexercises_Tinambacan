public class Airplane extends AirTransport {
    String airline;

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Flight Range: " + flightRange);
        System.out.println("Altitude Limit: " + altitudeLimit);
        System.out.println("Airline: " + airline);
    }
}
