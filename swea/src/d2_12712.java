// 뿌려진 일부가 영역을 벗어나도 상관없다. 조건을 고려하지 못한 코드
import java.util.*;

public class d2_12712 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t=1;t<=tc;t++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            //System.out.println("#"+t+" "+Arrays.deepToString(arr));

            int max = 0;
            //+
            for (int i=m-1;i<n-m+1;i++){
                for (int j=m-1;j<n-m+1;j++){
                    int sum = arr[i][j]+arr[i-1][j]+arr[i][j-1]+arr[i+1][j]+arr[i][j+1];
                    max = Math.max(max, sum);
                }
            }

            //x
            for (int i=m-1;i<n-m+1;i++){
                for (int j=m-1;j<n-m+1;j++){
                    int sum = arr[i][j]+arr[i-1][j-1]+arr[i+1][j+1]+arr[i-1][j+1]+arr[i+1][j-1];
                    max = Math.max(max,sum);
                }
            }

            System.out.println("#"+t+" "+max);

        }
    }
}
