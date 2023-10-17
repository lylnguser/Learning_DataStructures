package com.lylng.linkedlist.Josephus;

import com.lylng.linkedlist.singleLinkedList.SingleLinkedList;

/**
 * ClassName:Josephus
 * Package:com.lylng.linkedlist.Josephus
 * Description:
 * Author:lylng
 * Create:2023/10/17 - 21:41
 * Version:v1.0
 */
public class Josephus {
    public static void main(String[] args) {
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();

        singleCircleLinkedList.addListNode(30);
        singleCircleLinkedList.list();
    }
}
