import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int ma=Integer.MIN_VALUE;
        for(int i=0;i<n-k+1;i++){
            int temp=0;
            for(int j=0;j<k;j++){
                temp+=arr[i+j];
            }
//            System.out.print(temp+" ");
            ma=Math.max(ma,temp);
        }
        System.out.println(ma);
    }
}
