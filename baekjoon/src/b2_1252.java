import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2_1252 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        Long a=Long.valueOf(st.nextToken(),2);
        Long b=Long.valueOf(st.nextToken(),2);

        Long sum=a+b;
        String binary = Long.toBinaryString(sum);

        System.out.println(binary);
    }
}
