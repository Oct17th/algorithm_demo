package sort;

/**
 * 选择排序。每次在原序列中比较找到最小值，放入有序序列末端
 * <p>
 * 比较次数：N^2/2
 * 交换次数：N
 * 稳定性：不稳定  （可以通过新开数组或链表实现解决）
 * 特点：1.（平均）交换次数最少  2.最好最坏情况相同（排序所需时间与数组初始顺序无关）
 * 适用场景：
 * 优化：二元选择，双向比较
 *
 * @author YiJie  2017/6/4
 **/
public class SelectSort extends Sort {

    @Override
    public void sort(Comparable[] list) {
        int min;
        for (int i = 0; i < list.length - 1; i++) {
            min = i;//标记本趟最小值
            for (int j = i + 1; j < list.length; j++) {
                if (less(list[j], list[min])) {
                    min = j;
                }
            }
            exch(list, i, min);
            System.out.print("第" + i + "趟：");
            show(list);
        }
    }
}

/**
 * 双向选择排序
 */
class TwoWaySelectSort extends Sort {
    @Override
    public void sort(Comparable[] list) {
        int min, max;
        for (int i = 0, length = list.length - 1; i < length; i++, length--) {
            min = i;//标记本趟最小值
            max = length;//标记本趟最大值
            for (int j = i + 1; j < list.length; j++) {
                if (less(list[j], list[min])) {
                    min = j;
                }
                if (less(list[max], list[j])) {
                    max = j;
                }
            }
            exch(list, i, min);
            showStep(i, list);
        }
    }
}