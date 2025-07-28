import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s3_31575 {
    static int n,m;
    static int[] dx={0,1};
    static int[] dy={1,0};
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0);
    }

    static void bfs(int x,int y){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{x,y});
        boolean[][] visited=new boolean[n][m];
        visited[0][0]=true;

        while(!q.isEmpty()){
            int[] cur=q.poll();
            int cx=cur[0];
            int cy=cur[1];

            if(cx==n-1 && cy==m-1){
                System.out.println("Yes");
                return;
            }

            for(int i=0;i<2;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(isEdge(nx,ny) || map[nx][ny]==0 || visited[nx][ny]) continue;

                q.offer(new int[]{nx,ny});
                visited[nx][ny]=true;
            }
        }
        System.out.println("No");
    }

    static boolean isEdge(int x,int y){
        return (x<0||y<0||x>=n||y>=m);
    }
}
