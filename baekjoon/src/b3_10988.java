import java.io.*;

public class b3_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(br.readLine());
        String st = br.readLine();
        StringBuffer st2 = new StringBuffer(st);
        //System.out.println(st+st2.reverse().toString());

        if(st.equals(st2.reverse().toString())){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
