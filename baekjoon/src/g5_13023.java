import java.io.*;
import java.util.*;

public class g5_13023 {
    private static ArrayList<Integer>[] list;
    private static int answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        visited=new boolean[n];

        list= new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0;i<n;i++){
            if(answer==1){
                break;
            }
            dfs(i,0);
        }

        System.out.println(answer);
    }

    public static void dfs(int idx,int cnt){
        if(cnt>=4){ //친구연결관계가 4인것까지만 보면 됨
            answer=1;
            return;
        }

        visited[idx]=true;
        for(int i:list[idx]){
            if(visited[i]==false){
                dfs(i,cnt+1);
            }
        }
        visited[idx]=false;
    }
}
