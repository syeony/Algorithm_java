import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_14501_2 {
    static int[] day,pay;
    static int ma=Integer.MIN_VALUE, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        day = new int[20];
        pay = new int[20];

        n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0);
        System.out.println(ma);
    }

    static void dfs(int idx,int price){
        if(idx>n){
            ma=Math.max(ma,price);
            return;
        }

        //상담안할때
        dfs(idx+1,price);

        //상담할때
        if(idx+day[idx]<=n+1){
            dfs(idx+day[idx],price+pay[idx]);
        }

    }
}
