import java.util.Scanner;

public class Rgb {//dp임
    //총 n개의 집이 있다.
    //   1 2 i-2 i-1 i i+1 i+2  N-1 N //
    //이웃하는 애랑만 집색이 다르면 됨
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        int[][] val = new int[num][3];
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < 3; j++)
                val[i][j] = s.nextInt();
        }
        ////값들을 모두 입력 받고

        //dp를 위한 새로운 배열 생성, 1,3은 첫아파트 b로 할때의 가격
        int[][] ans = new int[num][3];

        //1째집 rgb로 칠할때의 값을 넣어줌
        ans[0][0] = val[0][0];
        ans[0][1] = val[0][1];
        ans[0][2] = val[0][2];
        for(int i = 1; i < num; i++) {//2번째 집부터 총 n - 1회를 반복
            //각회마다 rgb로 끝날 때 얼마인지를 저장
            for(int j = 0; j < 3; j++) {
                if(ans[i-1][(j+1) % 3] < ans[i-1][(j+2) % 3]) {//전회차까지의 합중 작은 것을 고르고 거기에 현재 위치를 더함
                    ans[i][j] = ans[i-1][(j+1) % 3] + val[i][j];
                } else
                    ans[i][j] = ans[i-1][(j+2) % 3] + val[i][j];
            }
        }
        int min = ans[num-1][0];

        for(int i = 0; i < 3; i++) {
            if(min > ans[num-1][i])
                min = ans[num-1][i];
        }
        System.out.println(min);

    }
}
