package com.lylng.linkedlist.Stack;

/**
 * ClassName:ListNode
 * Package:com.lylng.linkedlist.Stack
 * Description:
 * Author:lylng
 * Create:2023/10/21 - 22:48
 * Version:v1.0
 */
public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}
