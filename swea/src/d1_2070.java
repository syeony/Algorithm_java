import java.util.*;

public class d1_2070 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i=0;i<num;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            if(n1>n2){
                System.out.println("#"+(i+1)+" >");
            }
            else if(n1<n2){
                System.out.println("#"+(i+1)+" <");
            }
            else{
                System.out.println("#"+(i+1)+" =");
            }
        }
    }
}
