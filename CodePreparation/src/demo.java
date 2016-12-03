/**
 * Created by Aakash on 12/1/2016.
 */
public class demo {
    int count = 0;
    public static void main(String[] args) {
        demo d = new demo();
        //d.printPrime();
        //d.printfibo();
        d.recurfibo(0 , 1);
    }

    private void recurfibo(int x, int y) {
        if(count == 15) {
            return;
        }
        int temp = x + y;
        System.out.println(temp);
        count++;
        recurfibo(y, temp);
    }

    private void printfibo() {
        int prev = 1;
        int pprev = 0;
        for (int i = 0; i < 15; i++) {
            int temp = prev + pprev;
            System.out.println(temp);
            pprev = prev;
            prev = temp;
        }
    }

    private void printPrime() {
        for (int i = 2; i < 100; i++) {
            boolean flag = false;
            for (int j = 2; j <= i/2; j++) {
                if(i%j == 0) {
                    flag = true;
                }
            }
            if(!flag)
                System.out.println(i);
        }
    }
}
