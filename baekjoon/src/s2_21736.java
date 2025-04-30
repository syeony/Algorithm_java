import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_21736 {
	static int n,m;
	static char[][] map;
	static int Ix,Iy;
	static boolean[][] visited;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static int answer;

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new char[n][m];
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=line.charAt(j);
				if(map[i][j]=='I') {
					Ix=i;
					Iy=j;
				}
			}
		}
		answer=0;
		visited=new boolean[n][m];
		bfs(Ix,Iy);
		
		if(answer==0) {
			System.out.println("TT");
		}else {
			System.out.println(answer);
		}
	}
	
	static void bfs(int x,int y) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {x,y});
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			int[] cur=q.poll();
			int cx=cur[0];
			int cy=cur[1];
			
			for(int i=0;i<4;i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				
				if(isEdge(nx,ny)||visited[nx][ny]||map[nx][ny]=='X') continue;
				
				visited[nx][ny]=true;
				q.offer(new int[] {nx,ny});

				if(map[nx][ny]=='P') {
					answer++;
				}
			}
		}
	}
	
	static boolean isEdge(int x,int y) {
		return (x<0||y<0||x>=n||y>=m);
	}
}
