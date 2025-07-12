import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class b1_28323_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        Stack<Integer> list=new Stack<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int c=Integer.parseInt(st.nextToken());

            if(list.isEmpty()){
                list.push(c);
            }else{
                if((list.peek()+c)%2==1){
                    list.push(c);
                }
            }
        }

        System.out.println(list.size());
    }
}
