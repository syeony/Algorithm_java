import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class d4_1865_2 {
    static int n;
    static int[][] arr;
    static boolean[] v;
    static Queue<Integer> q;
    static double answer;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++) {
            n=Integer.parseInt(br.readLine());
            arr=new int[n][n];
            for(int i=0;i<n;i++) {
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }

//			System.out.println(Arrays.deepToString(arr));

            v=new boolean[n];
            answer=0.0;
            q=new LinkedList<>();
            temp=new int[n];
            dfs(0);

            System.out.println("#"+t+" "+String.format("%.6f", answer*100));
        }

    }

    static void dfs(int idx) {
//        if(probability<=answer) return;

        if(idx==n) {
            double probability=1.0;
            for(int i=0;i<n;i++){
                probability=getProbability(probability,temp[i]);
            }
            answer=Math.max(answer, probability);
            return;
        }

        for(int j=0;j<n;j++) {
            if(!v[j]) {
                v[j]=true;
                temp[idx]=j;
                dfs(idx+1);
                v[j]=false;
            }
        }

    }

    static double getProbability(double probability,int a) {
        return probability*(a/100.0);
    }

}
