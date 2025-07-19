import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_22971 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]+=dp[j];
                    dp[i]%=998244353;
                }

            }
        }

        for(int i:dp){
            System.out.print(i+" ");
        }
    }
}
