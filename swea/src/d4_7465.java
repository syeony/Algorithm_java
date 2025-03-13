
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class d4_7465 {
	static int n,m;
	static ArrayList<Integer>[] li;
	static boolean[] v;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			
			li=new ArrayList[n+1];
			for(int i=1;i<n+1;i++) {
				li[i]=new ArrayList<Integer>();
			}
			
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				li[a].add(b);
				li[b].add(a);
			}
			
			int answer=0;
			v=new boolean[n+1];
			for(int i=1;i<n+1;i++) {
				if(!v[i]) {
					bfs(i);
					answer+=1;
				}
			}
			
			System.out.println("#"+t+" "+answer);
		}
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		v[start]=true;
		
		while(!q.isEmpty()) {
			int c=q.poll();
			
			for(int i:li[c]) {
				if(!v[i]) {
					v[i]=true;
					q.offer(i);
				}
			}
		}
	}
}
