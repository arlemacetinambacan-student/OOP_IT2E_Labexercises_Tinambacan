class Resource {
    private int resourceID;
    private String type;
    private int quantity;

    public void allocate() {
        System.out.println("Resource allocated.");
    }

    public void updateQty() {
        System.out.println("Resource quantity updated.");
    }
}
