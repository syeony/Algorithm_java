import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_1074 {
    static int n,r,c,N;
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        N=(int)Math.pow(2,n);
        answer=0;
        dfs(0,0,N);
        System.out.println(answer);
    }

    static void dfs(int row, int col, int size){
        if(size==1) return;

        int newsize=size/2;
        if(r<row+newsize && c<col+newsize){
            dfs(row,col,newsize);
        }else if(r<row+newsize && c>=col+newsize){
            answer+=((size*size)/4);
            dfs(row,col+newsize,newsize);
        }else if(r>=row+newsize && c<col+newsize){
            answer+=((size*size)/4*2);
            dfs(row+newsize,col,newsize);
        }else if(r>=row+newsize && c>=col+newsize){
            answer+=((size*size)/4*3);
            dfs(row+newsize,col+newsize,newsize);
        }
    }
}
