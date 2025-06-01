import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g4_17144 {
    static int r,c,t;
    static int[][][] map;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int mx1=-1, mx2; //공기청정기 위치

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        map=new int[r][c][2];
        for(int i=0;i<r;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                map[i][j][0]=Integer.parseInt(st.nextToken());
                if(map[i][j][0]==-1){
                    if(mx1==-1){
                        mx1=i;
                    }else{
                        mx2=i;
                    }
                }
            }
        }

        for(int i=0;i<t;i++){
            //미세먼지 확산
            first();
            //미세먼지 이동
            second();
        }

        //맞게 이동했나 확인
//        for(int i=0;i<r;i++){
//            for(int j=0;j<c;j++){
//                System.out.print(map[i][j][0]+" ");
//            }
//            System.out.println();
//        }

        int answer=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j][0]>0){
                    answer+=map[i][j][0];
                }
            }
        }

        System.out.println(answer);
    }

    static void first(){
        //삼차원 map에 0:원래자리미세먼지(남은거) 1:퍼진미세먼지 나눠서 저장
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j][0]>=5){
                    int original=map[i][j][0];
                    int cnt=0; //사방으로 퍼지는 칸의 갯수

                    for(int f=0;f<4;f++){
                        int nx=i+dx[f];
                        int ny=j+dy[f];

                        if(isEdge(nx,ny) || map[nx][ny][0]==-1) continue;

                        cnt++;
                        map[nx][ny][1]+=original/5;
                    }

                    original-=((original/5)*cnt);
                    map[i][j][0]=original;
                }
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i][j][0]+=map[i][j][1];
                map[i][j][1]=0;
            }
        }
    }

    static void second() {
        // 1. 윗쪽(반시계, mx1행)
        // 위로
        for (int i = mx1 - 1; i > 0; i--) map[i][0][0] = map[i - 1][0][0];
        // 왼쪽
        for (int i = 0; i < c - 1; i++) map[0][i][0] = map[0][i + 1][0];
        // 아래로
        for (int i = 0; i < mx1; i++) map[i][c - 1][0] = map[i + 1][c - 1][0];
        // 오른쪽
        for (int i = c - 1; i > 1; i--) map[mx1][i][0] = map[mx1][i - 1][0];
        // 공기청정기에서 나온 바람
        map[mx1][1][0] = 0;

        // 2. 아랫쪽(시계, mx2행)
        // 아래로
        for (int i = mx2 + 1; i < r - 1; i++) map[i][0][0] = map[i + 1][0][0];
        // 왼쪽
        for (int i = 0; i < c - 1; i++) map[r - 1][i][0] = map[r - 1][i + 1][0];
        // 위로
        for (int i = r - 1; i > mx2; i--) map[i][c - 1][0] = map[i - 1][c - 1][0];
        // 오른쪽
        for (int i = c - 1; i > 1; i--) map[mx2][i][0] = map[mx2][i - 1][0];
        // 공기청정기에서 나온 바람
        map[mx2][1][0] = 0;

        // 공기청정기 위치 보정(-1 유지)
        map[mx1][0][0] = -1;
        map[mx2][0][0] = -1;
    }


    static boolean isEdge(int x, int y){
        return (x<0||y<0||x>=r||y>=c);
    }
}
