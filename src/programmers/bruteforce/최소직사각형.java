package programmers.bruteforce;

public class 최소직사각형 {
    public int solution(int[][] sizes) {

        int[] lengths = new int[sizes.length];
        int[] heights = new int[sizes.length];


        for (int i = 0; i < sizes.length; i++) {
            lengths[i] = Math.min(sizes[i][0], sizes[i][1]);
            heights[i] = Math.max(sizes[i][0], sizes[i][1]);
        }

        int lMax = 0;
        int hMax = 0;

        for (int i = 0; i < sizes.length; i++) {
            lMax = Math.max(lMax, lengths[i]);
            hMax = Math.max(hMax, heights[i]);
        }

        return lMax * hMax;
    }
}
