public class Drone {
    private String color;
    private String modelNo;
    private String serialNo;

    public Drone() {
        this.color = "No Color";
        this.modelNo = "No Model Number";
        this.serialNo = "No Serial Number Yet";
    }

    public Drone(String color, String modelNo, String serialNo) {
        this.color = color;
        this.modelNo = modelNo;
        this.serialNo = serialNo;
    }

    public Drone(String serialNo) {
        this.color = "Grey";
        this.modelNo = "DR-222";
        this.serialNo = serialNo;
    }

    public void displayInfo() {
        String info = "";
        info += "Color: " + this.color;
        info += "\nModelNo: " + this.modelNo;
        info += "\nSerialNo: " + this.serialNo;
        System.out.println(info);
    }
}
