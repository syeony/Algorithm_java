
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//참고: 백준 2252번 
public class d6_1267 {
	static int v,e;
	static ArrayList<Integer>[] li;
	static int[] rank;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t=1;t<=10;t++) {
			st=new StringTokenizer(br.readLine());
			
			v=Integer.parseInt(st.nextToken());
			e=Integer.parseInt(st.nextToken());
			
			li=new ArrayList[v+1];
			for(int i=1;i<v+1;i++) {
				li[i]=new ArrayList<Integer>();
			}
			
			rank=new int[v+1];
			
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				li[a].add(b);
				rank[b]++;
			}
			
			sb=new StringBuilder();
			
			bfs();
			
			System.out.println("#"+t+" "+sb.toString());
		}
	}
	
	static void bfs() {
		Queue<Integer> q=new LinkedList<>();
		
		for(int i=1;i<v+1;i++) {
			if(rank[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int c=q.poll();
			sb.append(c+" ");
			
			for(int i:li[c]) {
				rank[i]--;
				if(rank[i]==0) {
					q.offer(i);
				}
			}
		}
	}
}
