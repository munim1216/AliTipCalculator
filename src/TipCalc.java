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
        while (togetherPay != 1 && togetherPay != 0) {
            System.out.print("Please type 1 or 0, not any other number: ");
            togetherPay = scan.nextInt();
        }

        // checking how many bills to create
        if (togetherPay == 1) {
            while (itemAddedToBill != "done") {
                System.out.println("Okay! Only one bill will be printed. \n ");
                System.out.print("Enter an item bought today: ");
                itemAddedToBill = scan.nextLine();
                System.out.print("test");
                // itemAddedToBill += " \n";
                System.out.print(itemAddedToBill);
            }
        }
        else {

        }
    }
}
