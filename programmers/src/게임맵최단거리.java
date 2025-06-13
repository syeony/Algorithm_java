import java.io.*;
import java.util.*;

class 게임맵최단거리 {
    static int answer;
    static int n,m;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        n=maps.length;
        m=maps[0].length;
        visited=new boolean[n][m];
        answer=bfs(0,0,maps);
        return answer;
    }

    static int bfs(int x,int y,int[][] maps){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{x,y,1});
        visited[x][y]=true;

        while(!q.isEmpty()){
            int[] c=q.poll();
            int cx=c[0];
            int cy=c[1];
            int sum=c[2];

            if(cx==n-1 && cy==m-1){
                return sum;
            }

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                int sum2=sum+1;

                if(isEdge(nx,ny) || visited[nx][ny]) continue;

                if(maps[nx][ny]==1){
                    q.offer(new int[]{nx,ny,sum2});
                    visited[nx][ny]=true;
                }
            }
        }
        return -1;
    }

    static boolean isEdge(int x, int y){
        return x<0||y<0||x>=n||y>=m;
    }
}