package com.lylng.linkedlist.singleLinkedList;

/**
 * ClassName:SingleLinkedListDemo
 * Package:com.lylng.linkedlist
 * Description:
 * Author:lylng
 * Create:2023/10/13 - 23:32
 * Version:v1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"吴用","智多星");
        HeroNode hero3 = new HeroNode(3,"林冲","豹子头");
        HeroNode hero4 = new HeroNode(3,"林冲","豹子头");

        // 创建一个单链表
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

        // 向链表中添加数据
        singleLinkedList1.addHero2(singleLinkedList1.getHead(),hero1);
        singleLinkedList1.addHero2(singleLinkedList1.getHead(),hero3);
        singleLinkedList1.addHero2(singleLinkedList1.getHead(),hero2);
        singleLinkedList1.addHero2(singleLinkedList1.getHead(),hero4);
        singleLinkedList1.list();
//        //
        // 重新设置头指针
//        singleLinkedList2.addHero3(singleLinkedList2.getHead(),hero1);
//        singleLinkedList2.addHero3(singleLinkedList2.getHead(),hero3);
//        singleLinkedList2.addHero3(singleLinkedList2.getHead(),hero4);
//        singleLinkedList2.addHero3(singleLinkedList2.getHead(),hero2);

        // 显示链表数据

        System.out.println("修改数据前~~~");
        singleLinkedList1.list();



        System.out.println("修改数据后~~~");
        HeroNode newHeroNode1 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode newHeroNode2 = new HeroNode(3,"吴用","智多星");
        singleLinkedList1.alterNode(newHeroNode1);
        singleLinkedList1.alterNode(newHeroNode2);
        singleLinkedList1.list();
//        System.out.println("删除数据前~~~");
//        singleLinkedList1.list();

//        System.out.println("删除数据后~~~");
//        singleLinkedList1.deleteNode(hero3);
//        singleLinkedList1.deleteNode(hero1);
//        singleLinkedList1.deleteNode(hero2);
//        singleLinkedList1.list();

        System.out.println("第二个链表~~~");
        singleLinkedList2.list();
        // 显示有效长度
        System.out.println(singleLinkedList1.sizeNode(singleLinkedList1.getHead()));
        // 显示倒数第几个链表数据
        HeroNode h1 = singleLinkedList1.reciverNode(1, singleLinkedList1.sizeNode(singleLinkedList1.getHead()));
        System.out.println(h1);

        // 将链表进行反转
        System.out.println("反转链表之后~~~");
        singleLinkedList1.reversNode(singleLinkedList1.getHead());
        singleLinkedList1.list();

        // 测试反向输出链表数据，不破坏链表数据
        System.out.println("反向输出链表数据，为破坏链表结构~~~");
        singleLinkedList1.showReverseNode(singleLinkedList1.getHead(), singleLinkedList1.sizeNode(singleLinkedList1.getHead()));

    }
}
