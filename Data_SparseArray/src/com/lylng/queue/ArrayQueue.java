package com.lylng.queue;

/**
 * ClassName:ArrayQueue
 * Package:com.lylng.queue
 * Description:
 * Author:lylng
 * Create:2023/10/12 - 15:42
 * Version:v1.0
 */

// 用数组来模拟队列
public class ArrayQueue {
    private int maxQueue;   // 表示数组最大容量
    private int front;      // 队列头
    private int rear;       // 队列尾
    private int[] arr;

    public ArrayQueue(int arrMaxQueue){
        maxQueue = arrMaxQueue;
        front = -1;
        rear = -1;
        arr = new int[maxQueue];
    }

    // 判断队列是否已满
    // 当rear = maxQueue-1时，队列为满
    public boolean isFull(){
        return rear == maxQueue -1;
    }

    // 判断队列是否为空
    // 当rear == front 时，队列为空
    public boolean isEmpty(){
        return front == rear;
    }

    // 向队列中存数据
    public void addQueue(int n){
        if(isFull()){
            throw new RuntimeException("队列已满，无法添加数据");
        }
        rear++;
        arr[rear] = n;
    }

    // 从队列中取数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取数据~~");
        }
        front++;
        return arr[front];
    }
    // 显示队列数据

    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    // 显示队列头数据，不是取数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
