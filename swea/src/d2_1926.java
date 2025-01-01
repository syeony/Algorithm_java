import java.util.*;

public class d2_1926 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=1;i<=n;i++){
            String b = Integer.toString(i);

            if(b.contains("3") || b.contains("6") || b.contains("9")){
                for (int j=0;j<b.length();j++){
                    b=b.replaceAll("[369]","-");
                }
                b=b.replaceAll("[1245780]","");
            }
            System.out.print(b+" ");
        }

    }
}
