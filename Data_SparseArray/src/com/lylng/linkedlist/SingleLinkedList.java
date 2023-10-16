package com.lylng.linkedlist;

import com.sun.security.jgss.GSSUtil;

import java.util.Stack;

/**
 * ClassName:SingleLinkedList
 * Package:com.lylng.linkedlist
 * Description:
 * Author:lylng
 * Create:2023/10/13 - 22:21
 * Version:v1.0
 */

// 利用单链表来制作一个水浒传英雄排行
public class SingleLinkedList {
    // 定义一个头结点
    private HeroNode head = new HeroNode(0," "," ");

    public HeroNode getHead(){
        return head;
    }

    // 添加节点到单链表中
    // 思路：当不考虑编号顺序时
    // 1.找到当前链表的最后一个结点
    // 2.最后一个结点的next指向新结点

    public void addHero1(HeroNode head,HeroNode heroNode){
        // 头结点不能动，需要一个辅助指针
        HeroNode temp = head;
        // 遍历链表，找到最后一个结点
        while(true){
            // 当temp.next == null 即找到最后一个结点
            if(temp.next == null){
                break;
            }
            // 如果没有知道到，即temp后移
            temp = temp.next;
        }

        // 循环结束，即temp是最后一个结点
        temp.next = heroNode;
    }

    // 添加结点方式二
    public void addHero2(HeroNode head,HeroNode heroNode){
        // 辅助结点
        HeroNode temp = head;
        // 是否存在相同排名
        boolean flag = false;
        // 找到添加的位置
        while(true) {
            // 当链表为空或到链表末端结点，则直接添加结点
            if (temp.next == null) {
                break;
            }
            // 判断是否存在相同排名
            if(temp.next.heroNo == heroNode.heroNo){
                flag = true;
                break;
            }else if(temp.next.heroNo > heroNode.heroNo){
                break;
            }
            temp = temp.next;
        }
        // 已经找到了位置
        if(flag){
            System.out.printf("英雄编号%d已经存在，无法添加\n",heroNode.heroNo);
        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 头插法
    public void addHero3(HeroNode head,HeroNode heroNode){
        // 思路，只需要一个头结点即可
        heroNode.next = head.next;
        head.next = heroNode;
    }


    // 链表结点数据修改

    public void alterNode(HeroNode heroNode){
        // head结点不能动
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            // 当找到链表末端结点还是没有找到，即推出
            if(temp == null){
                // 遍历链表到末端
                break;
            }
            if(temp.heroNo == heroNode.heroNo){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 修改数据
        if(flag){
            temp.heroName = heroNode.heroName;
            temp.nickName = heroNode.nickName;
        }else{
            System.out.println("未找到修改编号，无法进行修改操作");
        }
    }

    // 删除结点数据
    public void deleteNode(HeroNode deleteNode){
        // 定义辅助结点
        HeroNode temp = head;
        boolean flag = false;

        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.heroNo == deleteNode.heroNo){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 循环结束，得到flag的值
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("待删除的英雄编号%d为在数据中，无法执行删除操作");
        }
    }

     // 返回链表倒数第几个数据
    public HeroNode reciverNode(int number,int size){
        // 返回链表数据，先判断链表是否为空
        if(head.next == null){
            return null;
        }
        // 定义一个中间变量，头结点不能动
        // current
        HeroNode current = head.next;
        boolean flag = false;
        // 判断链表是否为空
        if(head.next == null){
            return null;
        }
        // 添加判断条件，当输入的数字大于链表有效数字长度，即返回null
        if(number <= 0 || number > size){
            return null;
        }
        for (int i = 0; i < size - number; i++) {
            current = current.next;
        }
        return current;
    }

     // 将单链表进行反转
    // 会破坏链表的原有的结构
    public void reversNode(HeroNode head){
        // 判断链表是否为空
        if(head.next == null || head.next.next == null){
            return ;
        }
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reversHead = new HeroNode(0,"","");

        // 遍历原来的链表，并将头结点添加到
        while(temp != null){
            next = temp.next; // 保存当前结点的下一个结点
            temp.next = reversHead.next;
            reversHead.next = temp; // 将链表的首元结点插入到reverseHead结点之后
            temp = next;
        }
        head.next = reversHead.next;    // 重新链接head结点
    }

    // 将链表数据反向输出，但是不破坏原有链表结构
    // 方法：利用好栈结构来进行实现
    public void showReverseNode(HeroNode heroNode,int size) {
        // 定义中间变量
        HeroNode current = head.next;
        // 首先先判断链表是否为空
        if (head.next == null) {
            return;
        }
        // 判断是否只有一个结点的链表
        if (head.next.next == null) {
            System.out.println(head.next);
        }
        // 定义一个栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        // 遍历链表并加入到栈中
        while (true) {
            if (current == null){
                break;
            }
            stack.push(current);
            current = current.next;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(stack.pop());
        }
    }
     // 获取链表有效长度
    public int sizeNode(HeroNode head){
        int sum = 0;
        HeroNode cur = head.next;
        while(true){
            if(cur == null){
                break;
            }
            sum ++;
            cur = cur.next;
        }
        return sum;
    }

    // 显示链表
    // 遍历链表
    public void list(){
        // 判断链表是否为空
        // 即判断head.next是否为null
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        // 头结点不能动，利用辅助结点来进行遍历
        HeroNode temp = head.next;
        while(true){
            // 判断链表是否到最后
            if(temp == null){
                break;
            }
            System.out.println(temp);
            // 输出结点数据后，将结点进行后移
            temp = temp.next;
        }
    }
}
