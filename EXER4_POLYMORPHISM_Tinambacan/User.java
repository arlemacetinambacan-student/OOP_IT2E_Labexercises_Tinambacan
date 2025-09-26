public class User {
    private int userId;
    private String email;
    private String password;
    private String role;

    public void login() {
        System.out.println("User logged in.");
    }

    // Overloaded method (compile-time polymorphism)
    public void login(String email, String password) {
        System.out.println("User with email " + email + " logged in using password.");
    }

    public void logout() {
        System.out.println("User logged out.");
    }

    public void updateProfile() {
        System.out.println("User profile updated.");
    }
}
