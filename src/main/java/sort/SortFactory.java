package sort;

/**
 * 排序工厂
 *
 * @author YiJie  2017/6/4
 **/
public class SortFactory {
    public Sort getBubbleSort(){
        return new BubbleSort();
    }
}
 