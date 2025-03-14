import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g5_12865_2 {
    static int n,k_max;
    static int[] w,v;
    static int ma;
    static boolean[] visited;
    static int[] temp;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        k_max=Integer.parseInt(st.nextToken());

        w=new int[n];
        v=new int[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            w[i]=Integer.parseInt(st.nextToken());
            v[i]=Integer.parseInt(st.nextToken());
        }

        visited=new boolean[n];
        ma=0;
        temp=new int[n];
        dfs(0);
        System.out.println(ma);
    }

    static void dfs(int idx){
        if(idx==n){
            System.out.println(Arrays.toString(temp));
            int t=0;
            for(int i=0;i<n;i++){
                t+=w[i];
                if(t<=k_max){
                    ma=Math.max(ma,ma+v[i]);
                }
            }
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                temp[idx]=i;
                dfs(idx+1);
                visited[i]=false;
            }
        }
    }
}
