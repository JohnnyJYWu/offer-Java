package offer;

import java.util.ArrayList;

/**
 * @author JohnnyJYWu
 */

public class T19_printMatrix {
    //顺时针打印矩阵
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        if (matrix == null || matrix[0] == null) return list;

        int rowTop = 0, rowBottom = matrix.length - 1;
        int colLeft = 0, colRight = matrix[0].length - 1;

        while (colLeft <= colRight && rowTop <= rowBottom) {//跳出条件
            for (int i = colLeft; i <= colRight; i++) {//添加上边一行，从左到右
                list.add(matrix[rowTop][i]);
            }
            for (int i = rowTop + 1; i <= rowBottom; i++) {//添加右边一列，从上到下，注意去掉已添加的【右上角】。
                list.add(matrix[i][colRight]);
            }
            if (rowTop != rowBottom) {//若相等则已到同一行，无可继续添加的
                for (int i = colRight - 1; i >= colLeft; i--) {//添加下边一行，从右到左，注意去掉已添加的【右下角】。
                    list.add(matrix[rowBottom][i]);
                }
            }
            if (colLeft != colRight) {//若相等则已到同一列，无可继续添加的
                for (int i = rowBottom - 1; i > rowTop; i--) {//添加左边一列，从下到上，注意去掉已添加的【左下角】及【左上角】。
                    list.add(matrix[i][colLeft]);
                }
            }

            colLeft++;
            colRight--;
            rowTop++;
            rowBottom--;
        }

        return list;
    }
}
