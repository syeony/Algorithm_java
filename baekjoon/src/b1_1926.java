import java.io.*;
import java.util.*;

public class b1_1926{
    static int[][] map;
    static boolean[][] visited;
    static int row,col;
    static int count, max;
    static int[] xx={0,0,1,-1};
    static int[] yy={1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        row=Integer.parseInt(st.nextToken());
        col=Integer.parseInt(st.nextToken());

        map=new int[row][col];
        visited=new boolean[row][col];
        count=0;
        max=0;

        for(int i=0;i<row;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<col;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && map[i][j]==1){
                    visited[i][j]=true;
                    count++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);
        System.out.print(max);
    }

    static void bfs(int r, int c){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{r,c});

        int cnt=1;

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int cr=arr[0];
            int cc=arr[1];

            for(int i=0;i<4;i++){
                int nr=cr+xx[i];
                int nc=cc+yy[i];

                if(isEdge(nr,nc)) continue;

                if(map[nr][nc]==1 && !visited[nr][nc]){
                    visited[nr][nc]=true;
                    cnt++;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        max=Math.max(max,cnt);
    }

    static boolean isEdge(int x, int y){
        if(x<0 || y<0 || x>=row || y>=col) return true;
        return false;
    }
}