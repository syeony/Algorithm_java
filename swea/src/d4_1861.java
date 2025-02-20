import java.io.*;
import java.util.*;

public class d4_1861 {
    static int[][] arr;
    static int n, room=Integer.MAX_VALUE, move, temp;
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int tc=1;tc<=t;tc++) {
            n=Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for(int i=0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            move=-1;

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    bfs(i,j);
                    if(temp>move) {
                        move=temp;
                        room=arr[i][j];
                    }else if(temp==move && arr[i][j]<room) {
                        move=temp;
                        room=arr[i][j];
                    }
//					if(move<=temp) {
//						move=temp;
//						room=Math.min(arr[i][j], room);
//					}
                }
            }

            System.out.println("#"+tc+" "+room+" "+move);

        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        temp=1;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            x=curr[0];
            y=curr[1];

            for(int i=0;i<4;i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n) {
                    continue;
                }
                if(arr[nx][ny]==arr[x][y]+1) {
//					System.out.println(arr[x][y]);
                    temp+=1;
                    q.add(new int[] {nx,ny});
                }
            }
        }



    }

}
