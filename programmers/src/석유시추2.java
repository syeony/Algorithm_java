import java.io.*;
import java.util.*;

class 석유시추2 {
    static boolean[][] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int[][] land2;
    static int n,m;
    static int[] oil_list; //열마다 석유개수 저장

    public int solution(int[][] land) {
        n=land.length;
        m=land[0].length;
        land2=land;
        oil_list=new int[m];
        int max=0;
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && land2[i][j]==1){
                    bfs(i,j);
                }
            }
        }

        for(int i=0;i<m;i++){
            max=Math.max(max,oil_list[i]);
        }

        return max;
    }

    static void bfs(int x,int y){
        int cnt=0;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{x,y});
        Set<Integer> columns=new HashSet<>();
        columns.add(y);
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
                    columns.add(ny);
                    cnt++;
                }
            }
        }

        for(int i:columns){
            oil_list[i]+=cnt;
        }

    }

    static boolean isEdge(int x,int y){
        return x<0||y<0||x>=n||y>=m;
    }
}