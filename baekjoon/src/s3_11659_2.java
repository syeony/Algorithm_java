import java.io.*;
import java.util.*;

public class s3_11659_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr[0]=0;
        for(int i=1;i<n+1;i++){ //구간합계산
            arr[i]=arr[i-1]+Integer.parseInt(st2.nextToken());
        }

        for(int i=0;i<m;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            int sum=0;
            sum = arr[end]-arr[start-1];
            System.out.println(sum);
        }
    }
}
