public class ProjectTester {
    public static void main(String[] args) {
        // -------- Overloading (Compile-time Polymorphism) --------
        User user1 = new User();
        user1.login();
        user1.login("test@example.com", "12345");  // Overloaded method

        Person person = new Person();
        person.eatFood();
        person.eatFood("Rice");  // Overloaded method

        Application app = new Application();
        app.submit();
        app.submit();  // Overloaded method

        System.out.println("---- Runtime Polymorphism ----");

        // -------- Overriding (Runtime Polymorphism) --------
        User admin = new Admin();   // User reference, Admin object
        admin.login();              // Calls Admin's overridden login()

        Person applicant = new Applicant(); // Person reference, Applicant object
        applicant.applyJob();               // Calls Applicant's overridden applyJob()
    }
}
