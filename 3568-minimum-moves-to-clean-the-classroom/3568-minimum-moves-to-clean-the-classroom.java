import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int count = 0;

        int[][] id = new int[m][n];

        for (int[] row : id)
            Arrays.fill(row, -1);

        // S find karo aur L ko number do
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = count++;
                }
            }
        }

        int all = (1 << count) - 1;

        Queue<int[]> q = new LinkedList<>();

        // row, col, energy, mask, moves
        q.add(new int[]{sr, sc, energy, 0, 0});

        boolean[][][][] vis =
            new boolean[m][n][energy + 1][1 << count];

        vis[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];

            // Saara litter collect
            if (mask == all)
                return moves;

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= m ||
                    nc < 0 || nc >= n)
                    continue;

                if (classroom[nr].charAt(nc) == 'X')
                    continue;

                // Energy khatam hai
                if (e == 0)
                    continue;

                int ne = e - 1;
                int nmask = mask;

                char ch = classroom[nr].charAt(nc);

                // L mila
                if (ch == 'L') {
                    nmask |= (1 << id[nr][nc]);
                }

                // R mila → energy full
                if (ch == 'R') {
                    ne = energy;
                }

                if (!vis[nr][nc][ne][nmask]) {

                    vis[nr][nc][ne][nmask] = true;

                    q.add(new int[]{
                        nr, nc, ne, nmask, moves + 1
                    });
                }
            }
        }

        return -1;
    }
}