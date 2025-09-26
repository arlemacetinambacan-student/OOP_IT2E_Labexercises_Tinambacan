class Admin extends User {
    // Overridden method (runtime polymorphism)
    @Override
    public void login() {
        System.out.println("Admin logged in with elevated privileges.");
    }

    public void manageJobs() {
        System.out.println("Admin managing jobs.");
    }

    public void viewApplications() {
        System.out.println("Admin viewing applications.");
    }

    public void approveApplications() {
        System.out.println("Application approved.");
    }

    public void rejectApplications() {
        System.out.println("Application rejected.");
    }
}
