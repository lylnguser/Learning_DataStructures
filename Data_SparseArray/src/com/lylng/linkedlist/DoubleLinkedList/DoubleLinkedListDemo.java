package com.lylng.linkedlist.DoubleLinkedList;


/**
 * ClassName:DoubleLinkedListDemo
 * Package:com.lylng.linkedlist.DoubleLinkedList
 * Description:
 * Author:lylng
 * Create:2023/10/16 - 20:49
 * Version:v1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList1 = new DoubleLinkedList();
        DoubleLinkedList doubleLinkedList2 = new DoubleLinkedList();

        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");

//        doubleLinkedList1.addHerNode1(doubleLinkedList1.getHead(),heroNode1);
//        doubleLinkedList1.addHerNode1(doubleLinkedList1.getHead(),heroNode2);
//        doubleLinkedList1.addHerNode1(doubleLinkedList1.getHead(),heroNode3);


        doubleLinkedList2.addHeroNode3(doubleLinkedList2.getHead(),heroNode1);
        doubleLinkedList2.addHeroNode3(doubleLinkedList2.getHead(),heroNode3);
        doubleLinkedList2.addHeroNode3(doubleLinkedList2.getHead(),heroNode2);

        System.out.println("表1数据~~~");
//        doubleLinkedList1.list(doubleLinkedList1.getHead());
        System.out.println("表2数据~~~");
        doubleLinkedList2.list(doubleLinkedList2.getHead());

        // 链表删除
        System.out.println("链表删除结点后~~~");
//        doubleLinkedList2.deleteNode(doubleLinkedList2.getHead(),heroNode3);

        doubleLinkedList2.list(doubleLinkedList2.getHead());
    }
}
