import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_12865 {
    static int n,k_max;
    static int[] w,v;
    static int ma;
    static boolean[] visited;

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
        ma=Integer.MIN_VALUE;
        dfs(0,0);
        System.out.println(ma);
    }

    static void dfs(int weight, int value){
//        if(weight>0 && weight<=k_max){
//            ma=Math.max(ma,value);
//            return;
//        }

        if (weight > k_max) {
            return; // 무게 초과 시 종료
        }

        ma = Math.max(ma, value); // 최대 가치 갱신

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(weight+w[i],value+v[i]);
                visited[i]=false;
            }
        }
    }
}