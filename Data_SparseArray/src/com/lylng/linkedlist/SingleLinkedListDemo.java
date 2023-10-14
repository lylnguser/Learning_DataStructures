package com.lylng.linkedlist;

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
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        // 向链表中添加数据
        singleLinkedList.addHero2(hero1);
        singleLinkedList.addHero2(hero3);
        singleLinkedList.addHero2(hero2);
        singleLinkedList.addHero2(hero4);

        // 显示链表数据

        System.out.println("修改数据前~~~");
        singleLinkedList.list();

        singleLinkedList.alterNode(2,"卢俊义","玉麒麟");
        singleLinkedList.alterNode(3,"吴用","智多星");

        System.out.println("修改数据后~~~");
        singleLinkedList.list();

        System.out.println("删除数据前~~~");
        singleLinkedList.list();

        System.out.println("删除数据后~~~");
        singleLinkedList.deleteNode(hero2);
        singleLinkedList.list();
    }
}
