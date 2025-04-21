import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class a_2383 {
    static int n, cnt;
    static int[][] arr;
    static ArrayList<Integer> p1, p2;
    static int[] s1, s2;
    static ArrayList<int[]> position;
    static ArrayList<Integer> dist1, dist2;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc=Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++) {
            n=Integer.parseInt(br.readLine());

            arr=new int[n][n];
            position=new ArrayList<>();
            position.add(new int[] {0,0});
            s1=new int[3];
            s2=new int[3];
            cnt=0;

            for(int i=0;i<n;i++) {
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    if(arr[i][j]==1) {
                        position.add(new int[] {i,j});
                        cnt++;
                    }
                    if(arr[i][j]>1) {
                        if(s1[2]==0) {
                            s1[0]=i;
                            s1[1]=j;
                            s1[2]=arr[i][j];
                        }else {
                            s2[0]=i;
                            s2[1]=j;
                            s2[2]=arr[i][j];
                        }
                    }
                }
            }
            p1=new ArrayList<>();
            p2=new ArrayList<>();

            answer=Integer.MAX_VALUE;
            subComb(1);
            System.out.println("#" + t + " " + answer);
        }
    }

    static void subComb(int idx) {
        if(idx>cnt) {
//			System.out.print(p1+" ");
//			System.out.println(p2);
            getDist();
//			System.out.println(dist1+" "+dist2);
            int getT=Math.max(getTime(dist1,s1), getTime(dist2,s2));
//			System.out.println(getT);
            answer=Math.min(answer, getT);
            return;
        }

        p1.add(idx);
        subComb(idx+1);
        p1.remove(p1.size()-1);

        p2.add(idx);
        subComb(idx+1);
        p2.remove(p2.size()-1);
    }

    static void getDist() {
        dist1=new ArrayList<>();
        dist2=new ArrayList<>();

        for(int i=0;i<p1.size();i++) {
            int idx=p1.get(i);
            dist1.add(Math.abs(position.get(idx)[0]-s1[0])+Math.abs(position.get(idx)[1]-s1[1]));
        }

        for(int i=0;i<p2.size();i++) {
            int idx=p2.get(i);
            dist2.add(Math.abs(position.get(idx)[0]-s2[0])+Math.abs(position.get(idx)[1]-s2[1]));
        }
    }

    static int getTime(ArrayList<Integer> d, int[] s) {
        if (d.isEmpty()) return 0; //계단 하나에 다 몰릴 수도 있기 때문에 예외처리

        Collections.sort(d);
        int time = 0;
        Queue<Integer> arrivalQueue = new LinkedList<>(d); // 정렬된 도착 시간
        Queue<Integer> stairQueue = new LinkedList<>(); // 계단을 사용 중인 사람들의 끝나는 시간

        while (!arrivalQueue.isEmpty() || !stairQueue.isEmpty()) {
            time++;

            // 계단 사용을 끝낸 사람 제거
            while (!stairQueue.isEmpty() && stairQueue.peek() <= time) {
                stairQueue.poll();
            }

            // 도착했고 계단에 들어갈 수 있는 사람은 바로 투입
            while (!arrivalQueue.isEmpty() && arrivalQueue.peek() + 1 <= time && stairQueue.size() < 3) {
                arrivalQueue.poll();
                stairQueue.offer(time + s[2]); // 현재 시간 + 계단 소요 시간
            }
        }

        return time;
    }

}