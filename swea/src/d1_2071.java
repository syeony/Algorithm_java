import java.util.*;

public class d1_2071 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i=0;i<num;i++){
            float sum = 0;
            for (int j=0;j<10;j++){
                int n = sc.nextInt();
                sum+=n;
            }
            System.out.println("#"+(i+1)+" "+Math.round(sum/10));
        }
    }
}
