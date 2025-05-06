import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g3_13904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int day=Integer.parseInt(br.readLine());
        int[][] scores=new int[day][2];
        int max=0;
        for(int i=0;i<day;i++){
            st=new StringTokenizer(br.readLine());
            scores[i][0]=Integer.parseInt(st.nextToken());
            max=Math.max(max,scores[i][0]);
            scores[i][1]=Integer.parseInt(st.nextToken());
        }

        int sum=0;
        while(max>0){
            int idx=-1;
            int max2=0;
            for(int i=0;i<day;i++){
                if(scores[i][0]>=max && scores[i][1]>max2){
                    idx=i;
                    max2=scores[i][1];
                }
            }
            if(idx!=-1){
                sum+=max2;
                scores[idx][0]=0;
                scores[idx][1]=0;
            }
            max--;
        }
        System.out.println(sum);
    }
}
