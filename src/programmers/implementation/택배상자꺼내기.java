package programmers.implementation;

public class 택배상자꺼내기 {
    public int solution(int n, int w, int num) {

        int base = (n-1) / w;
        int numb = (num-1) / w;
        int answer = base - numb;
        int totalr = (n-1) % w;
        int objr = (num-1) % w;

        //같은 방향
        if((isOdd(numb) && isOdd(base)) || (!isOdd(numb) && !isOdd(base))) {
            if (totalr >= objr) answer++;
        } else {
            if (totalr >= w-1-objr) answer++;
        }
        return answer;
    }
    boolean isOdd(int n) {
        return n%2 == 1;
    }
}
