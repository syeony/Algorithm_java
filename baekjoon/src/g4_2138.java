import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_2138 {
    static int n;
    static int[] arr; //원본
    static int[] arr1;
    static int[] arr2;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        arr2=new int[n];
        answer=-1;

        String line=br.readLine();
        for(int i=0;i<n;i++){
            arr[i]=line.charAt(i)-'0';
        }

        String line2=br.readLine();
        for(int i=0;i<n;i++){
            arr2[i]=line2.charAt(i)-'0';
        }

        arr1=copyarr(arr);
        int cnt=0;
        //첫번째꺼 안누르고 시작했을때
        for(int i=1;i<n;i++){
            if(arr1[i-1]!=arr2[i-1]){
                sw(i);
                cnt++;
            }
        }
        boolean ok1 = equal(arr1, arr2);

        //첫번째꺼 누르고 시작했을때
        if(arr[0]==0){
            arr[0]=1;
            if(arr[1]==0){
                arr[1]=1;
            }else{
                arr[1]=0;
            }
        }else{
            arr[0]=0;
            if(arr[1]==0){
                arr[1]=1;
            }else{
                arr[1]=0;
            }
        }

        int cnt2=1; //첫번째꺼 눌렀으니까 1로 시작
        for(int i=1;i<n;i++){
            if(arr[i-1]!=arr2[i-1]){
                sw2(i);
                cnt2++;
            }
        }
        boolean ok2 = equal(arr, arr2);

        if (ok1 && ok2) answer = Math.min(cnt, cnt2);
        else if (ok1) answer = cnt;
        else if (ok2) answer = cnt2;

        System.out.println(answer);
    }

    static int[] copyarr(int[] arr){
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        return temp;
    }

    static boolean equal(int[] a, int[] a2){
        for(int i=0;i<n;i++){
            if(a[i]!=a2[i]) return false;
        }
        return true;
    }

    static void sw(int idx){
        if(idx-1>=0){
            if(arr1[idx-1]==0){
                arr1[idx-1]=1;
            }else{
                arr1[idx-1]=0;
            }
        }

        if(idx+1<n){
            if(arr1[idx+1]==0){
                arr1[idx+1]=1;
            }else{
                arr1[idx+1]=0;
            }
        }

        if(arr1[idx]==0){
            arr1[idx]=1;
        }else{
            arr1[idx]=0;
        }
    }

    static void sw2(int idx){
        if(idx-1>=0){
            if(arr[idx-1]==0){
                arr[idx-1]=1;
            }else{
                arr[idx-1]=0;
            }
        }

        if(idx+1<n){
            if(arr[idx+1]==0){
                arr[idx+1]=1;
            }else{
                arr[idx+1]=0;
            }
        }

        if(arr[idx]==0){
            arr[idx]=1;
        }else{
            arr[idx]=0;
        }
    }
}
