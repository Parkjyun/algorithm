package programmers.implementation;

public class 풍선터뜨리기 {
    public int solution(int[] a) {
        //작은 숫자는 한번만
        // 무조건 큰 숫자
        // 쌍에서 터뜨리고 압축 압축

        //여러 경우중 최후까지 살아남는 것이 가능한 갯
        //풍선 개수 백만 -> 최대 nlogn

        // 최소 chosen 최소 -> chosen이 젤 크면 불가
        // 양쪽 끝은 가능
        int answer = 0;
        //minf 해당 인덱스에서 앞쪽에 가장 큰넘
        // mf[i] = 0 - i-1 중에 최소 = min(a[i-1], mf[i-1])
        // mb[i] = i+1 - length-1중에 최소 = min(a[i+1], mf[i+1])
        int[] minf = new int[a.length];
        minf[0] = a[0];
        int[] minb = new int[a.length];
        minb[a.length-1] = a[a.length-1];
        minb[a.length-1] = a[a.length-1];
        for (int i = 1; i < a.length - 1; i++) {
            minf[i] = Math.min(a[i-1], minf[i-1]);
        }
        for (int i = a.length - 2; i > 0; i--) {
            minb[i] = Math.min(a[i+1], minb[i+1]);
        }

        for (int i = 1; i < a.length-1; i++) {
            if (a[i] > minf[i] && a[i] > minb[i]) answer++;
        }
        return a.length-answer;
    }
}