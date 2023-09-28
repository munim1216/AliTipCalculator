import java.util.Scanner;
public class TipCalc {
    public static void main(String[] args) {
        // initializing variables
        Scanner scan = new Scanner(System.in);
        double priceAddedToBill;
        int groupSize;
        int itemsOrdered = 0;
        String bill = "Items Purchased \n";
        String itemAddedToBill = "empty";
        int togetherPay;
        double billTotalPrice = 0;
        String tipDecision;
        double tip;


        // Group Size & If Paying Together
        System.out.println("Welcome to Jade's tip calculator!");
        System.out.print("How many people are in your group: ");
        groupSize = scan.nextInt();
        scan.nextLine();

        System.out.print("Type 1 to pay together, Type 0 to pay separately: ");
        togetherPay = scan.nextInt();
        scan.nextLine();

        while (togetherPay != 1 && togetherPay != 0) {
            System.out.print("Please type 1 or 0, not any other number: ");
            togetherPay = scan.nextInt();
            scan.nextLine();
        }

        // checking how many bills to create
        if (togetherPay == 1) {
            System.out.println("Okay! Only one bill will be printed.");

            // repeats until customer puts in all items
            while (!itemAddedToBill.equals("done")) {
                System.out.print("Enter an item bought today, or done to finish: ");
                itemAddedToBill = scan.nextLine();
                    if (!itemAddedToBill.equals("done")) {
                        System.out.print("Type the price of the item: ");
                        priceAddedToBill = (Math.round(100 * scan.nextDouble())) / 100.0;
                        scan.nextLine();
                        itemsOrdered++;
                        bill += itemAddedToBill + " - $" + priceAddedToBill + "\n";
                        billTotalPrice += priceAddedToBill;
                    }
            }

            BillSaver single = new BillSaver(1 , groupSize, itemsOrdered, bill, billTotalPrice);
            single.billBefore();
            System.out.print("Type 'Yes' if would you like to tip: ");
            tipDecision = scan.nextLine();
            if (single.yesOrNoTip(tipDecision)) {
                System.out.print("Thank you! How much would you like to tip?: ");

            } else {
                System.out.println("Thank you for enjoying a meal at Jade's!");
            }

        }
        else {
            System.out.print("One, Two, or Three separate bills?: ");
            int numberOfBills = scan.nextInt();
            scan.nextLine();
            while (numberOfBills != 1 && numberOfBills !=2 && numberOfBills != 3) {
                for (int i = 1; i <= numberOfBills; ++i) {
                    bill += "\nBill " + i + "\n";
                    System.out.println("This is Bill " + i + "\n");

                    // repeats until customer puts in all items
                    while (!itemAddedToBill.equals("done")) {
                        System.out.print("Enter an item bought today, or done to finish: ");
                        itemAddedToBill = scan.nextLine();
                        if (!itemAddedToBill.equals("done")) {
                            System.out.print("Type the price of the item: ");
                            priceAddedToBill = scan.nextDouble();
                            scan.nextLine();
                            itemsOrdered++;
                            bill += itemAddedToBill + " - $" + priceAddedToBill + "\n";
                            billTotalPrice += priceAddedToBill;
                        }
                    }

                    // checking which bill to save the orders to
                    if (i == 1) {
                        BillSaver billOne = new BillSaver(i, groupSize, itemsOrdered, bill, billTotalPrice);
                    } else if (i == 2) {
                        BillSaver billTwo = new BillSaver(i, groupSize, itemsOrdered, bill, billTotalPrice);
                    } else {
                        BillSaver billThree = new BillSaver(i, groupSize, itemsOrdered, bill, billTotalPrice);
                    }
                }
            }
        }
    }
}
