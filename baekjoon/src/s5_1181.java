// 시간초과
import java.io.*;
import java.util.*;

public class s5_1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> li = new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(br.readLine());
        }
//        System.out.println(li);

        for(int i=0;i<li.size();i++){
            for(int j=i+1;j<li.size();j++){

                if(li.get(i).equals(li.get(j))){
//                    System.out.println(li.get(i)+" "+li.get(j));
                    li.remove(j);
                    continue;
                }

                if(li.get(i).length()>li.get(j).length()){
                    String temp = li.get(i);
                    li.set(i, li.get(j));
                    li.set(j, temp);
                }
                else if(li.get(i).length()== li.get(j).length()){
                    String[] temp = {li.get(i), li.get(j)};
                    Arrays.sort(temp);
                    li.set(i, temp[0]);
                    li.set(j, temp[1]);
                }
            }
        }

        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i));
        }

    }
}
