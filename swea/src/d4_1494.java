import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class d4_1494 {
    static int tc;
    static int n;
    static List<pos> jirung;
    static List<Integer> group1,group2;
    static long answer;

    static class pos{
        int x,y;
        public pos(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++) {
            n=Integer.parseInt(br.readLine());

            jirung=new LinkedList<>();

            group1=new LinkedList<>();
            group2=new LinkedList<>();
            for(int i=0;i<n;i++) {
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                jirung.add(new pos(a,b));
            }
            answer=Long.MAX_VALUE;

            getComb(0,0);

            System.out.println("#"+t+" "+answer);
        }
    }

    static void getComb(int start, int cnt) {
        if(cnt==n/2) {
            group2.clear();
            for(int i=0;i<n;i++) {
                if(!group1.contains(i)) {
                    group2.add(i);
                }
            }

//            System.out.println(group1);
//            System.out.println(group2);
            long temp=getAnswer();
            answer=Math.min(temp,answer);

            return;
        }

        for(int i=start;i<n;i++) {
            group1.add(i);
            getComb(i+1,cnt+1);
            group1.remove(group1.size()-1);
        }
    }

    static long getAnswer() {
        long temp=0;
        long x=0;
        long y=0;
        for(int i=0;i<group1.size();i++){
            int idx=group1.get(i);
            x+=jirung.get(idx).x;
            y+=jirung.get(idx).y;
        }
        for(int i=0;i<group2.size();i++){
            int idx=group2.get(i);
            x-=jirung.get(idx).x;
            y-=jirung.get(idx).y;
        }

        temp=x*x+y*y;
        return temp;

    }
}
