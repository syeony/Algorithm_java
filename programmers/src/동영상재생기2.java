class 동영상재생기2 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] video=video_len.split(":");
        int v_hour=Integer.parseInt(video[0]);
        int v_minute=Integer.parseInt(video[1]);
        String[] time=pos.split(":");
        int hour=Integer.parseInt(time[0]);
        int minute=Integer.parseInt(time[1]);
        String[] start=op_start.split(":");
        int s_hour=Integer.parseInt(start[0]);
        int s_minute=Integer.parseInt(start[1]);
        String[] end=op_end.split(":");
        int e_hour=Integer.parseInt(end[0]);
        int e_minute=Integer.parseInt(end[1]);

        int v_len=toMinute(v_hour,v_minute);
        int cur=toMinute(hour,minute);
        int s=toMinute(s_hour,s_minute);
        int e=toMinute(e_hour,e_minute);

        if(cur>=s && cur<=e){
            cur=e;
        }

        for(String str:commands){
            if(str.equals("next")){
                cur+=10;
                if(cur>v_len) cur=v_len;
            }else{ //prev
                cur-=10;
                if(cur<0) cur=0;
            }

            if(cur>=s && cur<=e){
                cur=e;
            }

        }

        String h=String.valueOf(cur/60);
        String m=String.valueOf(cur%60);

        if(h.length()==1) h="0"+h;
        if(m.length()==1) m="0"+m;

        return h+":"+m;
    }

    static int toMinute(int h,int m){
        int minute=(h*60)+m;
        return minute;
    }
}

