import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.PriorityQueue;

public class g4_1715 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
//        System.out.println(pq);
        int sum=0;
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            sum+=(a+b);
            pq.add(a+b);
        }
        System.out.println(sum);
    }
}
