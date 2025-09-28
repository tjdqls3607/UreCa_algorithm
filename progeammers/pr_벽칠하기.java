package progeammers;

//롤러로 페인트칠해야 하는 최소 횟수를 return 하는 solution 함수를 작성해 주세요.
public class pr_벽칠하기 {
    class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0;
            int painted = 0;
            int [] wall = new int[n];
            for (int i=0; i< wall.length; i++) {
                wall[i] = i+1;
                for (int j=0; j<section.length; j++) {
                    if (section[j] > painted) {
                        answer++;
                        painted = section[j] + m - 1;
                    }
                }
            }
            return answer;
        }
    }
}
