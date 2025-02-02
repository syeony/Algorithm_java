import java.io.*;

public class b2_8958 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            String n = br.readLine();
            String[] arr = n.split("");
            int score = 0;
            int cnt = 0;

            for(int j = 0; j < n.length(); j++){
                if(arr[j].equals("O")){
                    cnt+=1;
                    score+=cnt;
                    // System.out.println(j+" "+cnt);
                }
                else{
                }
            }

            System.out.println(score);
        }
    }
}
