package offer;

/**
 * @author JohnnyJYWu
 */

public class T65_hasPath {
    //矩阵中的路径
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[matrix.length];//辅助数组，用于记录矩阵中各位置是否被访问过

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;//二维数组在一维数组形式中的表示

                if (matrix[index] == str[0]) {//找到str在矩阵的开始位置
                    if (findPath(matrix, rows, cols, i, j, str, 0, flag)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //动态规划求解
    private boolean findPath(char[] matrix, int rows, int cols, int i, int j,
                             char[] str, int strIndex,
                             int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols //数组越界
                || matrix[index] != str[strIndex] //矩阵该点与字符串相应位置值不同
                || flag[index] == -1) {//矩阵该点已使用过
            return false;
        }
        if (strIndex == str.length - 1) {//该点符合要求且已是字符串最后一位
            return true;
        }

        flag[index] = -1;
        //对该点上下左右递归求解
        if (findPath(matrix, rows, cols, i - 1, j, str, strIndex + 1, flag)
                || findPath(matrix, rows, cols, i + 1, j, str, strIndex + 1, flag)
                || findPath(matrix, rows, cols, i, j - 1, str, strIndex + 1, flag)
                || findPath(matrix, rows, cols, i, j + 1, str, strIndex + 1, flag)) {
            return true;//任一符合即可
        }

        flag[index] = 0;//记得回溯时将该点标记为未使用过

        return false;
    }
}
