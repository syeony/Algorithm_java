import java.io.*;
import java.util.*;

class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
            // System.out.println(stack.pop());
        }

        int flag = 0;
        while(!stack.isEmpty()){
            if(flag<=0 && stack.peek()=='('){
                flag++;
                break;
            }

            if(stack.peek()=='('){
                stack.pop();
                flag--;
            }else if(stack.peek()==')'){
                stack.pop();
                flag++;
            }
        }

        if(flag>0) answer=false;

        return answer;
    }
}