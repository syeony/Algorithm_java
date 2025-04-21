import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class a_요리사 {
    static int n;
    static int[][] arr;
    static List<Integer> start, link;
    static int mi;

    public static void main(String[] args) throws Exception{
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
            start=new ArrayList<>();
            link=new ArrayList<>();
            mi=Integer.MAX_VALUE;

            dfs(0,0);
            System.out.println("#"+t+" "+mi);
        }
    }

    static void dfs(int s, int idx) {
        if(n/2==start.size()) {
            link.clear();
            for(int i=0;i<n;i++) {
                if(!start.contains(i)) {
                    link.add(i);
                }
            }

//			System.out.println(start+" "+link);

            solve(start,link);
            return;
        }

        for(int i=idx;i<n;i++) {
            start.add(i);
            dfs(i+1, idx+1);
            start.remove(start.size()-1);
        }
    }

    static void solve(List<Integer> s,List<Integer> l) {
        int s_sum=0;
        int l_sum=0;
        for(int i=0;i<n/2-1;i++) {
            for(int j=i+1;j<n/2;j++) {
                s_sum+=(arr[start.get(i)][start.get(j)]+arr[start.get(j)][start.get(i)]);
                l_sum+=(arr[link.get(i)][link.get(j)]+arr[link.get(j)][link.get(i)]);
            }
        }

        mi=Math.min(mi, Math.abs(s_sum-l_sum));
    }

}
