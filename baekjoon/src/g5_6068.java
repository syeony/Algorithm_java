import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class g5_6068 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2)->{
            return o2[1]-o1[1];
        });

        int max=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][1]<max){
                max=arr[i][1];
            }
            max-=arr[i][0];
            if(max<0) break;
        }

        if(max<0){
            System.out.println(-1);
        }else{
            System.out.println(max);
        }
    }
}
