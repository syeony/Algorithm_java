import java.util.*;

public class d1_2068 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i=0;i<num;i++){
            int max = 0;
            for (int j=0;j<10;j++){
                max = Math.max(max, sc.nextInt());
            }
            System.out.println("#"+(i+1)+" "+max);
        }
    }
}
