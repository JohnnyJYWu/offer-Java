package offer;

/**
 * @author JohnnyJYWu
 */

public class T35_InversePairs {
    //数组中的逆序对
    private long cnt = 0;
    private int[] tmp;//辅助数组

    public int InversePairs(int[] array) {
        tmp = new int[array.length];

        mergeSortUp2Down(array, 0, array.length - 1);

        return (int) (cnt % 1000000007);
    }

    private void mergeSortUp2Down(int[] nums, int first, int last) {
        if (last - first < 1) return;

        int mid = (first + last) / 2;
        //分治思想
        mergeSortUp2Down(nums, first, mid);
        mergeSortUp2Down(nums, mid + 1, last);
        merge(nums, first, mid, last);
    }

    private void merge(int[] nums, int first, int mid, int last) {
        int i = first, j = mid + 1, k = first;

        while (i <= mid || j <= last) {
            if (i > mid) {
                tmp[k] = nums[j];
                j++;
            } else if (j > last) {
                tmp[k] = nums[i];
                i++;
            } else if (nums[i] < nums[j]) {
                tmp[k] = nums[i];
                i++;
            } else {
                tmp[k] = nums[j];
                j++;
                this.cnt += mid - i + 1;//nums[i] > nums[j]说明nums[i...mid]都大于nums[j]
            }
            k++;
        }
        for (k = first; k <= last; k++) {
            nums[k] = tmp[k];
        }
    }
}
