import java.io.*;
import java.util.*;

public class g4_24463_2 {
    static int N, M, sx, sy, ex, ey, max;
    static char[][] map;
    static int[][] cost;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        sx = sy = ex = ey = -1;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '.' && (i == 0 || j == 0 || i == N-1 || j == M-1)) {
                    if (sx == -1) { sx = i; sy = j; }
                    else         { ex = i; ey = j; }
                }
                if (map[i][j] == '.') {
                    map[i][j] = '@';
                }
            }
        }

        bfs();     // Dijkstra 대신 BFS
        dot();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void bfs() {
        cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cost[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        cost[sx][sy] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == ex && y == ey) {
                max = cost[x][y];
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == '+' || cost[nx][ny] != -1) continue;

                cost[nx][ny] = cost[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }

    static void dot() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ex, ey, max});
        map[ex][ey] = '.';

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], c = cur[2];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (cost[nx][ny] == c - 1) {
                    map[nx][ny] = '.';
                    q.offer(new int[]{nx, ny, c - 1});
                }
            }
        }
    }
}
