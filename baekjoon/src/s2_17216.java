import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_17216 {
    static int n, arr[], dp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dp=new int[n];

        update();
    }
    public static void update(){
        for(int i=0;i<n;i++){
            dp[i] = arr[i];
            for(int j=0;j<i;j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                }
            }
//            System.out.print(dp[i]+" ");
        }
//        System.out.println();
        Arrays.sort(dp);
        System.out.println(dp[n-1]);

    }
}
