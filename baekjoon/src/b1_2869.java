import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1_2869 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int v=Integer.parseInt(st.nextToken());
        int cnt=0;

        int c=a-b; //4
        int V=v-a; //1
//        if(V/c<=0){
//            cnt=1;
//        }else{
//            cnt=V/c;
//        }
        cnt=(V+c-1)/c;

        cnt+=1;

//        while(true){
//            sum+=a;
//            cnt+=1;
//            if(sum>=v){
//                break;
//            }
//            sum-=b;
//        }

        System.out.println(cnt);
    }
}
