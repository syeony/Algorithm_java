import java.util.*;

public class d1_1936 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] n = new int[2];
        for (int i=0; i < 2; i++){
            n[i] = sc.nextInt();
        }
        int a = n[0];
        int b = n[1];
        //가위1 바위2 보3
        if(a==1 && b==2){
            System.out.println("B");
        }
        else if(a==3 && b==1){
            System.out.println("B");
        }
        else if(a==2 && b==3){
            System.out.println("B");
        }
        else{
            System.out.println("A");
        }
    }
}
