import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d5_10507 {
    static int n,p;
    static int[] studyDays;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());

        for(int t=1;t<=tc;t++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            p=Integer.parseInt(st.nextToken());

            studyDays=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                studyDays[i]=Integer.parseInt(st.nextToken());
            }

            int maxLen = 0;
            int left = 0;
            for (int right = 0; right < n; right++) {
                // 총 구간 길이 = studyDays[right] - studyDays[left] + 1
                // 실제 공부한 날 수 = right - left + 1
                // 조작 필요한 날 수 = 전체 - 실제 = studyDays[right] - studyDays[left] + 1 - (right - left + 1)
                // 정리: (studyDays[right] - studyDays[left]) - (right - left)
                while ((studyDays[right] - studyDays[left]) - (right - left) > p) {
                    left++;
                }

                int currentLen = (studyDays[right] - studyDays[left] + 1);
                currentLen += p - ((studyDays[right] - studyDays[left]) - (right - left));
                maxLen = Math.max(maxLen, currentLen);
            }

            System.out.println("#"+t+" "+maxLen);
        }
    }
}
