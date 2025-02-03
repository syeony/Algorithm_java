import java.io.*;

public class b4_11945 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String[] arr = st.split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        for(int i=0;i<n;i++){
            String str = br.readLine();
            StringBuffer str2 = new StringBuffer(str);
            String str_reverse = str2.reverse().toString();
            System.out.println(str_reverse);
        }
    }
}
