import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class s1_2531 {
    static int n,d,k,c;
    static int[] arr;
    static Set<Integer> set;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        arr=new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        max=0;
        getAnswer();
        System.out.println(max);
    }

    static void getAnswer(){

        for(int i=1;i<n+1;i++){
            set=new HashSet<>();
            for(int j=0;j<k;j++){
                set.add(arr[(i+j-1)%n+1]);
            }
            getMax();
        }
    }

    static void getMax(){
        if(!set.contains(c)){
//            for (int num : set) {
//                System.out.print(num+" ");
//            }
            max=Math.max(max,set.size()+1);
        }else{
            max=Math.max(max,set.size());
        }
    }
}
