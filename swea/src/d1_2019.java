import java.util.*;

public class d1_2019 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        System.out.print(start+" ");
        for (int i=0;i<n;i++){
            System.out.print(start*2+" ");
            start*=2;
        }
    }
}
