import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d3_1240 {
	static int n,m,x,y;
	static int[][] arr;
	static int[] arr2;
	static int[] zero= {0,0,0,1,1,0,1},
			one= {0,0,1,1,0,0,1},
			two= {0,0,1,0,0,1,1},
			three= {0,1,1,1,1,0,1},
			four= {0,1,0,0,0,1,1},
			five= {0,1,1,0,0,0,1},
			six= {0,1,0,1,1,1,1},
			seven= {0,1,1,1,0,1,1},
			eight= {0,1,1,0,1,1,1},
			nine= {0,0,0,1,0,1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			m=Integer.parseInt(st.nextToken());
			arr=new int[n][m];
			
			for(int i=0;i<n;i++) {
				String line=br.readLine();
				for(int j=0;j<m;j++) {
					arr[i][j]=line.charAt(j)-'0';
				}
			}
			
			x=0;
			y=0;
			go:
			for(int i=n-1;i>=0;i--) {
				for(int j=m-1;j>=0;j--) {
					if(arr[i][j]==1) {
						x=i;
						y=j-55;
						break go;
					}
				}
			}
			
			arr2=new int[56];
			int q=0;
			for(int j=y;j<y+56;j++) {
				arr2[q++]=arr[x][j];
			}
			
//			System.out.println(Arrays.toString(arr2));
			int[] a=checkEachCode();
//			System.out.println(Arrays.toString(a));
			boolean b=checkRightCode(a);
//			System.out.println(b);
			
			System.out.print("#"+t+" ");
			if(b) {
				int answer=0;
				for(int i=0;i<8;i++) {
					answer+=a[i];
				}
				System.out.println(answer);
			}else {
				System.out.println(0);
			}
		}
	}
	
	static int[] checkEachCode() {
		int[] result=new int[8];
		int cnt=0;
		int j=0;
		int[] temp=new int[7];
		
		for(int i=0;i<56;i++) {
			temp[cnt]=arr2[i];
			if(cnt==6) {
				if(Arrays.equals(temp, zero)) result[j]=0;
				else if(Arrays.equals(temp, one)) result[j]=1;
				else if(Arrays.equals(temp, two)) result[j]=2;
				else if(Arrays.equals(temp, three)) result[j]=3;
				else if(Arrays.equals(temp, four)) result[j]=4;
				else if(Arrays.equals(temp, five)) result[j]=5;
				else if(Arrays.equals(temp, six)) result[j]=6;
				else if(Arrays.equals(temp, seven)) result[j]=7;
				else if(Arrays.equals(temp, eight)) result[j]=8;
				else if(Arrays.equals(temp, nine)) result[j]=9;
				j+=1;
				cnt=0;
//				Arrays.fill(temp, 0);
			}else {
				cnt+=1;
			}
		}
		
		return result;
	}
	
	static boolean checkRightCode(int[] a) {
		int odd=0;
		int even=0;
		
		for(int i=0;i<8;i++) {
			if((i+1)%2!=0) {
				odd+=a[i];
			}else {
				even+=a[i];
			}
		}
		
		if((odd*3+even)%10==0) {
			return true;
		}
		
		return false;
	}

}
