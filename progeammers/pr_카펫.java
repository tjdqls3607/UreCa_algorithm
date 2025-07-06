package progeammers;

import java.util.ArrayList;
import java.util.List;

public class pr_카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {0, 0};
            int total = brown / 2 + 2;  //두 변의 길이를 구하는 법
            List<Integer> carpetList = new ArrayList<>();   //만들어 질 수 있는 모든 카펫의 한 변의 길이

            for(int i = total-3; i > 1; i--) {  // -3 을 하는 이유는 갈색 만 있는 경우를 제외시키기 위해
                if( i >= total - i) {
                    carpetList.add(i);
                }
            }

            for(int i = 0; i < carpetList.size(); i++) {
                int yelloSize = (carpetList.get(i)-2) * (total - carpetList.get(i) - 2);
                if(yellow == yelloSize) {   // 이때 주어진 yellow 와 구한 yellow 가 같아지면 멈추고 배열 반환
                    answer[0] = carpetList.get(i);
                    answer[1] = total - carpetList.get(i);
                    break;
                }
            }

            return answer;
        }
    }
}
