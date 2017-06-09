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
 * （当 n 较大时）直接插入排序的最好情况 < 二分插入排序的比较次数 < 直接插入排序的最差情
 * 所当以元素初始序列已经接近升序时，直接插入排序比二分插入排序比较次数少。
 * 二分插入排序元素移动（交换）次数与直接插入排序相同，依赖于元素初始序列。
 * <p>
 * 稳定性：稳定
 * 适用场景：n较大的无序序列
 *
 * @author YiJie  2017/6/4
 **/
class BinaryInsertSort extends Sort {

    /**
     * 将n插入[0,n-1]数组，比较log2 N次方
     * @param list 不限定排序数组所属类型，只要它是一个Comparable实现类
     */
    @Override
    public void sort(Comparable[] list) {
        for (int i = 0, length = list.length; i < length - 1; i++) {
            for (int low = 0, high = i, mid = (low + high) / 2; ; mid = (low + high) / 2) {
                System.out.println("high =" + high + " low = " + low);
                if (low == mid) {//找到插入位置
                    System.out.println((i + 1) + "换到" + (mid));
                    for (int j = i; j >= mid; j--) {
                        exch(list, j + 1, j);//把j+1向上逐步交换，插到mid+1
                    }
                    break;
                }
                if (less(list[i + 1], list[mid])) {
                    high = (mid - 1) < 0 ? 0 : mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            showStep(i, list);
        }
    }

}


/**
 * 希尔排序/增量递减排序。插入排序的一种高速而稳定的改进版本
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率，但对乱序的序列，插入排序每次只能移动一小步。
 * 希尔排序会用较大的步长移动数据，在前期逐步将序列往有序靠近
 * <p>
 * 稳定性：不稳定
 *
 * @author YiJie  2017/6/4
 **/
class ShellSort extends Sort {

    @Override
    public void sort(Comparable[] list) {

    }

}
