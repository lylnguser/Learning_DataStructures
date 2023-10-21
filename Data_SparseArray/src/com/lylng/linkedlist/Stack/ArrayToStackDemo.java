package com.lylng.linkedlist.Stack;

import java.util.Scanner;

/**
 * ClassName:ArrayToStackDemo
 * Package:com.lylng.linkedlist.Stack
 * Description:
 * Author:lylng
 * Create:2023/10/21 - 21:38
 * Version:v1.0
 */
public class ArrayToStackDemo {
    public static void main(String[] args) {
        // 首先定义一个栈
        ArrayToStack Stack = new ArrayToStack(10);
        Scanner reader = new Scanner(System.in);

        String key = "";
        boolean flag = true;
        // 控制台
        while(flag){
            System.out.println("show(显示栈)");
            System.out.println("push(入栈)");
            System.out.println("pop(出栈)");
            System.out.println("exit(退出程序)");
            System.out.println("请输入选择：");
            key = reader.next();
            switch(key){
                case "show":
                    Stack.showStack();
                    break;
                case "push":
                    System.out.println("请输入入栈的数据：");
                    int value = reader.nextInt();
                    Stack.push(value);
                    break;
                case "pop":
                    try {
                        System.out.printf("出栈的数据是%d\n", Stack.pop());
                    }catch(RuntimeException e){
                        e.getMessage();
                    }
                    break;
                case "exit":
                    flag = false;
                    reader.close();
                    break;
                default:
                    break;
            }
            System.out.println("\n\n");
        }
    }
}
