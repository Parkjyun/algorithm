import java.util.Scanner;

public class Sosu {//1과 자기 자신만을 나눠지는 수로 -> 1은 소수 아님
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int no = s.nextInt();
        int[] num = new int[no];
        int ans = 0;
        for(int i = 0; i < no; i++) {
            num[i] = s.nextInt();
        }
        for(int i = 0; i < no; i++) {//각 후보군에 대하여
            int count = 0;
            for(int j = 1; j <= num[i]; j++) {//2-후보까지 나눠볼 것이야

                if (num[i] % j == 0)
                    count++;

            }
            if(count == 2)
                ans++;

        }
        System.out.println(ans);

    }
}
