public class Check {
    public Check() {}
    public String lastDigit(double check) {
        /* code to ask mr miller about
        System.out.println(check * 100);
        System.out.println((check * 100) % 10);
        */
        if ((Math.round(check * 100) % 10) == 0){
            if ((((int)(check * 10)) / 10) == check) {
                return "";
            } else {
                return "0";
            }
        } else {
            return " ";
        }
    }
}