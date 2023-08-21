import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution2 {
    /*1.sequence를 뒤에서 부터 queue 넣느다
    2. 만약 그 합들이 합을 넘으면 뺀다
    3. 12 반복, k나왔을 때 sequence저장, 뺴고 계속 진행
    4. 길이가 짧은 수열이 여러개인 경우는
addfirst removelast
     */
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int tmp1=0,tmp2=0;
        long dif = 10000000;
        Deque<Integer> queue = new ArrayDeque<>();
        int sum = 0;
        for(int i = sequence.length - 1; i >= 0; i--) {//모든 인덱스에 대해

            queue.addFirst(i);//큐에 인덱스를 큰 것부터 넣는다
            sum += sequence[queue.getFirst()];//인덱스에 대한 값을 합에 더한다

            if (sum < k) {//만약 합이 k보다 작다면 continue
                continue;
            } else if (sum == k) {//만약 합이라면
                if(queue.getLast() - queue.getFirst() > dif) break;//나는 최단을 찾아야 한다 고로 추후에 나오는 dif가 기존보다 크다면 break
                tmp1 = queue.getFirst();
                tmp2 = queue.getLast();
                dif = tmp2 - tmp1;//맨앞, 맨뒤 인덱스간 차이 알아내기 위해

                sum -= sequence[queue.getLast()]; //섬에서 마지막것을 빼. 더 찾기 위해..
                queue.removeLast();
            } else if (sum > k) {//만약 sum이 k를 넘는다면
                sum -= sequence[queue.getLast()];//sum에서 마지막 것을 빼고
                queue.removeLast();//큐에서도 뺀다.
            }
        }

        answer[0] = tmp1;
        answer[1] = tmp2;
        return answer;
    }

    public static void main(String[] args) {
        int[] sequence = {1,1,1,2,2,2};
        int k = 1;
        int[] answer = solution(sequence, k);

        for (int i : answer) {
            System.out.println("i = " + i + "\n");

        }
    }
}
