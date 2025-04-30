
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class g4_14499 {
	static int n,m,x,y,k;
	static int[][] map;
	static int[] command;

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		map=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		command=new int[k];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<k;i++) {
			command[i]=Integer.parseInt(st.nextToken());
		}
		bfs(x,y);
	}
	
	static void bfs(int x, int y) {
	    int[] dice = {0,0,0,0,0,0}; 
	    int nx = 0;
	    int ny = 0;

	    //맵 움직이는 코드
	    for (int i = 0; i < k; i++) {
	        if (command[i] == 1) { // 동쪽
	            nx = x;
	            ny = y + 1;
	        } else if (command[i] == 2) { // 서쪽
	            nx = x;
	            ny = y - 1;
	        } else if (command[i] == 3) { // 북쪽
	            nx = x - 1;
	            ny = y;
	        } else if (command[i] == 4) { // 남쪽
	            nx = x + 1;
	            ny = y;
	        }

	        if (isEdge(nx, ny)) continue; 

	        // 주사위 회전 코드 
	        int[] newDice = new int[6];
	        if (command[i] == 1) { // 동쪽
	            newDice[0] = dice[3];
	            newDice[1] = dice[1];
	            newDice[2] = dice[0];
	            newDice[3] = dice[5];
	            newDice[4] = dice[4];
	            newDice[5] = dice[2];
	        } else if (command[i] == 2) { // 서쪽
	            newDice[0] = dice[2];
	            newDice[1] = dice[1];
	            newDice[2] = dice[5];
	            newDice[3] = dice[0];
	            newDice[4] = dice[4];
	            newDice[5] = dice[3];
	        } else if (command[i] == 3) { // 북쪽
	            newDice[0] = dice[4];
	            newDice[1] = dice[0];
	            newDice[2] = dice[2];
	            newDice[3] = dice[3];
	            newDice[4] = dice[5];
	            newDice[5] = dice[1];
	        } else if (command[i] == 4) { // 남쪽
	            newDice[0] = dice[1];
	            newDice[1] = dice[5];
	            newDice[2] = dice[2];
	            newDice[3] = dice[3];
	            newDice[4] = dice[0];
	            newDice[5] = dice[4];
	        }

	        dice = newDice; // 회전된 주사위로 교체
	        x = nx;
	        y = ny;

	        if(map[x][y]==0) {
	        	map[x][y]=dice[5];
	        	System.out.println(dice[0]);
	        }else {
	        	dice[5]=map[x][y];
	        	map[x][y] = 0;
	        	System.out.println(dice[0]);
	        }
	    }
	}

	
	static boolean isEdge(int x,int y) {
		return (x<0||y<0||x>=n||y>=m);
	}
}
