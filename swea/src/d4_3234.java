import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_3234 {
    static int[] arr, arr2;
    static boolean[] visited;
    static int n, count, left, right;

    public static void dfs(int depth) { // 여기선 모든 나올 수 있는 순서를 구해준다
        if(depth>=n) {
//			System.out.println(Arrays.toString(arr2));
            check(0,0,0);
        }

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                visited[i]=true;
                arr2[depth]=arr[i];
                dfs(depth+1);
                visited[i]=false;
            }
        }
    }

    public static void check(int depth, int left, int right) {
        if(left<right) {
            return;
        }

        if(depth>=n) {
            count+=1;
            return;
        }

        check(depth+1, left, right+arr2[depth]);
        check(depth+1, left+arr2[depth], right);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for(int i=1;i<=tc;i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];

            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                arr[j]=Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n];
            arr2 = new int[n];
            left=0;
            right=0;

            dfs(0);
            System.out.println("#"+i+" "+count);
            count=0;
        }
    }
}
