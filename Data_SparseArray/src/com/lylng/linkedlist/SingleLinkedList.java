package com.lylng.linkedlist;

import com.sun.security.jgss.GSSUtil;

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
    private HeroNode head = new HeroNode(0,"","");

    // 添加节点到单链表中
    // 思路：当不考虑编号顺序时
    // 1.找到当前链表的最后一个结点
    // 2.最后一个结点的next指向新结点

    public void addHero1(HeroNode heroNode){
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
    public void addHero2(HeroNode heroNode){
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


    // 链表结点数据修改

    public void alterNode(int number,String name,String nickName){
        // head结点不能动
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            // 当找到链表末端结点还是没有找到，即推出
            if(temp.next == null){
                // 遍历链表到末端
                break;
            }
            if(temp.next.heroNo == number){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 修改数据
        if(flag){
            temp.next.heroName = name;
            temp.next.nickName = nickName;
        }else{
            System.out.println("未找到修改编号，无法进行修改操作");
        }
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
