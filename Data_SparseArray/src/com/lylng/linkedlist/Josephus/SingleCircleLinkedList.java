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

    // 出链表问题
    public void outOfListNode(int data){
        if(first == null){
            System.out.println("空链表~~~");
            return ;
        }
        // 定义辅助结点
        ListNode out = first.getNext();
        while()

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
