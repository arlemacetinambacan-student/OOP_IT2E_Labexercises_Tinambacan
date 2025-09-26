class Applicant extends Person {
    private String resume;
    private String skills;

    public void register() {
        System.out.println("Applicant registered.");
    }

    // Overridden method (runtime polymorphism)
    @Override
    public void applyJob() {
        System.out.println("Applicant submitted an online job application.");
    }

    public void viewApplicationStatus() {
        System.out.println("Viewing application status...");
    }
}
