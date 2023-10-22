package com.lylng.queue;

/**
 * ClassName:LinkedListToQueue  使用链表来实现队列
 * Package:com.lylng.queue
 * Description:
 * Author:lylng
 * Create:2023/10/22 - 16:30
 * Version:v1.0
 */
public class LinkedListToQueue {
    // 定义头结点
    private ListNode head = new ListNode(-1);

    public ListNode getHead(){
        return this.head;
    }

    // 队列为空
    public boolean isEmpty(){
        return head.getNext() == null;
    }

    // 队列头
    public ListNode getFront(){
        if(isEmpty()){
            System.out.println("队列为空，没有队头元素");
            return null;
        }
        ListNode front = head.getNext();
        return front;
    }

    // 队列尾
    public ListNode getRear(){
        // 判断链表是否为空
        if(isEmpty()){
            System.out.println("队列为空~~~");
            return null;
        }
        //定义遍历节点
        ListNode rear = head;
        while(true){
            if(rear.getNext() == null){
                break;
            }
            rear = rear.getNext();
        }
        return rear;
    }

    // 入队
    // 思路：采用的方式是末端添加的方式，将后入队的数据添加在后面
    // 出队的时候就不需要在遍历连=链表到最后

    public void push(int num){
        // 定义中间结点
        ListNode Node = new ListNode(num);
        ListNode temp = head;
        while(true){
            if(temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
        }
        // 位置到达最后一个结点
        Node.setNext(temp.getNext());
        temp.setNext(Node);
    }

    // 出队操作
    // 思路：出队方式，从链表首元结点进行队列的出队操作
    public ListNode pop(){
        if(isEmpty()){
            System.out.println("队列为空，无法执行出队操作！！！");
        }
        ListNode Node = head.getNext();
        head.setNext(Node.getNext());
        return Node;
    }

    // 遍历队列
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空，无法执行遍历操作！！！");
            return ;
        }
        // 定义遍历结点链表
        ListNode temp = head.getNext();
        while(temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}
