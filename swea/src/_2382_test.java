import java.util.*;

public class _2382_test {
    public static void main(String[] args){
//        int n=7;
//        int m=7/2;
//        System.out.println(m);

        int[][] arr = {
                {1, 1, 2, 7, 4},
                {2, 1, 3, 5, 3},
                {3, 2, 3, 8, 2},
                {4, 3, 3, 2, 1}
        };

        ArrayList<Integer> list = new ArrayList<>();
        int max=0;
        HashMap<String, Integer> hashmap = new HashMap<>();
        int sum=0;
        int max_idx=-1;

        for (int x = 0; x < arr.length; x++) {
            String key = arr[x][1] + "," + arr[x][2]; // 첫 번째와 두 번째 요소를 문자열 키로 생성

            if (hashmap.containsKey(key)) {
                int matchedIndex=hashmap.get(key);

                if(!list.contains(matchedIndex)){
                    list.add(matchedIndex);
                    sum+=arr[matchedIndex][3];
                }
                if(!list.contains(x)){
                    list.add(x);
                    sum+=arr[x][3];
                }

                if (arr[matchedIndex][3] > max) {
                    max = arr[matchedIndex][3];
                    max_idx = matchedIndex;
                }
                if (arr[x][3] > max) {
                    max = arr[x][3];
                    max_idx = x;
                }
            } else {
                hashmap.put(key, x); // 처음 등장하는 경우 저장
            }
        }

        System.out.println(list);
        System.out.println(max);
        System.out.println(sum);
        System.out.println(max_idx);

        if(sum!=0) {
            arr[max_idx][3] = sum;

            for(int i:list){
                if(i!=max_idx){
                    Arrays.fill(arr[i],-1);
                }
            }
        }



        System.out.println(Arrays.deepToString(arr));

    }
}
