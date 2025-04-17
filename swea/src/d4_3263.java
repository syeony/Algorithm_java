import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d4_3263 {
    static int tc;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n];

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            int[] LIS=new int[n+1];
            int max=0;
            for(int i=0;i<n;i++){
                LIS[arr[i]]=LIS[arr[i]-1]+1;
                max=Math.max(max,LIS[arr[i]]);
            }

            System.out.println("#"+t+" "+(n-max));
        }
    }
}
