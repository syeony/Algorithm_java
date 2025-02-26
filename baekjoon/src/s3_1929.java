import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_1929 {
    static boolean[] notsosu;

    static void getSosu(){
        notsosu[0]=true;
        notsosu[1]=true;
        for(int i=2;i<1000001;i++){
            if(i*i>1000000) break;
            if(notsosu[i]==true) continue;
            for(int j=i*i;j<1000001;j+=i){
                notsosu[j]=true;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        notsosu=new boolean[1000001];
        getSosu();

        for(int i=start;i<=end;i++){
            if(!notsosu[i]){
                System.out.println(i);
            }
        }
    }
}
