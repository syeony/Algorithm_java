import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class g2_19238 {
    static int n,m,f;
    static int[][] map,map2;
    static int tx,ty;
    static boolean[][] v;
    static ArrayList<customer> c;
    static ArrayList<Integer> c_dist;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};

    static class customer{
        int sx,sy,ex,ey;

        public customer(int sx,int sy,int ex,int ey){
            this.sx=sx;
            this.sy=sy;
            this.ex=ex;
            this.ey=ey;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        f=Integer.parseInt(st.nextToken());

        map=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        tx=Integer.parseInt(st.nextToken());
        ty=Integer.parseInt(st.nextToken());

        c=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            c.add(new customer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        c_dist=new ArrayList<>();

        while(c.size()>0){
            int minIdx=minDistanceIndex();
            f-=c_dist.get(minIdx);
            if(f<=0)break;
            f+=bfs(c.get(minIdx).sx,c.get(minIdx).sy,c.get(minIdx).ex,c.get(minIdx).ey);
            if(f<=0)break;
            tx=c.get(minIdx).sx;
            ty=c.get(minIdx).sy;
            c.remove(minIdx);
        }

        if(f>=0){
            System.out.println(f);
        }else{
            System.out.println(-1);
        }

    }

    static int minDistanceIndex(){
        int idx=0;
        c_dist.clear();

        for(int i=0;i<c.size();i++){
            v=new boolean[n+1][n+1];
            c_dist.add(bfs(c.get(i).sx,c.get(i).sy,tx,ty));
        }

        if(c.size()>1){
            for(int i=1;i<c.size();i++){
                if(c_dist.get(i-1)>c_dist.get(i)){
                    idx=i;
                }else if(c_dist.get(i-1)==c_dist.get(i)){
                    if(c.get(c_dist.get(i-1)).sx<c.get(c_dist.get(i)).sx){
                        idx=i-1;
                    }else if(c.get(c_dist.get(i-1)).sx>c.get(c_dist.get(i)).sx){
                        idx=i;
                    }else{
                        if(c.get(c_dist.get(i-1)).sy<c.get(c_dist.get(i)).sy){
                            idx=i-1;
                        }else{
                            idx=i;
                        }
                    }
                }
            }
        }else if(c.size()==1){
            idx=0;
        }

        return idx;
    }

    // 승객과 택시의 최단거리
    static int bfs(int x,int y,int tex,int tey){
        int[][] m=getmap2();
        v[x][y]=true;
        int d=0;

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{x,y});

        while(!q.isEmpty()){
            int[] temp=q.poll();
            int nowx=temp[0];
            int nowy=temp[1];

            if(nowx==tex && nowy==tey){
                break;
            }

            for(int i=0;i<4;i++){
                int nx=nowx+dx[i];
                int ny=nowy+dy[i];

                if(isedge(nx,ny) || m[nx][ny]==1 || v[nx][ny]) continue;

                q.offer(new int[]{nx,ny});
                d++;
            }
        }
        return d;
    }

    static int[][] getmap2(){
        map2=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                map2[i][j]=map[i][j];
            }
        }
        return map2;
    }

    static boolean isedge(int x,int y){
        return (x<=0 || y<=0 || x>n || y>n);
    }

}
