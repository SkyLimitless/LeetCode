package Easy;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Aakash on 1/30/2017.
 */
public class MinSwap{
  public static int minswaps(int[] arrays){
      int n = arrays.length;
      ArrayList<Pair<Integer,Integer>> position = new ArrayList<Pair<Integer, Integer>>();
      for(int i =0;i<n;i++)
          position.add(new javafx.util.Pair<Integer,Integer>(arrays[i],i));

      position.sort(new Comparator<Pair<Integer, Integer>>() {
          @Override
          public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
              if(p1.getValue() > p2.getValue())
                  return -1;
              else if (p1.getValue().equals(p2.getValue()))
                  return 0;
              else
                  return 1;
          }
      });
      Boolean[] visited = new Boolean[n];
      Arrays.fill(visited,false);
      int output = 0;

      for (int i =0;i<n;i++){
          if(visited[i] || position.get(i).getValue()==i){
            continue;
          }
          int cycle_length = 0;
          int j=i;
          while(!visited[j]){
              visited[j]=true;
              j=position.get(j).getValue();
              cycle_length++;
          }
          output +=(cycle_length-1);
      }
      int x = 10;
      StringBuilder sb = new StringBuilder(x);
      String ss = "";
      return output;

  }
}