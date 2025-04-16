package programmers.binarysearch;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        int answer = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
        }

        long ts = sum1 + sum2;

        if (ts % 2 == 1) {
            return -1;
        }

        //1에다가 이만큼 추가. 누적합에서 q2에서 tofind = q1 + aa1
        long aa = ts/2 - sum1;

        long[] cs1 = new long[queue1.length + queue2.length+1];
        long[] cs2 = new long[queue2.length + queue1.length+1];

        cs1[0] = 0;
        cs2[0] = 0;
        for(int i = 1; i < queue1.length+1; i++) {
            cs1[i] = queue1[i-1] + cs1[i-1];
        }
        for(int i = queue1.length+1; i < cs1.length; i++) {
            cs1[i] = queue2[i-queue1.length-1] + cs1[i-1];

        }





        for(int i = 1; i < queue2.length+1; i++) {
            cs2[i] = queue2[i-1] + cs2[i-1];
        }

        for(int i = queue2.length+1; i < cs2.length; i++) {
            cs2[i] = queue1[i-queue2.length-1] + cs2[i-1];
        }


        for (int i = 0; i < cs1.length; i++) {
            long toFind = cs1[i] + aa;
            int index = binarySearch(i, toFind, cs2);
            if (index >= 0) {
                answer = index + i;
                return answer;

            }
        }
        return -1;
    }

    int binarySearch(int i, long toFind, long[] arr) {
        int l = 0;
        int h = arr.length-1;
        int m;

        while(l <= h) {
            m = l + (h-l)/2;

            if(arr[m] < toFind) {
                l = m+1;
            } else if (arr[m] > toFind) {
                h = m-1;
            } else {
                return m;
            }
        }
        return -1;
    }


}
