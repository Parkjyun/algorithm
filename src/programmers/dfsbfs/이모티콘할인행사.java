package programmers.dfsbfs;

public class 이모티콘할인행사 {
    double[] candidate = {0.1, 0.2, 0.3, 0.4};
    int maxPlus = Integer.MIN_VALUE;
    int maxBuy = Integer.MIN_VALUE;
    double[] ps;
    public int[] solution(int[][] users, int[] emoticons) {
        ps = new double[emoticons.length];
        dfs(0, users, emoticons);
        return new int[]{maxPlus, maxBuy};
    }
    void dfs(int depth, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) { // 만약 emoticon개수만큼 채웠다면
            go(users, emoticons);//할인률순열을 사용해서 최대들을 계산
            return;
        }
        for(int i = 0; i < candidate.length; i++) {
            ps[depth] = candidate[i];
            dfs(depth + 1, users, emoticons);
        }
    }
    void go(int[][] users, int[] emoticons) {//하나의 퍼센트 조합에 대해
        int totalPrice = 0;
        int totalPlus = 0;
        for (int i = 0; i < users.length; i++) { // 모든 사람에 대해
            double leastP = users[i][0] / 100.0; // 이거 이상이면 모두 구매
            int changeToPlusPrice = users[i][1]; // 이거 이상이면 plusfh
            int price = 0; // 개인의 가격


            for (int j = 0; j < emoticons.length; j++) { // 모든 이모티콘에 대해

                if (ps[j] >= leastP ) { //할인률이 높다면 구매한다,
                    price += ((1-ps[j]) * emoticons[j]);//개별구매액
                }
            }
            //한 사람이 모든 이모티콘에 대해 돌고 난 후
            if (price >= changeToPlusPrice) {
                totalPlus++;

            } else {
                totalPrice += price;
            }

        }
        //모든 사람 모든 이모티콘에 대해 다 돈 상태
        if (totalPlus > maxPlus) { // 플로스 경신
            maxPlus = totalPlus;
            maxBuy = totalPrice;

        } else if (totalPlus == maxPlus) {
            if (totalPrice > maxBuy) {
                maxBuy = totalPrice;
            }
        }
    }
}
