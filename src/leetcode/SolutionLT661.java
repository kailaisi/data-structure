package leetcode;

/**
 *
 */
class SolutionLT661 {
    public static void main(String[] args) {
        SolutionLT661 lt167 = new SolutionLT661();
        int[] numbers = new int[]{6};
    }

    public int[][] imageSmoother(int[][] M) {
        // TODO: 2020/8/24  o
        int r = M.length;
        int c = M[0].length;
        int[][] ints = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int count = 0;
                for (int nr = i - 1; nr < i + 1; nr++) {
                    for (int nc = j - 1; nc < j + 1; nc++) {
                        if (nr >= 0 && nr < r && nc > 0 && nc < j) {
                            ints[i][j] += M[nr][nc];
                            count++;
                        }
                    }
                }
                ints[i][j] /= count;
            }
        }
        return ints;
    }
}