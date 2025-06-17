import java.io.*;
import java.util.*;

class 아이템줍기2 {
    static int start_x, start_y, end_x, end_y;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int answer;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        //*2하는이유는 겹치는 테두리 제거하기위해서
        start_x=characterX*2;
        start_y=characterY*2;
        end_x=itemX*2;
        end_y=itemY*2;

        answer = 0;
        map=new int[51*2][51*2];

        //1로채우고 내부 0으로 채워서 테두리만 1로.. 구하기
        for(int i=0;i<rectangle.length;i++){
            int sx=rectangle[i][0]*2;
            int sy=rectangle[i][1]*2;
            int ex=rectangle[i][2]*2;
            int ey=rectangle[i][3]*2;
            for(int x=sx;x<ex+1;x++){
                for(int y=sy;y<ey+1;y++){
                    map[x][y]=1;
                }
            }
        }

        for(int i=0;i<rectangle.length;i++){
            int sx=rectangle[i][0]*2;
            int sy=rectangle[i][1]*2;
            int ex=rectangle[i][2]*2;
            int ey=rectangle[i][3]*2;

            for(int x=sx+1;x<ex;x++){
                for(int y=sy+1;y<ey;y++){
                    map[x][y]=0;
                }
            }
        }

        // for(int i=0;i<11;i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }

        bfs();
        return answer;
    }

    static void bfs(){
        visited=new boolean[51*2][51*2];
        Queue<int[]> q=new LinkedList<>();
        visited[start_x][start_y]=true;
        q.offer(new int[]{start_x,start_y,0});

        while(!q.isEmpty()){
            int[] c=q.poll();

            if(c[0]==end_x && c[1]==end_y){
                answer=c[2]/2;
                return;
            }

            for(int i=0;i<4;i++){
                int nx=c[0]+dx[i];
                int ny=c[1]+dy[i];
                int dist=c[2];

                if(isEdge(nx,ny)||visited[nx][ny]||map[nx][ny]==0) continue;

                visited[nx][ny]=true;
                q.offer(new int[]{nx,ny,dist+1});

            }
        }
    }

    static boolean isEdge(int x,int y){
        return x<0||y<0||x>=51*2||y>=51*2;
    }
}