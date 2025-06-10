//답은 맞지만 시간초과

import java.io.*;
import java.util.*;

class 석유시추 {
    static boolean[][] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][] land2;
    static int cnt;
    static int n,m;

    public int solution(int[][] land) {
        int answer = 0;
        n=land.length;
        m=land[0].length;
        land2=land;
        int max=0;

        for(int i=0;i<m;i++){
            visited=new boolean[n][m];
            cnt=0;
            for(int j=0;j<n;j++){
                if(!visited[j][i] && land2[j][i]==1){
                    cnt=bfs(j,i);
                }
            }
            max=Math.max(max, cnt);
        }
        answer=max;
        return answer;
    }

    static int bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y]=true;
        cnt++;

        while(!q.isEmpty()){
            int[] c=q.poll();
            int cx=c[0];
            int cy=c[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(isEdge(nx,ny) || visited[nx][ny]) continue;

                if(land2[nx][ny]==1){
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny]=true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean isEdge(int x,int y){
        return x<0||y<0||x>=n||y>=m;
    }
}