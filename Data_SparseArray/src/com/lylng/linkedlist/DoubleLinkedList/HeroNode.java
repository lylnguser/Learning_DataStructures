package com.lylng.linkedlist.DoubleLinkedList;

/**
 * ClassName:HeroNode
 * Package:com.lylng.linkedlist.DoubleLinkedList
 * Description:
 * Author:lylng
 * Create:2023/10/16 - 20:51
 * Version:v1.0
 */
public class HeroNode {
    int heroNo;
    String heroName;
    String nickName;
    public HeroNode next;
    public HeroNode prior;

    public HeroNode(int no, String heroName, String nickName) {
        this.heroNo = no;
        this.heroName = heroName;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "heroNo=" + heroNo +
                ", heroName='" + heroName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
