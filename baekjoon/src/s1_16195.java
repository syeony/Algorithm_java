import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_16195 {
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        long[][] dp=new long[1001][1001];
        dp[1][1]=1;
        dp[2][1]=1;
        dp[2][2]=1;
        dp[3][1]=1;
        dp[3][2]=2;
        dp[3][3]=1;
        for(int i=4;i<1001;i++){
            for(int j=2;j<i;j++){
                dp[i][j]=(dp[i-1][j-1]+dp[i-2][j-1]+dp[i-3][j-1])%1000000009;
            }
            dp[i][i]=1; //1+1+1+1+1...(1로만 더한거)
        }
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            long sum=0;
            for(int j=1;j<=b;j++){
                sum = (sum+dp[a][j]) % 1000000009;
            }
            System.out.println(sum);
        }
    }
}
