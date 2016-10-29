/**
 * Created by Aakash on 10/29/2016.
 */
public class Problem12_IntegerToNumeral {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int div1 = num/1000;
        num = num%1000;
        for(int i = 0; i < div1; i++) {
            sb.append("M");
        }
        
        div1 = num/900;
        if(div1 == 1) {
            sb.append("CM");
        }
        num = num%900;
        div1 = num/500;
        if(div1 == 1) {
            sb.append("D");
        }
        num = num%500;

        div1 = num/400;
        if(div1 == 1) {
            sb.append("CD");
        }
        num = num%400;

        div1 = num/100;
        num = num%100;
        for(int i = 0; i < div1; i++) {
            sb.append("C");
        }

        div1 = num/90;
        if(div1 == 1) {
            sb.append("XC");
        }
        num = num%90;

        div1 = num/50;
        if(div1 == 1) {
            sb.append("L");
        }
        num = num%50;

        div1 = num/40;
        if(div1 == 1) {
            sb.append("XL");
        }
        num = num%40;

        div1 = num/10;
        num = num%10;
        for(int i = 0; i < div1; i++) {
            sb.append("X");
        }

        div1 = num/9;
        if(div1 == 1) {
            sb.append("IX");
        }
        num = num%9;

        div1 = num/5;
        if(div1 == 1) {
            sb.append("V");
        }
        num = num%5;

        div1 = num/4;
        if(div1 == 1) {
            sb.append("IV");
        }
        num = num%4;
        for(int i = 0; i < num; i++) {
            sb.append("I");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem12_IntegerToNumeral problem12_integerToNumeral = new Problem12_IntegerToNumeral();
        String result = problem12_integerToNumeral.intToRoman(119);
        System.out.println("result = " + result);
    }
}
