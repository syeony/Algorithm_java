import java.io.*;
import java.util.*;

public class 개구리의여행 {
    static int n;
    static char[][] map;
    static int q;
    static int x1,y1,x2,y2;
    static int[][][] cost;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static class flog{
        int x;
        int y;
        int power;
        int cost;
        public flog(int x,int y,int power,int cost){
            this.x=x;
            this.y=y;
            this.power=power;
            this.cost=cost;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        map=new char[n][n];
        for(int i=0;i<n;i++){
            String line=br.readLine();
            for(int j=0;j<n;j++){
                map[i][j]=line.charAt(j);
            }
        }
        q=Integer.parseInt(br.readLine());
        for(int i=0;i<q;i++){
            st=new StringTokenizer(br.readLine());
            //문제에서 1,1로 첫번째 인덱스를 세므로 1을 빼서 0,0으로 맞춰주기
            x1=Integer.parseInt(st.nextToken())-1;
            y1=Integer.parseInt(st.nextToken())-1;
            x2=Integer.parseInt(st.nextToken())-1;
            y2=Integer.parseInt(st.nextToken())-1;

            int answer=dijkstra(x1,y1,x2,y2);
            System.out.println(answer);
        }
    }

    static int dijkstra(int x1,int y1,int x2,int y2){
        cost=new int[n][n][6]; //점프력이 1~5
        for(int[][] a:cost){
            for(int[] b:a){
                Arrays.fill(b,Integer.MAX_VALUE-1);
            }
        }
        cost[x1][y1][1]=0;
        PriorityQueue<flog> pq=new PriorityQueue<>((a,b)->
                Integer.compare(a.cost,b.cost));
        pq.offer(new flog(x1,y1,1,0)); //초기상태:점프력은 1이고 time은 0

        while(!pq.isEmpty()){
            flog cur=pq.poll();
            int cx=cur.x;
            int cy=cur.y;
            int cp=cur.power;
            int cc=cur.cost;

            if(cx==x2 && cy==y2) return cc;

            for(int i=0;i<4;i++){
                if(!canJump(cx,cy,i,cp)) continue; //여기서 모든 안되는 경우 다 거름

                int nx=cx+dx[i]*cp;
                int ny=cy+dy[i]*cp;

                if(cost[nx][ny][cp]>cc+1){
                    cost[nx][ny][cp]=cc+1;
                    pq.offer(new flog(nx,ny,cp,cc+1));
                }
            }

            //점프력 증가시키기
            if(cp<5){
                int upcost = (cp+1)*(cp+1);
                if(cost[cx][cy][cp+1]>cc+upcost){
                    cost[cx][cy][cp+1]=cc+upcost;
                    pq.offer(new flog(cx,cy,cp+1,cc+upcost));
                }
            }

            //점프력 감소시키기
            for(int i=1;i<cp;i++){
                if(cost[cx][cy][i]>cc+1){
                    cost[cx][cy][i]=cc+1;
                    pq.offer(new flog(cx,cy,i,cc+1));
                }
            }
        }

        return -1;
    }

    static boolean canJump(int x,int y,int direct,int power){
        for(int i=1;i<=power;i++){
            int nx=x+dx[direct]*i;
            int ny=y+dy[direct]*i;

            if(isEdge(nx,ny)||map[nx][ny]=='#') return false; //범위를 벗어나거나 천적이 있으면 안됨
            if(i==power && map[nx][ny]=='S') return false; //점프하려는 지점에 미끄러운 돌이 있으면 안됨
        }
        return true;
    }

    static boolean isEdge(int x,int y){
        return (x<0||y<0||x>=n||y>=n);
    }
}