import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1_28323 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        List<Integer> list=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

//        System.out.println(list.toString());

        int t=1;
        while(t<list.size()){
            if((list.get(t)+list.get(t-1))%2!=0){
                t++;
            }else{
                list.remove(t+1);
            }
        }

        System.out.println(list.size());
    }
}
