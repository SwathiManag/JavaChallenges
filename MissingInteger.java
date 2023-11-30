/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MissingIntegerSolution {
    // complexity: O(nlogn)
    public int solution(int[] A) {
        int smallest = 1;
        Arrays.sort(A);
        for (int i : A) {
            if (i == smallest) {
                smallest++;
            }
        }
        return smallest;
    }

    // complexity: O(n)
    public int solution2(int[] A) {
        Set<Integer> setOfA = new HashSet<Integer>();
        for (int element : A) {
            setOfA.add(element);
        }
        int smallest = 1;
        while(setOfA.contains(smallest)) {
            smallest++;
        }
        return smallest;
    }
}

public class MissingInteger {
    public static void main(String[] args) {
        MissingIntegerSolution sol = new MissingIntegerSolution();
        int[] A = {1, 3, 6, 4, 1, 2};
        System.out.println(sol.solution(A));
        System.out.println(sol.solution2(A));
        int[]  B = {1, 2, 3};
        System.out.println(sol.solution(B));
        System.out.println(sol.solution2(B));
        int[] C = {-1, -3};
        System.out.println(sol.solution(C));
        System.out.println(sol.solution2(C));
    }
}
