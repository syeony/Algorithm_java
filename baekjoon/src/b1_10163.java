import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1_10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] arr=new int[1001][1001];
        int num=1;
        for(int t=0;t<n;t++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int xx=Integer.parseInt(st.nextToken());
            int yy=Integer.parseInt(st.nextToken());
            for(int i=x;i<Math.min(1001,x+xx);i++){
                for(int j=y;j<Math.min(1001,y+yy);j++){
                    arr[i][j]=num;
                }
            }
            num+=1;
        }
        for(int t=1;t<=n;t++){
            int answer=0;
            for(int i=0;i<101;i++){
                for(int j=0;j<101;j++){
                    if(arr[i][j]==t){
                        answer+=1;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
