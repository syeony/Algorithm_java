import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d3_1244 {
	static int[] arr;
	static int chance;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			st=new StringTokenizer(br.readLine());
			String a=st.nextToken();
			chance=Integer.parseInt(st.nextToken());
			
			arr=new int[a.length()];
			for(int i=0;i<a.length();i++) {
				arr[i]=a.charAt(i)-'0';
			}
			
			if(arr.length<chance) {
				chance=arr.length;
			}
			
//			System.out.println(Arrays.toString(arr));
			answer=Integer.MIN_VALUE;
			allComb(0);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	static void allComb(int c) {
		if(c==chance) {
			int n=changeNum();
			answer=Math.max(answer, n);
			
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				swap(i,j);
				allComb(c+1);
				swap(i,j);
			}
		}
	}
	
	static void swap(int a, int b) {
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	static int changeNum() {
		int num=0;
		for(int i:arr) {
			num=num*10+i;
		}
		
		return num;
	}

}
