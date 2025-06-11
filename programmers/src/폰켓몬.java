import java.io.*;
import java.util.*;

class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int choice=nums.length/2;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int m_size=map.size();
        if(choice>m_size){
            answer=m_size;
        }else{
            answer=choice;
        }

        return answer;
    }
}