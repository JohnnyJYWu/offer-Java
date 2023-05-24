package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author JohnnyJYWu
 */

public class T63_Median {
    //数据流中的中位数

    private int count = 0;//计数，判断奇偶
    //使用自动排序的PriorityQueue,两个堆详情见图片
    //小顶推：默认从小到大排序，堆顶为最小数，用于存储后半部分较大的数，堆顶用于计数中位数
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //大顶堆：声明从大到小排序，堆顶为最大数，用于存储前半部分较小的数，堆顶用于计数中位数
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer arg0, Integer arg1) {
            return arg1 - arg0;
        }
    });

    public void Insert(Integer num) {
        //分奇偶次插入，一半入小顶堆，一半入大顶堆，保证两个堆数量一半一半
        if (count % 2 == 0) {//注意这里0为第1个数，所以插入时奇数次对应的count为偶数
            //奇数次插入时，最终入小顶堆
            //注意插入时是先入大顶堆，由大顶堆排序后取大顶堆最大的插入小顶堆

            //插入大顶堆
            maxHeap.offer(num);
            //取大顶堆堆顶
            int maxInMaxHead = maxHeap.poll();
            //堆顶插入小顶堆
            minHeap.offer(maxInMaxHead);
        } else {
            //偶数次插入时，最终入大顶堆
            //原理同上

            //插入小顶堆
            minHeap.offer(num);
            //取小顶堆堆顶
            int minInMinHead = minHeap.poll();
            //堆顶入大顶堆
            maxHeap.offer(minInMinHead);
        }

        count++;
    }

    @SuppressWarnings("deprecation")
    public Double GetMedian() {
        //由于先入小顶堆，小顶堆数量总是比大顶堆多1或相等
        //所以这里，count为奇次时，插入了奇数次，中位数是小顶堆堆顶
        //count为偶次时，插入了偶数次，中位数是两堆堆顶平均数
        if (count % 2 == 0) {
            return new Double(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}
