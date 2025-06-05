// 비트연산자 or연산 사용(|)
// T:민트(001=1) C:초코(010=2) M:우유(100=4)
// CM:초코우유(110=6) TM:민트우유(101=5) TC:민트초코(011=3)
// TCM:민트초코우유(111=7)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 민트초코우유 {
    static int n,t;
    static class status{
        int x,y;
        int bit; //비트연산자
        int believe; //신앙심
        boolean delegate; //대표인가?
        boolean defense; //방어상태인가?

        public status(int x, int y, int bit, int believe, boolean delegate, boolean defense){
            this.x=x;
            this.y=y;
            this.bit=bit;
            this.believe=believe;
            this.delegate=delegate;
            this.defense=defense;
        }
    }
    static status[][] map;
    static boolean[][] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        map=new status[n][n];
        //초기화 필수
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = new status(i, j, 0, 0, false, false);
            }
        }

        for(int i=0;i<n;i++){
            String line=br.readLine();
            for(int j=0;j<n;j++){
                char c=line.charAt(j);
                if(c=='T') map[i][j].bit=1;
                else if(c=='C') map[i][j].bit=2;
                else map[i][j].bit=4;
            }
        }

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j].believe=Integer.parseInt(st.nextToken());
            }
        }

        for(int day=1;day<=t;day++){

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    map[i][j].delegate=false;
                    map[i][j].defense=false;
                }
            }
            visited=new boolean[n][n];

            lunch();
