import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class s1_2531_2 {
    static int n,d,k,c;
    static int[] arr;
    static int[] v;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        max=0;
        v=new int[d+1];
        getAnswer();
        System.out.println(max);
    }

    static void getAnswer(){
        int total=0;

        for(int i=0;i<k;i++){
            if(v[arr[i]]==0) total++;
            v[arr[i]]++;
        }

        if(v[c]==0){
            max=total+1;
        }else{
            max=total;
        }

        for(int i=1;i<n;i++){
            v[arr[i-1]]--;
            if(v[arr[i-1]]==0) total--;

            if(v[arr[(i+k-1)%n]]==0) total++;
            v[arr[(i+k-1)%n]]++;


            if(v[c]==0){
                max=Math.max(max,total+1);
            }else{
                max=Math.max(max,total);
            }

        }
    }


}
