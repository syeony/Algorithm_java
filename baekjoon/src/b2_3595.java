import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2_3595 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int min=Integer.MAX_VALUE;
        int[] arr=new int[3];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i*j>n) break;
                for(int k=1;k<=n;k++){
                    if(i*j*k>n) break;

                    if(i*j*k==n){
                        int sum=i*j+j*k+i*k;
                        if(sum<min){
                            min=sum;
                            arr[0]=i;
                            arr[1]=j;
                            arr[2]=k;
                        }

                    }
                }
            }
        }

        for(int i=0;i<3;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
