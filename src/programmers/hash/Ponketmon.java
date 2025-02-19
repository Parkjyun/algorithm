package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class Ponketmon {
        public int solution(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            int chance = nums.length/2; //고를 수 있는 마리
            int variaty = map.size();
            if(variaty >= chance) return chance;
            return variaty;
        }
}
