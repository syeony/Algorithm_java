import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d2_14510_2 {
    static int tc;
    static int n;
    static int max;
    static int[] trees;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            n=Integer.parseInt(br.readLine());

            trees=new int[n];
            int max=0;
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                trees[i]=Integer.parseInt(st.nextToken());
                max=Math.max(max,trees[i]);
            }

            int even=0;
            int odd=0;
            for(int i=0;i<n;i++){
                int diff=max-trees[i];

//                if(diff==0) continue;

                even+=(diff/2);
                odd+=(diff%2);
            }

            //시간초과
//            while(true){ //핵심! 2와 1의 차이가 1이거나 0이어야함!
//                if(Math.abs(even-odd)<=1){ //even<=odd
//                    break;
//                }
//
//                even-=1;
//                odd+=2;
//            }

            if(even>odd){ //주의! 2의 갯수가 1의 갯수보다 커야 들어가야함!
                while(true){ //핵심! 2와 1의 차이가 1이거나 0이어야함!
                    if(Math.abs(even-odd)<=1){ //even<=odd
                        break;
                    }

                    even-=1;
                    odd+=2;
                }
            }

            int answer=0;
            if(even==odd){
                answer=even+odd;
            }else if(even>odd){
                answer=even*2; //2는 1+1로 쪼갤수있으니 1과 2의 차이가 0일 것이다
                // 1 2 1 2 1 2
            }else if(odd>even){
                answer=odd*2-1; //주의! 물 안주고 건너뛰는 날도 고려해야한다...
                // 1 2 1 () 1 () 1
            }

            System.out.println("#"+t+" "+answer);
        }
    }
}
