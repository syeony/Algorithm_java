import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class s2_30804 {
	static int n,left;
	static int[] arr;
	static Map<Integer,Integer> map;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		arr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		left=0;
		map=new HashMap<Integer, Integer>();
		answer=0;
		
		getAnswer();
		
		System.out.println(answer);
		
	}
	
	static void getAnswer() {
		for(int right=0;right<n;right++) {
			map.put(arr[right], map.getOrDefault(arr[right],0)+1);
			
			while(map.size()>2) {
				map.put(arr[left], map.get(arr[left])-1);
				
				if(map.get(arr[left])==0) {
					map.remove(arr[left]);
				}
				
				left++;
			}
			
			answer=Math.max(answer, right-left+1);
		}
	}

}
