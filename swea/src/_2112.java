import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2112 {
    static int d,w,k,map[][],inject[],min; //전역변수로 쓸거 빼놓기.

    static boolean check(){
        outer:for(int i=0;i<w;i++){
            int cnt=1;
            for(int j=0;j<d-1;j++){
                int curr = inject[j]==-1?map[j][i]:inject[j];
                int next = inject[j+1]==-1?map[j+1][i]:inject[j+1];//j와 i 순서 헷갈렸음. 주의.
                if(curr==next) {
                    cnt += 1;
                    if (cnt >= k) {
                        continue outer;
                    }
                }else{
                    cnt=1;
                }
            }
            if(cnt<k){
                return false;
            }
        }
        return true;
    }

    static void subs(int cnt, int su){ //cnt:행 su:약품수
        if(cnt>=d){
            if(check()){
                min = Math.min(min,su);
            }
            return;
        }
        if(su>=min){
            return;
        }

        inject[cnt]=-1;
        subs(cnt+1,su+0);

        inject[cnt]=0;
        subs(cnt+1,su+1);
        inject[cnt]=1;
        subs(cnt+1,su+1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i=1;i<=tc;i++){
            st = new StringTokenizer(br.readLine());
            d=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());

            map = new int[d][w];
            inject = new int[d];

            for(int x=0;x<d;x++){
                st = new StringTokenizer(br.readLine());
                for(int y=0;y<w;y++){
                    map[x][y]=Integer.parseInt(st.nextToken());
                }
            }

            min=k;
//            System.out.println(Arrays.deepToString(map)); //입력 받아오기 테스트.
            subs(0,0);
            sb.append("#").append(i).append(" ").append(min).append("\n");

        }
        System.out.println(sb); //한꺼번에 출력.

    }
}
