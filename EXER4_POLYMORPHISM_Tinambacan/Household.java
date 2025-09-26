class Household {
    private int householdID;
    private String address;
    private int incomeLevel;
    private Person[] members;

    public void addMember(Person p) {
        System.out.println("Added member: " + p);
    }

    public void calcNeeds() {
        System.out.println("Household needs calculated.");
    }

    public void trackHealth() {
        System.out.println("Tracking household health.");
    }
}
