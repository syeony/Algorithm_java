import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g4_4485 {
    static int n;
    static int[][] map;
    static int[][] cost;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};

    static class Node{
        int x;
        int y;
        int c;

        public Node(int x,int y,int c){
            this.x=x;
            this.y=y;
            this.c=c;
        }
    }

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx=0;

        while(true){
            n=Integer.parseInt(br.readLine());
            if(n==0) break;
            map=new int[n][n];

            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("Problem "+(++idx)+": "+dijkstra());
        }
    }

    //다익스트라에는 visited안쓴다
    //cost[nx][ny]=map[nx][ny]+현재cost 외우기
    static int dijkstra(){
        PriorityQueue<Node> pq=new PriorityQueue<>(
                (a,b)-> Integer.compare(a.c,b.c));
        pq.offer(new Node(0,0,map[0][0]));
        cost=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE-1);
        }


        while(!pq.isEmpty()){
            Node N=pq.poll();
            int x=N.x;
            int y=N.y;
            int c=N.c;

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(isEdge(nx,ny)) continue;
                if(cost[nx][ny]>map[nx][ny]+c){
                    cost[nx][ny]=map[nx][ny]+c;
                    pq.offer(new Node(nx,ny,cost[nx][ny]));
                }
            }
        }

        return cost[n-1][n-1];
    }

    static boolean isEdge(int x,int y){
        return x<0||y<0||x>=n||y>=n;
    }
}
