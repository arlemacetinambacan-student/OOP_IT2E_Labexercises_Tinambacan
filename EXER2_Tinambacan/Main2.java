public class Main2 {
    public static void main(String[] args) {
        Drone drone1 = new Drone();
        drone1.displayInfo();

        System.out.println("--------------------");

        Drone drone2 = new Drone("White", "DJI-Mini3", "DRN-123456");
        drone2.displayInfo();

        System.out.println("--------------------");

        Drone drone3 = new Drone("DRN-999999");
        drone3.displayInfo();
    }
}

