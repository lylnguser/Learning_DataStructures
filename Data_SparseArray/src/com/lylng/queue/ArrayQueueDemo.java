package com.lylng.queue;

import java.util.Scanner;

/**
 * ClassName:ArrayQueueDemo
 * Package:com.lylng.queue
 * Description:
 * Author:lylng
 * Create:2023/10/12 - 15:40
 * Version:v1.0
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 测试队列

        // 创建一个队列

        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';     // 用于接受用户输入
        Scanner reader = new Scanner(System.in);
        boolean skip = true;
        while(skip) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列获取数据");
            System.out.println("h(head):获取队列头部数据");
            System.out.println("e(exit):退出程序");
            key = reader.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        arrayQueue.showQueue();
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    try {
                        System.out.println("请输入一个数字：");
                        int a = reader.nextInt();
                        arrayQueue.addQueue(a);
                    }catch(RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出的数据是：" + res);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int ros = arrayQueue.headQueue();
                        System.out.println("队列头部数据是：" + ros);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    reader.close();
                    skip = false;
                    System.out.println("程序结束");
                    break;
                default:
                    break;
            }
        }
    }
}
