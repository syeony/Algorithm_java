//메모리초과 

import java.io.*;
import java.util.*;

public class g1_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        ArrayList<Integer> li = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=(i+1)*(j+1);
                li.add(arr[i][j]);
            }
        }

        Collections.sort(li);

        System.out.println(li.get(k));
    }
}
