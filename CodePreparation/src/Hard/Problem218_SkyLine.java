package Hard;

import java.util.*;

/**
 * Created by Aakash on 2/7/2017.
 */
public class Problem218_SkyLine {

    public static void main(String[] args) {
        int[][] buidings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        Problem218_SkyLine skyLine = new Problem218_SkyLine();
        List<int[]> result = skyLine.getSkyline(buidings);
        for (Iterator<int[]> iterator = result.iterator(); iterator.hasNext(); ) {
            int[] next =  iterator.next();
            System.out.println("next = " + next[0] + "," + next[1]);
        }
    }

    public List<int []> getSkyline(int[][] buildings) {
        int lastIndex = 0;
        ArrayList<Integer> height = new ArrayList<>();
        List<int []> result = new ArrayList<>();
        for(int a[] : buildings) {
            if(a[0] == 0 && a[1] == 2147483647) {
                result.add(new int[]{0, 2147483647});
                result.add(new int[]{2147483647, 0});
                return result;
            }
            for (int i = lastIndex; i < a[0]; i++) {
                height.add(0);
            }
            for (int i = a[0]; i <= a[1] ; i++) {
                if(height.size() <= i) {
                    height.add(a[2]);
                } else {
                    int temp = height.get(i);
                    height.set(i, Math.max(temp, a[2]));
                }
            }
            lastIndex = Math.max(lastIndex, a[1]);
        }

        int prevx = 0, prevh = 0;
        for (int i = 0; i < height.size(); i++) {
            int currh = height.get(i);
            if(currh != prevh && (i != prevx || i == 0)) {
                if(currh > prevh) {
                    result.add(new int[]{i, currh});
                } else {
                    result.add(new int[]{i - 1, currh});
                }
                prevx = i;
                prevh = currh;
            }
        }
        if(result.size() > 0)
            result.add(new int[]{height.size() - 1, 0});
        return result;
    }

    class point implements Comparator<point> {
        int x;
        int y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compare(point t1, point t2) {
            return t1.x == t2.x ? t1.y - t2.y : t1.x - t2.x;
        }
    }
}
