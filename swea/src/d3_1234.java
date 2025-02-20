import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class d3_1234 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1;t<=10;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            String str=st.nextToken();
            Stack<Integer> stack = new Stack<>();
            stack.push(str.charAt(0)-'0');

            for(int i=1;i<n;i++) {
                int a=str.charAt(i)-'0';
                if(!stack.isEmpty() && stack.peek()==a) {
                    stack.pop();
                }else {
                    stack.push(str.charAt(i)-'0');
                }
            }

            System.out.print("#"+t+" ");
            for(int i=0;i<stack.size();i++) {
                System.out.print(stack.get(i));
            }
            System.out.println();
        }

    }

}
