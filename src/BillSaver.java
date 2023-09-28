public class BillSaver {
    // initializing variables
    private int billNumber;
    private String itemsOrdered;
    private int totalItems;
    private double billPrice;
    private double getAmountToBePayedTip;
    private double tip;
    private int groupSize;

    public BillSaver (int bN, int gS, int tI, String iO, double bP){
        billNumber = bN;
        groupSize = gS;
        totalItems = tI;
        itemsOrdered = iO;
        billPrice = (Math.round(100 * bP)) / 100.0;
    }
    public double tipAmount(double t) {
        tip = t;
        return billPrice / tip;
    }
    public void billBefore() {
        System.out.println ("This is bill number " + billNumber);
        System.out.println("-- Items Ordered Today --");
        System.out.println(itemsOrdered);
        System.out.println("The per person cost before tip is: " + (billPrice / groupSize));
        System.out.println("The Total Price Before Tip is: " + billPrice);

    }

    public boolean yesOrNoTip(String decision) {
        return decision.equals("yes");
    }
}
