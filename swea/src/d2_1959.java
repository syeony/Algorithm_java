import java.util.*;

public class d2_1959 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=1;i<=n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            ArrayList<Integer> a_arr = new ArrayList<>();
            ArrayList<Integer> b_arr = new ArrayList<>();
            for (int j=0;j<a;j++){
                a_arr.add(sc.nextInt());
            }
            for (int j=0;j<b;j++){
                b_arr.add(sc.nextInt());
            }

            int max = 0;

            if(a>=b){
                for (int x=0;x<=Math.abs(a-b);x++){
                    int sum = 0;
                    for (int y=0;y<Math.min(a,b);y++){
                        sum += (a_arr.get(x+y) * b_arr.get(y));
                    }
                    max = Math.max(max, sum);
                }
            }
            else{
                for (int x=0;x<=Math.abs(a-b);x++){
                    int sum = 0;
                    for (int y=0;y<Math.min(a,b);y++){
                        sum += (a_arr.get(y) * b_arr.get(x + y));
                    }
                    max = Math.max(max, sum);
                }
            }

            System.out.println("#"+i+" "+max);
        }
    }
}
