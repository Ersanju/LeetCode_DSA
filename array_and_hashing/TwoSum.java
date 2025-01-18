package array_and_hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSumByBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSumBySorting(int[] nums, int target) {
        int[][] A = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            A[i][0] = nums[i];
            A[i][1] = i;
        }

        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int cur = A[i][0] + A[j][0];
            if (cur == target) {
                return new int[]{Math.min(A[i][1], A[j][1]), 
                                 Math.max(A[i][1], A[j][1])};
            } else if (cur < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }

    public int[] twoSumByHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;
            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }
            prevMap.put(num, i);
        }
        return new int[] {};
    }


    public static void main(String[] args) {

        TwoSum obj = new TwoSum();
        int[] nums = {2, 7, 11, 15, 9};
        int target = 16;
        int[] result1 = obj.twoSumByBruteForce(nums, target);
        System.out.println(result1[0] + " " + result1[1]);
        int[] result2 = obj.twoSumBySorting(nums, target);
        System.out.println(result2[0] + " " + result2[1]);
        int[] result3 = obj.twoSumByHashMap(nums, target);
        System.out.println(result3[0] + " " + result3[1]);

        
    }
}
