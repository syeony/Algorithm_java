import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class d4_1249 {
    static int n;
    static int[][] map;
    static int[][] cost;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static class Node{
        int x;
        int y;
        int cost;
        public Node(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            n=Integer.parseInt(br.readLine());
            map=new int[n][n];
            for(int i=0;i<n;i++){
                String line=br.readLine();
                for(int j=0;j<n;j++){
                    map[i][j]=line.charAt(j)-'0';
                }
            }

            int answer=dijkstra();
            System.out.println("#"+t+" "+answer);
        }
    }

    static int dijkstra(){
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->
                Integer.compare(a.cost,b.cost));
        pq.offer(new Node(0,0,map[0][0]));
        cost=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE-1);
        }
        cost[0][0]=map[0][0];

        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int cx=cur.x;
            int cy=cur.y;
            int ccost=cur.cost;

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(isEdge(nx,ny)) continue;
                if(cost[nx][ny]>map[nx][ny]+ccost){
                    cost[nx][ny]=map[nx][ny]+ccost;
                    pq.offer(new Node(nx,ny,cost[nx][ny]));
                }
            }
        }
        return cost[n-1][n-1];
    }

    static boolean isEdge(int x,int y){
        return (x<0||y<0||x>=n||y>=n);
    }
}
