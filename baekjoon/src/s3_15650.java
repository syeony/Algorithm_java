import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_15650 {
    static int n,m;
    static int[] arr;
    static boolean[] v;
    static int[] b;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        sb=new StringBuilder();

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n];
        for(int i=1;i<n+1;i++){
            arr[i-1]=i;
        }
//        System.out.println(Arrays.toString(arr));
        v=new boolean[n];
        b=new int[m];
        perm(0,0);
        System.out.println(sb.toString());
    }

    static void perm(int idx, int start){
        if(idx==m){
            for(int i=0;i<m;i++){
                sb.append(b[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<n;i++){
//            if(!v[i]){
//                v[i]=true;
                b[idx]=arr[i];
                perm(idx+1,i+1);
//                v[i]=false;
//            }
        }
    }
}
