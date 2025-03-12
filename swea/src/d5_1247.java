import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d5_1247 {
	static int n;
	static Point office, home, customers[];
	static boolean[] v;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			n=Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			office=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			home=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			customers=new Point[n];
			for(int i=0;i<n;i++) {
				customers[i]=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			v=new boolean[n];
			answer=Integer.MAX_VALUE;
			getAnswer(0,office,0);
			
			System.out.println("#"+t+" "+answer);
		}
	}
	
	static void getAnswer(int cnt, Point prev, int distance) {
		if(distance>=answer) {
			return;
		}
		
		if(cnt==n) {
			int cal=distance+(Math.abs(home.x-prev.x)+Math.abs(home.y-prev.y));
			answer=Math.min(answer, cal);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!v[i]) {
				v[i]=true;
				getAnswer(cnt+1,customers[i],distance+(Math.abs(prev.x-customers[i].x)+Math.abs(prev.y-customers[i].y)));
				v[i]=false;
			}
		}
	}
}
