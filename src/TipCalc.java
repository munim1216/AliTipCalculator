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
        String tipDecision = "empty";
        double tip;
        int numberOfBills = 0;
        int billNumber = 1;


        //  If Paying Together
        System.out.println("Welcome to Jade's tip calculator!");
        System.out.print("Type 1 to pay together, Type 0 to pay separately: ");
        togetherPay = scan.nextInt();
        scan.nextLine();

        while (togetherPay != 1 && togetherPay != 0) {
            System.out.print("Please type 1 or 0, not any other number: ");
            togetherPay = scan.nextInt();
            scan.nextLine();
        }

        // checking how many bills to create
        // start of single bill option
        if (togetherPay == 1) {
            System.out.println("Okay! Only one bill will be printed.");
            System.out.print("How many people are in your group: ");
            groupSize = scan.nextInt();
            scan.nextLine();

            // repeats until customer puts in all items
            while (!itemAddedToBill.equals("done")) {
                System.out.print("Enter an item bought today, or done to finish: ");
                itemAddedToBill = scan.nextLine();

                    // finding price of items
                    if (!itemAddedToBill.equals("done")) {
                        System.out.print("Type the price of the item: ");
                        priceAddedToBill = (Math.round(100 * scan.nextDouble())) / 100.0;
                        scan.nextLine();
                        itemsOrdered++;
                        bill += itemAddedToBill + " - $" + priceAddedToBill + "\n";
                        billTotalPrice += priceAddedToBill;
                    }
            }

            // saving bill, then showing bill without tip
            BillSaver single = new BillSaver(1 , groupSize, itemsOrdered, bill, billTotalPrice);
            single.billBefore();

            //checking if they are tipping or not
            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                System.out.print("Type 'yes' if would you like to tip: ");
                tipDecision = scan.nextLine();

                if (tipDecision.equals("yes")) {
                    // yes tip
                    System.out.print("Thank you! How much would you like to tip?: ");
                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                    System.out.print("$" + tip + " is " + single.tipAmount(tip) + "% of your order");
                    single.totalBillSetter(single.totalBillGetter() + tip);
                    single.billAfter();

                } else if (tipDecision.equals("no")) {
                    // no tip
                    System.out.println("Thank you for enjoying a meal at Jade's!");

                } else {
                    // answer was not acceptable
                    System.out.println("Error, invalid input try again \n");
                }
            }
        }

        // beginning of the separate pay area
        else {
            // making sure the correct numbers are put in
            while (!(numberOfBills == 3) && !(numberOfBills == 2) && !(numberOfBills == 1)) {
            System.out.print("2 or 3 separate bills?: ");
            numberOfBills = scan.nextInt();
            scan.nextLine();

                if (numberOfBills == 3) {

                } else if (numberOfBills == 2) {
                    // only 2 bills
                    while (billNumber < 3) {
                        // dividing the separate bills among people
                        System.out.print("How many people will be paying for bill " + billNumber + "? : ");
                        groupSize = scan.nextInt();
                        scan.nextLine();

                        // repeats until customer puts in all items
                        while (!itemAddedToBill.equals("done")) {
                            System.out.print("Enter an item bought today, or done to finish: ");
                            itemAddedToBill = scan.nextLine();

                            // finding price of items
                            if (!itemAddedToBill.equals("done")) {
                                System.out.print("Type the price of the item: ");
                                priceAddedToBill = (Math.round(100 * scan.nextDouble())) / 100.0;
                                scan.nextLine();
                                itemsOrdered++;
                                bill += itemAddedToBill + " - $" + priceAddedToBill + "\n";
                                billTotalPrice += priceAddedToBill;
                            }
                        }
                        if (billNumber == 1) {
                            // creating bill 1
                            BillSaver billOne = new BillSaver(billNumber, groupSize, itemsOrdered, bill, billTotalPrice);
                            groupSize = 0;
                            itemsOrdered = 0;
                            bill = "Items Purchased \n";
                            billTotalPrice = 0;
                            itemAddedToBill = "empty";

                            //checking if they are tipping or not
                            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                                System.out.print("Type 'yes' if would you like to tip: ");
                                tipDecision = scan.nextLine();

                                if (tipDecision.equals("yes")) {
                                    // yes tip
                                    System.out.print("Thank you! How much would you like to tip?: ");
                                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                                    System.out.print("$" + tip + " is " + billOne.tipAmount(tip) + "% of your order");
                                    billOne.totalBillSetter(billOne.totalBillGetter() + tip);
                                    billOne.billAfter();

                                } else if (tipDecision.equals("no")) {
                                    // no tip
                                    System.out.println("Thank you for enjoying a meal at Jade's!");

                                } else {
                                    // answer was not acceptable
                                    System.out.println("Error, invalid input try again \n");
                                }
                            }
                            tipDecision = "empty";
                        } else {
                            // creating bill 2
                            BillSaver billTwo = new BillSaver(billNumber, groupSize, itemsOrdered, bill, billTotalPrice);
                            //checking if they are tipping or not
                            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                                System.out.print("Type 'yes' if would you like to tip: ");
                                tipDecision = scan.nextLine();

                                if (tipDecision.equals("yes")) {
                                    // yes tip
                                    System.out.print("Thank you! How much would you like to tip?: ");
                                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                                    System.out.print("$" + tip + " is " + billTwo.tipAmount(tip) + "% of your order");
                                    billTwo.totalBillSetter(billTwo.totalBillGetter() + tip);
                                    billTwo.billAfter();

                                } else if (tipDecision.equals("no")) {
                                    // no tip
                                    System.out.println("Thank you for enjoying a meal at Jade's!");

                                } else {
                                    // answer was not acceptable
                                    System.out.println("Error, invalid input try again \n");
                                }
                            }
                        }

                        billNumber++;
                    }
                } else {
                    System.out.println("My apologies customer, we do not support this many bills");
                }
            }
        }
    }
}
