import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int n=citations.length;
        
        // 0, 1, 3, 5, 6
        
        for(int i=0;i<n;i++){
            int h=n-i; //남은 논문
            if(citations[i]>=h){
                answer=h;
                break;
            }
        }
        
        return answer;
    }
}
