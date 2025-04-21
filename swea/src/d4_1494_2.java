import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

//맞는코드
public class d4_1494_2 {
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
            for(int i=1;i<n+1;i++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                jirung.add(new pos(x,y));
            }
            answer=Long.MAX_VALUE;
            g1=new ArrayList<>();
            g2=new ArrayList<>();

            subSet(1,0);
            System.out.println("#"+t+" "+answer);
        }
    }

    static void subSet(int start,int cnt){
        if(cnt==n/2){
            g2.clear();
            for(int i=1;i<n+1;i++){
                if(!g1.contains(i)){
                    g2.add(i);
                }
            }

            System.out.println(g1 + " " + g2);

            answer=Math.min(answer,getVector());

            return;
        }

        for(int i=start;i<n+1;i++){
            g1.add(i);
            subSet(i+1,cnt+1);
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
