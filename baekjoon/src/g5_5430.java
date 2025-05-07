import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class g5_5430 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			String line=br.readLine();
			int n=Integer.parseInt(br.readLine());
			
			ArrayList<Character> c=new ArrayList<>();
			for(int i=0;i<line.length();i++) {
				c.add(line.charAt(i));
			}
			
			String line2=br.readLine();
			line2=line2.replace("[", "");
			line2=line2.replace("]", "");
			
			Deque<Integer> arr=new ArrayDeque<Integer>();
			
			if(line2.length()>0) {
				String[] tokens = line2.split(",");
				for (String token : tokens) {
				    arr.add(Integer.parseInt(token.trim()));
				}
			}
			
//			System.out.println(arr);
			
			boolean err=false;
			boolean reverse=false;
			
			for(int i=0;i<line.length();i++) {
				if(c.get(i)=='R') {
					reverse=!reverse; //토글형식으로 
				}else {
					if(arr.size()==0) {
						err=true;
						break;
					}
					if(reverse) arr.pollLast();
					else arr.pollFirst();
				}
			}
			
			if(err) {
				System.out.println("error");
			}else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if (!arr.isEmpty()) {
					if (reverse) {
						ArrayList<Integer> temp = new ArrayList<>(arr);
						for (int i = temp.size() - 1; i >= 0; i--) {
							sb.append(temp.get(i));
							if (i != 0) sb.append(",");
						}
					} else {
						ArrayList<Integer> temp = new ArrayList<>(arr);
						for (int i = 0; i < temp.size(); i++) {
							sb.append(temp.get(i));
							if (i != temp.size() - 1) sb.append(",");
						}
					}
				}
				sb.append("]");
				System.out.println(sb.toString());
//				if(reverse) {
//					System.out.println(arr.reversed());
//				}else {
//					System.out.println(arr);
//				}
			}
		}
	}

}
