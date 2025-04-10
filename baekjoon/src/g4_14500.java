import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_14500 {
    static int n,m;
    static int[][] map;
    static int max=0;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        v=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                v[i][j]=true;
                dfs(i,j,map[i][j],1);
                v[i][j]=false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int r, int c, int sum, int cnt){
        if(cnt==4){
            max=Math.max(max,sum);
            return;
        }

        for(int i=0;i<4;i++){
            int nx=r+dx[i];
            int ny=c+dy[i];

            if(isedge(nx,ny)||v[nx][ny]) continue;

            //ㅗ모양때문에 한번 더
            if(cnt==2){
                v[nx][ny]=true;
                dfs(r,c,sum+map[nx][ny],cnt+1);
                v[nx][ny]=false;
            }

            v[nx][ny]=true;
            dfs(nx,ny,sum+map[nx][ny],cnt+1);
            v[nx][ny]=false;
        }
    }

    static boolean isedge(int x, int y){
        return (x<0 || y<0 || x>=n || y>=m);
    }
}
