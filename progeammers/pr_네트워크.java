package progeammers;

public class pr_네트워크 {
    class Solution {
        boolean[] visited;
        int n;
        int[][] computers;
        public int solution(int n, int[][] computers) {
            this.n = n;
            this.visited = new boolean[n];
            this.computers = computers;

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }
            return count;
        }
        public void dfs(int node) {
            visited[node] = true;
            for (int i = 0; i < n; i++) {
                if (computers[node][i] == 1 && !visited[i]) {
                    dfs(i);
                }
            }
        }
    }

}
