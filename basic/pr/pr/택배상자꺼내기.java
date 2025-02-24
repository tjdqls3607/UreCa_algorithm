package basic.pr;

class pr.택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        int answer = 0;
        while (num <= n) {
            num += 2 * (w - ((num - 1) % w)-1) +1;
            answer++;
        }
        return answer;
    }
}