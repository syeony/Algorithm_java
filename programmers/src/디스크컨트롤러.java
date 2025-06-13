//틀림

import java.io.*;
import java.util.*;

class 디스크컨트롤러 {
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
            return Integer.compare(b[0],a[0]);
        });

        for(int i=0;i<jobs.length;i++){
            pq.offer(new job(i,jobs[i][0],jobs[i][1]));
        }

        int end=0;
        int sum=0;

        for(int i=0;i<jobs.length;i++){
            job c=pq.poll();
            int num=c.num;
            int start=c.start;
            int time=c.time;
            if(start>end) end+=(start-end);
            end=end+time;
            sum+=end-start;
        }

        int answer=sum/jobs.length;
        return answer;
    }
}