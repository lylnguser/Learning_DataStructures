package com.lylng.linkedlist.Stack;

/**
 * ClassName:ArrayToStack
 * Package:com.lylng.linkedlist.Stack
 * Description:
 * Author:lylng
 * Create:2023/10/21 - 21:24
 * Version:v1.0
 */
public class ArrayToStack {
    private int top = -1;   // 栈顶
    private int[] stack;
    private int maxTop;

    public ArrayToStack(int maxTop){
        this.maxTop = maxTop;
        stack = new int[maxTop];    // 数组模拟栈，即用于存放链表数据
    }

    public boolean isFull(){
        return top == maxTop - 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    // 入栈操作
    public void push(int num){
        if(isFull()){
            System.out.println("栈已满，无法执行入栈操作！");
            return;
        }
        top++;
        stack[top] = num;
    }

    // 出栈
    public int pop() {
        int temp = 0;
        if (isEmpty()) {
            System.out.println("栈空,无法执行出栈操作！");
        }
        temp = stack[top];
        top--;
        return temp;
    }

    // 遍历栈
    // 思路：从栈顶开始显示数据
    public void showStack(){
        if(isEmpty()){
            System.out.println("栈为空，无法执行遍历操作！");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
