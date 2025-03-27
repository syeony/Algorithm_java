import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1_16918 {
    static int r,c,n;
    static char[][] map, map2, answer;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());

        map=new char[r][c];
        map2=new char[r][c];
        for(int i=0;i<r;i++){
            String line=br.readLine();
            for(int j=0;j<c;j++){
                map[i][j]=line.charAt(j);
                map2[i][j]='0';
            }
        }
        time=1;
        answer=new char[r][c];

        if(n%2==0){
            answer=arraycopy();
        }else if(n==1){
            answer=map;
        }else{
            updateMap(map);
        }

        for(int i=0;i<r;i++){
            System.out.println(Arrays.toString(answer[i]));
        }

    }

    //1,3,5,7,9초만....
    static void updateMap(char[][] m){
        if (time == n) {
            answer=m;
            return;
        }

        char[][] temp=arraycopy();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(m[i][j]=='0'){
                    bfs(i,j,temp,m);
                }
            }
        }
        time=time+2;
        updateMap(temp);

    }

    static void bfs(int x,int y, char[][] t,char[][] m){
        map2[x][y]='.';
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(isEdge(nx,ny)) continue;
            if(m[nx][ny]=='0'){
                t[nx][ny]='.';
            }
        }
    }

    static char[][] arraycopy(){
        char[][] t=new char[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                t[i][j]=map2[i][j];
            }
        }
        return t;
    }

    static boolean isEdge(int x,int y){
        return (x<0 || y<0 || x>=r || y>=c);
    }

}
