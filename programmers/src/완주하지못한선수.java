import java.io.*;
import java.util.*;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map=new HashMap<>();
        for(String str:participant){
            map.put(str,map.getOrDefault(str, 0) + 1);
        }

        for(String str:completion){
            if(map.containsKey(str)){
                map.put(str,map.getOrDefault(str, 0)-1);
            }
        }

        for(String str:participant){
            if(map.get(str)!=0){
                answer=str;
                break;
            }
        }
        return answer;
    }
}