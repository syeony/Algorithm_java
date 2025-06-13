import java.io.*;
import java.util.*;

class 타겟넘버 {
    static int answer;
    static int[] n;
    static int t;

    public int solution(int[] numbers, int target) {
        answer = 0;
        n=numbers;
        t=target;

        perm(0,0);

        return answer;
    }

    static void perm(int idx, int sum){
        if(idx==n.length){
            if(sum==t){
                answer++;
            }
            return;
        }

        perm(idx+1,sum+n[idx]);
        perm(idx+1,sum-n[idx]);
    }
}