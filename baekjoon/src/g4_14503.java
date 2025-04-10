import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_14503 {
    static int n,m,r,c,d;
    static int[][] map;
    static boolean[][] v;
    //시계방향
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());

        map = new int[n][m];
        v = new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        answer=0;
        bfs(r,c,d);
        System.out.println(answer);
    }

    static void bfs(int x,int y,int direct){
        //1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if(!v[x][y]){
            v[x][y]=true;
            answer++;
        }

        //2.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        if(checkfour(x,y)){
            int new_d=(direct+2)%4;
            int nx=x+dx[new_d];
            int ny=y+dy[new_d];

            //2-1.바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            if(!isedge(nx,ny)){
                bfs(nx,ny,direct);
            }
        } else{ //3.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            for(int i=0;i<4;i++){
                direct=(direct+3)%4; //90도 회전
                int nx=x+dx[direct];
                int ny=y+dy[direct];

                if(!isedge(nx,ny) && !v[nx][ny]){
                    bfs(nx,ny,direct);
                    break;
                }
            }

        }

    }

    static boolean checkfour(int x,int y){
        int n=0;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(!isedge(nx,ny) && !v[nx][ny]) n++;
        }

        if(n==0) return true;
        else return false;
    }

    static boolean isedge(int x,int y){
        return (x<0||y<0||x>=n||y>=m||map[x][y]==1);
    }
}
