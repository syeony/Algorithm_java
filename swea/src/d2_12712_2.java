import java.util.*;

public class d2_12712_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t=1;t<=tc;t++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int N = n+(m-1)*2;
            int[][] arr = new int[N][N];

            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    arr[i+(m-1)][j+(m-1)] = sc.nextInt();
                }
            }

            //System.out.println("#"+t+" "+Arrays.deepToString(arr));

            int max = 0;
            //+
            for (int i=m-1;i<N-(m-1);i++){
                for (int j=m-1;j<N-(m-1);j++){
                    int sum = arr[i][j];
                    for (int k = 1; k < m; k++) {
                        sum += arr[i - k][j] + arr[i + k][j] + arr[i][j - k] + arr[i][j + k];
                    }
                    max = Math.max(max, sum);
                }
            }

            //x
            for (int i=m-1;i<N-(m-1);i++){
                for (int j=m-1;j<N-(m-1);j++){
                    int sum = arr[i][j];
                    for (int k = 1; k < m; k++) {
                        sum += arr[i - k][j - k] + arr[i - k][j + k] + arr[i + k][j - k] + arr[i + k][j + k];
                    }
                    max = Math.max(max,sum);
                }
            }

            System.out.println("#"+t+" "+max);

        }
    }
}
