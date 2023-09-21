import java.util.Scanner;
public class TipCalc {
    public static void main(String[] args) {
        // initializing variables
        Scanner scan = new Scanner(System.in);
        int groupSize;
        double tip;
        double itemAddedToBill;
        double billBeforeTip;
        double billAfterTip;
        int togetherPay;
        // ask if paying individually or together
        // gathering user input
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
    }
}
