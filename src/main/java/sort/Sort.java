package sort;

/**
 * 排序算法抽象类,。
 * 实现小到大排序，提供工具方法less、exch、show、isSorted
 * 继承该抽象类只需重写sort方法
 * <p>
 * 插入、希尔、选择、堆、冒泡、快速、归并、基数、计数、桶
 * 许多排序算法的性能与输入模型（初始顺序，数组大小等）都有很大的关系，所以会有不同的适用场景
 *
 * @author YiJie
 * @date May 4, 2017
 */
public abstract class Sort {
    /**
     * 比较次数
     */
    public int compareCount = 0;
    /**
     * 交换次数
     */
    public int exchangeCount = 0;

    /**
     * 打印比较/交换次数
     */
    public void showCount() {
        System.out.println("比较次数:" + compareCount);
        System.out.println("交换次数:" + exchangeCount);
    }

    /**
     * 元素排序。方法内完成对传入数组的ASC排序
     *
     * @param list 不限定排序数组所属类型，只要它是一个Comparable实现类
     */
    public abstract void sort(Comparable[] list);

    /**
     * 比较元素。传入参数必须是Comparable的实现类，实现compareTo方法，比较方式自定义
     *
     * @param x
     * @param y
     * @return 返回x是否小于y
     */
    @SuppressWarnings("unchecked")
    public boolean less(Comparable x, Comparable y) {
        compareCount++;
        return x.compareTo(y) < 0;
    }

    /**
     * 交换元素。
     *
     * @param a 交换元素所在数组
     * @param i 交换下标
     * @param j 交换下标
     */
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        exchangeCount++;
    }

    /**
     * ASC升序打印
     *
     * @param a
     */
    public void show(Comparable[] a) {
        if (a.length == 0) {
            System.out.println("[]");
        }
        System.out.print("[" + a[0]);
        for (int i = 1; i < a.length; i++) {// 这里不能用for-each循环，for-each是基于集合的iterator实现的，数组没有迭代器
            System.out.print(", " + a[i]);
        }
        System.out.println("]");
    }

    /**
     * 在排序循环内打印每趟排序的结果
     *
     * @param i 第i趟
     * @param a 数组序列
     */
    public void showStep(int i, Comparable[] a) {
        System.out.print("第" + i + "趟:");
        show(a);
    }

    /**
     * 检验数组是否升序排列
     *
     * @param a
     * @return
     */
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
