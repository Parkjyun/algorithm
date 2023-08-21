
import java.util.Scanner;



public class SumofSubsequence1182 {

    private static int s;
    private  static int[] arr;
    private  static int len;
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        len = sc.nextInt();//수의 개수
        s = sc.nextInt();//합



        arr = new int[len];//본집합을 담고 있는 배열
        for(int i =0; i < len; i++)
            arr[i] = sc.nextInt();

        bt(0, 0);
        if(s == 0)
            System.out.println(count-1);//목표합이 0이면 첨에 합을 0으로 정했기 때문에 공집합했을때 겹쳐서 하나 빼야 돼
        else
            System.out.println(count);
    }

    private static void bt(int depth, int sum) {
        /////매 회마다 subset의 합을 구해

        if(depth == len) {//만약 모든 요소에 대한 순회를 했고 그 순회가 depth라면 0
            if (sum == s)//그리고 그 합이 s와 같다면 count를 늘린다.
                count++;
            return;
        }

        //이것을 통해 2^5 = 32개의 조합을 모두 시도한다.
        bt(depth + 1, sum + arr[depth]);
        bt(depth + 1, sum);
    }
}
