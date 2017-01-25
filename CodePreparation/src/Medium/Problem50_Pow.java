package Medium;

/**
 * Created by Aakash on 1/25/2017.
 */
public class Problem50_Pow {
    public static void main(String[] args) {
        Problem50_Pow pow = new Problem50_Pow();
        System.out.println(pow.myPow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            x = 1/x;
            if(n == -2147483648) {
                x = x*x;
                n++;
            }
            n = -n;
        }
        return n%2 == 0 ? myPow(x*x, n/2) : x * myPow(x * x, n/2);
    }
}
