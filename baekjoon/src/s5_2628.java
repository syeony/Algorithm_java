import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class s5_2628 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int garo=Integer.parseInt(st.nextToken());
        int sero=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> garo_li=new ArrayList<>();
        garo_li.add(0);
        garo_li.add(garo);
        ArrayList<Integer> sero_li=new ArrayList<>();
        sero_li.add(0);
        sero_li.add(sero);

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int rec=Integer.parseInt(st.nextToken());
            int centi=Integer.parseInt(st.nextToken());
            if(rec==0){
                sero_li.add(centi);
            }else{
                garo_li.add(centi);
            }
        }
        garo=0;
        Collections.sort(garo_li);
        for(int i=1;i<garo_li.size();i++){
            garo=Math.max(garo,garo_li.get(i)-garo_li.get(i-1));
        }
        sero=0;
        Collections.sort(sero_li);
        for(int i=1;i<sero_li.size();i++){
            sero=Math.max(sero,sero_li.get(i)-sero_li.get(i-1));
        }
        int answer=garo*sero;
        System.out.println(answer);
    }
}
