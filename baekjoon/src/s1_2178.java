import java.util.*;

public class s1_2178 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int m;
    static int[][] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for(int i=0;i<n;i++){
            String[] s = sc.next().split("");
            for(int j = 0; j<m;j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        //System.out.println(Arrays.deepToString(arr));

        System.out.println(bfs(0,0));

    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while (!q.isEmpty()){
            int[] current = q.poll();
            x=current[0];
            y=current[1];

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m){
                    continue;
                }
                if(arr[nx][ny]==0){
                    continue;
                }
                if(arr[nx][ny]==1){
                    arr[nx][ny] = arr[x][y]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        return arr[n-1][m-1];
    }
}