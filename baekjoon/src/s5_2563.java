import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] v=new int[101][101];
        for(int t=0;t<n;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            for(int i=y;i<y+10;i++){
                for(int j=x;j<x+10;j++){
                    v[i][j]=1;
                }
            }
        }
        int answer=0;
        for(int i=0;i<101;i++){
            for(int j=0;j<101;j++){
                if(v[i][j]==1){
                    answer+=1;
                }
            }
        }
        System.out.println(answer);
    }
}
