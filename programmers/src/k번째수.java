import java.io.*;
import java.util.*;

class k번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){
            int[] array2=copyarr(array);
            int x=commands[i][0]-1;
            int y=commands[i][1]-1;
            int k=commands[i][2]-1;

            List<Integer> slice=new ArrayList<>();
            for(int j=x;j<=y;j++){
                slice.add(array2[j]);
            }
            Collections.sort(slice);
            answer[i]=slice.get(k);
        }
        return answer;
    }

    static int[] copyarr(int[] array){
        int[] arr=new int[array.length];
        for(int i=0;i<array.length;i++){
            arr[i]=array[i];
        }
        return arr;
    }
}