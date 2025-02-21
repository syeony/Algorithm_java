import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class d4_1238 {
    static ArrayList<Integer>[] list;
    static boolean[] v;
    static int[] depth;
    static int answer=0, max_depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t=1;t<=10;t++) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int start=Integer.parseInt(st.nextToken());

            list=new ArrayList[101];
            for(int i=0;i<101;i++) {
                list[i]=new ArrayList<>();
            }

            st=new StringTokenizer(br.readLine());
            while(st.countTokens()>0) {
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());

                list[a].add(b);
            }

            v=new boolean[101];
            depth=new int[101];
            answer=start;
            max_depth=0;
            Arrays.fill(depth, 0);

            System.out.println("#"+t+" "+bfs(start));
        }
    }

    static int bfs(int start) {
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        v[start]=true;
        depth[start]=1;

        while(!q.isEmpty()) {
            int c=q.poll();

            for(int i:list[c]) {//2->7,15
                if(!v[i]) {
                    q.add(i);
                    v[i]=true;
                    depth[i]=depth[c]+1;
                    max_depth=Math.max(depth[i], max_depth);
                }
            }

        }

        ArrayList<Integer> templist=new ArrayList<>();
        for(int i=0;i<101;i++){
            if(depth[i]==max_depth){
//                System.out.println(i);
                templist.add(i);
            }
        }
        Collections.sort(templist);
        int answer=templist.get(templist.size()-1);

        return answer;
    }

}