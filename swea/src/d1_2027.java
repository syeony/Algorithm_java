import java.util.*;

public class d1_2027 {
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        for (i=0;i<5;i++){
            for (j=0;j<5;j++){
                if(i==j){
                    System.out.print("#");
                }
                else{
                    System.out.print("+");
                }
            }
            System.out.print("\n");
        }
    }
}
