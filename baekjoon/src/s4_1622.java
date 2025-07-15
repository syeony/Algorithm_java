import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s4_1622 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int[] one=new int[27];
            int[] two=new int[27];

            String a=br.readLine();
            if(a==null) break;
            String b=br.readLine();

            for(int i=0;i<a.length();i++){
                int idx=(int) a.charAt(i)-'a';
                one[idx]++;
            }

            for(int i=0;i<b.length();i++){
                int idx=(int) b.charAt(i)-'a';
                two[idx]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                int count = Math.min(one[i], two[i]);
                for (int j = 0; j < count; j++) {
                    sb.append((char) (i + 'a'));
                }
            }

            System.out.println(sb.toString());
        }
    }
}
