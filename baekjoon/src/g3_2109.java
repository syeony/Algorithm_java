import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class g3_2109 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        int max=0;
        List<Integer> pays=new ArrayList<>();
        List<Integer> days=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int p=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            pays.add(p);
            days.add(d);
            max=Math.max(max,d);
        }

        int day=max;
        int answer=0;
        while(day>0){
            int max2=0;
            int idx=-1;
            for(int i=0;i<n;i++){
                if(days.get(i)>=day && pays.get(i) > 0){
                    if(max2<pays.get(i)){
                        max2=pays.get(i);
                        idx=i;
                    }
                }
            }
            if(idx!=-1){
                answer+=max2;
//                System.out.println(idx);
                days.set(idx,0);
                pays.set(idx,0);
            }
            day--;
        }

        System.out.println(answer);

    }
}
