import java.io.*;
import java.util.*;

class 디스크컨트롤러2 {
    static class job{
        int num; //3.작업번호
        int start; //2.요청시각
        int time; //1.소요시간
        public job(int num,int start,int time){
            this.num=num;
            this.start=start;
            this.time=time;
        }
    }
    static PriorityQueue<job> pq;

    public int solution(int[][] jobs) {
        pq=new PriorityQueue<>((a,b)->{
            if(a.time!=b.time) return Integer.compare(a.time,b.time);
            else{
                if(a.start!=b.start) return Integer.compare(a.start,b.start);
                else return Integer.compare(a.num,b.num);
            }
        });

        Arrays.sort(jobs,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });

        int end=0;
        int sum=0;
        int idx=0;
        int cnt=0;

        while(true){
            if(cnt>=jobs.length) break;

            while(idx<jobs.length && jobs[idx][0]<=end){
                pq.offer(new job(idx,jobs[idx][0],jobs[idx][1]));
                idx++;
            }

            if(!pq.isEmpty()){
                job c=pq.poll();
                int num=c.num;
                int start=c.start;
                int time=c.time;
                if(start>end) end+=(start-end);
                end=end+time;
                sum+=end-start;
                cnt++;
            }else{
                end=jobs[idx][0];
            }
        }

        int answer=sum/jobs.length;
        return answer;
    }
}