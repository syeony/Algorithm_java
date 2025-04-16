
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_12851 {
	static int a,b;
	static int answer=Integer.MAX_VALUE, count=0;
	static int[] d= {1,-1,2};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		
		dfs(a,b);
		
		System.out.println(answer);
		System.out.println(count);
	}
	
	static void dfs(int start, int goal) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		int[] move=new int[100001];
		
		while(!q.isEmpty()) {
			int now=q.poll();
			
			if(answer>=move[now] && now==b) {
				answer=move[now];
				count++;
			}
			
			for(int i=0;i<3;i++) {
				int next=now;
				
				if(i==2) {
					next*=2;
				}else {
					next+=d[i];
				}
				
				if(isBound(next)) continue;
				
				if(move[next]==0 || move[next]>=move[now]+1) {
					q.offer(next);
					move[next]=move[now]+1;
				}
			}
		}
	}
	
	static boolean isBound(int x) {
		return (x<0 || x>100000);
	}
}
