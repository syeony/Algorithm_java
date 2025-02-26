import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class g5_1931 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n= Integer.parseInt(br.readLine());
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            arr[i][0]=start;
            arr[i][1]=end;
        }

        Arrays.sort(arr, (o1,o2)->(o1[1]==o2[1])?(o1[0]-o2[0]):(o1[1]-o2[1]));
        // 회의 끝나는 시간 기준으로 정렬하되, 같으면 회의 시작하는 시간도 정렬해줌

//        System.out.println(Arrays.deepToString(arr));
        int update=0;
        int pre_end=0;
        for(int i=0;i<n;i++){
            if(pre_end<=arr[i][0]){ //끝나는 것과 동시에 다음 회의가 시작될 수 있다고 했으므로 <가 아닌 <=
                update+=1;
                pre_end=arr[i][1];
            }
        }
        System.out.println(update);
    }
}
