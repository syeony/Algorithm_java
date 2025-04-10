import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class g2_19238_2 {
    static int n, m, f;
    static int[][] map;
    static boolean[][] v;
    static int tx, ty; // 택시 위치
    static ArrayList<customer> c;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class customer {
        int sx, sy, ex, ey;

        public customer(int sx, int sy, int ex, int ey) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        tx = Integer.parseInt(st.nextToken());
        ty = Integer.parseInt(st.nextToken());

        c = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            c.add(new customer(sx, sy, ex, ey));
        }

        while (c.size() > 0) {
            int idx = getClosestCustomer();

            if (idx == -1) {
                System.out.println(-1);
                return;
            }

            customer cust = c.get(idx);
            int toCustomer = bfs(tx, ty, cust.sx, cust.sy);

            if (toCustomer == -1 || f < toCustomer) {
                System.out.println(-1);
                return;
            }

            f -= toCustomer;
            tx = cust.sx;
            ty = cust.sy;

            int toDestination = bfs(tx, ty, cust.ex, cust.ey);

            if (toDestination == -1 || f < toDestination) {
                System.out.println(-1);
                return;
            }

            f += toDestination;

            tx = cust.ex;
            ty = cust.ey;

            c.remove(idx);
        }

        System.out.println(f);
    }

    // 가장 가까운 승객의 인덱스를 구함
    static int getClosestCustomer() {
        int minDist = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < c.size(); i++) {
            customer cust = c.get(i);
            int dist = bfs(tx, ty, cust.sx, cust.sy);

            if (dist == -1) continue;

            if (dist < minDist) {
                minDist = dist;
                idx = i;
            } else if (dist == minDist) {
                customer now = c.get(idx);
                if (cust.sx < now.sx || (cust.sx == now.sx && cust.sy < now.sy)) {
                    idx = i;
                }
            }
        }

        return idx;
    }

    // 최단 거리 계산 BFS
    static int bfs(int x, int y, int ex, int ey) {
        v = new boolean[n + 1][n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        v[x][y] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cx = temp[0];
            int cy = temp[1];
            int dist = temp[2];

            if (cx == ex && cy == ey) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isedge(nx,ny) || v[nx][ny] || map[nx][ny] == 1) continue;

                v[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return -1; // 목적지 도달 불가능
    }

    static boolean isedge(int x,int y){
        return (x <= 0 || y <= 0 || x > n || y > n);
    }
}
