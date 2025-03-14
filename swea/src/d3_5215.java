import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_5215 {
    static int n,l;
    static int[] tt,k;
    static boolean[] visited;
    static int ma;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            l=Integer.parseInt(st.nextToken());

            tt=new int[n];
            k=new int[n];
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                tt[i]=Integer.parseInt(st.nextToken());
                k[i]=Integer.parseInt(st.nextToken());
            }

            visited=new boolean[n];
            ma=0;
            dfs(0,0);
            System.out.println("#"+t+" "+ma);
        }
    }
    static void dfs(int score,int kal){
        if(kal>l) return;

        ma=Math.max(ma,score);

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(score+tt[i],kal+k[i]);
                visited[i]=false;
            }
        }
    }
}
