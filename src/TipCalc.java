import java.util.ArrayList;
import java.util.Scanner;
public class TipCalc {
    public static void main(String[] args) {
        // to be used if i decide to refactor it
//        ArrayList<BillSaver> bills = new ArrayList<BillSaver>();
//
//
//        BillSaver bill = new BillSaver(4, 5, 6, "h", 5.6);
//        bills.add(bill);
//
//        for (int i = 0; i < bills.size(); i++) {
//            bills.get(i).billAfter();
//        }
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
        Check checker = new Check();

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
            System.out.print("How many people are in your group?: ");
            groupSize = scan.nextInt();
            scan.nextLine();

            // repeats until customer puts in all items
            while (!itemAddedToBill.equals("done")) {
                System.out.print("Enter an item bought today, or done to finish: ");
                itemAddedToBill = scan.nextLine();

                    // finding price of items
                    if (!itemAddedToBill.equals("done")) {
                        System.out.print("Type the price of the item: ");
                        // learnt math.round from https://www.youtube.com/watch?v=nLDWeTz3Zgc&ab_channel=TanUv90
                        priceAddedToBill = (Math.round(100 * scan.nextDouble())) / 100.0;
                        scan.nextLine();
                        itemsOrdered++;
                        bill += itemAddedToBill + " - $" + priceAddedToBill + checker.lastDigit(priceAddedToBill) + "\n";
                        billTotalPrice += priceAddedToBill;
                    }
            }

            // saving bill, then showing bill without tip
            BillSaver single = new BillSaver(1 , groupSize, itemsOrdered, bill, billTotalPrice);
            single.billBefore();
            //checking if they are tipping or not
            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                System.out.print("Type 'yes' if would you like to tip or 'no' to decline: ");
                tipDecision = scan.nextLine();

                if (tipDecision.equals("yes")) {
                    // yes tip
                    System.out.print("Thank you! How many dollars would you like to tip?: ");
                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                    single.totalBillSetter(single.totalBillGetter() + tip);
                    single.tipSetter(tip);
                    single.billAfter();
                    System.out.println("$" + tip + " is " + single.tipAmount() + "% of your order");
                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

                } else if (tipDecision.equals("no")) {
                    // no tip
                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

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
                    // making 3 bills
                    while (billNumber < 4) {
                        // dividing the separate bills among people
                        System.out.print("How many people will be paying for bill " + billNumber + "?: ");
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
                                bill += itemAddedToBill + " - $" + priceAddedToBill + checker.lastDigit(priceAddedToBill) + "\n";
                                billTotalPrice += priceAddedToBill;
                            }
                        }
                        if (billNumber == 1) {
                            // creating bill 1
                            BillSaver billOne = new BillSaver(billNumber, groupSize, itemsOrdered, bill, billTotalPrice);
                            // clearing variables
                            groupSize = 0;
                            itemsOrdered = 0;
                            bill = "Items Purchased \n";
                            billTotalPrice = 0;
                            itemAddedToBill = "empty";

                            //bill before tip
                            billOne.billBefore();
                            //checking if they are tipping or not
                            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                                System.out.print("Type 'yes' if would you like to tip or 'no' to decline: ");
                                tipDecision = scan.nextLine();

                                if (tipDecision.equals("yes")) {
                                    // yes tip
                                    System.out.print("Thank you! How many dollars would you like to tip?: ");
                                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                                    billOne.totalBillSetter(billOne.totalBillGetter() + tip);
                                    billOne.tipSetter(tip);
                                    billOne.billAfter();
                                    System.out.println("$" + tip + " is " + billOne.tipAmount() + "% of your order");
                                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

                                } else if (tipDecision.equals("no")) {
                                    // no tip
                                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

                                } else {
                                    // answer was not acceptable
                                    System.out.println("Error, invalid input try again \n");
                                }
                            }
                            tipDecision = "empty";
                        } else if (billNumber == 2){
                            // creating bill 2
                            BillSaver billTwo = new BillSaver(billNumber, groupSize, itemsOrdered, bill, billTotalPrice);

                            // clearing variables
                            groupSize = 0;
                            itemsOrdered = 0;
                            bill = "Items Purchased \n";
                            billTotalPrice = 0;
                            itemAddedToBill = "empty";
                            // bill before tip
                            billTwo.billBefore();
                            //checking if they are tipping or not
                            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                                System.out.print("Type 'yes' if would you like to tip or 'no' to decline: ");
                                tipDecision = scan.nextLine();

                                if (tipDecision.equals("yes")) {
                                    // yes tip
                                    System.out.print("Thank you! How many dollars would you like to tip?: ");
                                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                                    billTwo.totalBillSetter(billTwo.totalBillGetter() + tip);
                                    billTwo.tipSetter(tip);
                                    billTwo.billAfter();
                                    System.out.println("$" + tip + " is " + billTwo.tipAmount() + "% of your order");
                                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

                                } else if (tipDecision.equals("no")) {
                                    // no tip
                                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

                                } else {
                                    // answer was not acceptable
                                    System.out.println("Error, invalid input try again \n");
                                }
                            }
                            tipDecision = "empty";
                        }   else {
                            // creating bill 3
                            BillSaver billThree = new BillSaver(billNumber, groupSize, itemsOrdered, bill, billTotalPrice);
                            // bill before tip
                            billThree.billBefore();
                            //checking if they are tipping or not
                            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                                System.out.print("Type 'yes' if would you like to tip or 'no' to decline: ");
                                tipDecision = scan.nextLine();

                                if (tipDecision.equals("yes")) {
                                    // yes tip
                                    System.out.print("Thank you! How many dollars would you like to tip?: ");
                                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                                    billThree.totalBillSetter(billThree.totalBillGetter() + tip);
                                    billThree.tipSetter(tip);
                                    billThree.billAfter();
                                    System.out.println("$" + tip + " is " + billThree.tipAmount() + "% of your order");
                                    System.out.println("Thank you for enjoying a meal at Jade's! \n");

                                } else if (tipDecision.equals("no")) {
                                    // no tip
                                    System.out.println("Thank you for enjoying a meal at Jade's! \n");

                                } else {
                                    // answer was not acceptable
                                    System.out.println("Error, invalid input try again \n");
                                }
                            }
                        }

                        billNumber++;
                    }

                } else if (numberOfBills == 2) {
                    // only 2 bills
                    while (billNumber < 3) {
                        // dividing the separate bills among people
                        System.out.print("How many people will be paying for bill " + billNumber + "?: ");
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
                                bill += itemAddedToBill + " - $" + priceAddedToBill + checker.lastDigit(priceAddedToBill) + "\n";
                                billTotalPrice += priceAddedToBill;
                            }
                        }
                        if (billNumber == 1) {
                            // creating bill 1
                            BillSaver billOne = new BillSaver(billNumber, groupSize, itemsOrdered, bill, billTotalPrice);
                            // clearing variables
                            groupSize = 0;
                            itemsOrdered = 0;
                            bill = "Items Purchased \n";
                            billTotalPrice = 0;
                            itemAddedToBill = "empty";

                            //bill before tip
                            billOne.billBefore();

                            //checking if they are tipping or not
                            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                                System.out.print("Type 'yes' if would you like to tip or 'no' to decline: ");
                                tipDecision = scan.nextLine();

                                if (tipDecision.equals("yes")) {
                                    // yes tip
                                    System.out.print("Thank you! How many dollars would you like to tip?: ");
                                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                                    billOne.totalBillSetter(billOne.totalBillGetter() + tip);
                                    billOne.tipSetter(tip);
                                    billOne.billAfter();
                                    System.out.println("$" + tip + " is " + billOne.tipAmount() + "% of your order");
                                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

                                } else if (tipDecision.equals("no")) {
                                    // no tip
                                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

                                } else {
                                    // answer was not acceptable
                                    System.out.println("Error, invalid input try again \n");
                                }
                            }
                            tipDecision = "empty";
                        } else {
                            // creating bill 2
                            BillSaver billTwo = new BillSaver(billNumber, groupSize, itemsOrdered, bill, billTotalPrice);
                            // bill before tip
                            billTwo.billBefore();
                            //checking if they are tipping or not
                            while (!tipDecision.equals("yes") && !tipDecision.equals("no")) {
                                System.out.print("Type 'yes' if would you like to tip or 'no' to decline: ");
                                tipDecision = scan.nextLine();

                                if (tipDecision.equals("yes")) {
                                    // yes tip
                                    System.out.print("Thank you! How many dollars would you like to tip?: ");
                                    tip = (Math.round(100 * scan.nextDouble())) / 100.0;
                                    billTwo.totalBillSetter(billTwo.totalBillGetter() + tip);
                                    billTwo.tipSetter(tip);
                                    billTwo.billAfter();
                                    System.out.println("$" + tip + " is " + billTwo.tipAmount() + "% of your order");
                                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

                                } else if (tipDecision.equals("no")) {
                                    // no tip
                                    System.out.println("Thank you for enjoying a meal at Jade's!\n");

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
