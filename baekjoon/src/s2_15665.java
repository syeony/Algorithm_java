import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_15665 {
    static int arr[], answer[],m,n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        answer = new int[m];
        sb = new StringBuilder();

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth>=m){
            for(int a:answer){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before=0;
        for(int i=0;i<n;i++){
            int now=arr[i];
            if(before!=now){
                answer[depth]=arr[i];
                before=now;
                dfs(depth+1);
            }
        }
    }
}
