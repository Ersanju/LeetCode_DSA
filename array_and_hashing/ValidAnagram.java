//Question:  https://neetcode.io/problems/is-anagram

package array_and_hashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    public static boolean isAnagramBySorting(String s, String t) {
        
        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }

    public static boolean isAnagramByHashMap(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }

        return sMap.equals(tMap);
    }

    public static boolean isAnagramByHashTable(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n != m) return false;

        int[] count = new int[26];
        for(int i=0; i<m; i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int val : count){
            if(val != 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramBySorting(s, t));
        System.out.println(isAnagramByHashMap(s, t));
        System.out.println(isAnagramByHashTable(s, t));
        
    }
}
