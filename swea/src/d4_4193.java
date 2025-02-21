import java.io.*;
import java.util.*;

public class d4_4193 {
    static int n;
    static int[][] arr;
    static int[][] v;
    static int sx, sy, ex, ey;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class State {
        int x, y, t;
        public State(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t; //시간
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            v = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    v[i][j] = Integer.MAX_VALUE;
                }
            }
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            int answer = bfs(sx, sy);
            if(answer == Integer.MAX_VALUE) answer = -1;
            System.out.println("#" + tc + " " + answer);
        }
    }

    static int bfs(int X, int Y) {
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.t));
        v[X][Y] = 0;
        pq.add(new State(X, Y, 0));

        while(!pq.isEmpty()){
            State cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int curT = cur.t;

            if(curT > v[x][y]) continue; // 가지치기

            if(x == ex && y == ey) return curT;

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if(arr[nx][ny] == 1) continue;

                int newT = 0;
                if(arr[nx][ny] == 0) { // 바다면 1초
                    newT = curT + 1;
                } else if(arr[nx][ny] == 2) { // 소용돌이면
                    // 현재 시각 curT에서 출발 시 소용돌이가 잠잠한 시점은 curT % 3 == 2이어야 함
                    int mod = curT % 3;
                    if(mod == 2) newT = curT + 1;       // 바로 이동
                    else if(mod == 1) newT = curT + 2;    // 1초 대기
                    else if(mod == 0) newT = curT + 3;    // 2초 대기
                }

                if(newT < v[nx][ny]) {
                    v[nx][ny] = newT;
                    pq.add(new State(nx, ny, newT));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
