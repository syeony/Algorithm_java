import java.io.*;
import java.util.*;

class 순위 {
    static List<Integer>[] win_lose;
    static List<Integer>[] lose_win;
    static HashSet<Integer> map;

    public int solution(int n, int[][] results) {
        int answer = 0;
        int m=results.length;
        win_lose=new ArrayList[n+1];
        lose_win=new ArrayList[n+1];
        map=new HashSet<>();
        for(int i=1;i<n+1;i++){
            win_lose[i]=new ArrayList<>();
            lose_win[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a=results[i][0];
            int b=results[i][1];
            win_lose[a].add(b);
            lose_win[b].add(a);
        }
        for(int i=1;i<n+1;i++){
            if(win_lose[i].size()+lose_win[i].size()==n-1){
                map.add(i);
                if(win_lose[i].size()==1){
                    map.add(win_lose[i].get(0));
                }
                if(lose_win[i].size()==1){
                    map.add(lose_win[i].get(0));
                }
            }
        }
        answer=map.size();

        return answer;
    }
}