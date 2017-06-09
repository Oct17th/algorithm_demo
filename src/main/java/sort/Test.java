package sort;

import java.util.Scanner;

/**
 * 排序算法测试类
 *
 * @author YiJie  2017/6/4
 **/
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组（以逗号或空格符分隔）：");
        String[] s = in.nextLine().split("[ ,，]+");//读取输入元素
        Integer[] list = new Integer[s.length];
        try {
            for (int i = 0; i < s.length; i++) {//转换为Integer数组
                list[i] = Integer.parseInt(s[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("输入元素类型不合法！");
        }
//        Integer[] list = new Integer[]{77, 75, 52, 32, 21, 8, 12};
//        list = new Integer[]{7, 5, 5, 28, 757, 3, 45};
        Sort bs = new BinaryInsertSort();//选择用哪种方式排序
        bs.show(list);
        bs.sort(list);
        bs.showCount();
//        bs.show(list);
    }

}
