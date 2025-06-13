import java.io.*;
import java.util.*;

class 가장먼노드 {
    static List<Integer>[] list;
    static int[] dist;
    static boolean[] visited;
    static int node2;
    static int max;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        dist=new int[n+1];
        list=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            int a=edge[i][0];
            int b=edge[i][1];
            list[a].add(b);
            list[b].add(a);
        }

        visited=new boolean[n+1];
        bfs(1);

        // System.out.println(Arrays.toString(dist));
        for(int i=2;i<n+1;i++){
            if(dist[i]==max){
                answer++;
            }
        }
        return answer;
    }

    static void bfs(int node){
        Queue<Integer> q=new LinkedList<>();
        q.offer(node);
        visited[node]=true;

        while(!q.isEmpty()){
            int c=q.poll();
            for(int i:list[c]){
                if(!visited[i]){
                    visited[i]=true;
                    dist[i]=dist[c]+1;
                    max=Math.max(dist[i],max);
                    q.offer(i);
                }
            }

        }

    }

}