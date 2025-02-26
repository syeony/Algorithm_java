import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class g4_1744 {
    static PriorityQueue<Integer> plus, minus;

    static int getSum(PriorityQueue<Integer> pq){
        Queue<Integer> q = new LinkedList<>();
        int res=0;

        while(!pq.isEmpty()){
            int curr=pq.poll();

            if(pq.isEmpty()){
                q.add(curr);
            }else{
                int next=pq.poll();

                if(curr==1 || next==1){
                    q.add(curr);
                    q.add(next);
                }else{
                    q.add(curr*next);
                }
            }
        }

        while(!q.isEmpty()){
            res+=q.poll();
        }

        return res;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        plus=new PriorityQueue<>(Collections.reverseOrder());
        minus=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int temp=Integer.parseInt(br.readLine());
            if(temp>0){
                plus.add(temp);
            }else{
                minus.add(temp);
            }
        }

        int result=getSum(plus)+getSum(minus);
        System.out.println(result);
    }
}
