package linked_list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

    public static int findDuplicateBySorting(int[] nums){
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        return -1;
    }

    public static int findDuplicateByHashSet(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    public static int findDuplicateByArray(int[] nums){
        int[] seen = new int[nums.length];
        for(int num : nums){
            if(seen[num-1] == 1)
                return num;
            seen[num-1] = 1;
        }
        return -1;
    }

    public static int findDuplicateByNegativeMarking(int[] nums){
        for(int num : nums){

            if(nums[num-1] < 0)
                return num;
            nums[num - 1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,3,4,2};
        System.out.println(findDuplicateBySorting(nums));
        System.out.println(findDuplicateByHashSet(nums));
        System.out.println(findDuplicateByArray(nums));
        System.out.println(findDuplicateByNegativeMarking(nums));
        
    }
}
