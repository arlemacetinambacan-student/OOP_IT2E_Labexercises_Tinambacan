public class Main {
    public static void main(String[] args) {
        car car1 = new car(); 
        car1.displayInfo();

        System.out.println("--------------------");

        car car2 = new car("Black", "Arle-011", "CHS-456789"); 
        car2.displayInfo();

        System.out.println("--------------------");

        car car3 = new car("CHS-987654"); 
        car3.displayInfo();
    }
}
