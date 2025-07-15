import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2_10708 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int f_cnt=Integer.parseInt(br.readLine());
        int g_cnt=Integer.parseInt(br.readLine());

        int[] target=new int[g_cnt];
        int[] score=new int[f_cnt];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<g_cnt;i++){
            target[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<g_cnt+1;i++){
            st=new StringTokenizer(br.readLine());

            for(int j=1;j<f_cnt+1;j++){
                int temp=Integer.parseInt(st.nextToken());

                if(j==target[i-1]){
                    //타겟이 자신이라면
                    if(temp==target[i-1]){
                        score[j-1]++;
                    }
                }else{
                    if(temp==target[i-1]){
                        score[j-1]++;
                    }else{
                        score[target[i-1]-1]++;
                    }
                }
            }
        }

        for(int i=0;i<f_cnt;i++){
            System.out.println(score[i]);
        }
    }
}
