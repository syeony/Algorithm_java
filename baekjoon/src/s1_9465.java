import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_9465 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		for(int t=0;t<n;t++) {
			int num=Integer.parseInt(br.readLine());
			int[] a=new int[num];
			int[] b=new int[num];
			
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<num;j++) {
				a[j]=Integer.parseInt(st.nextToken());
			}
			
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<num;j++) {
				b[j]=Integer.parseInt(st.nextToken());
			}
			
			int[][] dp=new int[2][num];
			
			dp[0][0]=a[0];
			dp[1][0]=b[0];
			
			if(num>=2) {
				dp[0][1]=dp[1][0]+a[1];
				dp[1][1]=dp[0][0]+b[1];
			}
			
			for(int i=2;i<num;i++) {
				dp[0][i]=Math.max(dp[1][i-2], dp[1][i-1])+a[i];
				dp[1][i]=Math.max(dp[0][i-2], dp[0][i-1])+b[i];
			}
			
			System.out.println(Math.max(dp[0][num-1], dp[1][num-1]));
			
		}
	}

}
