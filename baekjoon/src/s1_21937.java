import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s1_21937 {
    static boolean[] v;
    static ArrayList<Integer>[] list;
    static int depth=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        v=new boolean[n+1];

        list=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            list[b].add(a);
        }

        int target=Integer.parseInt(br.readLine());
        dfs(target);
        System.out.println(depth);

    }

    static void dfs(int t){
        v[t]=true;

        for(int i:list[t]){
            if(!v[i]){
                v[i]=true;
                depth+=1;
                dfs(i);
            }
        }
    }
}
