import java.io.*;
import java.util.*;

public class d2_14510 {
    static int tc;
    static int n;
    static int max;
    static int[] trees;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            n=Integer.parseInt(br.readLine());

            max=0;
            trees=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                trees[i]=Integer.parseInt(st.nextToken());
                max=Math.max(max,trees[i]);
            }

            int even=0;
            int odd=0;
            for(int i=0;i<n;i++){
                int diff=max-trees[i];

                if(diff==0) continue;

                even+=(diff/2);
                odd+=(diff%2);
            }

            if(even>odd){
                while(Math.abs(even-odd)>1){
                    even-=1;
                    odd+=2;
                }
            }

            System.out.print("#"+t+" ");
            if(even==odd){
                System.out.println(even+odd);
            }else if(even>odd){
                System.out.println(even*2);
            }else{
                System.out.println(odd*2-1);
            }
        }
    }
}
