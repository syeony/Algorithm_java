import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class cctv{
    int x,y,num;

    public cctv(int x, int y, int num) {
        this.x=x;
        this.y=y;
        this.num=num;
    }
}

public class g3_15683 {
    static int n,m;
    static int[][] arr;
    static ArrayList<cctv> cctvs;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n][m];
        cctvs=new ArrayList<>();
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]!=6 && arr[i][j]!=0) {
                    cctvs.add(new cctv(i,j,arr[i][j]));
                }
            }
        }

        answer=Integer.MAX_VALUE;
        dfs(0,arr);
        System.out.println(answer);

    }

    static void dfs(int idx, int[][] arr) {
        if(idx==cctvs.size()) {
            answer=Math.min(answer, zerocnt(arr));
            return;
        }

        cctv c=cctvs.get(idx);
        int x=c.x;
        int y=c.y;
        int num=c.num;
        int[][] temp;

        if(num==1) {
            temp=copyarr(arr);
            seeUp(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeDown(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeLeft(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeRight(x,y,temp);
            dfs(idx+1,temp);
        }else if(num==2) {
            temp=copyarr(arr);
            seeRight(x,y,temp);
            seeLeft(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeUp(x,y,temp);
            seeDown(x,y,temp);
            dfs(idx+1,temp);
        }else if(num==3) {
            temp=copyarr(arr);
            seeLeft(x,y,temp);
            seeUp(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeLeft(x,y,temp);
            seeDown(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeRight(x,y,temp);
            seeUp(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeRight(x,y,temp);
            seeDown(x,y,temp);
            dfs(idx+1,temp);
        }else if(num==4) {
            temp=copyarr(arr);
            seeRight(x,y,temp);
            seeDown(x,y,temp);
            seeUp(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeRight(x,y,temp);
            seeLeft(x,y,temp);
            seeUp(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeLeft(x,y,temp);
            seeDown(x,y,temp);
            seeUp(x,y,temp);
            dfs(idx+1,temp);

            temp=copyarr(arr);
            seeRight(x,y,temp);
            seeDown(x,y,temp);
            seeLeft(x,y,temp);
            dfs(idx+1,temp);
        }else if(num==5) {
            temp=copyarr(arr);
            seeRight(x,y,temp);
            seeDown(x,y,temp);
            seeLeft(x,y,temp);
            seeUp(x,y,temp);
            dfs(idx+1,temp);
        }
    }

    //-1이 감시한 곳이라고 치자
    static void seeUp(int x,int y, int[][] arr) {
        int idx=x-1;
        while(idx>=0){
            if(arr[idx][y]==6) return;
            if(arr[idx][y]==0) arr[idx][y]=-1;
            idx--;
        }
    }

    static void seeDown(int x,int y, int[][] arr) {
        int idx=x+1;
        while(idx<n){
            if(arr[idx][y]==6) return;
            if(arr[idx][y]==0) arr[idx][y]=-1;
            idx++;
        }
    }

    static void seeRight(int x,int y, int[][] arr) {
        int idx=y+1;
        while(idx<m){
            if(arr[x][idx]==6) return;
            if(arr[x][idx]==0) arr[x][idx]=-1;
            idx++;
        }
    }

    static void seeLeft(int x,int y, int[][] arr) {
        int idx=y-1;
        while(idx>=0){
            if(arr[x][idx]==6) return;
            if(arr[x][idx]==0) arr[x][idx]=-1;
            idx--;
        }
    }

    static int zerocnt(int[][] arr) {
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0) cnt++;
            }
        }
        return cnt;
    }

    static int[][] copyarr(int[][] arr) {
        int[][] temp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[i][j]=arr[i][j];
            }
        }
        return temp;
    }
}
