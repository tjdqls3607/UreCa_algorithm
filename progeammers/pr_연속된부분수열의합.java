package progeammers;

public class pr_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int a = 0;  // 왼쪽 포인터 (부분 수열의 시작 인덱스)
        int b = 0;  // 오른쪽 포인터 (부분 수열의 끝 다음 인덱스)
        Long sum = 0L;  // 현재 a부터 b-1까지의 합
        int minLength = Integer.MAX_VALUE;  // 가장 짧은 수열의 길이 저장
        int answer[] = {-1, -1};  // 정답 [시작, 끝] 인덱스 (없을 경우 -1)

         while (true) {
             if (sum>=k) {
                 if(sum == k && b - a < minLength) {
                     minLength = b - a;
                     answer[0] = a;
                     answer[1] = b-1;
                 }
                 sum -= sequence[a++];  //왼쪽 포인터를 오른쪽으로 한 칸 옮기면서
                 // 현재 합에서 sequence[a]값을 빼고 다음 반복 준비


             }else {
                 if (b == sequence.length ) break;
                 sum += sequence[b++];  // 합이 부족하니까 오른쪽 포인터를 오른쪽으로 확장
             }
         }
        return answer;
    }
}
