package sort;

/**
 * 插入排序。在原序列中按顺序拿值，放入有序列中（从后往前逐一）比较找到插入位置
 * <p>
 * 比较次数：[N-1, N^2/4, N^2/2]     可以通过二分查找减少
 * 交换系数：[0, N^2/4, N^2/2]   每个插入位置后的数要在比较中逐一后移，故可以通过链表实现减少交换次数
 * 稳定性：稳定
 * 特点：1.适合部分有序或是小规模的数组
 * 2.设数组中倒置的数量为 M，数组大小为 N，则需交换次数 = M，M <= 需比较次数 <= M+N-1，
 * 适用场景：
 * 优化：二分插入排序
 *
 * @author YiJie  2017/6/4
 **/
public class InsertSort extends Sort {

    @Override
    public void sort(Comparable[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {//前j-1个看做有序数组，每趟把list[i]加入这个有序数组中
                if (less(list[j], list[j - 1])) {
                    exch(list, j, j - 1);
                } else {
                    break;//list[j]<list[j-1]不成立，则确定插入位置，插入成功，跳出循环，不再进行多余比较
                }
            }
            showStep(i, list);
        }
    }
}

/**
 * 二分插入排序/折半插入排序
 */
class BinaryInsertSort extends Sort {

    @Override
    public void sort(Comparable[] list) {

    }
}

/**
 * 希尔排序。插入排序的一种高速而稳定的改进版本
 *
 * @author YiJie  2017/6/4
 **/
class ShellSort extends Sort {

    @Override
    public void sort(Comparable[] list) {

    }

}
