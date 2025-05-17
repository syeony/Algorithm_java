import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_2636 {
    static int n,m;
    static int[][] map;
    static boolean[][] hole;
    static int[] dx= {0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    static boolean[][] C;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int time=0;
        int cheeseCnt=0;
        while (true) {
            int currentCheese = countCheese();
            if (currentCheese == 0) break;

            cheeseCnt = currentCheese;
            visit = new boolean[n][m];
            bfsAndMelt();  // 외부 공기를 따라 치즈를 녹임
            time++;
        }

        System.out.println(time);
        System.out.println(cheeseCnt);
    }

    // 외부 공기를 기준으로 BFS 하며 치즈를 즉시 녹임
    static void bfsAndMelt() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isEdge(nx,ny) || visit[nx][ny]) continue;

                visit[nx][ny] = true;

                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;  // 치즈 녹임
                } else if (map[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});  // 외부 공기면 계속 탐색
                }
            }
        }
    }

    // 현재 남은 치즈 개수 세기
    static int countCheese() {
        int count = 0;
        for (int[] row : map) {
            for (int cell : row) {
                if (cell == 1) count++;
            }
        }
        return count;
    }

    static boolean isEdge(int x,int y) {
        return (x<0 || y<0 || x>=n || y>=m);
    }
}
