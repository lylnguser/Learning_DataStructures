package com.lylng.queue;

/**
 * ClassName:ArrayQueue
 * Package:com.lylng.queue
 * Description:
 * Author:lylng
 * Create:2023/10/12 - 15:42
 * Version:v2.0
 */

// 用数组来模拟队列
public class ArrayQueue {
    private int maxSize;   // 表示数组最大容量
    private int front;      // 队列头
    private int rear;       // 队列尾
    private int[] arr;

    public ArrayQueue(int arrMaxQueue){
        maxSize = arrMaxQueue;
//        front = -1;
//        rear = -1;
        // 优化后：
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    // 判断队列是否已满
    // 当rear = maxQueue-1时，队列为满

    // 优化判断此时初始话front = 0 rear = 0 ,当 (rear+1) % maxSize = front即可判断为空
    public boolean isFull(){
        return ((rear + 1)% maxSize) == front;
    }
    // 判断队列是否为空
    // 当rear == front 时，队列为空
    public boolean isEmpty(){
        return front == rear;
    }

    // 向队列中存数据
    public void addQueue(int n){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列已满，无法添加数据~~");
            return;
        }
        // 赋值n给arr[rear]
        // 然后将(rear+1)%maxSize即将rear向后移动一个位置
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 从队列中取数据
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取数据~~");
        }
        // 利用临时变量保存arr[front]数据
        int value = arr[front];
        // 防止front一直增加上去，然后超出数组最大下标
        front = (front + 1) % maxSize;
        // 返回临时变量值
        return value;
    }
    // 显示队列数据
    public void showQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据~~~");
        }
        // 通过计算的队列中的有效数据+front的值作为便利的限制条件
        // 然后从front开始便利，
        // 在便利过程中通过front%maxSize来控制遍历位置在队列中
        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",(i % maxSize),arr[i % maxSize]);
        }
    }

    // 计算队列中的有效数值的个数
    /*-
    方法：(rear + maxSize - front) % maxSize
    分析：
    1.当rear在增加的过程中，rear<=maxSize-1，front<rear时，有效数值个数即为 rear - front
    2.当rear在增加过程中,rear<front时，如果要计算有效数值的个数时，要添加上maxSize可进行(rear - front + maxSize)
    3。保证计算的有效数值的个数小于maxSize，即在进行取余(rear - front + maxSize) % maxSize
     */
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列头数据，不是取数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
