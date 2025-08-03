import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//1. 맵 입력받으면서 시작점, 끝점 좌표를 저장해놓고 .을 @로 바꾸기
//2. 다익스트라로 시작-끝 까지 .을 모두 번호로 바꾼다
//3. 끝에서 시작해서 하나씩 줄어드는 것만 .으로 바꾼다
public class g4_24463 {
    static int N,M,sx,sy,ex,ey,max;
    static char[][] map;
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

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new  StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new char[N][M];
        sx=sy=ex=ey=-1;
        for(int i=0;i<N;i++){
            String line=br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=line.charAt(j);
                if(map[i][j]=='.'&&(i==0||j==0||i==N-1||j==M-1)){
                    if(sx==-1){
                        sx=i;
                        sy=j;
                    }else{
                        ex=i;
                        ey=j;
                    }
                }
                if(map[i][j]=='.'){
                    map[i][j]='@';
                }
            }
        }

        dijkstra();

        dot();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(map[i][j]);;
            }
            System.out.println();
        }

    }

    static void dijkstra(){
        cost=new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE-1);
        }
        cost[sx][sy]=1;
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)-> {
            return Integer.compare(a.c, b.c);
        });
        pq.offer(new Node(sx,sy,1));

        while(!pq.isEmpty()){
            Node node=pq.poll();
            int x=node.x;
            int y=node.y;
            int c=node.c;
            if(x==ex&&y==ey){
                max=cost[x][y];
                break;
            }

            for(int i=0;i<4;i++){
                int nx=node.x+dx[i];
                int ny=node.y+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M||map[nx][ny]=='+'){
                    continue;
                }

                if(c+1<cost[nx][ny]){
                    cost[nx][ny]=c+1;
                    pq.offer(new Node(nx,ny,c+1));
                }
            }
        }

//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(cost[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    static void dot(){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{ex,ey,max});
        map[ex][ey]='.';

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            int c=curr[2];

            for(int i=0;i<4;i++){
                int nx=curr[0]+dx[i];
                int ny=curr[1]+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M||cost[nx][ny]==Integer.MAX_VALUE-1){
                    continue;
                }

                if(cost[nx][ny]==c-1){
                    q.offer(new int[]{nx,ny,c-1});
                    map[nx][ny]='.';
                }
            }
        }

//                for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
