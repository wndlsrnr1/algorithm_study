package algorithm.study.level1;

import java.util.HashSet;
import java.util.Set;

public class PhoneKetMonEasy {

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() >= nums.length/2){
            return nums.length / 2;
        }else {
            return set.size();
        }
    }
}
