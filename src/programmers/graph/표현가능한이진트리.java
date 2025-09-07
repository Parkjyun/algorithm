package programmers.graph;

public class 표현가능한이진트리 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = find(numbers[i]);
        }
        return answer;
    }

    int find(long num) {
        String b = Long.toBinaryString(num);

        int l = b.length();
        int count = 0;
        while(l > 0) {
            l/=2;
            count++;
        }
        int j = 1;
        for (int i = 0; i < count; i++) {
            j *= 2;
        }

        b = String.format("%" + (j-1) + "s", b);
        b= b.replace(' ', '0');// 001 1 111

        if (possible(b)) {
            return 1;
        }
        return 0;
    }

    boolean possible(String b) { // 주어진 이진수가 포화로 변경될 수 있는지 // 자식이 있는데 부모가 없다면
        if(b.length() == 1) return true;

        int mid = b.length()/2;
        if (b.charAt(mid) == '0' && (b.substring(0, mid).contains("1") || b.substring(mid+1, b.length()).contains("1"))) return false;
        if (possible(b.substring(0, mid)) && possible(b.substring(mid+1, b.length()))) {
            return true;
        } else {
            return false;
        }

    }
}
