package com.lylng.linkedlist.singleLinkedList;

/**
 * ClassName:HeroNode
 * Package:com.lylng.linkedlist
 * Description:
 * Author:lylng
 * Create:2023/10/13 - 22:46
 * Version:v1.0
 */

// 保存英雄信息
public class HeroNode {
     public int heroNo;
     public String heroName;
     public String nickName;

     public HeroNode next;
     public HeroNode(){}

    public HeroNode(int number,String name,String nickName){
        this.heroNo = number;
        this.heroName = name;
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
