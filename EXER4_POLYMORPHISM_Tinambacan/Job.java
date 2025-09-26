class Job {
    private int jobId;
    private String title;
    private String description;
    private String requirements;
    private String status;
    private int salary;
    private boolean isAvailable;

    public void postJob() {
        System.out.println("Job posted.");
    }

    public void updateJob() {
        System.out.println("Job updated.");
    }

    public void closeJob() {
        System.out.println("Job closed.");
    }

    public void assignJob() {
        System.out.println("Job assigned.");
    }
}
