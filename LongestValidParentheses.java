import java.util.*;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = 0;
        int max = 0;

        // Left to Right 
        for (int i = 0; i < arr.length; i++) {

           
            if (arr[i] == '(') {
                left++;
            }

           
            else {
                right++;
            }

           
            if (left == right) {

                int length = 2 * left;

                if (length > max) {
                    max = length;
                }
            }

         
            else if (right > left) {

                left = 0;
                right = 0;
            }
        }

        // Right to Left 
        left = 0;
        right = 0;

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] == '(') {
                left++;
            }

            else {
                right++;
            }

           
            if (left == right) {

                int length = 2 * left;

                if (length > max) {
                    max = length;
                }
            }

           
            else if (left > right) {

                left = 0;
                right = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Parentheses String: ");
        String s = sc.nextLine();

        int ans = longestValidParentheses(s);

        System.out.println("Longest Valid Parentheses Length = " + ans);

        sc.close();
    }
}