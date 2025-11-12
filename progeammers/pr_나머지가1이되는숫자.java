package progeammers;

import java.util.Scanner;

public class pr_나머지가1이되는숫자 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for (int x = 1; x < n; x++) {
                if (n % x == 1) {
                    answer = x;
                    break;
                }
            }
            return answer;
        }
    }
}
