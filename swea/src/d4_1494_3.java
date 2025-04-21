import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//이렇게 풀면 안된다는 코드
//맞는 코드는 2번
public class d4_1494_3 {
    static int tc;
    static int n;
    static List<pos> jirung;
    static class pos{
        int x;
        int y;
        public pos(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static long answer;
    static List<Integer> g1;
    static List<Integer> g2;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++) {
            n=Integer.parseInt(br.readLine());

            jirung=new ArrayList<>();
            jirung.add(new pos(0,0));
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                jirung.add(new pos(x,y));
            }
            answer=Long.MAX_VALUE;
            g1=new ArrayList<>();
            g2=new ArrayList<>();

            subSet(0);
            System.out.println("#"+t+" "+answer);
        }
    }

    static void subSet(int cnt){
        if(n/2==g1.size()){
            g2.clear();
            for(int i=0;i<n;i++){
                if(!g1.contains(i)){
                    g2.add(i);
                }
            }

            System.out.println(g1 + " " + g2);

            answer=Math.min(answer,getVector());

            return;
        }

        for(int i=cnt;i<n;i++){
            g1.add(i);
            subSet(i+1); //start파라미터 없애버리면 중복허용이 안되서 계산이 똑바로 안됨
            //요리사에선 start파라미터를 없애고 중복을 없앰으로서 시간초과를 해결했지만
            //여기서는 중복을 허용해야 제대로 계산되기때문에 start파라미터 반드시 필요!
            g1.remove(g1.size()-1);
        }
    }

    static long getVector(){
        long x=0;
        long y=0;
        for(int i=0;i<g1.size();i++){
            int idx=g1.get(i);
            x+=jirung.get(idx).x;
            y+=jirung.get(idx).y;
        }
        for(int i=0;i<g2.size();i++){
            int idx=g2.get(i);
            x-=jirung.get(idx).x;
            y-=jirung.get(idx).y;
        }
        return x*x+y*y;
    }

}
