import java.util.Scanner;
public class TipCalc {
    public static void main(String[] args) {
        // initializing variables
        Scanner scan = new Scanner(System.in);
        int groupSize;
        double tip;
        double priceAddedToBill;
        double billBeforeTip;
        double billAfterTip;
        String itemList = "Items Purchased \n ";
        String itemAddedToBill = "empty";
        int togetherPay;


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
            while (!itemAddedToBill.equals("done")) {
                System.out.println("Okay! Only one bill will be printed.");
                System.out.print("Enter an item bought today, or done to finish: ");
                itemAddedToBill = scan.nextLine();
                    if (!itemAddedToBill.equals("done")) {
                        System.out.print("Type the price of the item: ");
                        priceAddedToBill = scan.nextDouble();
                        scan.nextLine();
                        itemList += itemAddedToBill + "\n";
                    }
            }
        }
        else {
            System.out.print("Type the number of bills needed: ");
            int numberOfBills = scan.nextInt();
            scan.nextLine();

        }
    }
}
