import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_11055 {
    static int n,arr[],answer[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        answer = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        answer[0]=1;
        update();
    }
    public static void update(){
        for(int i=1;i<n;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    max = Math.max(max,answer[j]);
                }
            }
            answer[i]=max+1;
        }
        Arrays.sort(answer);
        System.out.println(answer[n-1]);

    }
}
