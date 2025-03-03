import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class g4_1707 {
    static ArrayList<Integer>[] list;
    static int v,e;
    static boolean colorcheck;
    static int[] colors;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            v=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());

            list=new ArrayList[v+1];
            for(int i=0;i<v+1;i++){
                list[i]=new ArrayList<>();
            }

            for(int i=0;i<e;i++){
                st=new StringTokenizer(br.readLine());
                int p=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());
                list[p].add(c);
                list[c].add(p);
            }
            colors=new int[v+1];
            colorcheck=true;

            for(int i=1;i<v+1;i++){
                if(!colorcheck){
                    break;
                }
                if(colors[i]==0){
                    dfs(i,1);
                }
            }
            System.out.println(colorcheck ? "YES":"NO");
        }
    }

    static void dfs(int v, int color){
        colors[v]=color;

        for(int i:list[v]){
            if(colors[i]==color){
                colorcheck=false;
                return;
            }
            if(colors[i]==0){
                dfs(i,-color);
            }
        }
    }
}
