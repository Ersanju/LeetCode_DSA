package two_pointers;

public class IsPalindrome {

    public static boolean isPalindromeByReverse(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public static boolean isPalindromeByTwoPointer(String s) {

        int i = 0, j = s.length() - 1;
        while (i < j) {
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindromeByReverse(s));
        System.out.println(isPalindromeByTwoPointer(s));
        
    }
    
}
