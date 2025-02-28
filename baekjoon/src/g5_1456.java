import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g5_1456 {
    static boolean[] notsosu;

    static void getSosu(){
        notsosu[0]=true;
        notsosu[1]=true;

        for(int i=2;i*i<1000001;i++){
            if(notsosu[i]==true) continue;
            for(int j=i*i;j<1000001;j+=i){
                notsosu[j]=true;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long start=Long.parseLong(st.nextToken());
        long end=Long.parseLong(st.nextToken());
        notsosu=new boolean[1000001];
        getSosu();
        int count=0;

        for(int i=2;i<=1000000;i++){
            if(!notsosu[i]){
                long temp=i;

                while(temp<=end/i){
                    temp*=i;
                    if(temp>=start){
                        count++;
                    }
                }

            }
        }

        System.out.println(count);
    }
}
