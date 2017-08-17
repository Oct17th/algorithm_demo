package datastructure;

/**
 * 链表翻转
 *
 * @author YiJie 2017/8/17.
 */
public class LinkedListReverse {
    //    private Node<Integer> head = new Node<Integer>(1);//一个单向链表

    private static LinkedList<Integer> linkedList = new LinkedList<Integer>(1);
    private static LinkedList.Node head = linkedList.add(new Integer[]{2, 3, 4, 5, 6, 7, 8}).getHead();

    @org.junit.Test
    public void testtraverseReverse() {
        traverseReverse(head);
//        printHead(head);
    }

    @org.junit.Test
    public void testrecursionReverse() {
        recursionReverse(head);
//        printHead(head);
    }


    /**
     * 打印链表
     *
     * @param head
     */
    private static void printHead(LinkedList.Node head) {
        System.out.print(head.getData());
        LinkedList.Node curr = head.getNext();
        while (curr != null) {
            System.out.print("-->" + curr.getData());
            curr = curr.getNext();
        }
    }

    /**
     * 遍历翻转：从前往后反转各个结点的指针域的指向
     *
     * --->测试更为低效
     *
     * @param node
     */
    private static void traverseReverse(LinkedList.Node node) {
        LinkedList.Node pre = null;
        LinkedList.Node curr = node;
        LinkedList.Node temp = node.getNext();
        while (true) {
            curr.setNext(pre);
            if (temp == null) {
                head = curr;
                return;
            }
            pre = curr;
            curr = temp;
            temp = temp.getNext();
        }
    }

    /**
     * 递归翻转：从后往前逆序反转指针域的指向
     *
     * @param node
     */
    private static void recursionReverse(LinkedList.Node node) {
        if (node.getNext() == null) {
            head = node;
            return;
        }
        recursionReverse(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
    }

}

/**
 * 单链表数据结构
 */
class LinkedList<T> {

    /**
     * 头结点
     */
    private Node<T> head;
    /**
     * 当前结点
     */
    private Node<T> curr;

    public LinkedList(T headData) {
        this.head = new Node<T>(headData);
        this.curr = this.head;
    }

    public LinkedList<T> add(T data) {
        Node<T> node = new Node<T>(data);
        if (head.equals(curr)) {
            head.next = node;
        }
        curr.next = node;
        curr = curr.next;
        return this;
    }

    public LinkedList<T> add(T[] dataList) {
        for (T data : dataList) {
            add(data);
        }
        return this;
    }

    public Node<T> getHead() {
        return head;
    }

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}