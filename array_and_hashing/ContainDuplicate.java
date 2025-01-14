package array_and_hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {

    public static boolean hasDuplicateBySorting(int[] nums){
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicateByHashing(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

    public static boolean hasDuplicateByHashSetLength(int[] nums){
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 5};
        System.out.println(hasDuplicateBySorting(nums));
        System.out.println(hasDuplicateByHashing(nums));
        System.out.println(hasDuplicateByHashSetLength(nums));
        
    }
    
}
