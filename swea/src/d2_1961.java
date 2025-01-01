import java.util.*;

public class d2_1961 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int t=1;t<=n;t++){
            int a = sc.nextInt();
            int[][] arr = new int[a][a];
            for (int i=0;i<a;i++){
                for (int j=0;j<a;j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            //배열을 출력하는 방법
            //System.out.println(Arrays.deepToString(arr));

            int[][] arr_90 = new int[a][a];
            int[][] arr_180 = new int[a][a];
            int[][] arr_270 = new int[a][a];

            System.out.println("#"+t);

            for (int i=0;i<a;i++){
                for (int j=0;j<a;j++) {
                    arr_90[i][j] = arr[a - j - 1][i];
                }
            }

            for (int i=0;i<a;i++){
                for (int j=0;j<a;j++) {
                    arr_180[i][j] = arr_90[a - j - 1][i];
                }
            }

            for (int i=0;i<a;i++){
                for (int j=0;j<a;j++){
                    arr_270[i][j] = arr_180[a-j-1][i];
                }
            }

            for (int i=0;i<a;i++){
                for (int j=0;j<a;j++){
                    System.out.print(arr_90[i][j]);
                }
                System.out.print(" ");
                for (int j=0;j<a;j++){
                    System.out.print(arr_180[i][j]);
                }
                System.out.print(" ");
                for (int j=0;j<a;j++){
                    System.out.print(arr_270[i][j]);
                }
                System.out.println();
            }

        }
    }
}

