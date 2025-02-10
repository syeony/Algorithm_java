import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] exist = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            exist[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(exist); //이진탐색할때는 무조건 정렬해줘야함!

        int m = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder(); //String은 값을 수정못하지만 이건 수정 가능해서 시간복잡도 개선.
        //문자열을 여러번 수정해야할 때 꼭 사용할 것.

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int a=Integer.parseInt(st.nextToken());

            int temp = Arrays.binarySearch(exist,a); //순서 중요. 앞이 배열, 뒤가 숫자.
            // 이진탐색시 찾지 못하면 음수 반환!

            if(temp>=0){
                answer.append(1+"\n");
            }else{
                answer.append(0+"\n");
            }

        }

        System.out.println(answer);


    }
}
