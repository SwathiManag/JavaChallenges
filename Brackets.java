/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.
 */

import java.util.*;

class BracketsSolution {
    public int solution(String S) {
        // Implement your solution here
        if (S.isEmpty()) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return 0;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}

public class Brackets {
    public static void main(String[] args) {
        BracketsSolution sol = new BracketsSolution();
        String S = "{[()()]}";
        String T = "([)()]";
        System.out.println(sol.solution(S));
        System.out.println(sol.solution(T));
    }
}
