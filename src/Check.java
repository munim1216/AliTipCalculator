public class Check {
    public Check() {}
    public String lastDigit(double check) {
        // friend liam & andrew helped with this
        if ((Math.round(check * 100) % 10) == 0){
            return "0";
        } else {
            return " ";
        }
    }
}