//        //체크
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(map[i][j].delegate+" ");
//            }
//            System.out.println();
//        }
//        //체크
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(map[i][j].believe+" ");
//            }
//            System.out.println();
//        }
            evening();
            print();
        }

    }

    //대표자 정하기
    static void lunch(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    int what=map[i][j].bit;
                    bfs(i,j,what);
                }
            }
        }
    }

    static void bfs(int x,int y, int what){
        int cnt=0;
        PriorityQueue<status> pq=new PriorityQueue<>((a,b)->{
            if(a.believe==b.believe){
                //행, 열 순으로 작은것부터
                if(a.x==b.x) return Integer.compare(a.y, b.y);
                else return Integer.compare(a.x, b.x);
            }else{
                //신앙심 큰순으로 정렬
                return Integer.compare(b.believe, a.believe);
            }
        });
        Queue<status> q=new LinkedList<>();
        boolean[][] visited2=new boolean[n][n];

        visited[x][y]=true;
        visited2[x][y]=true;
        cnt++;
        pq.offer(map[x][y]);
        q.offer(map[x][y]);

        while(!q.isEmpty()){
            status cur=q.poll();

            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];

                if(isEdge(nx,ny)||visited2[nx][ny]||map[nx][ny].bit!=what) continue;

                visited[nx][ny]=true;
                visited2[nx][ny]=true;
                cnt++;
                pq.offer(map[nx][ny]);
                q.offer(map[nx][ny]);
            }
        }

        status del=pq.poll();
        map[del.x][del.y].delegate=true;
        map[del.x][del.y].believe+=cnt;
    }

    //전파
    static void evening() {
        PriorityQueue<status> pq1 = new PriorityQueue<>((a,b)->{
            if(a.believe==b.believe){
                if(a.x==b.x) return Integer.compare(a.y, b.y);
                else return Integer.compare(a.x, b.x);
            }else{
                return Integer.compare(b.believe, a.believe);
            }
        });
        PriorityQueue<status> pq2 = new PriorityQueue<>(pq1.comparator());
        PriorityQueue<status> pq3 = new PriorityQueue<>(pq1.comparator());

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j].delegate){
                    int bit = map[i][j].bit;
                    if(bit==1||bit==2||bit==4) pq1.offer(map[i][j]);
                    else if(bit==3||bit==5||bit==6) pq2.offer(map[i][j]);
                    else if(bit==7) pq3.offer(map[i][j]);
                }
            }
        }
        spread(pq1);
        spread(pq2);
        spread(pq3);
    }

    static void spread(PriorityQueue<status> pq2){
        while(!pq2.isEmpty()){
            status c=pq2.poll();
            if(map[c.x][c.y].defense) continue;

            int mod=map[c.x][c.y].believe%4;
            int b=map[c.x][c.y].believe-1;
            map[c.x][c.y].believe=1;

            if(mod==0){ //위
                up(c,b);
            }else if(mod==1){ //아래
                down(c,b);
            }else if(mod==2){ //왼
                left(c,b);
            }else if(mod==3){ //오
                right(c,b);
            }
        }
    }

    static void up(status c,int b){
        int nx=c.x;

        while(true){
            nx-=1;
            if(isEdge(nx,c.y) || b<=0) break;
            if(map[nx][c.y].bit == map[c.x][c.y].bit) continue;
            //강한전파, 약한전파
            if(b>map[nx][c.y].believe){
                map[nx][c.y].bit=map[c.x][c.y].bit;
                b-=(map[nx][c.y].believe+1);
                map[nx][c.y].believe++;
            }else{
                map[nx][c.y].bit=map[nx][c.y].bit | map[c.x][c.y].bit;
                map[nx][c.y].believe+=b;
                b=0;
            }
            map[nx][c.y].defense=true;
        }
    }

    static void down(status c, int b){
        int nx=c.x;

        while(true){
            nx+=1;
            if(isEdge(nx,c.y) || b<=0) break;
            if(map[nx][c.y].bit == map[c.x][c.y].bit) continue;
            //강한전파, 약한전파
            if(b>map[nx][c.y].believe){
                map[nx][c.y].bit=map[c.x][c.y].bit;
                b-=(map[nx][c.y].believe+1);
                map[nx][c.y].believe++;
            }else{
                map[nx][c.y].bit=map[nx][c.y].bit | map[c.x][c.y].bit;
                map[nx][c.y].believe+=b;
                b=0;
            }
            map[nx][c.y].defense=true;
        }
    }

    static void right(status c, int b){
        int ny=c.y;

        while(true){
            ny+=1;
            if(isEdge(c.x,ny) || b<=0) break;
            if(map[c.x][ny].bit == map[c.x][c.y].bit) continue;
            //강한전파, 약한전파
            if(b>map[c.x][ny].believe){
                map[c.x][ny].bit=map[c.x][c.y].bit;
                b-=(map[c.x][ny].believe+1);
                map[c.x][ny].believe++;
            }else{
                map[c.x][ny].bit=map[c.x][c.y].bit | map[c.x][ny].bit;
                map[c.x][ny].believe+=b;
                b=0;
            }
            map[c.x][ny].defense=true;
        }
    }

    static void left(status c, int b){
        int ny=c.y;

        while(true){
            ny-=1;
            if(isEdge(c.x,ny) || b<=0) break;
            if(map[c.x][ny].bit == map[c.x][c.y].bit) continue;
            //강한전파, 약한전파
            if(b>map[c.x][ny].believe){
                map[c.x][ny].bit=map[c.x][c.y].bit;
                b-=(map[c.x][ny].believe+1);
                map[c.x][ny].believe++;
            }else{
                map[c.x][ny].bit=map[c.x][c.y].bit | map[c.x][ny].bit;
                map[c.x][ny].believe+=b;
                b=0;
            }
            map[c.x][ny].defense=true;
        }
    }

    static void print(){
        int tcm=0;
        int tc=0;
        int tm=0;
        int cm=0;
        int m=0;
        int c=0;
        int t=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int bit = map[i][j].bit;
                if(bit == 7) tcm+=map[i][j].believe;      // 111b = 7 : TCM
                else if(bit == 3) tc+=map[i][j].believe;  // 011b = 3 : TC
                else if(bit == 5) tm+=map[i][j].believe;  // 101b = 5 : TM
                else if(bit == 6) cm+=map[i][j].believe;  // 110b = 6 : CM
                else if(bit == 4) m+=map[i][j].believe;   // 100b = 4 : M
                else if(bit == 2) c+=map[i][j].believe;   // 010b = 2 : C
                else if(bit == 1) t+=map[i][j].believe;   // 001b = 1 : T
            }
        }

        System.out.println(tcm+" "+tc+" "+tm+" "+cm+" "+m+" "+c+" "+t);
    }

    static boolean isEdge(int x, int y){
        return (x<0||y<0||x>=n||y>=n);
    }
}
