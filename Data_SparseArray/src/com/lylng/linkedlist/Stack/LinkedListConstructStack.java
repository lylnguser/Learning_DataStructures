package com.lylng.linkedlist.Stack;

import java.util.Stack;

/**
 * ClassName:LinkedListConstuctStack 链表实现栈
 * Package:com.lylng.linkedlist.Stack
 * Description:
 * Author:lylng
 * Create:2023/10/21 - 22:46
 * Version:v1.0
 */
public class LinkedListConstructStack {
    private ListNode head = new ListNode(-1);

    public ListNode getHead(){
        return head;
    }

    // 栈空
    public boolean isEmpty(){
        return head.getNext() == null;
    }

    // 入栈操作，因为是链表，最好的入栈方式，就是从前增加头结点，出栈也类似、
    public void push(int num){
        // 创建一个Node
        ListNode Node = new ListNode(num);
        Node.setNext(head.getNext());
        head.setNext(Node);
    }

    // 出栈操作
    // 思路：直接返回首元结点数据即可，同时也是按照栈的原则“后进先出”
    // 返回的数据：定义一个中间变量，然后把结点的数据给变量，然后返回变量
    public int pop(){
        int data = 0;
        if(isEmpty()){
            System.out.println("栈为空，无法执行出栈操作~~~");
        }
        ListNode Node = head.getNext();
        data = Node.getValue();
        head.setNext(Node.getNext());

        return data;
    }

    // 遍历栈
    public void showStack(){
        // 判断栈是否为空
        if(isEmpty()){
            System.out.println("栈为空，无法执行显示操作~~~");
            return;
        }
        ListNode temp = head.getNext();
        while(temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    // 得到栈顶的值，而不需要实施出栈操作
    public int peek(){
        if(isEmpty()){
            System.out.println("栈空，无法执行peek操作~~~");
        }
        ListNode Peek = head.getNext();
        return Peek.getValue();
    }

    // 定义符号的优先级
    // 目前的表达式只有"+-*/"
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else{
            return -1;
        }
    }

    // 判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        // 用于存放计算的结果
        int res = 0;
        switch(oper){
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}

