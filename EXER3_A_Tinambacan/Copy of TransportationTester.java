public class TransportationTester {
    public static void main(String[] args) {
        Truck truck = new Truck();
        truck.speed = "80 km/h";
        truck.engine = "Diesel";
        truck.model = "Fuso";
        truck.fuelType = "Diesel";
        truck.numberOfWheels = 6;
        truck.terrainType = "Off-road";
        truck.loadCapacity = 10;
        truck.displayInfo();

        System.out.println("\n-----\n");

        Airplane plane = new Airplane();
        plane.speed = "900 km/h";
        plane.engine = "Jet Engine";
        plane.model = "Boeing 747";
        plane.flightRange = "15000 km";
        plane.altitudeLimit = "40000 ft";
        plane.airline = "Delta Airlines";
        plane.displayInfo();

        System.out.println("\n-----\n");

        Boat boat = new Boat();
        boat.speed = "50 km/h";
        boat.engine = "Outboard Motor";
        boat.model = "Fishing Boat";
        boat.displacement = "2000 tons";
        boat.materialUsed = "Steel";
        boat.workRange = "Near Shore";
        boat.boatType = "Trawler";
        boat.displayInfo();
    }
}
