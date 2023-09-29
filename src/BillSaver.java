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
        billPrice = bP;
    }
    public double tipAmount(double t) {
        tip = t;
        return ((Math.round(100 * tip / billPrice)));
    }
    public void billBefore() {
        System.out.println ("This is bill number " + billNumber);
        System.out.println("-- Items Ordered Today --");
        System.out.println(itemsOrdered);
        System.out.println("The per person cost before tip is: $" + ((Math.round(100 * billPrice / groupSize)) / 100.0));
        System.out.println("The Total Price Before Tip is: $" + billPrice);
    }
    public void billAfter() {
        System.out.println ("This is bill number " + billNumber);
        System.out.println("-- Items Ordered Today --");
        System.out.println(itemsOrdered);
        System.out.println("The per person cost for tip is: $" + ((Math.round(100 * tip / groupSize)) / 100));
        System.out.println("The per person cost for the whole order is: $" + ((Math.round(100 * billPrice / groupSize)) / 100));
        System.out.println("The total price after tip is: $" + billPrice);
    }

    public double totalBillGetter() {
        return billPrice;
    }

    public void totalBillSetter(double newBillPrice) {
        billPrice = newBillPrice;
    }
}
