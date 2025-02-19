import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class d4_1218 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        for(int t=1;t<=10;t++) {
            int n=Integer.parseInt(br.readLine());
            Stack<Character> stack = new Stack<>();
            int answer=0;
//			stack.push("(");
//			stack.push("{");
//			System.out.println(stack.peek());
//			System.out.println(stack.pop());
//			System.out.println(stack.size());
            String str=br.readLine();

            for(int i=0;i<n;i++) {
                char st = str.charAt(i);
//				System.out.println(st);
                if(st==')') {
                    if(stack.peek().equals('(')) {
                        stack.pop();
                        if(stack.size()==0) {
                            answer=1;
                            break;
                        }
                    }else {
                        break;
                    }
                }else if(st=='}'){
                    if(stack.peek().equals('{')) {
                        stack.pop();
                        if(stack.size()==0) {
                            answer=1;
                            break;
                        }
                    }else {
                        break;
                    }

                }else if(st==']'){
                    if(stack.peek().equals('[')) {
                        stack.pop();
                        if(stack.size()==0) {
                            answer=1;
                            break;
                        }
                    }else {
                        break;
                    }

                }else if(st=='>'){
                    if(stack.peek().equals('<')) {
                        stack.pop();
                        if(stack.size()==0) {
                            answer=1;
                            break;
                        }
                    }else {
                        break;
                    }
                }
                else {
                    stack.push(st);
                }

                if(stack.size()==0) {
                    answer=1;
                    break;
                }
            }


            System.out.println("#"+t+" "+answer);
        }
    }
}
