import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class s2_1260 {
    private static ArrayList<Integer>[] list;
    private static int v;
    private static boolean[] visited_dfs;
    private static boolean[] visited_bfs;
    private static ArrayList<Integer> dfs_answer;
    private static ArrayList<Integer> bfs_answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int V=Integer.parseInt(st.nextToken());
        v=V;

        list=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            list[i]=new ArrayList<>();
        }
        visited_dfs=new boolean[n+1];
        visited_bfs=new boolean[n+1];
        dfs_answer=new ArrayList<>();
        bfs_answer=new ArrayList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1;i<n+1;i++){
            list[i].sort(null); //sort()함수엔 무조건 null을 넣어야함. 그럼 오름차순 기본.
            //만약 내림차순 하고싶으면 list.sort(Comparator.reverseOrder());
        }

        dfs(v);
        for(int i:dfs_answer){
            System.out.print(i+" ");
        }

        System.out.println();

        bfs(v);
        for(int i:bfs_answer){
            System.out.print(i+" ");
        }

    }

    public static void dfs(int idx){
        visited_dfs[idx]=true;
        dfs_answer.add(idx);

        for(int i:list[idx]){
            if(!visited_dfs[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>(); // ArrayList<Integer> q = new ArrayList<>();
        //큐가 어레이리스트보다 시간복잡도 적음

        visited_bfs[idx]=true;
        q.add(idx);
        bfs_answer.add(idx);

        while(!q.isEmpty()){
            int a = q.poll(); //첫 값 꺼내기

            for(int i:list[a]){
                if(!visited_bfs[i]){
                    q.add(i);
                    bfs_answer.add(i);
                    visited_bfs[i]=true;
                }
            }
        }
    }
}
