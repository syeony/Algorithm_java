import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        int n=triangle.length-1;
        
        while(n>0){
            for(int i=0;i<n;i++){
                triangle[n-1][i]+=Math.max(triangle[n][i],triangle[n][i+1]);
            }
            n--;
        }
        
        return triangle[0][0];
    }
}
