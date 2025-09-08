public class car {
    private String color;
    private String plateNo;
    private String chassisNo;

    public car() {
        this.color = "No Color";
        this.plateNo = "No PlateNumber";
        this.chassisNo = "No Chassis No Yet";
    }

    public car(String color, String plateNo, String chassisNo) {
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
    }

    public car(String chassisNo) {
        this.color = "Grey";
        this.plateNo = "222-222";
        this.chassisNo = chassisNo;
    }

    public void displayInfo() {
        String info = "";
        info += "Color: " + this.color;
        info += "\nPlateNO: " + this.plateNo;
        info += "\nChassisNo: " + this.chassisNo;
        System.out.println(info);
    }
}
