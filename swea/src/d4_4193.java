import java.io.*;
import java.util.*;

public class d4_4193 {
    static int n, time, answer;
    static int[][] arr;
    static int[][] v;
    static int sx,sy,ex,ey;
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++) {
            time=0;
            answer=Integer.MAX_VALUE;
            n=Integer.parseInt(br.readLine());
            arr=new int[n][n];
            v=new int[n][n];
            for(int i=0;i<n;i++) {
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    v[i][j]=-1;
                }
            }

            st=new StringTokenizer(br.readLine());
            sx=Integer.parseInt(st.nextToken());
            sy=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            ex=Integer.parseInt(st.nextToken());
            ey=Integer.parseInt(st.nextToken());

//			arr[sx][sy]=1;
            v[sx][sy]=0;
            bfs(sx,sy);
            System.out.println("#"+tc+" "+answer);
        }

    }

    static int bfs(int x,int y) {
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            x=curr[0];
            y=curr[1];
            if(x==ex && y==ey) {
                answer=Math.min(answer, v[ex][ey]);
                return answer;
            }
            time+=1;

            for(int i=0;i<4;i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n) {
                    continue;
                }
                if(arr[nx][ny]==1) {
                    continue;
                }
                if(v[nx][ny]!=-1) continue;
                if(arr[nx][ny]==2) {
                    if(time%3==0) {
                        v[nx][ny]=v[x][y]+4;

                        q.add(new int[] {nx,ny});
                        continue;

                    }else if(time%3==1) {
                        v[nx][ny]=v[x][y]+3;

                        q.add(new int[] {nx,ny});
                        continue;

                    }else if(time%3==2) {
                        v[nx][ny]=v[x][y]+1;

                        q.add(new int[] {nx,ny});
                        continue;
                    }
                }
                if(arr[nx][ny]==0) {
                    v[nx][ny]=v[x][y]+1;

                    q.add(new int[] {nx,ny});
                }

            }
        }
        return -1;
    }

}
