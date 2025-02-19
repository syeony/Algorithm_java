import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d4_1219 {
    static int[] arr1, arr2;
    static boolean[] v;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for(int t=1;t<=10;t++) {
            st=new StringTokenizer(br.readLine());
            int tc=Integer.parseInt(st.nextToken());
            int len=Integer.parseInt(st.nextToken());
            arr1=new int[100];
            arr2=new int[100];
            int[] temp=new int[len*2];

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<(len*2);i++) {
                temp[i]=Integer.parseInt(st.nextToken());
            }


            for(int i=1;i<temp.length;i+=2) {
//				System.out.println(temp[i-1]+" "+temp[i]);
                if(arr1[temp[i-1]]!=0) {
                    arr2[temp[i-1]]=temp[i];
                }else {
                    arr1[temp[i-1]]=temp[i];
                }
            }

            v=new boolean[100];
            answer=0;
            dfs(0);

            System.out.println("#"+t+" "+answer);

//			System.out.println(Arrays.toString(arr1));
//			System.out.println(Arrays.toString(arr2));
        }

    }

    static void dfs(int idx) {
        if(arr1[idx]==99 || arr2[idx]==99) {
            answer=1;
        }

        v[idx]=true;

        if(!(v[arr1[idx]])) {
            dfs(arr1[idx]);
        }
        if(!(v[arr2[idx]])) {
            dfs(arr2[idx]);
        }
    }

}
