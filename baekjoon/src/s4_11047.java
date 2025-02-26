import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4_11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int won=Integer.parseInt(st.nextToken());
        int count=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
//        System.out.println(Arrays.toString(arr));

        for(int i=n-1;i>=0;i--){
            if(arr[i]<=won){
                int temp_cnt=(won/arr[i]);
                count+=temp_cnt;
                won-=(arr[i]*temp_cnt);
//                System.out.println(arr[i]+" "+count+" "+won);
            }
        }
        System.out.println(count);
    }
}
