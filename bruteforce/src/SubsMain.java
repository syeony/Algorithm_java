import java.io.*;
import java.util.*;

//부분집합
public class SubsMain {
    static int N=4, C=0;
    static int[] a={1,2,3,4};
    //static boolean[] v=new boolean[N];

    static void subs(int cnt,String str){
        if(cnt==N){
            //System.out.println(Arrays.toString(v)); C++;
            //for(int i=0; i<N; i++) System.out.print(v[i]? a[i]:"_");
            //System.out.println(); C++;
            System.out.println(str);
            C++;
            return;
        }
        //v[cnt]=true;
        subs(cnt+1,str+a[cnt]);
        //v[cnt]=false;
        subs(cnt+1,str+"_");
    }
    public static void main(String[] args) throws Exception{
        C=0;
        subs(0,"");
        System.out.println(C);
    }
}
