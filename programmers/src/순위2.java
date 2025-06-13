import java.io.*;
import java.util.*;

class 순위2 {
    static List<Integer>[] win_lose;
    static List<Integer>[] lose_win;
    static boolean[] visited;
    static int cnt;

    public int solution(int n, int[][] results) {
        int answer = 0;
        int m=results.length;
        win_lose=new ArrayList[n+1];
        lose_win=new ArrayList[n+1];

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
            visited=new boolean[n+1];
            cnt=0;
            dfs(i,win_lose);
            int win=cnt;

            visited=new boolean[n+1];
            cnt=0;
            dfs(i,lose_win);
            int lose=cnt;

            if(win+lose==n-1){
                answer++;
            }
        }

        return answer;
    }

    static void dfs(int node, List<Integer>[] list){
        for(int i:list[node]){
            if(!visited[i]){
                visited[i]=true;
                cnt++;
                dfs(i,list);
            }
        }
    }
}