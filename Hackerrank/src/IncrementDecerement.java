import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash on 10/23/2016.
 */
public class IncrementDecerement {
    public List<String> generateRle(String s){
        List<String> result = new ArrayList<>();
        char prev=s.charAt(0);
        result.add(prev+"");
        int count = 1;
        for(int i = 1; i < s.length();i++){
            if(prev == s.charAt(i)) {
                count++;
            } else {
                result.add(count+"");
                prev = s.charAt(i);
                result.add(prev+"");
                count = 1;
            }
        }
        result.add(count + "");
        return result;
    }

    public static void main(String args[]) {
        IncrementDecerement id = new IncrementDecerement();
        List<String> rle = id.generateRle("IIII");
        System.out.println(id.permute1(rle).size());
    }

    private void permute(List<String> rle) {
        int count = 1;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < rle.size(); i = i + 2) {
            int c = Integer.parseInt(rle.get(i + 1));
            if(rle.get(i).equalsIgnoreCase("I")){
                if(i != 0 && i+2 != rle.size()) {
                    c--;
                }
                for(int j = 0; j < c; j++) {
                    result.append(count);
                    count++;
                }
            } else {
                for(int j = count + c; j > count; j--) {
                    result.append(j);
                }
                result.append(count);
                count = count + c + 1;
            }
        }
        System.out.println(result.toString());
    }

boolean flag = false;
    private ArrayList<Integer> permute1(List<String> rle) {
        int count = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < rle.size(); i = i + 2) {
            int c = Integer.parseInt(rle.get(i + 1));
            if(rle.get(i).equalsIgnoreCase("I")){
                if(i != 0 && i+2 != rle.size()) {
                    c--;
                }
                if(i+2 == rle.size() && !flag){
                    c = c + 1;
                }
                for(int j = 0; j < c; j++) {
                    result.add(count);
                    count++;
                }
            } else {
                flag = true;
                for(int j = count + c; j > count; j--) {
                    result.add(j);
                }
                result.add(count);
                count = count + c + 1;
            }
        }
        return result;
    }
}
