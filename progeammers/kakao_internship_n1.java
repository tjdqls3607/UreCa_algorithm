package progeammers;


import java.util.PriorityQueue;

public class kakao_internship_n1 {
    public class Solution {
        static int n, target, round=1;
        static PriorityQueue<Integer> pq = new PriorityQueue<>();   // 예비 쌍들
        static int[] indice;
        static boolean[] visited;

        public static int solution(int coin, int[] cards) {
            target = (n = cards.length) + 1;
            indice = new int[n+1];  //indice[a] = b; -> a가 적힌 카드는 b번째에 뽑힘
            visited = new boolean[n+1];

            // n/3개 뽑기
            for (int i = 0; i < n/3; i++) {
                int card = cards[i];
                int index = target - card;

                visited[card] = true;
                indice[card] = i;

                if (visited[index]) pq.add(0);
            }

            // 나머지 순서대로 뽑기
            for (int i=n/3; i<n; i++) {
                int card = cards[i];
                int index = target - card;

                visited[card] = true;
                indice[card] = i;

                if (visited[index]) {
                    if (indice[index] < n/3)
                        pq.add(1);
                    else
                        pq.add(2);
                }

                if (i%2==1) {
                    if (!pq.isEmpty()) {
                        int cost = pq.poll();
                        if (coin >= cost) {
                            coin -= cost;
                            round++;
                        }
                        else
                            break;
                    }
                    else
                        break;
                }
            }
            return round;
        }
    }
}
