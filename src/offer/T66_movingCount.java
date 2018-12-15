package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T66_movingCount {
	//机器人的运动范围
	public int movingCount(int threshold, int rows, int cols) {
		int[] flags = new int[rows * cols];//辅助数组，用于记录矩阵中各位置是否被访问过
		
		return moving(threshold, rows, cols, 0, 0, flags);
    }
	
	//动态规划
	private int moving(int k, int rows, int cols,
						int i, int j, int[] flags) {
		int index = i * cols + j;
		if(i < 0 || i >= rows || j < 0 || j >= cols || flags[index] == -1) {//数组越界或该点被访问过
			return 0;
		}
		
		int sum = 0;
		int tmp = i;
		while(tmp != 0) {//横坐标各位和
			sum += tmp % 10;
			tmp /= 10;
		}
		tmp = j;
		while(tmp != 0) {//纵坐标各位和
			sum += tmp % 10;
			tmp /= 10;
		}
		
		if(sum <= k) {
			flags[index] = -1;//访问过，与上题不同的是，这里不需回溯
			int steps = 1;//计入当前点
			//对该点右边和下边的点递归求解，左边与上边在前面的迭代过程中已访问过，无需再次访问
			steps += moving(k, rows, cols, i + 1, j, flags);
			steps += moving(k, rows, cols, i, j + 1, flags);
			return steps;
		}
		
		return 0;
	}
}
