import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
////////////배워갈 것 정렬 by람다식
//요격시스템 == 그리디
//1. 구간을 폐구간을 기준으로 오름차순으로 정렬
//2. 각 구간마다 iteration을 돌며 마지막 폐구간이 구간에 포함되어 ㅣㅇㅆ는지 검사
//3. 만약 포함 안되어 있으면 하나 추가, 마지막 폐구간 갱신
public class Solution3 {

    public static int solution(int[][] targets) {
        int answer = 0;
        //targets를 폐구간을 기준으로 오름차순 정렬
        Arrays.sort(targets, (o1, o2) -> {return o1[1] - o2[1];});

        int end = targets[0][1] - 1;//첫번쨰로 만들어지는 요격 시스템 x좌표는 폭격 미사일의 맨뒤로한다. -> 폭격을 맨뒤기준 오름차순 정렬했으니
        answer++;

        for (int[] target : targets) {//매 폭격 미사일마다 다음을 검사한다
            if (target[0] < end && end < target[1]) {//만약 기존의 요격 미사일이 새 폭격미사일의 범위 안에 들어가면 nothing
                continue;
            } else if (end < target[0]) {//먼약 기존의 요격미사일이 새 폭격 미사일의 범위에 못들어간다면
                answer++;//새 요격 미사일 생성
                end = target[1] - 1;// 새 요격 미사일의 좌표는 폭격 미사일 범위의 맨 끝
            }

        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
