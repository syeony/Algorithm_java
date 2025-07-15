import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class s5_15876 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        // 0 1 1 0 1 1 1 0 0 1 0 1 1 1 0 1 1 1 1 0 0 0
        // 일단 2진수 배열 만들어서 저장
        List<Character> binaries = new ArrayList<>();
        int cnt=0;
        int num=0;
        while(cnt<=n*5){
            String binary=Integer.toBinaryString(num);
            int idx=binary.length();
            cnt+=idx;
            for(int i=0;i<idx;i++){
                binaries.add(binary.charAt(i));
            }
            num++;
        }

//        System.out.println(binaries);

        // 답 출력
        int printed=0;
        for(int i=0;i<binaries.size();i++){
            if((i+1)%n==k%n){
                System.out.print(binaries.get(i)+" ");
                printed++;
                if(printed==5) break;
            }
        }
    }
}
