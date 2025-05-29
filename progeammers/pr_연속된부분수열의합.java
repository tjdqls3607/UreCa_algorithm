package progeammers;

public class pr_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int a = 0;
        int b = 0;
        Long sum = 0L;
        int minLength = Integer.MAX_VALUE;
        int answer[] = {-1, -1};

         while (true) {
             if (sum>=k) {
                 if(sum == k && b - a < minLength) {
                     minLength = b - a;
                     answer[0] = a;
                     answer[1] = b-1;
                 }
                 sum -= sequence[a++];
             }else {
                 if (b == sequence.length ) break;
                 sum += sequence[b++];
             }
         }
        return answer;
    }
}
