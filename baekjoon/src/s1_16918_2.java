import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s1_16918_2 {
    static int r,c,n;
    static char[][] map;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());

        q=new LinkedList<>();
        map=new char[r][c];
        for(int i=0;i<r;i++){
            String line=br.readLine();
            for(int j=0;j<c;j++){
                map[i][j]=line.charAt(j);

            }
        }

        for(int t=2;t<=n;t++){
            if(t%2==1){
                for(int i=0;i<r;i++){
                    for(int j=0;j<c;j++){
                        if(map[i][j]=='O') q.add(new int[]{i,j});
                    }
                }
                for(char[] m:map){
                    Arrays.fill(m,'O');
                }
                bfs();
            }
        }

        if(n%2==0){
            for(char[] m:map){
                Arrays.fill(m,'O');
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }


    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] cc=q.poll();
            int x=cc[0];
            int y=cc[1];
            map[x][y]='.';

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(isEdge(nx,ny)) continue;
                if(map[nx][ny]=='O'){
                    map[nx][ny]='.';
                }
            }
        }

    }

    static boolean isEdge(int x,int y){
        return (x<0 || y<0 || x>=r || y>=c);
    }

}
