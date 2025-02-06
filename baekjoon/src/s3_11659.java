import java.io.*;
import java.util.*;

// 시간초과 나와서 누적합 개념 찾아봄

public class s3_11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st2.nextToken());
        }

        for(int i=0;i<m;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st3.nextToken())-1;
            int end = Integer.parseInt(st3.nextToken());
            int sum=0;
            for(int j=start;j<end;j++){
                sum+=arr[j];
            }
            System.out.println(sum);
        }
    }
}
