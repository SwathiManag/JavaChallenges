/*
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000];
string S is made only of the characters '(' and/or ')'.
 */

import java.util.*;

class NestingSolution {
    public int solution(String S) {
        if(S.isEmpty()) {
            return 1;
        }

        if (S.length() % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) {
                    return 0;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}

public class Nesting {
    public static void main(String[] args) {
        NestingSolution sol = new NestingSolution();
        String S = "(()(())())";
        String T = "())";
        System.out.println(sol.solution(S));
        System.out.println(sol.solution(T));
    }
}
