import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class g4_1753 {
    static int v,e, start;
    static ArrayList<int[]>[] li;
    static int mi=0;
    static int[] dist;
    static int[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());

        start=Integer.parseInt(br.readLine());

        li=new ArrayList[v+1];
        for(int i=1;i<v+1;i++) {
            li[i]=new ArrayList<>();
        }

        for(int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            li[a].add(new int[] {b,p});
        }

        for(int i=1;i<v+1;i++){
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }

    }

    static void bfs(int start, int price, int end) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[] {start,price});

        dist=new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;

        while(!pq.isEmpty()) {
            int[] temp=pq.poll();
            int t=temp[0];
            int p=temp[1];

            if(p>dist[t]) continue;

            for(int[] i:li[t]) {
                int nextt=i[0];
                int nextp=i[1];

                if(dist[nextt]>p+nextp) {
                    dist[nextt]=p+nextp;
                    pq.offer(new int[] {nextt,dist[nextt]});
                }

            }
        }

    }
}
