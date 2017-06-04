package sort;

/**
 * 冒泡排序：每个数依次与自己后面的数比较，小数上提，大数下压
 * <p>
 * 我理解的冒泡排序是一种比较差的选择排序，通过相邻比较交换（逐个下压）的方式选出最大值，交换次数较选择排序多，
 * 但保证了稳定性，并且在前期交换的过程中，序列逐渐变得部分有序
 * <p>
 * 稳定性：稳定
 * 优化：1.大数下沉到底端标记比较终止位置（后面数组已排序完成 ）   2.鸡尾酒排序/双向冒泡排序
 *
 * @author YiJie
 * @date May 4, 2017
 */
public class BubbleSort extends Sort {

    /**
     * 原理：每个数依次与自己后面的数比较，大数下压
     *
     * @param list
     **/
    @Override
    public void sort(Comparable[] list) {
        for (int i = 1, length = list.length; i < length; i++) {//每次循环将一个最大值压底
            for (int j = 0; j < length - i; j++) {//后i个值已经排好序，不再比较
                if (less(list[j + 1], list[j])) {//每个数依次与自己后面的数比较
                    exch(list, j + 1, j);
                }
            }
            System.out.print("第" + i + "趟:");
            show(list);
        }
    }
}

/**
 * 双向冒泡排序
 */
class CocktailSort extends Sort {

    @Override
    public void sort(Comparable[] list) {
        for (int high = list.length - 1, low = 0; low < high; low++) {
            for (int i = low; i < high; i++) {//大数下沉
                if (less(list[i + 1], list[i])) {
                    exch(list, i + 1, i);
                }
            }
            //本趟大数已下沉到末端，high自减 ，省去一次比较
            for (int i = --high; i > low; i--) {//小数上浮
                if (less(list[i], list[i - 1])) {
                    exch(list, i, i - 1);
                }
            }
            showStep(low,list);
        }
    }
}