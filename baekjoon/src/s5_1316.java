import java.io.*;
import java.util.*;

public class s5_1316 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i=0;i<t;i++){
            String st = br.readLine();
            String[] arr = st.split("");
            ArrayList<String> exist = new ArrayList<>();
            boolean flag = true;

            exist.add(arr[0]);

            for(int j=1;j<arr.length;j++){
                if(!arr[j].equals(arr[j-1])){
                    if(exist.contains(arr[j])){
                        flag = false;
                        break;
                    }
                    else{
                        exist.add(arr[j]);
                    }
                }
            }

            if(flag==true){
                answer+=1;
            }

        }

        System.out.println(answer);


    }
}
