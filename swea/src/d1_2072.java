import java.util.*;

public class d1_2072 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i=0;i<num;i++){
            int sum = 0;
            for (int j=0;j<10;j++){
                int n = sc.nextInt();
                if (n%2!=0){
                    sum+=n;
                }
            }
            System.out.println("#"+(i+1)+" "+sum);
        }
    }
}
