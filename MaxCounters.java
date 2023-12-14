/*
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
 */

import java.util.Arrays;

class MaxCountersSolution{
    public int[] solution(int N, int[] A) {
        int[] nArray = new int[N];
        int max = -1;
        int lastUpdate = 0;

        for (int a : A) {
            if (a <= N) {
                if(nArray[a-1] < lastUpdate){
                    nArray[a-1] = lastUpdate+1;
                }
                else{
                    nArray[a-1]++;
                }
                max = nArray[a-1] > max ? nArray[a-1] : max;
            }
            else {
                lastUpdate = max;
            }
        }

        for (int i=0; i<N; i++) {
            if (nArray[i] < lastUpdate) {
                nArray[i] = lastUpdate;
            }
        }


        return nArray;
    }
}

public class MaxCounters {
    public static void main(String[] args) {
        MaxCountersSolution sol = new MaxCountersSolution();
        int N = 5;
        int[] A = {3,4,4,6,1,4,4};
        System.out.println(Arrays.toString(sol.solution(N, A)));
    }
}
