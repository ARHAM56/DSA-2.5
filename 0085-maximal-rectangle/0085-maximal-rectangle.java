class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                int r = m - 1;

                for (int k = i; k < n; k++) {

                    for (int l = j; l <= r; l++) {

                        if (matrix[k][l] == '0') {
                            r = l - 1;
                            break;
                        }
                    }

                    if (r < j)
                        break;

                    int area = (r - j + 1) * (k - i + 1);
                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }
}
