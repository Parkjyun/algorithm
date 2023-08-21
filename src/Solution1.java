import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class Solution1 {
    public static int[] solution(int[] numbers) {
        int[]answer = new int[numbers.length];

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(0);//첫번쩨 인덱스를 푸쉬한다

        for(int i = 1; i < numbers.length; i++){ //numbers의 인덱스를 전부 돈다
//스택이 비어있다는 것은 이미 다 대체 되었다는 것 그리고 첫번쨰 와일문에서 비어 있지 않다는 조건을 단 것은 peek해야하는데 스택이 비어있으면 안 되자나
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]) { //스택이 비어있지 않고 새로 들어오는 놈이 큰놈이라면
                answer[stack.peek()] = numbers[i];//답배열의 pop된 인덱스에 대해 대체한다
                stack.pop();
            }
                stack.push(i); //그리고 이번에 들어온 애를 다시 넣는다 -> 얘도 나중에 검증 받아야 되자나
        }
        while(!stack.isEmpty()) {//포문이 다 끝나고 남은 애들은 자기보다 큰애들을 찾지 못한애
            answer[stack.pop()] = -1;//그래서 스택이 빌떄까지 pop하며 해당 인덱스에 대한 답울 -1 로 바꾼다
        }

        return answer;

    }
    public static void main(String[] args) {
        int[] numbers = {2,3,3,5};
        int [] ans = solution(numbers);
        for(int i = 0; i < ans.length; i++)
            System.out.println(ans[i]);
    }
}
