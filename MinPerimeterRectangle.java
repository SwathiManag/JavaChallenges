/*
An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

(1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..1,000,000,000].
 */
class MinPerimeterRectangleSolution {
    public int solution(int N) {
        int sqrtOfN = (int)Math.sqrt(N);
        int minPerimeter = Integer.MAX_VALUE;

        for (int i=1; i<=sqrtOfN; i++) {
            if (N%i == 0) {
                int L = i;
                int B = N/i;
                int perimeter = 2 * (L + B);
                minPerimeter = Math.min(minPerimeter, perimeter);
            }
        }

        return minPerimeter;
    }
}

public class MinPerimeterRectangle {
    public static void main(String[] args) {
        MinPerimeterRectangleSolution sol = new MinPerimeterRectangleSolution();
        System.out.println(sol.solution(30));
    }
}
