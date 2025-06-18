import java.io.*;
import java.util.*;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //반례(도난당한사람이랑 여분있는사람이 같을때)
        //예 n=5, lost[2,3], reserve[1,2]
        for(int i=0;i<reserve.length;i++){
            for(int j=0;j<lost.length;j++){
                if(reserve[i]==lost[j]){
                    answer++;
                    reserve[i]=-200;
                    lost[j]=-100;
                }
            }
        }

        for(int i=0;i<reserve.length;i++){
            for(int j=0;j<lost.length;j++){
                if(reserve[i]-1==lost[j] || reserve[i]+1==lost[j]){
                    answer++;
                    lost[j]=-100;
                    reserve[i]=-200;
                }
            }
        }
        return answer;
    }
}