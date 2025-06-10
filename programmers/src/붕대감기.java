class 붕대감기 {
    static int t,x,y,h,last;

    public int solution(int[] bandage, int health, int[][] attacks) {
        t=bandage[0];
        x=bandage[1];
        y=bandage[2];
        h=health;
        last=attacks[attacks.length-1][0];

        int time=0;
        int time2=0;
        int idx=0;

        while(time<last){
            time++;
            time2++;
            if(idx < attacks.length && attacks[idx][0]==time){
                h-=attacks[idx][1];
                idx++;
                time2=0;
                if(h<=0) return -1;
            }else{
                if(h+x>health){
                    h=health;
                }else{
                    h+=x;
                }

                if(time2%t==0){
                    if(h+y>health){
                        h=health;
                    }else{
                        h+=y;
                    }
                }
            }

        }


        return h;
    }
}