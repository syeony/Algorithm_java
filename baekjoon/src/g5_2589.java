import java.io.*;
import java.util.*;

public class g5_2589{
    static int n,m;
    static char[][] map;
    static boolean[][] v;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new char[n][m];
        for(int i=0;i<n;i++){
            String line=br.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=line.charAt(j);
            }
        }

        answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]=='L'){
                    bfs(i,j);
                }
            }
        }

        System.out.println(answer);

    }

    static void bfs(int x,int y){
        v=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        int dist=0;
        q.offer(new int[]{x,y,dist});
        v[x][y]=true;

        while(!q.isEmpty()){
            int[] c=q.poll();
            int cx=c[0];
            int cy=c[1];
            dist=c[2];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(isEdge(nx,ny)||map[nx][ny]=='W'||v[nx][ny]) continue;

                q.offer(new int[]{nx,ny,dist+1});
                v[nx][ny]=true;
            }
        }

        answer=Math.max(answer,dist);
    }

    static boolean isEdge(int x,int y){
        return (x<0||y<0||x>=n||y>=m);
    }
}