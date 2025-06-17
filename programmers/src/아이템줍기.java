import java.io.*;
import java.util.*;

class 아이템줍기 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int answer;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = 0;
        map=new int[51][51];
        //1로채우기
        for(int i=0;i<rectangle.length;i++){
            int sx=rectangle[i][0];
            int sy=rectangle[i][1];
            int ex=rectangle[i][2];
            int ey=rectangle[i][3];
            for(int x=sx;x<ex+1;x++){
                for(int y=sy;y<ey+1;y++){
                    map[x][y]=1;
                }
            }
            for(int x=sx+1;x<ex;x++){
                for(int y=sy+1;y<ey;y++){
                    map[x][y]=0;
                }
            }
        }

        // for(int i=0;i<11;i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }

        bfs(characterX,characterY,itemX,itemY);
        return answer;
    }

    static void bfs(int characterX, int characterY, int itemX, int itemY){
        visited=new boolean[51][51];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{characterX,characterY,0});
        visited[characterX][characterY]=true;

        while(!q.isEmpty()){
            int[] c=q.poll();

            if(c[0]==itemX && c[1]==itemY){
                answer=c[2];
                return;
            }

            for(int i=0;i<4;i++){
                int nx=c[0]+dx[i];
                int ny=c[1]+dy[i];
                int dist=c[2];

                if(isEdge(nx,ny)||visited[nx][ny]||map[nx][ny]==0) continue;

                q.offer(new int[]{nx,ny,dist+1});
            }
        }
    }

    static boolean isEdge(int x,int y){
        return x<0||y<0||x>=51||y>=51;
    }
}