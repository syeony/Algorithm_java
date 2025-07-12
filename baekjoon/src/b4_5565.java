import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b4_5565 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price=Integer.parseInt(br.readLine());
        int sum=0;

        for(int i=0;i<9;i++){
            sum+=Integer.parseInt(br.readLine());
        }

        System.out.println(price-sum);
    }
}
