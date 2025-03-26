import java.util.StringTokenizer;

public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        String s = transform(n,k);
        String[] arr = s.split("0");

        for (String str : arr) {
            if (str.equals("")) continue;
            long num = Long.parseLong(str);
            if(isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }


    String transform(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n%k);
            n /= k;
        }

        return (sb.reverse().toString());
    }

    boolean isPrime(long n) {
        if (n == 1) return false;
        boolean res = true;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) res = false;
        }
        return res;
    }
}
