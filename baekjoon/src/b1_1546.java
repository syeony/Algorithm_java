import java.io.*;
import java.util.*;

public class b1_1546 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Double.parseDouble(st.nextToken());
        }

        double max_num = 0;
        for(int i=0;i<n;i++){
            max_num = Math.max(arr[i],max_num);
        }

        double sum=0;
        for(int i=0;i<n;i++){
            double cal=((arr[i]/max_num)*100);
            sum+=cal;
        }

        double avg = sum/n;
        System.out.println(avg);

    }
}
