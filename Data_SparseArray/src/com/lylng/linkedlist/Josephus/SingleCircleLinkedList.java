package com.lylng.linkedlist.Josephus;

/**
 * ClassName:SingleCircleLinkedList
 * Package:com.lylng.linkedlist.Josephus
 * Description:
 * Author:lylng
 * Create:2023/10/17 - 21:42
 * Version:v1.0
 */
public class SingleCircleLinkedList {

    // 首先创建第一个结点
    ListNode first = new ListNode(1);

    // 向链表中添加数据
    public void addListNode(int num){
        // 定义辅助结点
        ListNode addListNode = null;
        for (int i = 1; i <= num; i++) {
            ListNode Node = new ListNode(i);
            if(i == 1){
                first = Node;
                first.setNext(first);
                addListNode = first;
            }
            // 将循环指针添加到后添加的结点上
            Node.setNext(addListNode.getNext());
            // 将结点添加到链表上
            addListNode.setNext(Node);
            // 然后将辅助结点后移
            addListNode = addListNode.getNext();
        }
    }

    // 根据用户的输入，对链表进行结点的输出

    /**
     *
     * @param startNo   开始进行报数的位置
     * @param countNum  表示要出圈的数结点
     * @param nums      表示一共有多少个结点
     */
    public void outListNode(int startNo,int countNum,int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("输入数据有误，请重新输入~~~");
            return;
        }
        // 定义辅助结点,进行遍历结点，然后将结点给抛出
        ListNode last = first;
        // 将last指针指向链表=最后一个结点
        while (true) {
            if (last.getNext() == first) {
                break;
            }
            last = last.getNext();
        }
        // 先让链表的first结点移动到要报数的结点上
        for (int i = 1; i < startNo; i++) {
            first = first.getNext();
            last = last.getNext();
        }

        // 小孩开始出圈时，指针同时的移动m-1，然后出圈
        // 当只有一个结点时，循环结束
        while (true) {
            // 结束条件
            if (last == first) {
                break;
            }
            // 开始报数
            // 当位置到要出圈的位置时
            // 思路：1.first的位置到达待删除位置的前一个位置，然后停止
            for (int i = 1; i < countNum; i++) {
                first = first.getNext();
                last = last.getNext();
            }
            // 这时，结点first结点就是要出圈的结点
            System.out.printf("孩子%d出圈\n", first.getValue());
            // 执行结点删除操作
            first = first.getNext();
            last.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩是%d",first.getValue());
    }

    // 遍历链表
    public void list(){
        // 判断链表是否为空
        if(first == null){
            System.out.println("链表为空");
        }
        ListNode lit = first;
        while(true){
            System.out.println(lit);
            if(lit.getNext() == first){
                break;
            }
            lit = lit.getNext();
        }
    }
}
