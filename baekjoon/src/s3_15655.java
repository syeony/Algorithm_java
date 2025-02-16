import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s3_15655 {
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

    static void dfs(int depth, int start){ //start가 있는 이유는 출력되는 한 줄의 수열이 오름차순 !
        if(depth>=m){
            for(int a:answer){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                answer[depth]=arr[i];
                dfs(depth+1,i);
                visited[i]=false;
            }
        }
    }
}
