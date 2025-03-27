import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g3_1520 {
    static int n,m;
    static int[][] map;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int path;
    static boolean[][] v;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        path=0;
        v=new boolean[n][m];
        v[0][0]=true;
        dfs(0,0);
        System.out.println(path);
    }

    static void dfs(int x,int y){
        if(x==n-1 && y==m-1){
            path++;
            return;
        }

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(isEdge(nx,ny) || v[nx][ny]) continue;

            if(map[nx][ny]<map[x][y]){
                v[nx][ny]=true;
                dfs(nx,ny);
            }

        }
    }

    static boolean isEdge(int x,int y){
        return (x<0 || y<0 || x>=n || y>=m);
    }
}
