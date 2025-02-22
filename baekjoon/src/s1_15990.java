import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s1_15990 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[1000001][4];
        dp[1][1]=1;
        dp[2][2]=1;
        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;
        for(int i=4;i<1000001;i++){
            dp[i][1]=(dp[i-1][2]+dp[i-1][3])%1000000009;
            dp[i][2]=(dp[i-2][1]+dp[i-2][3])%1000000009;
            dp[i][3]=(dp[i-3][1]+dp[i-3][2])%1000000009;
        }

        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            int n=Integer.parseInt(br.readLine());

            long answer=(dp[n][1]+dp[n][2]+dp[n][3])%1000000009;
            System.out.println(answer);
        }
    }
}
