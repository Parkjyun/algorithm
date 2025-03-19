package programmers.bruteforce;

import java.util.*;

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        //가장 작은 넘의 약수들
        int c1 = Integer.MIN_VALUE;
        int min = findMin(arrayA);

        List<Integer> ys1 = findY(min);

        //경우 1
        for (int y : ys1) {

            if (isAllY(arrayA, y) && isAllN(arrayB, y)) {
                c1 = y;
            }
        }


        int c2 = Integer.MIN_VALUE;
        List<Integer> ys2 = findY(findMin(arrayB));
        for (int y : ys2) {
            if (isAllY(arrayB, y) && isAllN(arrayA, y)) {
                c2 = y;
            }
        }
        int a = Math.max(c1,c2);

        return a == Integer.MIN_VALUE ? 0 : a;
    }
    boolean isAllY(int[] arr, int n) {//모두 나누는가
        boolean result = true;
        for (int i  : arr) {
            if (i % n != 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    boolean isAllN(int[] arr, int n) {//하나도 못나누는가
        boolean result = true;
        for (int i  : arr) {
            if (i % n == 0) {//하나라도 나눠지면 false;
                result = false;
                break;
            }
        }
        return result;
    }

    int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
        }
        return min;
    }

    List<Integer> findY(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <=n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
