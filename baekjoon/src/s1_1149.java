import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_1149 {
	static int n;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		dp=new int[n][n];
		st=new StringTokenizer(br.readLine());
		dp[0][0]=Integer.parseInt(st.nextToken());
		dp[0][1]=Integer.parseInt(st.nextToken());
		dp[0][2]=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+r;
			dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+g;
			dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+b;
		}
		
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}

}
