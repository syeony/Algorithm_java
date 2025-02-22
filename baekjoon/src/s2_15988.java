import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s2_15988 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[1000001];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<1000001;i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
        }

        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            int n=Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}
