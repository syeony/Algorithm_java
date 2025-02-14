import java.util.*;
import java.lang.*;
import java.io.*;

public class s1_2343 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int left=0;
        int right=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left,arr[i]);
            right+=arr[i];
        }

        int answer=0;
        int mid=0;

        while(left<=right){
            mid = (left+right)/2;

            int temp_sum=0;
            int cnt=1;

            for(int i=0;i<n;i++){
                if(temp_sum+arr[i]>mid){
                    cnt+=1;
                    temp_sum=0;
                }
                temp_sum+=arr[i];
            }

            if(cnt<=m){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        System.out.println(answer);
    }
}