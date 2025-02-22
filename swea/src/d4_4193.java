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

    static int bfs(int startX, int startY) {
        Queue<State> q = new LinkedList<>();
        v[startX][startY] = 0;
        q.add(new State(startX, startY, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int curT = cur.t;

            // 현재 시간이 이미 기록된 최단시간보다 크다면 스킵
            if(curT > v[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if(arr[nx][ny] == 1) continue;

                int newT = 0;
                if(arr[nx][ny] == 0) {
                    newT = curT + 1;
                } else if(arr[nx][ny] == 2) { // 소용돌이
                    int mod = curT % 3;
                    if(mod == 2) {       // 바로 이동 가능
                        newT = curT + 1;
                    } else if(mod == 1) { // 1초 대기
                        newT = curT + 2;
                    } else if(mod == 0) { // 2초 대기
                        newT = curT + 3;
                    }
                }

                // 새로운 시간이 기존 기록보다 작으면 갱신하고 Queue에 추가
                if(newT < v[nx][ny]) {
                    v[nx][ny] = newT;
                    q.add(new State(nx, ny, newT));
                }
            }
        }
        return v[ex][ey];
    }

}
