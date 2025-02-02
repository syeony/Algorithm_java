import java.io.*;
import java.util.*;

public class s5_1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int[] arr = new int[n.length()];

        for(int i=0;i<n.length();i++){
            arr[i] = n.charAt(i) - '0';
        }

        Arrays.sort(arr);
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }

        for(int num:arr){
            System.out.print(num);
        }
    }
}
