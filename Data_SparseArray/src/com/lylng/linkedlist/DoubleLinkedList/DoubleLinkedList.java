package com.lylng.linkedlist.DoubleLinkedList;

/**
 * ClassName:DoubleLinkedList
 * Package:com.lylng.linkedlist.DoubleLinkedList
 * Description:
 * Author:lylng
 * Create:2023/10/16 - 20:50
 * Version:v1.0
 */
public class DoubleLinkedList {
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return this.head;
    }

    // 判断是不是空链表
    public boolean isEmpty(){
        return head.next == null;
    }

    // 便利双向链表
    public void list(HeroNode head){
        // 判断链表是否到末端结点
        if (isEmpty()) {
            System.out.println("链表为空~~~");
            return;
        }
        // 定义辅助结点，方便便利
        HeroNode cur = head.next;
        while(cur != null){
            System.out.println(cur);
            cur = cur.next;
        }
    }

    // 向双向表中添加数据
    // 思路：向链表第一个结点添加
    public void addHerNode1(HeroNode head,HeroNode heroNode){
        // 如何判断末端结点
        heroNode.next = head.next;
        heroNode.prior = head;
        head.next = heroNode;
    }

    // 尾插法
    public void addHeroNode2(HeroNode head,HeroNode heroNode){
        //定义辅助结点
        HeroNode cur = head;
        while(true){
            if(cur.next == null){
                break;
            }
            cur = cur.next;
        }
        cur.next = heroNode;
        heroNode.prior = cur;
    }

    // 添加方法，让添加的结点按照结点的某一特征进行排序添加
    public void addHeroNode3(HeroNode head,HeroNode heroNode){
        // 定义辅助结点
        HeroNode add = head;
        while(true){
            if(add.next == null){
                break;
            }
            // 判断结点的下一个结点是否大于heroNode结点的某一特征值
            if(add.next.heroNo > heroNode.heroNo){
                break;
            }
            add = add.next;
        }
        heroNode.next = add.next;
        add.next = heroNode;
        heroNode.prior = add;
    }

    // 双链表删除结点

    public void deleteNode(HeroNode head,HeroNode heroNode){
        // 首先判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空~~~");
            return;
        }

        // 定义辅助结点来进行遍历
        HeroNode del = head.next;
        while(true){
            // 当链表便利到末端结点，没找到，即返回
            if(del == null){
                System.out.println("没找到待删除数据，无法执行删除操作");
                break;
            }
            if(del.heroNo == heroNode.heroNo){
                break;
            }
            del = del.next;
        }
        // 循环结束，即找到待删除结点
        del.prior.next = del.next;
        // 当要删除最后一个结点时，下面的操作会导致空指针异常
        // 解决办法，当要删除最后一个结点时，即不需要执行下面的操作
        // 加上判断，即当del是最后一个结点时，则不执行
        if(del.next != null){
            del.next.prior = del.prior;
        }
    }
}
