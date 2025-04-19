import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//a,b그룹으로 나누고
//각각 지네끼리 연결되있는지 체크하고
//인구수 차이 계산해서 min값 업데이트
public class g3_17471 {
    static int n;
    static int[] popular;
    static List<Integer>[] connect;
    static List<Integer> group1, group2;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());

        popular=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            popular[i]=Integer.parseInt(st.nextToken());
        }

        connect=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            connect[i]=new ArrayList<>();
        }

        for(int i=1;i<n+1;i++){
            st=new StringTokenizer(br.readLine());
            int cnt=Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt;j++){
                int city = Integer.parseInt(st.nextToken());
                connect[i].add(city);
            }
        }

//        System.out.println(Arrays.toString(popular));
//        System.out.println(Arrays.toString(connect));

        group1=new ArrayList<>();
        group2=new ArrayList<>();

        getsubSet(1);

        if(min==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }

    }

    static void getsubSet(int cnt){
        if(cnt==n+1){
            if(group1.size()>0 && group2.size()>0){
//                System.out.println(group1+" "+group2);
                //그룹끼리 연결되어있는지 확인
                if(connected(group1) && connected(group2)){
                    //조건 만족하면 그룹의 인원수 차이 구하기
                    int sub=getPopular(group1,group2);
                    //최소값 갱신
                    min=Math.min(min,sub);
                }
            }
            return;
        }

        group1.add(cnt);
        getsubSet(cnt+1);
        group1.remove(group1.size()-1);

        group2.add(cnt);
        getsubSet(cnt+1);
        group2.remove(group2.size()-1);
    }

    static int getPopular(List<Integer> group1,List<Integer> group2){
        int sum1=0;
        int sum2=0;

        for(int i:group1){
            sum1+=(popular[i]);
        }

        for(int i:group2){
            sum2+=(popular[i]);
        }

        return Math.abs(sum1-sum2);
    }

    static boolean connected(List<Integer> group){
        boolean[] visited=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.offer(group.get(0));

        while(!q.isEmpty()){
            int c=q.poll();

            visited[c]=true;
            for(int i:connect[c]){
                if(!visited[i]){
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }

        for(int i:group){
            if(!visited[i]){
                return false;
            }
        }
//        System.out.println(group);
        return true;
    }

}
