package com.algorithm.linklist;

/**
 * Created by OY on 2020/4/11.
 */
public class Test {

    @org.junit.Test
    public void test() {
        LinkList list = new LinkList();
        //添加节点
        System.out.println("添加节点");
        AnimalNode n1 = new AnimalNode(1, "Tiger");
        AnimalNode n2 = new AnimalNode(2, "Horse");
        AnimalNode n3 = new AnimalNode(3, "Glass");

        list.add(n1);
        list.add(n2);
        list.add(n3);
        //打印节点
        System.out.println("打印节点:" + list.getSize() + "=" + list.getSizeByIterate());
        list.show();
        //查找倒数第n个节点
        int n = 2;
        AnimalNode lastNode = list.getLastNode(n);
        System.out.println("倒数第" + n + ":" + lastNode.toString());

    }
}

class LinkList {
    private int size;
    private AnimalNode head;

    public LinkList() {
        head = new AnimalNode(-1, null);
    }

    /**
     * 添加节点
     * @param newNode
     */
    public void add(AnimalNode newNode) {
        if (newNode == null) {
            return;
        }
        AnimalNode next = head;
        while (next.getNext() != null) {
            if (newNode.getNo() == next.getNo()) {
                System.out.println("节点已存在");
                return;
            }
            next = next.getNext();
        }
        next.setNext(newNode);
        //计数器
        size ++;
    }

    /**
     * 打印节点
     */
    public void show() {
        AnimalNode next = head.getNext();
        while (next != null) {
            System.out.println(next.toString());
            next = next.getNext();
        }
    }

    public int getSizeByIterate(){
        if (empty()) {
            return 0;
        }
        int size = 0;
        AnimalNode next = head.getNext();
        while (next != null){
            size ++;
            next = next.getNext();
        }
        return size;
    }

    /**
     * 获取倒数第n个node，两种方法：
     *  1.第一次遍历获取链表长度k，第二次遍历 k-n 次即为倒数第n个节点
     *  当链表结构中没有记录长度的字段，两次遍历的时间复杂度为O(k * (k-n))
     *  第一种实现方式略
     *  2.采用双指针进行遍历
     * @param n
     * @return
     */
    public AnimalNode getLastNode(int n){
        //判断链表是否为空
        if (empty()){
            return null;
        }
        AnimalNode next = head;
        for (int i = 0; i < n; i ++){
            next = next.getNext();
        }
        AnimalNode p = next;
        next = head;
        while (p != null){
            p = p.getNext();
            next = next.getNext();
        }
        return next;
    }


    public boolean empty() {
        if (head.getNext() == null) {
            System.out.println("链表为空~~");
            return true;
        }
        return false;
    }

    //修改数据

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public AnimalNode getHead() {
        return head;
    }

    public void setHead(AnimalNode head) {
        this.head = head;
    }
}

class AnimalNode {
    private int no;
    private String name;
    private AnimalNode next;

    public AnimalNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnimalNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalNode getNext() {
        return next;
    }

    public void setNext(AnimalNode next) {
        this.next = next;
    }
}
