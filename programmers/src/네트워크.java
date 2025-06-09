import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static boolean flag;
    static int[][] computer;
    static int m;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer=computers;
        m=n;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            flag=false;
            dfs(i);
            if(flag) answer++;
        }
        return answer;
    }

    static void dfs(int i){
        for(int j=0;j<m;j++){
            if(computer[i][j]==1 && !visited[j]){
                visited[j]=true;
                flag=true;
                if(i!=j) dfs(j);
            }
        }
    }
}