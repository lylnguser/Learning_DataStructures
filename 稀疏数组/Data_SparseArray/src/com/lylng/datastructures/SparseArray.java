package com.lylng.datastructures;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * ClassName:SparseArray
 * Package:com.lylng.datastructures
 * Description:
 * Author:lylng
 * Create:2023/10/11 - 21:46
 * Version:v1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组11*11
        // 0:表示没有棋子，1表示黑子，2表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][1] = 1;
        // 输出原始的二维数组
        System.out.println("输出原始的二位数组~~~");
        for(int[] row: chessArr1){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        // 将原始二维数组转换为稀疏数组
        // 先统计原始二维数组中统计有效数字
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum:"+sum);


        // 根据统计的sum创建系数数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 将数据进行读入稀疏数组中
        System.out.println("输出的稀疏数组~~~");
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        // 输出系数数组
        for (int[] low : sparseArr){
            for (int data : low){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 将稀疏数组转换为原始二维数组
        // 根据稀疏数组创建原始二维数组
        // 根据数值的默认值关系，整型数组默认值为0
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length;i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 将转换后的二维数组输出
        System.out.println("将稀疏数组转换为原始二位数组~~~");
        for (int[] row:chessArr2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        // 将系数数组保存到磁盘中

        File file = new File("/file/map.data");
        RandomAccessFile in = null;
        try{
            in = new RandomAccessFile("map.data","rw");
            for (int i = 0; i < sparseArr.length; i++) {
                for (int j = 0; j < sparseArr[i].length; j++) {
                 in.write(sparseArr[i][j]);
                }
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        // 通过map.data恢复原来的二维数组
        
    }
}
