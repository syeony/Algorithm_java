import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class a_5656 {
    static int tc;
    static int n,w,h;
    static int[][] map;
    static List<Integer> perm;
    static int[] width;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());

            map=new int[h][w];
            for(int i=0;i<h;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            width=new int[w];
            for(int i=0;i<w;i++){
                width[i]=i;
            }

            perm=new LinkedList<>();
            answer=Integer.MAX_VALUE;
            getPerm(0);
            System.out.println("#"+t+" "+answer);
        }
    }

    static void getPerm(int depth){
        if(depth==n){
//            System.out.println(perm);
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<perm.size();i++){
                list.add(perm.get(i));
            }
            int[][] map2=copyMap();

            while(list.size()>0){
                bfs(list,map2);
            }

            int cnt=countMap(map2);
            answer=Math.min(answer,cnt);
            return;
        }

        for(int i=0;i<w;i++){
            //중복순열(배열로 할 수도 있지만 후처리를 위해 리스트로 선택)
            perm.add(width[i]);
            getPerm(depth+1);
            perm.remove(perm.size()-1);
        }
    }

    static int[][] copyMap(){
        int[][] map2=new int[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                map2[i][j]=map[i][j];
            }
        }
        return map2;
    }

    static int countMap(int[][] map2){
        int cnt=0;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if(map2[i][j]>0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(List<Integer> list, int[][] map2) {
        int y = list.remove(0);
        int[] t = getTop(y, map2);
        int x = t[0];
        int z = t[2];
        if (x == -1) return;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, z});
        boolean[][] visited = new boolean[h][w];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cz = cur[2];
            visited[cx][cy] = true;

            for (int d = 0; d < 4; d++) {
                for (int i = 1; i < cz; i++) {
                    int nx = cx + dx[d] * i;
                    int ny = cy + dy[d] * i;
                    if (isEdge(nx, ny)) break;
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, map2[nx][ny]});
                    }
                }
            }
        }

        updateMap(visited, map2);
    }


    //visited처리된 블록을 없애고 남은 블록을 밑으로 내리는 함수
    static void updateMap(boolean[][] visited,int[][] map2){
        //i,j반대로 적어서 답이 계속 잘못나왔었음...너무 헷갈림
        for(int i=0;i<w;i++){
            Queue<Integer> queue=new LinkedList<>();

            for(int j=0;j<h;j++){
                if(visited[j][i]){
                    map2[j][i]=0;
                }
            }

            for(int j=h-1;j>=0;j--){
                if(map2[j][i]!=0){
                    queue.offer(map2[j][i]);
                }
            }

            for(int j=h-1;j>=0;j--){
                if(!queue.isEmpty()){
                    map2[j][i]=queue.poll();
                }else {
                    map2[j][i] = 0; // 이 부분도 빠져 있음 (안 하면 잔상이 남음)
                }
            }
        }
    }

    static boolean isEdge(int x,int y){
        return (x<0||y<0||x>=h||y>=w);
    }

    //제일 위쪽 x,y위치 구하는 함수
    static int[] getTop(int y, int[][] map2) {
        int[] temp = new int[3];
        for (int i = 0; i < h; i++) {
            if (map2[i][y] != 0) {
                temp[0] = i;
                temp[1] = y;
                temp[2] = map2[i][y];
                return temp;
            }
        }
        return new int[]{-1, -1, -1}; // 터질 벽돌이 없을 경우 처리
    }

}
