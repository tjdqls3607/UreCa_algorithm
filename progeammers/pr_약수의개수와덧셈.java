package progeammers;

public class pr_약수의개수와덧셈 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for (int i=left; i<=right; i++) {
                int rotn = 0;
                for (int j=1; j<=right; j++) {
                    if (i%j==0) {
                        rotn++;
                    }
                }
                if (rotn % 2 == 0) {
                    answer += i;
                }else {
                    answer -= i;
                }
            }
            return answer;
        }
    }
}
