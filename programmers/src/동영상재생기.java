class 동영상재생기 {
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

        if(isInRange(hour, minute, s_hour, s_minute, e_hour, e_minute)){
            hour=e_hour;
            minute=e_minute;
        }

        for(int i=0;i<commands.length;i++){
            if(commands[i].equals("next")){
                if(minute>=50){
                    if(hour<v_hour) {
                        hour++;
                        if(hour==v_hour){
                            if(minute+10-60>=v_minute){
                                minute=v_minute;
                            }else minute=minute+10-60;
                        }else minute=minute+10-60;
                    }
                    else {
                        if(minute+10<v_minute){
                            minute+=10;
                        }else{
                            minute=v_minute;
                        }
                    }
                }else{
                    if(hour==v_hour){
                        if(minute+10<v_minute){
                            minute+=10;
                        }else{
                            minute=v_minute;
                        }
                    }else{
                        minute+=10;
                    }
                }
            }else{ //prev
                if(minute<10){
                    if(hour>0) {
                        hour--;
                        minute = minute - 10 + 60;
                    }
                    else { //hour==0
                        minute=0;
                    }
                }else{
                    minute-=10;
                }
            }

            if(isInRange(hour, minute, s_hour, s_minute, e_hour, e_minute)){
                hour=e_hour;
                minute=e_minute;
            }
            //System.out.println(String.valueOf(hour)+":"+String.valueOf(minute));
        }

        String h=String.valueOf(hour);
        String m=String.valueOf(minute);
        if(h.length()==1){
            h="0"+h;
        }
        if(m.length()==1){
            m="0"+m;
        }
        return h+":"+m;
    }

    // 구간 비교 함수
    private boolean isInRange(int hour, int minute, int s_hour, int s_minute, int e_hour, int e_minute){
        boolean afterStart = (hour > s_hour) || (hour == s_hour && minute >= s_minute);
        boolean beforeEnd = (hour < e_hour) || (hour == e_hour && minute <= e_minute);
        return afterStart && beforeEnd;
    }
}
