
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_6913 {
	static int n,m;
	static int[][] arr;
	static int[] people;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			arr=new int[n][m];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<m;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			people=new int[n];
			int ma=Integer.MIN_VALUE;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==1) {
						people[i]+=1;
					}
					ma=Math.max(ma, people[i]);
				}
			}
			
			int a=0;
			for(int i=0;i<n;i++) {
				if(people[i]==ma) {
					a+=1;
				}
			}
			
			System.out.println("#"+t+" "+a+" "+ma);
			
		}
	}

}
