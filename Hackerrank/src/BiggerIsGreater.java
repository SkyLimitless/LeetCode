import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by achaurasia on 10/15/16.
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        BiggerIsGreater obj = new BiggerIsGreater();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i  < n; i++) {
            System.out.println(obj.nextGreaterOptimized(sc.nextLine()));
        }
    }

    String nextGreater(String input){
        String result = "no answer";
        for(int j =  1; j < input.length(); j++ ) {
            char inChar[] = input.toCharArray();
            int len = inChar.length;
            int min = inChar[len - j];
            for (int i = len - 1 - j; i >= 0; i--) {
                int temp = inChar[i];
                if (temp < min) {
                    inChar[i] = (char) min;
                    inChar[len - j] = (char) temp;
                    char tmpArray[] = new char[len - i - 1];
                    System.arraycopy(inChar, i + 1, tmpArray, 0, len - i - 1);
                    Arrays.sort(tmpArray);
                    StringBuilder sb = new StringBuilder();
                    sb.append(input.substring(0, i));
                    sb.append(inChar[i]);
                    sb.append(tmpArray);
                    return sb.toString();
                }
            }
        }
        return result;
    }

    String nextGreaterOptimized(String input){

        String result = "no answer";
        char inChar[] = input.toCharArray();
        int len = inChar.length;
        int max = inChar[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            int temp = inChar[i];
            if (temp < max) {
                for(int j = len - 1; j > i; j--){
                    int nextHigher = inChar[j];
                    if(temp < nextHigher){
                        inChar[i] = (char) nextHigher;
                        inChar[j] = (char) temp;
                        break;
                    }
                }
                for(int j = 0; j < (len - i - 1)/2; j++){
                    char tempC = inChar[j + i + 1];
                    inChar[j + i + 1] = inChar[len - j - 1];
                    inChar[len - j - 1] = tempC;
                }
                return new String(inChar);
            } else{
                max = temp;
            }
        }
        return result;
    }
}
