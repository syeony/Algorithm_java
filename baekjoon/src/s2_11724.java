import java.io.*;
import java.util.*;

public class s2_11724 {
    private static ArrayList<Integer>[] list;
    private static boolean[] visited;
    private static int cnt=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        list=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            list[i]=new ArrayList<>();
        }

        visited=new boolean[n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1;i<n+1;i++){
            if(visited[i]==false){
                dfs(i);
                cnt+=1;
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int idx){
        visited[idx]=true;
        for(int i:list[idx]){
            if(visited[i]==false){
                dfs(i);
            }
        }

    }
}
