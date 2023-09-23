public class BillSaver {
    // initializing variables
    private int billNumber;
    private String itemsOrdered;
    private int totalItems;
    private double amountToBePayedNoTip;
    private double getAmountToBePayedTip;
    private double tipPercent;
    private int groupSize;

    public BillSaver (int bN, int gS, int tI, String iO, double aTBPNT){
        billNumber = bN;
        groupSize = gS;
        totalItems = tI;
        itemsOrdered = iO;
        amountToBePayedNoTip = aTBPNT;
    }

    public void billBefore() {
        System.out.println ("This is bill number " + billNumber);
        System.out.println("-- Items Ordered Today --");
        System.out.println(itemsOrdered);
        System.out.println("The Total Price Before Tip is: " + amountToBePayedNoTip);
    }
}
