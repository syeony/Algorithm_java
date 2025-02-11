import java.io.*;
import java.util.*;

public class _2382 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        // 상: 1, 하: 2, 좌: 3, 우: 4
        int[] dx={0,-1,1,0,0};
        int[] dy={0,0,0,-1,1};

        for(int i=1;i<=tc;i++){
            int answer=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            int[][] map=new int[n][n];
            int[][] info=new int[k][4];

            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                info[j][0] = Integer.parseInt(st.nextToken());
                info[j][1] = Integer.parseInt(st.nextToken());
                map[info[j][0]][info[j][1]]=1;
                info[j][2] = Integer.parseInt(st.nextToken());
                info[j][3] = Integer.parseInt(st.nextToken());
            }

//            System.out.println(Arrays.deepToString(map));
//            System.out.println(Arrays.deepToString(info));
            // 저장 잘 됐는지 확인

            for(int j=0;j<m;j++){ //시간
                for(int x=0;x<k;x++){
                    if(info[x][0]!=-1){
                        //위치업데이트
                        info[x][0]+=dx[info[x][3]];
                        info[x][1]+=dy[info[x][3]];
                        if(info[x][0]<1 || info[x][0]>=n-1 || info[x][1]<1 || info[x][1]>=n-1){
                            if(info[x][3]==1){
                                info[x][3]=2;
                            }
                            else if(info[x][3]==2){
                                info[x][3]=1;
                            }
                            else if(info[x][3]==3){
                                info[x][3]=4;
                            }
                            else if(info[x][3]==4){
                                info[x][3]=3;
                            }
                            info[x][2]/=2;
                        }
                    }
                }

                ArrayList<Integer> list = new ArrayList<>();
                int max=0;
                HashMap<String, Integer> hashmap = new HashMap<>();
                int sum=0;
                int max_idx=-1;

                for(int x=0;x<k;x++){
                    if(info[x][0]!=-1){
                        String key = info[x][0] + "," + info[x][1]; // 0 번째와 1 번째 요소를 문자열 키로 생성

                        if (hashmap.containsKey(key)) {
                            int matchedIndex=hashmap.get(key);

                            if(!list.contains(matchedIndex)){
                                list.add(matchedIndex);
                                sum+=info[matchedIndex][2];
                            }
                            if(!list.contains(x)){
                                list.add(x);
                                sum+=info[x][2];
                            }

                            if (info[matchedIndex][2] > max) {
                                max = info[matchedIndex][2];
                                max_idx = matchedIndex;
                            }
                            if (info[x][2] > max) {
                                max = info[x][2];
                                max_idx = x;
                            }
                        } else {
                            hashmap.put(key, x); // 처음 등장하는 경우 저장
                        }
                    }

                }

                if(sum!=0){
                    info[max_idx][2]=sum;

                    for(int x:list){
                        if(x!=max_idx){
                            Arrays.fill(info[x],-1);
                        }
                    }
                }

            }

            for(int j=0;j<k;j++){
                if(info[j][0]!=-1){
                    answer+=info[j][2];
                }
            }

            System.out.println("#"+i+" "+answer);

        }
    }
}
