public class Solution {

    private void DFS(int[][] M, boolean[] visited, int i) {
        int N = M.length;
        for (int j = 0; j < N; j++) {
            if (!visited[j] && M[i][j] == 1) {
                visited[j] = true;
                DFS(M, visited, j);
            }
        }
    }


    public int findCircleNum(int[][] M) {
        // M[i][j] == -1 means that i, j has been visited
        int N = M.length;
        int res = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                DFS(M, visited, i);
                res++;
            }
        }
        return res;
    }
}