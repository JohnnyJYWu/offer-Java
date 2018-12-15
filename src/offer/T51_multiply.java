package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T51_multiply {
	//构建乘积数组(不能使用除法。)
    public int[] multiply(int[] A) {//矩阵，详见图片
    	int len = A.length;
    	int[] B = new int[len];//乘积数组
    	int[] C = new int[len];
    	int[] D = new int[len];
    	
    	//构建前向乘积数组C[i]=A[0]*A[1]*...*A[i-1]，即C[i]=C[i-1]*A[i-1]
    	C[0] = 1;
    	for(int i = 1; i < len; i ++) {
    		C[i] = C[i - 1] * A[i - 1];
    	}
    	
    	//构建后向乘积数组D[i]=A[n-1]*A[n-2]*...A[n-i+1]，即D[i]=D[i+1]*A[i+1]
    	D[len - 1] = 1;
    	for(int i = len - 2; i >= 0; i --) {
    		D[i] = D[i + 1] * A[i + 1];
    	}
    	
    	//B[i]=C[i]*D[i]
    	for(int i = 0; i < len; i ++) {
    		B[i] = C[i] * D[i];
    	}
    	
    	return B;
    }
}
