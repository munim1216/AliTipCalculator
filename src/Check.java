public class Check {
    public Check() {}
    public String lastDigit(double check) {
        if (((check * 100) % 10) == 0){
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