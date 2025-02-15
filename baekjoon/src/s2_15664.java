import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s2_15664 {
    static int arr[], answer[],m,n;
    static StringBuilder sb;
    static boolean visited[];

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
        visited = new boolean[n];
        sb = new StringBuilder();

        dfs(0,0);
        System.out.println(sb);
    }

    static void dfs(int depth, int start){
        if(depth>=m){
            for(int a:answer){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev=0;

        for(int i=start;i<n;i++){
            if(!visited[i] && arr[i]!=prev){
                visited[i]=true;
                answer[depth]=arr[i];
                prev=arr[i];
                dfs(depth+1,i);
                visited[i]=false;
            }
        }
    }
}
