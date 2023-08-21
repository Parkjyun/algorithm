import java.util.Scanner;

public class blackjack {
    //n장의 카드중 3장을 뽑아서 m에 가깝게 만들어야한다.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();//카드수
        int m = s.nextInt();//목표 수

        int sum = 0;
        int tmp;
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                for(int k = j + 1; k < arr.length; k++) {
                    tmp = arr[i] + arr[j] + arr[k];
                    if(tmp == m) {
                        sum = tmp;
                        break;
                    }
                    else if (tmp < m && sum < tmp) {
                        sum = tmp;

                    }
                }
            }
        }
        System.out.println(sum);


    }
}
