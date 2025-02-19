
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a_1 {
    static int sum, n, p, t;
    static int[] f,s;
    static int[][] arr;
    static boolean[] v;
    static StringBuilder sb;

    public static void dfs(int depth) {
        if(depth>=n) {
            int temp=0;
            temp+=arr[0][0];
            for(int i=1;i<n;i++) {
                if(arr[i-1][1]==arr[i][1]) {
                    temp=temp+arr[i][0]-p;
                }
                else {
                    temp=temp+arr[i][0];
                }
            }

            sum=Math.max(sum, temp);
            return;
        }

        arr[depth][0]=f[depth];
        arr[depth][1]=1;
        dfs(depth+1);
        arr[depth][0]=s[depth];
        arr[depth][1]=2;
        dfs(depth+1);

//        for(int i=depth;i<n;i++) {
//            if(!v[i]) {
//                v[i]=true;
//                if(i>0 && depth>0 && arr[i-1]==f[depth-1]) {
//                    arr[i]=f[depth]-p;
//
//                }else {
//                    arr[i]=f[depth];
//
//                }
//                dfs(depth+1);
//                if(i>0 && depth>0 && arr[i-1]==s[depth-1]) {
//                    arr[i]=s[depth]-p;
//
//                }else {
//                    arr[i]=s[depth];
//
//                }
//                dfs(depth+1);
//                v[i]=false;
//            }
//        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb=new StringBuilder();

        int tc=Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            f = new int[n];
            s = new int[n];
            int a=0;
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                f[j]=Integer.parseInt(st.nextToken());
                a+=f[j];
            }
            int b=0;
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                s[j] = Integer.parseInt(st.nextToken());
                b+=s[j];
            }

            sum=0;
            arr=new int[n][2];
            v=new boolean[n];
            t=Math.min(a, b);

            dfs(0);
//            sb.append("#").append(i).append(" ").append(sum).append("\n");
            System.out.println("#"+i+" "+sum);
//            System.out.println(Arrays.toString(f));
//            System.out.println(Arrays.toString(s));
        }
//        System.out.println(sb);
    }
}