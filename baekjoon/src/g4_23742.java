import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class g4_23742 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] p=new long[n];
        long sum=0;
        long plus_cnt=0;

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            p[i]=Integer.parseInt(st.nextToken());

            if(p[i]>=0){
                plus_cnt++;
            }
        }

        Arrays.sort(p);
//        System.out.println(Arrays.toString(p));
        for(int i=0;i<n;i++){
            if(p[i]<0){
                sum+=p[i];
            }else{
                sum+=(plus_cnt*p[i]);
            }
        }

        System.out.println(sum);

    }
}
