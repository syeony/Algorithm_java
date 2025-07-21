import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2_14561 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            long a=Long.parseLong(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            if (b < 2 || b > 36) {
                System.out.println(0);
                continue;
            }

            String c=Long.toString(a,b);
            String reverse_c=new StringBuilder(c).reverse().toString();

            if(c.equals(reverse_c)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
