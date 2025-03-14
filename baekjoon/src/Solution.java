import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static double[][] arr;
    static boolean[] v;
    static double answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());

            arr = new double[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            v = new boolean[n];
            answer = 0.0;
            dfs(0, 1.0);

            System.out.println("#" + t + " " + String.format("%.6f", answer * 100));
        }
    }

    static void dfs(int idx, double percent) {
        if (answer >= percent) {
            return;
        }

        if (idx == n) {
            answer = Math.max(percent, answer);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;

                // 모든 탐색 경로 출력
                System.out.println("idx: " + idx + ", i: " + i + ", percent: " + (percent * (arr[idx][i] / 100)));

                dfs(idx + 1, percent * (arr[idx][i] / 100));
                v[i] = false;
            }
        }
    }
}