import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class d4_1226 {
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,1,-1};
    static int[][] arr;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1;t<=10;t++) {
            int n=Integer.parseInt(br.readLine());
            arr = new int[16][16];
            for(int i=0;i<16;i++) {
                String st=br.readLine();
                for(int j=0;j<16;j++) {
                    arr[i][j]=st.charAt(j)-'0';
                }
            }
//			System.out.println(Arrays.deepToString(arr));
            v=new boolean[16][16];

            System.out.println("#"+n+" "+bfs(1,1));
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int[] temp=q.poll();
            int xx=temp[0];
            int yy=temp[1];

            for(int i=0;i<4;i++) {
                int nx=xx+dx[i];
                int ny=yy+dy[i];

                if(nx<0 || ny>=16 || nx>=16 || ny<0) {
                    continue;
                }
                if(arr[nx][ny]==1) {
                    continue;
                }
                if(arr[nx][ny]==0) {
                    q.add(new int[] {nx,ny});
                    arr[nx][ny]=1;
//					for(int j=0;j<16;j++) {
//						System.out.println(Arrays.toString(arr[j]));
//					}
//					System.out.println("========================================================");
                }
                if(arr[nx][ny]==3) {
//					System.out.println(nx+" "+ny);
                    return 1;
                }
            }
        }

        return 0;
    }

}

