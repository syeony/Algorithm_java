import java.io.*;
import java.util.*;

class 프로세 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n=priorities.length;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int p:priorities){
            pq.offer(p);
        }
        
        while(!pq.isEmpty()){
            for(int i=0;i<n;i++){
                if(pq.peek()==priorities[i]){
                    answer++;
                    pq.poll();
                    if(i==location){
                        return answer;
                    }
                }
            }
        }
        
        return answer;
    }
}
