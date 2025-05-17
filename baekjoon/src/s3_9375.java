import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class s3_9375 {
    static int tc,n;
    static ArrayList<String> specific;
    static int[] list;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            n=Integer.parseInt(br.readLine());

            specific=new ArrayList<>();
            list=new int[n];
            for(int i=0;i<n;i++){
                st=new StringTokenizer(br.readLine());
                String a=st.nextToken();
                String b=st.nextToken();

                boolean flag=false;
                for(int j=0;j<specific.size();j++){
                    if(specific.get(j).equals(b)){
                        flag=true;
                        list[j]++;
                        break;
                    }
                }

                if(!flag){
                    specific.add(b);
                    list[specific.size()-1]++;
                }

            }

            int answer=1;
            for(int i=0;i<n;i++){
                if(list[i]==0){
                    break;
                }

                answer*=(list[i]+1);
            }
            answer-=1;
            System.out.println(answer);
        }


    }
}
