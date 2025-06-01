import java.io.*;
import java.util.*;

public class g4_17281 {
    static int N;
    static int[][] innings;
    static int maxScore = 0;
    static boolean[] selected = new boolean[9];
    static int[] order = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];

        // 이닝 데이터 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1번 선수(인덱스 0)는 4번 타순(인덱스 3)에 고정
        selected[0] = true;
        order[3] = 0;
        permute(0);

        System.out.println(maxScore);
    }

    // 순열 생성 (1번 선수 제외한 8명의 타자)
    private static void permute(int depth) {
        if (depth == 9) {
            simulate();
            return;
        }

        if (depth == 3) {
            permute(depth + 1); // 4번 타자는 고정
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!selected[i]) {
                selected[i] = true;
                order[depth] = i;
                permute(depth + 1);
                selected[i] = false;
            }
        }
    }

    // 경기 시뮬레이션
    private static void simulate() {
        int score = 0;
        int playerIdx = 0; // 현재 타순 인덱스

        for (int inning = 0; inning < N; inning++) {
            int out = 0;
            boolean[] base = new boolean[3]; // 1루, 2루, 3루

            while (out < 3) {
                int player = order[playerIdx];
                int result = innings[inning][player];

                if (result == 0) {
                    out++;
                } else {
                    // 주자 이동
                    for (int i = 2; i >= 0; i--) {
                        if (base[i]) {
                            if (i + result >= 3) score++;
                            else base[i + result] = true;
                            base[i] = false;
                        }
                    }
                    // 타자 진루
                    if (result == 4) {
                        score++;
                    } else {
                        base[result - 1] = true;
                    }
                }

                playerIdx = (playerIdx + 1) % 9;
            }
        }

        maxScore = Math.max(maxScore, score);
    }
}
