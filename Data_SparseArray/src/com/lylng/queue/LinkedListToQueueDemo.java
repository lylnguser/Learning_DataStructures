package com.lylng.queue;

import java.util.Scanner;

/**
 * ClassName:LinkedListToQueueDemo
 * Package:com.lylng.queue
 * Description:
 * Author:lylng
 * Create:2023/10/22 - 17:01
 * Version:v1.0
 */
public class LinkedListToQueueDemo {
    public static void main(String[] args) {
        // 首先创建一个队列
        LinkedListToQueue Queue = new LinkedListToQueue();

        Scanner reader = new Scanner(System.in);
        String key = "";

        boolean flag = true;
        while(flag){
            System.out.println("show(显示队列数据)");
            System.out.println("push(入队操作)");
            System.out.println("pop(出队操作)");
            System.out.println("front(得到队首数据)");
            System.out.println("rear(得到队尾数据)");
            System.out.println("rear(得到队尾数据)");
            System.out.println("exit(退出程序)");
            System.out.println("请输入对应操作名称：");
            key = reader.next();
            switch(key){
                case "show":
                    Queue.showQueue();
                    break;
                case "push":
                    System.out.println("请输入要入队的数据：");
                    int value = reader.nextInt();
                    Queue.push(value);
                    break;
                case "pop":
                    try{
                        System.out.println("出队元素是："+Queue.pop());
                    }catch (RuntimeException e){}
                    break;
                case "front":
                    System.out.println("队头元素是："+Queue.getFront());
                    break;
                case "rear":
                    System.out.println("队尾元素是："+Queue.getRear());
                    break;
                case "exit":
                    flag = false;
                    reader.close();
                    break;
                default:
                    break;
            }
            System.out.println();
        }
    }
}
