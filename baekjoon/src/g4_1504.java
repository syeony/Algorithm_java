import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class g4_1504 {

    static class Node implements Comparable<Node>{
        int index, cost;

        Node(int index, int cost){
            this.index=index;
            this.cost=cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost; //비용 오름차순 정렬
        }
    }

    static int n,e,v1,v2;
    static ArrayList<Node>[] arr;
    static int INF = Integer.MAX_VALUE;
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());

        arr=new ArrayList[n+1];
        for(int i=1;i<n+1;i++) {
            arr[i]=new ArrayList<Node>();
        }

        for(int i=0;i<e;i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            arr[b].add(new Node(a,c));
        }

        st=new StringTokenizer(br.readLine());
        v1=Integer.parseInt(st.nextToken());
        v2=Integer.parseInt(st.nextToken());

        long[] fromStart = dijkstra(1);
        long[] fromV1 = dijkstra(v1);
        long[] fromV2 = dijkstra(v2);

        long path1 = INF;
        long path2 = INF;

        if (fromStart[v1] != INF && fromV1[v2] != INF && fromV2[n] != INF) {
            path1 = fromStart[v1] + fromV1[v2] + fromV2[n];
        }

        if (fromStart[v2] != INF && fromV2[v1] != INF && fromV1[n] != INF) {
            path2 = fromStart[v2] + fromV2[v1] + fromV1[n];
        }

        answer=Math.min(path1,path2);

        if(answer==INF){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }


    }

    static long[] dijkstra(int start) {
        long[] dist = new long[n+1];
        Arrays.fill(dist,INF);
        dist[start]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node now=pq.poll();
            int now_index=now.index;
            int now_cost=now.cost;

            for(Node next:arr[now_index]){
                long new_cost=now_cost+next.cost;
                if(new_cost<dist[next.index]){
                    dist[next.index]=new_cost;
                    pq.offer(new Node(next.index,(int)new_cost));
                }
            }
        }

        return dist;
    }

}
