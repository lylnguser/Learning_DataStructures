package com.lylng.linkedlist.Stack.ConprehensiveOperation;

import com.lylng.linkedlist.Stack.LinkedListConstructStack;
/**
 * ClassName:ConprehensiveOperation
 * Package:com.lylng.linkedlist.Stack.ConprehensiveOperation
 * Description:实现对算术运算的实现
 * Author:lylng
 * Create:2023/10/26 - 15:01
 * Version:v1.0
 */
public class ConprehensiveOperation {
    public static void main(String[] args) {
        // 首先创建一个数栈和符号栈
        LinkedListConstructStack numStack = new LinkedListConstructStack();
        LinkedListConstructStack operStack = new LinkedListConstructStack();

        // String接收运算符
        String str = "170+2*30-4*5/3";
        int index = 0;  // 用于扫描字符串
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';  // 将每次扫描的char保存到ch
        String keepNum = "";
        // 开始while循环的扫描str
        while(true){
            // 先依次得到str的每一个字符
            ch = str.substring(index,index+1).charAt(0);
            // 判断ch是什么，然后做相应的处理
            if(operStack.isOper(ch)){
                // 判断当前栈是否为空,若为空，则直接入栈,若不为空，则需要判断符号的优先级
                if(!operStack.isEmpty()){
                    // 判断符号的优先级，若栈顶的优先级大于ch的优先级，则先进行计算
                    try {
                        if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            oper = operStack.pop();
                            numStack.push(numStack.cal(num1, num2, oper));
                            operStack.push(ch);
                        } else {
                            // 当ch的优先级大于栈顶的优先级，则直接入栈
                            operStack.push(ch);
                        }
                    }catch(RuntimeException e){
                        e.getMessage();
                    }
                }else{
                    // 若栈为空则，直接入栈
                    operStack.push(ch);
                }
            }else{
                // 如果不是符号，是数字，则直接入数字栈
                // 出现的问题是：当发现是数字后，则直接就如占了，那么当一个数字，就会出现两次入栈，导致结果不符合运算结果
                // numStack.push(ch - 48);
                // 其中，ch是字符，不是int型，故，需要减去48
                // 会出现下标越界情况，如果是最后一位，则直接入栈
                keepNum += ch;
                if(index == str.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    // 判断ch的下一个字符是否是符号
                    if (operStack.isOper(str.substring(index + 1, index + 2).charAt(0))) {
                        // 如果后一位是符号，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        // 将keepNum清空
                        keepNum = "";
                    }
                }
            }
            index++;
            if(index >= str.length()){
                break;
            }
        }
        // 循环结束后，则可直接开始进行运算
        while(true){
            // 如果符号栈为空，则数栈只有一个数字，即就是运算后的结果
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("公式：%s = %d",str,numStack.pop());
    }
}
