
public class PrintPrimes {
    public static int fibbo(int x) {
        if (x <= 1){
            return x;}
        else {
            return fibbo(x-1) + fibbo(x-2);
        }
    }
}
    