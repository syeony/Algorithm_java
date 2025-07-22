import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class s5_25178 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        String a=br.readLine();
        String b=br.readLine();

        boolean flag=true;

        //1. 한 단어를 재배열해 다른 단어를 만들 수 있어야 한다.
        int[] cnt_a=new int['z'-'a'+1];
        int[] cnt_b=new int['z'-'a'+1];
        for(int i=0;i<n;i++){
            cnt_a[a.charAt(i)-'a']++;
            cnt_b[b.charAt(i)-'a']++;
        }
        for(int i=0;i<'z'-'a'+1;i++){
            if(cnt_a[i]!=cnt_b[i]){
                flag=false;
                break;
            }
        }

        //2. 두 단어의 첫 글자와 마지막 글자는 서로 동일해야 한다.
        if(a.charAt(0)!=b.charAt(0) || a.charAt(n-1)!=b.charAt(n-1)) flag=false;

        //3. 각 단어에서 모음(a, e, i, o, u)을 제거한 문자열은 동일해야 한다.
        String a2=a.replaceAll("[aeiou]","");
        String b2=b.replaceAll("[aeiou]","");
        if(!a2.equals(b2)) flag=false;

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
