import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class g4_12834 {
    static int n,v,e,a,b,answer;
    static int[] position, dist;
    static List<List<Node>> list;
    static boolean[] visited;

    static class Node{
        int to, dist;
        public Node(int to, int dist){
            this.to=to;
            this.dist=dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());

        position=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            position[i]=Integer.parseInt(st.nextToken());
        }

        list=new ArrayList<>();
        for(int i=0;i<e;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());

            list.get(from).add(new Node(to,dist));
            list.get(to).add(new Node(from,dist));
        }

        for(int p:position){
            dijkstra(p);

            if(dist[a]==Integer.MAX_VALUE-1) dist[a]=-1;
            if(dist[b]==Integer.MAX_VALUE-1) dist[b]=-1;

            answer+=(dist[a]+dist[b]);
        }

        System.out.println(answer);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->
        {
            return Integer.compare(a.dist,b.dist);
        });
        pq.offer(new Node(start,0));
        dist=new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE-1);
        dist[start]=0;
        visited=new boolean[v+1];
        visited[start]=true;

        while(!pq.isEmpty()){
            Node c=pq.poll();

            for(Node next:list.get(c.to)){
                if(!visited[next.to] && dist[next.to] > dist[c.to]+next.dist){
                    dist[next.to] = dist[c.to]+next.dist;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }

    }
}
