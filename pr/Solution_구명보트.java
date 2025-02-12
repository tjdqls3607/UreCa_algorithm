package pr;
import java.util.*;

// 그리디
// 무거운 사람부터 태운다
// 무거운 사람을 우선 고려하되, limit에 여유가 있으면 가벼운 사람을 태워본다.
// 사람을 무게 순으로 정렬
// 무게로 정렬한 사람들 중에 가장 무거운 사람과 가장 가벼운 사람을 태워 본다
public class Solution_구명보트 {


    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;     //구명보트의 갯수 (최솟값)

            // 무게별로 정렬
            Arrays.sort(people);    // 가벼운 ~ 무거운 순
            int count = 0;
            int i = 0;
            int j = people.length - 1;

            while (i <= j) {

                //  현 시점에서 가장 무거운 사람과 가장 가벼운 사람
                if (people[i] + people[j] <= limit) {
                    i++; // 가벼운 사람도 함께 태운다.
                }

                // 무조건 무거운 사람 태운다.
                j--;
                count++;
            }
            return count;
        }
    }
}
